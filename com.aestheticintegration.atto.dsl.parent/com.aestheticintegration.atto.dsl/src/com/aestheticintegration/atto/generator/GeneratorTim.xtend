package com.aestheticintegration.atto.generator

import com.aestheticintegration.atto.itlDsl.DefDataType
import com.aestheticintegration.atto.itlDsl.DefDataValue
import com.aestheticintegration.atto.itlDsl.DefFunction
import com.aestheticintegration.atto.itlDsl.DefImport
import com.aestheticintegration.atto.itlDsl.DefTest
import com.aestheticintegration.atto.itlDsl.Model
import com.aestheticintegration.atto.util.AttoUtil
import javax.inject.Inject
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import com.aestheticintegration.atto.itlDsl.DataTypeValue
import com.aestheticintegration.atto.itlDsl.DataTypeInstance
import com.aestheticintegration.atto.itlDsl.OutputExpression
import com.aestheticintegration.atto.itlDsl.impl.ExceptionImpl
import com.aestheticintegration.atto.itlDsl.OutputExpressionTotal
import com.aestheticintegration.atto.itlDsl.Literal2

public class GeneratorTim {
	@Inject
	private AttoUtil attoUtil;
	
	def className(Resource res) {
		var name = res.URI.lastSegment
		return name.substring(0, name.indexOf('.')) + ".tim"
	}

