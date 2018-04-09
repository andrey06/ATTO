package com.aestheticintegration.atto.util;

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import com.aestheticintegration.atto.itlDsl.DataType
import com.aestheticintegration.atto.itlDsl.Primitives
import com.aestheticintegration.atto.itlDsl.Literal
import com.aestheticintegration.atto.itlDsl.InputParam
import com.aestheticintegration.atto.itlDsl.impl.BooleanImpl
import com.aestheticintegration.atto.itlDsl.impl.IntegerImpl
import com.aestheticintegration.atto.itlDsl.impl.FloatImpl
import com.aestheticintegration.atto.itlDsl.impl.StringImpl
import com.aestheticintegration.atto.itlDsl.Primary
import com.aestheticintegration.atto.itlDsl.DefDataType
import com.aestheticintegration.atto.itlDsl.impl.ModelImpl
import com.aestheticintegration.atto.itlDsl.DefDataValue
import com.aestheticintegration.atto.itlDsl.DefFunction
import com.aestheticintegration.atto.itlDsl.impl.DefFunctionImpl
import com.aestheticintegration.atto.itlDsl.DefTest
import com.aestheticintegration.atto.itlDsl.OutputExpression
import com.aestheticintegration.atto.itlDsl.DataTypeInstance
import com.aestheticintegration.atto.itlDsl.impl.ExceptionImpl
import com.aestheticintegration.atto.itlDsl.DataTypeValue
import com.aestheticintegration.atto.itlDsl.IfStatement
import com.aestheticintegration.atto.itlDsl.ExpOrIfStatement
import com.aestheticintegration.atto.itlDsl.BoolExpression
import com.aestheticintegration.atto.itlDsl.impl.IfStatementImpl
import com.aestheticintegration.atto.itlDsl.impl.DataTypeInstanceImpl
import com.aestheticintegration.atto.itlDsl.impl.DefDataValueImpl
import com.aestheticintegration.atto.itlDsl.impl.NullImpl
import com.aestheticintegration.atto.itlDsl.Null
import com.aestheticintegration.atto.itlDsl.OutputExpressionTotal
import java.util.Optional
import com.aestheticintegration.atto.itlDsl.Literal2

public class AttoUtil {
	
	def public AttoUtil() {
		
	}


	def public String convertDataTypeToString(DataType dataType) {
		var String str = null
			 
		if (dataType.boolean !== null) 		str = 'boolean' else
		if (dataType.booleanObj !== null) 	str = 'Boolean' else
		if (dataType.short !== null) 		str = 'short'  else
		if (dataType.shortObj !== null) 		str = 'Short'  else
		if (dataType.int !== null) 			str = 'int'  else
		if (dataType.intObj !== null) 		str = 'Integer'  else
		if (dataType.long !== null) 			str = 'long'  else
		if (dataType.longObj !== null) 		str = 'Long'  else
		if (dataType.float !== null) 		str = 'float'  else
		if (dataType.floatObj !== null) 		str = 'Float'  else
		if (dataType.double !== null) 		str = 'double'  else
		if (dataType.doubleObj !== null) 	str = 'Double'  else
		if (dataType.string !== null) 		str = 'String' else
		if (dataType.defDataType !== null) 	str = dataType.defDataType.name
		
		return str
	}
	def String convertDataTypeToPrimitive(DataType dataType) {
		var String dataTypeOut = null
		if (dataType.boolean !== null) {
			dataTypeOut = Primitives.BOOL.literal
		} else if (dataType.booleanObj !== null) {
			dataTypeOut = Primitives.BOOLOPT.literal
		} else if (dataType.short !== null || dataType.int !== null || dataType.long !== null) {
			dataTypeOut = Primitives.INT.literal
		} else if (dataType.shortObj !== null || dataType.intObj !== null || dataType.longObj !== null) {
			dataTypeOut = Primitives.INTOPT.literal
		} else if (dataType.float !== null || dataType.double !== null) {
			dataTypeOut = Primitives.FLOAT.literal
		} else if (dataType.floatObj !== null || dataType.doubleObj !== null) {
			dataTypeOut = Primitives.FLOATOPT.literal
		} else if (dataType.string !== null) {
			dataTypeOut = Primitives.STRINGOPT.literal
		} else if (dataType.defDataType !== null) {
			dataTypeOut = dataType.defDataType.name
		}
		return dataTypeOut
	}
	def String convertLiteralToPrimitive(Literal literal) {
		if (literal.variable !== null) {
			var String[] idVars = literal.variable.split("\\.")
			// Find function
			var defFunction = this.getDefFunction(literal)
			// Find inputParam
			var InputParam inputParam = null
			for (inputParam0 : defFunction.inputParams) {
				if (inputParam0.name == idVars.get(0)) {
					inputParam = inputParam0
				}
			}
			if (inputParam === null) {
				return ""
			}
			// Find InputDataType
			var String dataType = inputParam.inputDataType.defDataType.name
			for (dataType2 : this.getAllDefDataTypes(defFunction)) {
				if (dataType2.name == dataType) {
					for (inputParam3 : dataType2.fields) {
						if (inputParam3.name == idVars.get(1)) {
							var dataType4 = inputParam3.inputDataType
							return this.convertDataTypeToPrimitive(dataType4)
						}
					}
				}
			}
			return ""
			
		} else if (literal.primary !== null) {
			return this.convertPrimaryToPrimitive(literal.primary)
		}
	}
	def String convertLiteral2ToPrimitive(Literal2 literal) {
		if (literal.dataValue !== null) {
			return literal.dataValue.dataTypeInstance.defDataType.name
			
		} else if (literal.primary !== null) {
			return this.convertPrimaryToPrimitive(literal.primary)
		}
	}
	def String convertPrimaryToPrimitive(Primary primary) {
		var String primaryType = null
		if (primary instanceof BooleanImpl) {
			primaryType = Primitives.BOOL.literal
		} else if (primary instanceof IntegerImpl) {
			primaryType = Primitives.INT.literal
		} else if (primary instanceof FloatImpl) {
			primaryType = Primitives.FLOAT.literal
		} else if (primary instanceof StringImpl) {
			primaryType = Primitives.STRINGOPT.literal
		} else if (primary instanceof NullImpl) {
			primaryType = Primitives.NULL.literal
		}
		return primaryType
	}
	
