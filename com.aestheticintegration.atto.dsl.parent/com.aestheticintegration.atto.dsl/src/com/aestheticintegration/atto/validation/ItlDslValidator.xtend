/*
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.validation

import javax.inject.Inject
import org.eclipse.xtext.validation.Check
import com.aestheticintegration.atto.itlDsl.BoolExpression
import com.aestheticintegration.atto.itlDsl.DataType
import com.aestheticintegration.atto.itlDsl.DataTypeInstance
import com.aestheticintegration.atto.itlDsl.DefDataType
import com.aestheticintegration.atto.itlDsl.DefDataValue
import com.aestheticintegration.atto.itlDsl.DefFunction
import com.aestheticintegration.atto.itlDsl.DefTest
import com.aestheticintegration.atto.itlDsl.Literal
import com.aestheticintegration.atto.itlDsl.Model
import com.aestheticintegration.atto.itlDsl.OutputExpression
import com.aestheticintegration.atto.itlDsl.Primitives
import com.aestheticintegration.atto.itlDsl.impl.DefFunctionImpl
import com.aestheticintegration.atto.itlDsl.impl.ExpOrIfStatementImpl
import com.aestheticintegration.atto.util.AttoUtil

import org.eclipse.emf.common.util.EList
import com.aestheticintegration.atto.itlDsl.InputParam
import com.aestheticintegration.atto.itlDsl.ItlDslPackage

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class ItlDslValidator extends AbstractItlDslValidator {
	private static String OCAML_OPTION = "Opt";
	@Inject
	private AttoUtil attoUtil;
	
// TODO	private Model model;
	
	@Check
	def checkUniqueness(DefDataType defDataType) {
		// DataType uniqueness
		var EList<DefDataType> datatypes = this.attoUtil.getAllDefDataTypes(defDataType)
		var qty = datatypes.stream.filter[it.name == defDataType.name].count

		if (qty != 1) {
			error("The datatype is not unique", null, ItlDslPackage.DATA_TYPE_VALUE)
		}
		
		// Fields of the DataType uniqueness
		var fields = defDataType.fields
		if (1 < fields.size) {
			for (InputParam inputParam : fields) {
				if (1 < fields.stream.filter[it.name == inputParam.name].count) {
					error("The field '"+ inputParam.name +"' is not unique", null, ItlDslPackage.INPUT_PARAM__NAME)
				}
			}
		}
	}
	@Check
	def checkUniqueness(DefDataValue defDataValue) {
		if (defDataValue.name === null) {
			return
		}
		var EList<DefDataValue> datavalues = this.attoUtil.getAllDefDataValues(defDataValue)
		var qty = datavalues.stream.filter[it.name == defDataValue.name].count

		if (qty != 1) {
			error("The datavalue is not unique", null, ItlDslPackage.DATA_TYPE_VALUE)
		}
	}
	@Check
	def checkUniqueness(DefFunction defFunction) {
		// TODO Put the signature uniqueness
		
/*		var EList<DefFunction> defFunctions = this.attoUtil.getAllDefFunctions(defFunction)
		var qty = defFunctions.stream.filter[it.name == defFunction.name].count

		if (qty != 1) {
			error("The function name is not unique", null, ItlPackage.DATA_TYPE_VALUE)
		}
*/
	}
	@Check
	def checkUniqueness(DefTest defTest) {
		var EList<DefTest> tests = this.attoUtil.getAllDefTests(defTest)
		var qty = tests.stream.filter[it.name == defTest.name].count

		if (qty != 1) {
			error("The test is not unique", null, ItlDslPackage.DEF_TEST)
		}
	}
	@Check
	def checDataValueWithDataType(DataTypeInstance dataTypeInstance) {
		var dataTypeFields = dataTypeInstance.defDataType.fields
		if (dataTypeFields.size < dataTypeInstance.literal2s.size) {
			error("Too many arguments in this datavalue", null, ItlDslPackage.DATA_TYPE_INSTANCE)
			return
		}
		for (var index = 0; index < dataTypeInstance.literal2s.size; index++) {
			var dataTypeType = this.attoUtil.convertDataTypeToPrimitive(dataTypeFields.get(index).inputDataType)
			var dataTypeTypeOpt = dataTypeType;
			if (!dataTypeType.endsWith(OCAML_OPTION)) {
				dataTypeTypeOpt = dataTypeType + OCAML_OPTION
			}
			
			var primaryType = this.attoUtil.convertLiteral2ToPrimitive(dataTypeInstance.literal2s.get(index))
			var primaryTypeOpt = primaryType;
			if (!primaryType.endsWith(OCAML_OPTION)) {
				primaryTypeOpt = primaryType + OCAML_OPTION
			}
			
			if (dataTypeTypeOpt != primaryTypeOpt) {
				error("Wrong type of the arguments in this datavalue", null, ItlDslPackage.DATA_TYPE_INSTANCE)
			}
		}
	}
	
	// TODO verify that the function with these input really exists.
	// TODO Consider only the function in the current file
	@Check
	def checkFunctionSig(DefTest test) '''
	
	'''
	
	// Comparison the type of the output literal with outputDataType
	@Check
	def checkBooleanExpressionWithInputDataTypeGreetingStartsWithCapital(BoolExpression boolExpression) {
		var String literalLeftType = this.findInputParamMap(boolExpression, boolExpression.literalLeft);
		if (boolExpression.literalRight ===  null &&
			literalLeftType != Primitives.BOOL.literal) 
		{
			error("Wrong type. The left part of the literal should be a boolean", null, ItlDslPackage.BOOL_EXPRESSION)
			return
		}
		
		var literalRightType = this.findInputParamMap(boolExpression, boolExpression.literalRight);
		
		if (literalLeftType === null || literalRightType === null) {
			return
		}
		
		var literalLeftTypeOpt = literalLeftType;
		if (!literalLeftType.endsWith(OCAML_OPTION)) {
			literalLeftTypeOpt = literalLeftType + OCAML_OPTION
		}

		var literalRightTypeOpt = literalRightType;
		if (!literalRightType.endsWith(OCAML_OPTION)) {
			literalRightTypeOpt = literalRightType + OCAML_OPTION
		}
		
		if (!literalLeftTypeOpt.equals(literalRightTypeOpt) &&
			!(literalRightType == Primitives.NULL.literal && literalLeftType.endsWith(OCAML_OPTION)))
		{
			// Verify the type of the right literal
			error("Wrong type. The data types are not the same", null, ItlDslPackage.BOOL_EXPRESSION)
		}
		return
	}
	
	// Comparison the type of the output literal with outputDataType
	@Check
	def checkOutputExpressionWithOutputDataType(OutputExpression outputExpression) {
		// TODO: So far Primary and OutputExpression is the same - change it.
		if (!(outputExpression.eContainer() instanceof ExpOrIfStatementImpl)) {
			return
		}
		
		var DataType funcDateType = this.findFuncReturnDataType(outputExpression)
		var String primFuncReturnType = this.attoUtil.convertDataTypeToPrimitive(funcDateType)
		var primFuncReturnTypeOpt = primFuncReturnType;
		if (!primFuncReturnType.endsWith(OCAML_OPTION)) {
			primFuncReturnTypeOpt = primFuncReturnType + OCAML_OPTION
		}
		
		var String expressReturnType = this.attoUtil.convertOutputExpressionToPrimitive(outputExpression)
		var expressReturnTypeOpt = expressReturnType;
		if (!expressReturnType.endsWith(OCAML_OPTION)) {
			expressReturnTypeOpt = expressReturnType + OCAML_OPTION
		}
		
		if (expressReturnTypeOpt != primFuncReturnTypeOpt &&
			expressReturnType != Primitives.EXCEPTION.literal &&
			!(expressReturnType == Primitives.NULL.literal && primFuncReturnType.endsWith(OCAML_OPTION)))
		{
			var String funcReturnType = this.attoUtil.convertDataTypeToString(funcDateType)
			error("Wrong type. It should be '" + funcReturnType + "'", null, ItlDslPackage.OUTPUT_EXPRESSION)
		}
		return
	}
	def private String findInputParamMap(BoolExpression boolExpression, Literal literal) {
		var String literalType = null
		var eContainer = boolExpression.eContainer()
		
		if (literal.variable !== null) {
			// Determine the type based on the input param type
			while (eContainer !== null && !(eContainer instanceof DefFunctionImpl)) {
				eContainer = eContainer.eContainer()
			}
			if (eContainer !== null) {
				var defFunc = eContainer as DefFunction
				var String[] partVariable = literal.variable.split("\\.")
				for (InputParam inputParam : defFunc.inputParams) {
					if (inputParam.name.equals(partVariable.get(0))) {
						literalType = this.attoUtil.convertDataTypeToPrimitive(inputParam.inputDataType)
						if (1 < partVariable.size) {
							// TODO For now - only 1 level deeper
							var model = defFunc.eContainer() as Model
							for (DefDataType defDataType : model.datatypes) {
								if (defDataType.name == literalType) {
									for (InputParam inputParam2 : defDataType.fields) {
										if (inputParam2.name.equals(partVariable.get(1))) {
											literalType = this.attoUtil.convertDataTypeToPrimitive(inputParam2.inputDataType)
										}
									}
								}
							}
						}
					}
				}
			}
			if (literalType === null) {
				error("The variable '" + literal.variable + "' is unknown", null, ItlDslPackage.LITERAL__VARIABLE)
				return literalType
			}
		}
		if (literal.primary !== null) {
			literalType = this.attoUtil.convertPrimaryToPrimitive(literal.primary)
		}
			
		return literalType
	}
	def private DataType findFuncReturnDataType(OutputExpression outputExpression) {
		var DataType funcReturnType = null
		var eContainer = outputExpression.eContainer()
		while (eContainer !== null && !(eContainer instanceof DefFunctionImpl)) {
			eContainer = eContainer.eContainer()
		}
		if (eContainer !== null) {
			funcReturnType = (eContainer as DefFunctionImpl).outputDataType
		}
		
		return funcReturnType
	}
}