	def compile(Model model) '''
		«IF model !== null»
		{
			«model.imports.compile»
			«model.datatypes.compile2»
			«model.datavalues.compile3»
			«model.functions.compile4»
			«model.tests.compile5»
		}
		«ENDIF»
	'''
	def compile(EList<DefImport> imports) '''
		"imports": [
		«FOR index : 0 ..< imports.size»
			"«imports.get(index).name»" «IF index !== imports.size -1 » , «ENDIF»
		«ENDFOR»
		],
	'''
	def compile2(EList<DefDataType> datatypes) '''
		"datatypes": [
		«FOR index : 0 ..< datatypes.size»
				{ "name": "«datatypes.get(index).name»",
				  "fields": [
			«FOR index2 : 0 ..< datatypes.get(index).fields.size»
			{ "name": "«datatypes.get(index).fields.get(index2).name»",
			  "type": "«this.attoUtil.convertDataTypeToString(datatypes.get(index).fields.get(index2).inputDataType)»"
			}«IF index2 !== datatypes.get(index).fields.size -1 » , «ENDIF»
			«ENDFOR»
			]
			}«IF index !== datatypes.size -1 » , «ENDIF»
		«ENDFOR»
		],
	'''
	def compile3(EList<DefDataValue> datavalues) '''
		"datavalues": [
		«FOR index : 0 ..< datavalues.size»
			«datavalues.get(index).compile3a»
			«IF index !== datavalues.size -1 » , «ENDIF»
		«ENDFOR»
		],
	'''
	def compile3a(DefDataValue datavalue) '''
		{ "name": "«datavalue.name»",
		  "datatype": "«datavalue.dataTypeInstance.defDataType.name»",
		  "fields": [
		       «this.getDataTypeInstanceAsJson(datavalue.dataTypeInstance)»
		   ]
		}	'''
	def compile4(EList<DefFunction> functions) '''
		"functions": [
		«FOR index : 0 ..< functions.size»
		{ "name": "«functions.get(index).name»",
		  "mlName":"«this.attoUtil.nameToOcaml(functions.get(index).name)»",
		     "inputParams": [
			«FOR index2 : 0 ..< functions.get(index).inputParams.size»
			{
			"name":"«functions.get(index).inputParams.get(index2).name»",
				"type":"«this.attoUtil.convertDataTypeToString(functions.get(index).inputParams.get(index2).inputDataType)»"
			}«IF index2 !== functions.get(index).inputParams.size -1 » , «ENDIF»
			«ENDFOR»
				  ],
				  "returnType": "«this.attoUtil.convertDataTypeToString(functions.get(index).outputDataType)»",
				  "testCases" : [
				  	{ "constraints": "",
				  	  "input": null,
				  	  "output_expect": null,
				  	  "output_actual": null
				  	 }
				   ]
				}«IF index !== functions.size -1 » , «ENDIF»
		«ENDFOR»
		],
	'''
	def compile5(EList<DefTest> tests) '''
		"tests": [
		«FOR index : 0 ..< tests.size»
				{ "name": "«tests.get(index).name»",
				  "function": "«tests.get(index).defFunc.name»",
				  "input": [
			«FOR index2 : 0 ..< tests.get(index).dataTypeValues.size»
				«var dataTypeValue = tests.get(index).dataTypeValues.get(index2)»
				«IF dataTypeValue.primary !== null»
					«this.attoUtil.getPrimaryValueAsString(dataTypeValue.primary)»«IF index2 !== tests.get(index).dataTypeValues.size -1 » , «ENDIF»
				«ENDIF»
				«IF dataTypeValue.dataTypeInstance !== null»
					{
					"datatype": "«dataTypeValue.dataTypeInstance.defDataType.name»",
					"fields":[
					«FOR index3 : 0 ..< dataTypeValue.dataTypeInstance.literal2s.size»
						«this.getLiteral2ValueAsJson(dataTypeValue.dataTypeInstance.literal2s.get(index3))»«IF index3 !== dataTypeValue.dataTypeInstance.literal2s.size -1 » , «ENDIF»
					«ENDFOR»
					]
					}«IF index2 !== tests.get(index).dataTypeValues.size -1 » , «ENDIF»
				«ENDIF»
				«IF dataTypeValue.defDataValue !== null»
					{
					"datavalue": "«dataTypeValue.defDataValue.name»"«IF index2 !== tests.get(index).dataTypeValues.size -1 » , «ENDIF»
					}
				«ENDIF»
			«ENDFOR»
				 ],
				  	   "output_expect" : «this.getOutputExpressionTotalAsJson(tests.get(index).outputExpressionTotal)»,
				  	   "output_actual": null
				}«IF index !== tests.size -1 » , «ENDIF»
		«ENDFOR»
		]
	'''
/////////////////////////////////
	def String getDataTypeValueAsJson(DefDataValue defDataValue) {
		var str = 
		"{ \"name\": \"" + defDataValue.name + "\"" +
		  "\"datatype\": \"" + defDataValue.dataTypeInstance.defDataType.name + "\"" +
		  "\"fields\": [" +
		       this.getDataTypeInstanceAsJson(defDataValue.dataTypeInstance) +
		  "]" +
		"}"
		return str
	}
	def String getDataTypeInstanceAsJson(DataTypeInstance dataTypeInstance) {
		var comma = ""
		var str = "{"
		for (var index = 0; index < dataTypeInstance.literal2s.size; index++) {
			str = str + comma + 
				"\"" + dataTypeInstance.defDataType.fields.get(index).name + "\"" +  ": " +
				this.getLiteral2ValueAsJson(dataTypeInstance.literal2s.get(index))
			comma = ", "
		}
		str = str + "}"
		return str
	}
	def String getDataTypeValueAsJson(DataTypeValue dataTypeValue) {
		var String str = ""
		if (dataTypeValue.primary !== null) {
			str = this.attoUtil.getPrimaryValueAsString(dataTypeValue.primary)
		} else if (dataTypeValue.dataTypeInstance !== null) {
			var comma2 = ""
			str = str + "{"
			for (var index2 = 0; index2 < dataTypeValue.dataTypeInstance.literal2s.size; index2++) {
				str = str + comma2 + dataTypeValue.dataTypeInstance.defDataType.fields.get(index2).name + "="
				str = str + this.getLiteral2ValueAsJson(dataTypeValue.dataTypeInstance.literal2s.get(index2))
				comma2 = "; "
			}
			str = str + "}"
		} else if (dataTypeValue.defDataValue !== null) {
			str = dataTypeValue.defDataValue.name.toLowerCase
		}
		
		return str
	}
	def String getOutputExpressionTotalAsJson(OutputExpressionTotal outputExpressionTotal) {
		var String str = ""
		
		if (outputExpressionTotal.primary !== null) {
			str = this.attoUtil.getPrimaryValueAsString(outputExpressionTotal.primary)
		} else if (outputExpressionTotal.outputExpression !== null) {
			str = this.getOutputExpressionAsJson(outputExpressionTotal.outputExpression)
		}
		
		return str
	}
	def String getOutputExpressionAsJson(OutputExpression outputExpression) {
		var String str = ""
		
 		if (outputExpression instanceof DataTypeInstance) {
// 			str = this.toOcamlValue(outputExpression as DataTypeInstance)
			
			var comma2 = ""
			str = str + "{"
			for (var index2 = 0; index2 < outputExpression.dataTypeInstance.literal2s.size; index2++) {
				str = str + comma2 + "\"" + outputExpression.dataTypeInstance.defDataType.fields.get(index2).name + "\": "
				str = str + this.getLiteral2ValueAsJson(outputExpression.dataTypeInstance.literal2s.get(index2))
				comma2 = ", "
			}
			str = str + "}"
		} else if (outputExpression instanceof DefDataValue) {
//			str = outputExpression.valueDataValue.name.toLowerCase

			var dataTypeInstance = (outputExpression as DefDataValue).valueDataValue.dataTypeInstance
			str = "{ \"name\": \"" + outputExpression.valueDataValue.name + "\", " +
		  			"\"datatype\": \"" + dataTypeInstance.defDataType.name + "\", " + 
		  			"\"fields\": ["
		  	str = str + this.getDataTypeInstanceAsJson(dataTypeInstance)
			str = str + "]" + "}"
		} else if (outputExpression instanceof ExceptionImpl) {
			str = "\"Exception " + "\\\"" + (outputExpression as ExceptionImpl).valueException + "\\\"\""
		}
		
		return str
	}
	def String getLiteral2ValueAsJson(Literal2 literal2) {
		if (literal2.dataValue !== null) {
			return getDataTypeInstanceAsJson(literal2.dataValue.dataTypeInstance)
		} else if (literal2.primary !== null) {
			return this.attoUtil.getPrimaryValueAsString(literal2.primary)
		}
	}

}