	def EList<DefDataType> getAllDefDataTypes(EObject eObject) {
		var eContainer = eObject.eContainer()
		while (eContainer !== null && !(eContainer instanceof ModelImpl)) {
			eContainer = eContainer.eContainer()
		}
		return (eContainer as ModelImpl).datatypes
	}
	def EList<DefDataValue> getAllDefDataValues(EObject eObject) {
		var eContainer = eObject.eContainer()
		while (eContainer !== null && !(eContainer instanceof ModelImpl)) {
			eContainer = eContainer.eContainer()
		}
		return (eContainer as ModelImpl).datavalues
	}
	def EList<DefFunction> getAllDefFunctions(EObject eObject) {
		var eContainer = eObject.eContainer()
		while (eContainer !== null && !(eContainer instanceof ModelImpl)) {
			eContainer = eContainer.eContainer()
		}
		return (eContainer as ModelImpl).functions
	}
	def DefFunction getDefFunction(EObject eObject) {
		var eContainer = eObject.eContainer()
		while (eContainer !== null && !(eContainer instanceof DefFunctionImpl)) {
			eContainer = eContainer.eContainer()
		}
		return (eContainer as DefFunctionImpl)
	}
	def EList<DefTest> getAllDefTests(EObject eObject) {
		var eContainer = eObject.eContainer()
		while (eContainer !== null && !(eContainer instanceof ModelImpl)) {
			eContainer = eContainer.eContainer()
		}
		return (eContainer as ModelImpl).tests
	}
	
