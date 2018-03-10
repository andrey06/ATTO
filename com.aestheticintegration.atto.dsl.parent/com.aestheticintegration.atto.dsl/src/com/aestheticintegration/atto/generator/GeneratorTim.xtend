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
		{ "name": "«datavalues.get(index).name»",
		  "datatype": "«datavalues.get(index).dataTypeInstance.defDataType.name»",
		  "fields": [
			«FOR index2 : 0 ..< datavalues.get(index).dataTypeInstance.literals.size»
		       «this.attoUtil.getLiteralValueAsString(datavalues.get(index).dataTypeInstance.literals.get(index2))»«IF index2 !== datavalues.get(index).dataTypeInstance.literals.size -1 » , «ENDIF»
			«ENDFOR»
		   ]
		}«IF index !== datavalues.size -1 » , «ENDIF»
		«ENDFOR»
		],
	'''
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
					«FOR index3 : 0 ..< dataTypeValue.dataTypeInstance.literals.size»
						«this.attoUtil.getLiteralValueAsString(dataTypeValue.dataTypeInstance.literals.get(index3))»«IF index3 !== dataTypeValue.dataTypeInstance.literals.size -1 » , «ENDIF»
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
				  	   "output_expect" : «this.attoUtil.getOutputExpressionAsString(tests.get(index).outputExpression)»,
				  	   "output_actual": null
				}«IF index !== tests.size -1 » , «ENDIF»
		«ENDFOR»
		]
	'''
}
