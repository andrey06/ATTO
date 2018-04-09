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
import com.aestheticintegration.atto.itlDsl.InputParam
import com.aestheticintegration.atto.itlDsl.DataType
import com.aestheticintegration.atto.itlDsl.Primitives

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
				«IF defFunction.inputParams.size != 0»
			   		«compileExtra(defFunction)»
			   	«ELSE»
			   		«compileExtraNoInput(defFunction)»
				«ENDIF»
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
	def compileExtraNoInput(DefFunction defFunction) '''
		(* Run function *) «this.attoUtil.nameToOcaml(defFunction.name)»
		;;
	'''
	def compile(DefDataType defDataType) '''
		type «defDataType.name.toLowerCase» = {
			«FOR inputParam : defDataType.fields»
				«inputParam.name»: «(this.getDataTypeAsPrimitiveLiteral(inputParam.inputDataType))»;
			«ENDFOR»
		}
		;;
		let «defDataType.name.toLowerCase»_default = «this.buildDefaultDatavalue(defDataType)»
		;;
	'''
	def compile(DefDataValue defDataValue) '''
		let «this.attoUtil.nameToOcaml(defDataValue.name)»: «defDataValue.dataTypeInstance.defDataType.name.toLowerCase» option = «this.attoUtil.getDataTypeInstanceToOcaml(defDataValue.dataTypeInstance)»
		;;
	'''
	def compile(DefFunction defFunction) '''
		let «this.attoUtil.nameToOcaml(defFunction.name)»«this.getFunctionParams(defFunction.inputParams)» =
			«defFunction.functionBody.compile»
		;;
	'''
	def compile(FunctionBody functionBody) '''
		«FOR statement : functionBody.statement»
			«IF statement.ifStatement !== null»
				«statement.ifStatement.compile»
			«ENDIF»
			«IF statement.outputExpressionTotal !== null»
				«this.attoUtil.getOutputExpressionTotalValueAsString(statement.outputExpressionTotal)»
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
		«IF expOrIfStatement.outputExpressionTotal !== null»
			«this.attoUtil.getOutputExpressionTotalValueAsString(expOrIfStatement.outputExpressionTotal)»
		«ENDIF»
		«IF expOrIfStatement.ifStatement !== null»
			«expOrIfStatement.ifStatement.compile»
		«ENDIF»
	'''
	def compile2(EList<BoolExpression> boolExpressionList) '''
		«this.attoUtil.getBoolExpressionListAsString(boolExpressionList)»		
	'''
	def createTypeBuildInExt(Model model) '''
		type 'a optionOut = Something of ('a option) | Exception of string;;

		let get_value (z: 'a option) (default: 'a) =
			match z with 
			| Some c -> c
			| None -> default
		;;

	'''
	def private String buildDefaultDatavalue(DefDataType defDataType) {
		var comma = ""
		var str = "{"
		for (InputParam inputParam : defDataType.fields) {
			str = str + comma + this.buildDefaulForDataType(inputParam)
			comma = "; "
		}
		str = str + "}"
		return str
	}
	def String buildDefaulForDataType(InputParam inputParam) {
		var DataType dataType = inputParam.inputDataType
		var String str = inputParam.name + " = "
		var some = ""
		if (dataType.booleanObj !== null || 
			dataType.shortObj !== null || dataType.intObj !== null || dataType.longObj !== null ||
			dataType.floatObj !== null || dataType.doubleObj !== null ||
			dataType.string !== null ||
			dataType.defDataType !== null) 
		{
			some = "Some "		
		}
		
		if (dataType.boolean !== null || dataType.booleanObj !== null) {
			str = str + some + "false"
		} else if (dataType.short !== null || dataType.int !== null || dataType.long !== null ||
			       dataType.shortObj !== null || dataType.intObj !== null || dataType.longObj !== null) {
			str = str + some + "0"
		} else if (dataType.float !== null || dataType.double !== null || 
				   dataType.floatObj !== null || dataType.doubleObj !== null ) {
			str = str + some + "0.0"
		} else if (dataType.string !== null) {
			str = str + some + "\"\""
		} else if (dataType.defDataType !== null) {
			str = str + some + this.buildDefaultDatavalue(dataType.defDataType)
		}
		return str
	}
	def String getFunctionParams(EList<InputParam> inputParams) {
		var String str = ""
		for (var index = 0; index < inputParams.size; index++) {
			str = str + " (" + inputParams.get(index).name + ":" + this.getDataTypeAsPrimitiveLiteral(inputParams.get(index).inputDataType) + ")"
		}
		return str
	}
	def String getDataTypeAsPrimitiveLiteral(DataType dataType) {
		var String optionStr = " option"
		var String dataTypeOut = null
		if (dataType.boolean !== null) {
			dataTypeOut = Primitives.BOOL.literal
		} else if (dataType.booleanObj !== null) {
			dataTypeOut = Primitives.BOOL.literal + optionStr
		} else if (dataType.short !== null || dataType.int !== null || dataType.long !== null) {
			dataTypeOut = Primitives.INT.literal
		} else if (dataType.shortObj !== null || dataType.intObj !== null || dataType.longObj !== null) {
			dataTypeOut = Primitives.INT.literal + optionStr
		} else if (dataType.float !== null || dataType.double !== null) {
			dataTypeOut = Primitives.FLOAT.literal
		} else if (dataType.floatObj !== null || dataType.doubleObj !== null) {
			dataTypeOut = Primitives.FLOAT.literal + optionStr
		} else if (dataType.string !== null) {
			dataTypeOut = Primitives.STRING.literal + optionStr
		} else if (dataType.defDataType !== null) {
			dataTypeOut = dataType.defDataType.name.toLowerCase + optionStr
		}
		return dataTypeOut
	}

}