	def String getLiteralValueAsString(Literal literal) {
		if (literal.variable !== null) {
			return literal.variable
		} else if (literal.primary !== null) {
			return this.getPrimaryValueAsString(literal.primary)
		}
	}
	def String getLiteral2ValueAsOcaml(Literal2 literal2) {
		if (literal2.dataValue !== null) {
			return this.getDataTypeInstanceToOcaml(literal2.dataValue.dataTypeInstance)
		} else if (literal2.dataTypeInstance !== null) {
			return this.getDataTypeInstanceToOcaml(literal2.dataTypeInstance)
		} else if (literal2.primary !== null) {
			return this.getPrimaryValueAsString(literal2.primary)
		}
	}
	def String getPrimaryValueAsString(Primary primary) {
		var String primaryValue = ""
		if (primary instanceof BooleanImpl) {
			primaryValue = (primary as BooleanImpl).valueBoolean.toString
		} else if (primary instanceof IntegerImpl) {
			primaryValue = (primary as IntegerImpl).valueInteger.toString
		} else if (primary instanceof FloatImpl) {
			primaryValue = (primary as FloatImpl).valueFloat.toString
		} else if (primary instanceof StringImpl) {
			primaryValue = '"' + (primary as StringImpl).valueString + '"'
		} else if (primary instanceof NullImpl) {
			primaryValue = Primitives.NULL.literal	 
		}
		return primaryValue
	}
	def String getPrimaryValueAsOcaml(Primary primary) {
		var String primaryValue = this.getPrimaryValueAsString(primary)
		if (primaryValue.equals(Primitives.NULL.literal)) {
			primaryValue = "None"
		}
		
		if (primary instanceof IntegerImpl || primary instanceof FloatImpl) {
			if (primaryValue.startsWith("-")) {
				primaryValue = "(" + primaryValue + ")"
			}
		}
		return "Some " + primaryValue
	}
	
