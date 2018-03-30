package com.aestheticintegration.atto.generator

import com.aestheticintegration.atto.itlDsl.BoolExpression
import com.aestheticintegration.atto.itlDsl.DefDataType
import com.aestheticintegration.atto.itlDsl.DefDataValue
import com.aestheticintegration.atto.itlDsl.DefFunction
import com.aestheticintegration.atto.itlDsl.ExpOrIfStatement
import com.aestheticintegration.atto.itlDsl.FunctionBody
import com.aestheticintegration.atto.itlDsl.IfStatement
import com.aestheticintegration.atto.itlDsl.Model
import com.aestheticintegration.atto.util.AttoUtil
import javax.inject.Inject
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource

public class GeneratorOcaml {
	@Inject
	private AttoUtil attoUtil;
	
	
	def className(Resource res) {
		var name = res.URI.lastSegment
		return name.substring(0, name.indexOf('.')) + ".ml"
	}

	def compile(Model model) '''
		«IF model !== null»
			«this.createTypeBuildInExt(model)»
			«FOR defDataType : model.datatypes»
				«defDataType.compile»
			«ENDFOR»
			«FOR defDataValue : model.datavalues»
				«defDataValue.compile»
			«ENDFOR»
			«FOR defFunction : model.functions»
				«defFunction.compile»
			«ENDFOR»
			Reflect.Mode.program ()
			;;
			«FOR defFunction : model.functions»
			   «compileExtra(defFunction)»
			«ENDFOR»
		«ENDIF»
	'''
	def compileExtra(DefFunction defFunction) '''
		let func_name = "«this.attoUtil.nameToOcaml(defFunction.name)»"
		;;
		let rs = Decompose.top func_name
		;; 
		Extract.to_file ~signature:(Event.DB.fun_id_of_str func_name) ~filename:"mex.ml" ()
		;;
		System.mod_use "mex.ml"
		;;
		Caml.List.iter (fun r -> print_string (Decompose.string_of_region r)) rs
		;;
		let tcs = List.map Mex.of_region rs
		;;
	'''
	def compile(DefDataType defDataType) '''
		type «defDataType.name.toLowerCase» = {
			«FOR inputParam : defDataType.fields»
				«inputParam.name»: «(this.attoUtil.convertDataTypeToOption(inputParam.inputDataType))»;
			«ENDFOR»
		}
		;;
	'''
	def compile(DefDataValue defDataValue) '''
		let «this.attoUtil.nameToOcaml(defDataValue.name)» = «this.attoUtil.toOcamlValue(defDataValue.dataTypeInstance)»
		;;
	'''
	def compile(DefFunction defFunction) '''
		let «this.attoUtil.nameToOcaml(defFunction.name)»«this.attoUtil.getFunctionParams(defFunction.inputParams)» =
			«defFunction.functionBody.compile»
		;;
	'''
	def compile(FunctionBody functionBody) '''
		«FOR statement : functionBody.statement»
			«IF statement.ifStatement !== null»
				«statement.ifStatement.compile»
			«ENDIF»
			«IF statement.outputExpression !== null»
				«this.attoUtil.getOutputExpressionValueAsString(statement.outputExpression)»
			«ENDIF»
		«ENDFOR»
	'''
	def compile(IfStatement ifStatement) '''
		if «ifStatement.inputBoolExpression.compile2»
		then «ifStatement.thenExpOrIfStatement.compile»
		«IF ifStatement.elseExpOrIfStatement !== null»
		else «ifStatement.elseExpOrIfStatement.compile»
		«ENDIF»
	'''
	def compile(ExpOrIfStatement expOrIfStatement) '''
		«IF expOrIfStatement.outputExpression !== null»
			«this.attoUtil.getOutputExpressionValueAsString(expOrIfStatement.outputExpression)»
		«ENDIF»
		«IF expOrIfStatement.ifStatement !== null»
			«expOrIfStatement.ifStatement.compile»
		«ENDIF»
	'''
	def compile2(EList<BoolExpression> boolExpressionList) '''
		«this.attoUtil.getBoolExpressionListAsString(boolExpressionList)»		
	'''
	def createTypeBuildInExt(Model model) '''
		type 'a objOpt = Nothing | Something of 'a;;

		type 'a objExcOpt = Nothing | Something of 'a | Exception of string;;

	'''
}