	def String getOutputExpressionTotalValueAsString(OutputExpressionTotal outputExpressionTotal) {
		var String outputExpressionValue = ""
		if (outputExpressionTotal.primary !== null) {
			outputExpressionValue = "Something (" + this.getPrimaryValueAsOcaml(outputExpressionTotal.primary) + ")"
		} else if (outputExpressionTotal.outputExpression !== null) {
			outputExpressionValue = this.getOutputExpressionAsOcaml(outputExpressionTotal.outputExpression)		}
		return outputExpressionValue
	}
	def String getOutputExpressionValueAsString(OutputExpression outputExpression) {
		var String str = ""
		if (outputExpression instanceof DataTypeInstance) {
			str = this.getDataTypeInstanceToOcaml((outputExpression as DataTypeInstance).dataTypeInstance)
		} else if (outputExpression instanceof DefDataValue) {
			str = "Some " + (outputExpression as DefDataValue).valueDataValue.name
		} else if (outputExpression instanceof ExceptionImpl) {
			str = "Exception " + "\"" + (outputExpression as ExceptionImpl).valueException + "\""
		}
		return str
	}
	def String getOutputExpressionValueAsString_DEL_ME(OutputExpressionTotal outputExpressionTotal) {
		var String outputExpressionValue = ""
		if (outputExpressionTotal instanceof ExceptionImpl) {
			outputExpressionValue = "Exception " + "\"" + (outputExpressionTotal as ExceptionImpl).valueException + "\""
		} else if (outputExpressionTotal instanceof NullImpl) {
			outputExpressionValue = "None"
		} else if (outputExpressionTotal instanceof StringImpl) {
				outputExpressionValue = '"' + (outputExpressionTotal as StringImpl).valueString + '"'
		} else {
			var some = "Some "
			if (outputExpressionTotal instanceof BooleanImpl) {
				outputExpressionValue = some + (outputExpressionTotal as BooleanImpl).valueBoolean.toString
			} else if (outputExpressionTotal instanceof IntegerImpl) {
				var integerValue = (outputExpressionTotal as IntegerImpl).valueInteger
				if (integerValue < 0) {
					outputExpressionValue = some + "(" + integerValue.toString + ")"
				} else {
					outputExpressionValue = some + integerValue.toString
				}
			} else if (outputExpressionTotal instanceof FloatImpl) {
				var floatValue = (outputExpressionTotal as FloatImpl).valueFloat
				if (floatValue < 0.0) {
					outputExpressionValue = some + "(" + floatValue.toString + ")"
				} else {
					outputExpressionValue = some + floatValue.toString
				}
			} else if (outputExpressionTotal instanceof DataTypeInstance) {
				outputExpressionValue = some + this.getDataTypeInstanceToOcaml((outputExpressionTotal as DataTypeInstance).dataTypeInstance)
			} else if (outputExpressionTotal instanceof DefDataValue) {
				outputExpressionValue = some + (outputExpressionTotal as DefDataValue).valueDataValue.name
			}
		}
		return outputExpressionValue
	}
	def String convertOutputExpressionToPrimitive(OutputExpression outputExpression) {
		var String dataTypeOut = null

		if (outputExpression instanceof BooleanImpl) {
			dataTypeOut = Primitives.BOOL.literal
		} else if (outputExpression instanceof IntegerImpl) {
			dataTypeOut = Primitives.INT.literal
		} else if (outputExpression instanceof FloatImpl) {
			dataTypeOut = Primitives.FLOAT.literal
		} else if (outputExpression instanceof StringImpl) {
			dataTypeOut = Primitives.STRINGOPT.literal
		} else if (outputExpression instanceof NullImpl) {
			dataTypeOut = Primitives.NULL.literal
		} else if (outputExpression instanceof DataTypeInstanceImpl) {
			dataTypeOut = (outputExpression as DataTypeInstanceImpl).dataTypeInstance.defDataType.name
		} else if (outputExpression instanceof DefDataValueImpl) {
			var datavalues = this.getAllDefDataValues(outputExpression)
			if (datavalues !== null && datavalues.size != 0) {
				for (DefDataValue defDataValue : datavalues) {
					if (defDataValue.name == (outputExpression as DefDataValueImpl).valueDataValue.name) {
						dataTypeOut = defDataValue.dataTypeInstance.defDataType.name
					}
				}
			}			
		} else if (outputExpression instanceof ExceptionImpl) {
			dataTypeOut = Primitives.EXCEPTION.literal
		}

		return dataTypeOut
	}
	def String toOcamlType_NOT_USED(DataTypeInstance dataTypeInstance) {
		var str = "{"
		var dataTypeFields = dataTypeInstance.defDataType.fields
		var comma = ""
		for (var index = 0; index < dataTypeFields.size; index++) {
			var fieldName = dataTypeFields.get(index).name
			var fieldValue = ""	//	this.getDataTypeAsPrimitiveLiteral(dataTypeFields.get(index).inputDataType)
			str = str + comma + fieldName + "=" + fieldValue 
			comma = "; "
		}
		str += "}"
		
		return str;
	}
	def String getDataTypeInstanceToOcaml(DataTypeInstance dataTypeInstance2) {
		var dataTypeInstance = dataTypeInstance2
		if (dataTypeInstance.dataTypeInstance !== null) {
			dataTypeInstance = dataTypeInstance.dataTypeInstance
		}
		
		var str = "Some {"
		var dataTypeFields = dataTypeInstance.defDataType.fields
		var comma = ""
		for (var index = 0; index < dataTypeFields.size; index++) {
			var fieldName = dataTypeFields.get(index).name
			var fieldValue = this.getLiteral2ValueAsOcaml(dataTypeInstance.literal2s.get(index))
			
			var dataTypeName = this.convertDataTypeToPrimitive(dataTypeFields.get(index).inputDataType)
			var some = ""
			if (dataTypeName.endsWith("Opt")) {
				some = "Some "
			}
			
			str = str + comma + fieldName + " = " + some + fieldValue 
			comma = "; "
		}
		str += "}"
		
		return str;
	}
	def String getAllDataTypeValueAsString_DELME(EList<DataTypeValue> dataTypeValues) {
		var String str = ""
		var comma = ""
		for (var index = 0; index < dataTypeValues.size; index++) {
			var dataTypeValue = dataTypeValues.get(index)
			if (dataTypeValue.primary !== null) {
				str = str + comma + this.getPrimaryValueAsString(dataTypeValue.primary)
			} else if (dataTypeValue.dataTypeInstance !== null) {
				var comma2 = ""
				str = str + "{"
				for (var index2 = 0; index2 < dataTypeValue.dataTypeInstance.literal2s.size; index2++) {
					str = str + comma2 + dataTypeValue.dataTypeInstance.defDataType.fields.get(index2).name + "="
					str = str + this.getLiteral2ValueAsOcaml(dataTypeValue.dataTypeInstance.literal2s.get(index2))
					comma2 = "; "
				}
				str = str + "}"
			} else if (dataTypeValue.defDataValue !== null) {
				str = str + comma + dataTypeValue.defDataValue.name.toLowerCase
			}
			comma = ", "
		}
		
		return str
	}
	def String getOutputExpressionAsOcaml(OutputExpression outputExpression) {
		var String str = ""
		
 		if (outputExpression instanceof DataTypeInstance) {
 			str = this.getDataTypeInstanceToOcaml(outputExpression as DataTypeInstance)
		} else if (outputExpression instanceof DefDataValue) {
			str = outputExpression.valueDataValue.name
		} else if (outputExpression instanceof ExceptionImpl) {
			str = "Exception " + "\"" + (outputExpression as ExceptionImpl).valueException + "\""
		}
		
		return str
	}

	def boolean hasFunctionException(DefFunction defFunciton) {
		for (statement : defFunciton.functionBody.getStatement()) {
			if (statement.ifStatement !== null) {
				if (this.hasIfStatementException(statement.ifStatement)) {
					return true;
				}
			}
		}
		
		return false
	}
	def boolean hasIfStatementException(IfStatement ifStatement) {
		if (this.hasExpOrIfStatementException(ifStatement.thenExpOrIfStatement)) {
			return true;
		}
		if (this.hasExpOrIfStatementException(ifStatement.elseExpOrIfStatement)) {
			return true;
		}
		return false
	}
	def boolean hasExpOrIfStatementException(ExpOrIfStatement expOrIfStatement) {
		if (expOrIfStatement === null) {
			return false;
		}
		if (expOrIfStatement.outputExpressionTotal !== null) {
			if (expOrIfStatement.outputExpressionTotal instanceof ExceptionImpl) {
				return true;
			}
		}
		if (expOrIfStatement.ifStatement !== null) {
			if (this.hasIfStatementException(expOrIfStatement.ifStatement)) {
				return true;
			}
		}
		return false
	}
	def String getBoolExpressionListAsString(EList<BoolExpression> boolExpressionList) {
		var String str = ""
		for (var index = 0; index < boolExpressionList.size; index++) {
			var boolExpression = boolExpressionList.get(index)
			if (0 < index ) {
				var String sign = (boolExpression.eContainer as IfStatementImpl).sign.get(index-1)
				str = str + " " + sign + " "
			}
			str = str + this.getBoolExpressionAsString(boolExpression)
		}
		return str
	}
	def String getBoolExpressionAsString(BoolExpression boolExpression) {
		var String str = this.getParamComplecated2(boolExpression.literalLeft, boolExpression.literalRight)
		if (boolExpression.literalRight !== null) {
			str = str + " " + boolExpression.sign + " " + this.getParamComplecated2(boolExpression.literalRight, boolExpression.literalLeft)
		}
		return str
	}
	def String getParamComplecated2(Literal literal, Literal literalOposite) {
		var String exp = ""
		
		if (literal.variable !== null) {
			var String[] partVariable = literal.variable.split("\\.")
			var InputParam inputParam3 = null
			var comma = ""
			
			for (var index = 0; index < partVariable.size; index++) {
				var String paramName = partVariable.get(index)
				if (index === 0) {
					inputParam3 = this.getInputParamFromFunction(literal, paramName)
				} else {
					inputParam3 = this.getInputParamFromDataType(inputParam3, paramName)
				}
				if (inputParam3.inputDataType.defDataType !== null) {
					exp = "(get_value " + exp + comma + paramName + " " + inputParam3.inputDataType.defDataType.name.toLowerCase + "_default)"
				} else {
					exp = exp + comma + paramName
				}
				comma = "."
			}
		}
		if (literal.primary !== null) {
			exp = this.getPrimaryValueAsString(literal.primary)
		}
			
		return exp

	}
	def String getInputParamByName2(String paramName) {
		
	}
	def String getParamComplecated(Literal literal, Literal literalOposite) {
		var paramName = this.getLiteralValueAsString(literal)
		var paramNameOpos = this.getLiteralValueAsString(literalOposite)
		
		var str = paramName
		if (paramNameOpos === null || paramNameOpos == Primitives.NULL.literal) {
			return str
		}
		
		var defFunction = this.getDefFunction(literal)
		var EList<InputParam> inputParams = defFunction.inputParams
		for (InputParam inputParam : inputParams) {
			if (paramName.startsWith(inputParam.name + ".")) {
				var EList<DefDataType> datatypes = this.getAllDefDataTypes(defFunction)
				var Optional<DefDataType> defDataType = datatypes.stream.filter[it.name.equalsIgnoreCase(inputParam.name)].findFirst
				if (defDataType !== null) {
					var paramName2 = paramName.substring(paramName.indexOf(".")+1)
					for (InputParam inputParam2 : defDataType.get.fields) {
						if (paramName2.equals(inputParam2.name)){
							var dataTypeName = this.convertDataTypeToPrimitive(inputParam2.inputDataType)
							if (dataTypeName.endsWith("Opt")) {
								str = "(get_value " + inputParam.name + " " + inputParam.inputDataType.defDataType.name.toLowerCase + "_default)." + paramName2
							}
							return str
						}
					}
				}
			}
			if (paramName.equals(inputParam.name)){
				var dataTypeName = this.convertDataTypeToPrimitive(inputParam.inputDataType)
				if (dataTypeName.endsWith("Opt")) {
					str = "get_value " + paramName + " " + this.getDefalutValue(dataTypeName)
				}
				return str
			}
		}
		
		return str
	}
	def String getDefalutValue(String dataTypeName) {
		var defaultValue = ""
		if (dataTypeName.startsWith("bool")) {
			defaultValue = "false"
		} else if (dataTypeName.startsWith("int")) {
			defaultValue = "4611686018427387903"
		} else if (dataTypeName.startsWith("float")) {
			defaultValue = "1.99999999999999999"				//	"1.79769313486231571e+308"
		} else if (dataTypeName.startsWith("string")) {
			defaultValue = '"qwertyuiop[]asdfghjkl;zxcvbnm,../"'
		}
		return defaultValue
	}
	def String getSome_NotUsed(BoolExpression boolExpression, String paramName, Literal literal) {
		var str = ""
		if (literal !== null && 
			literal.primary !== null && 
			literal.primary instanceof Null)
		{
			return str;
		}

		var defFunction = this.getDefFunction(literal)
		var EList<InputParam> inputParams = defFunction.inputParams
		for (InputParam inputParam : inputParams) {
			if (inputParam.name.equals(paramName)){
				var dataTypeName = this.convertDataTypeToPrimitive(inputParam.inputDataType)
				if (dataTypeName.endsWith("Opt")) {
					str = "get_value "
				}
				return str
			}
		}

		return str
	}
	def String nameToOcaml(String name) {
		var str = name.substring(0,1).toLowerCase + name.substring(1)
		str = str.replace(".", "_")
		return str
	}
	
	def String buildPrepToJson_DEL_ME(DefFunction defFunction) {
// 		let prep_to_json (param1:int) (param2: bool) = [("param1", `Int param1); ("param2", `Bool param2)]
		var EList<InputParam> inputParams = defFunction.inputParams
		var comma = ""
		var str = "let prep_" + this.nameToOcaml(defFunction.name) + " " + ""	//	this.getFunctionParams(inputParams) + " = "
		str = str + "["
		for (var index = 0; index < inputParams.size; index++) {
			str = str + comma + " (\"" + inputParams.get(index).name + "\", " + 
				this.convertDataTypeToJsonType(inputParams.get(index).inputDataType) + " " + inputParams.get(index).name + ")"
			comma = "; "
		}
		str = str + "]"
		
		return str		
	}
	def String convertDataTypeToJsonType(DataType dataType) {
		var String dataTypeOut = null
		if (dataType.boolean !== null || dataType.booleanObj !== null) {
			dataTypeOut = "`Bool"
		} else if (dataType.short !== null || dataType.shortObj !== null ||
				   dataType.int !== null || dataType.intObj !== null ||
				   dataType.long !== null || dataType.longObj !== null) {
			dataTypeOut = "`Int"
		} else if (dataType.float !== null || dataType.floatObj !== null ||
				   dataType.double !== null || dataType.doubleObj !== null) {
			dataTypeOut = "`Float"
		} else if (dataType.string !== null) {
			dataTypeOut = "`String"
		} else if (dataType.defDataType !== null) {
			dataTypeOut = "`NotDoneYet"
		}
		return dataTypeOut
	}
	def InputParam getInputParamFromFunction(EObject eObject, String paramName) {
		var defFunc = this.getDefFunction(eObject)
		for (InputParam inputParam : defFunc.inputParams) {
			if (inputParam.name.equals(paramName)) {
				return inputParam
			}
		}
		return null
	}
	def InputParam getInputParamFromDataType(InputParam inputParam, String paramName) {
		var DefDataType defDataType = inputParam.inputDataType.defDataType
		for (InputParam inputParam2 : defDataType.fields) {
			if (inputParam2.name.equals(paramName)) {
				return inputParam2
			}
		}
		return null
	}
}
