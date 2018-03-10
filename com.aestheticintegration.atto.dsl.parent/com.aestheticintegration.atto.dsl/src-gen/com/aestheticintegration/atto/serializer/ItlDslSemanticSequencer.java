/*
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.serializer;

import com.aestheticintegration.atto.itlDsl.BoolExpression;
import com.aestheticintegration.atto.itlDsl.DataType;
import com.aestheticintegration.atto.itlDsl.DataTypeInstance;
import com.aestheticintegration.atto.itlDsl.DataTypeValue;
import com.aestheticintegration.atto.itlDsl.DefDataType;
import com.aestheticintegration.atto.itlDsl.DefDataValue;
import com.aestheticintegration.atto.itlDsl.DefFunction;
import com.aestheticintegration.atto.itlDsl.DefImport;
import com.aestheticintegration.atto.itlDsl.DefTest;
import com.aestheticintegration.atto.itlDsl.ExpOrIfStatement;
import com.aestheticintegration.atto.itlDsl.FunctionBody;
import com.aestheticintegration.atto.itlDsl.IfStatement;
import com.aestheticintegration.atto.itlDsl.InputParam;
import com.aestheticintegration.atto.itlDsl.ItlDslPackage;
import com.aestheticintegration.atto.itlDsl.Literal;
import com.aestheticintegration.atto.itlDsl.Literal2;
import com.aestheticintegration.atto.itlDsl.Model;
import com.aestheticintegration.atto.itlDsl.Statement;
import com.aestheticintegration.atto.services.ItlDslGrammarAccess;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ItlDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ItlDslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ItlDslPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ItlDslPackage.BOOL_EXPRESSION:
				sequence_BoolExpression(context, (BoolExpression) semanticObject); 
				return; 
			case ItlDslPackage.BOOLEAN:
				if (rule == grammarAccess.getOutputExpressionRule()) {
					sequence_OutputExpression(context, (com.aestheticintegration.atto.itlDsl.Boolean) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPrimaryRule()) {
					sequence_Primary(context, (com.aestheticintegration.atto.itlDsl.Boolean) semanticObject); 
					return; 
				}
				else break;
			case ItlDslPackage.DATA_TYPE:
				sequence_DataType(context, (DataType) semanticObject); 
				return; 
			case ItlDslPackage.DATA_TYPE_INSTANCE:
				if (rule == grammarAccess.getDataTypeInstanceRule()) {
					sequence_DataTypeInstance(context, (DataTypeInstance) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOutputExpressionRule()) {
					sequence_OutputExpression(context, (DataTypeInstance) semanticObject); 
					return; 
				}
				else break;
			case ItlDslPackage.DATA_TYPE_VALUE:
				sequence_DataTypeValue(context, (DataTypeValue) semanticObject); 
				return; 
			case ItlDslPackage.DEF_DATA_TYPE:
				sequence_DefDataType(context, (DefDataType) semanticObject); 
				return; 
			case ItlDslPackage.DEF_DATA_VALUE:
				if (rule == grammarAccess.getDefDataValueRule()) {
					sequence_DefDataValue(context, (DefDataValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOutputExpressionRule()) {
					sequence_OutputExpression(context, (DefDataValue) semanticObject); 
					return; 
				}
				else break;
			case ItlDslPackage.DEF_FUNCTION:
				sequence_DefFunction(context, (DefFunction) semanticObject); 
				return; 
			case ItlDslPackage.DEF_IMPORT:
				sequence_DefImport(context, (DefImport) semanticObject); 
				return; 
			case ItlDslPackage.DEF_TEST:
				sequence_DefTest(context, (DefTest) semanticObject); 
				return; 
			case ItlDslPackage.EXCEPTION:
				sequence_OutputExpression(context, (com.aestheticintegration.atto.itlDsl.Exception) semanticObject); 
				return; 
			case ItlDslPackage.EXP_OR_IF_STATEMENT:
				sequence_ExpOrIfStatement(context, (ExpOrIfStatement) semanticObject); 
				return; 
			case ItlDslPackage.FLOAT:
				if (rule == grammarAccess.getOutputExpressionRule()) {
					sequence_OutputExpression(context, (com.aestheticintegration.atto.itlDsl.Float) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPrimaryRule()) {
					sequence_Primary(context, (com.aestheticintegration.atto.itlDsl.Float) semanticObject); 
					return; 
				}
				else break;
			case ItlDslPackage.FUNCTION_BODY:
				sequence_FunctionBody(context, (FunctionBody) semanticObject); 
				return; 
			case ItlDslPackage.IF_STATEMENT:
				sequence_IfStatement(context, (IfStatement) semanticObject); 
				return; 
			case ItlDslPackage.INPUT_PARAM:
				sequence_InputParam(context, (InputParam) semanticObject); 
				return; 
			case ItlDslPackage.INTEGER:
				if (rule == grammarAccess.getOutputExpressionRule()) {
					sequence_OutputExpression(context, (com.aestheticintegration.atto.itlDsl.Integer) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPrimaryRule()) {
					sequence_Primary(context, (com.aestheticintegration.atto.itlDsl.Integer) semanticObject); 
					return; 
				}
				else break;
			case ItlDslPackage.LITERAL:
				sequence_Literal(context, (Literal) semanticObject); 
				return; 
			case ItlDslPackage.LITERAL2:
				sequence_Literal2(context, (Literal2) semanticObject); 
				return; 
			case ItlDslPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case ItlDslPackage.STATEMENT:
				sequence_Statement(context, (Statement) semanticObject); 
				return; 
			case ItlDslPackage.STRING:
				if (rule == grammarAccess.getOutputExpressionRule()) {
					sequence_OutputExpression(context, (com.aestheticintegration.atto.itlDsl.String) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPrimaryRule()) {
					sequence_Primary(context, (com.aestheticintegration.atto.itlDsl.String) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     BoolExpression returns BoolExpression
	 *
	 * Constraint:
	 *     (
	 *         literalLeft=Literal 
	 *         (
	 *             (
	 *                 sign='<=' | 
	 *                 sign='>=' | 
	 *                 sign='>' | 
	 *                 sign='<' | 
	 *                 sign='=' | 
	 *                 sign='<>'
	 *             ) 
	 *             literalRight=Literal
	 *         )?
	 *     )
	 */
	protected void sequence_BoolExpression(ISerializationContext context, BoolExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeInstance returns DataTypeInstance
	 *
	 * Constraint:
	 *     (defDataType=[DefDataType|ID] (literals+=Literal literals+=Literal*)*)
	 */
	protected void sequence_DataTypeInstance(ISerializationContext context, DataTypeInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataTypeValue returns DataTypeValue
	 *
	 * Constraint:
	 *     (primary=Primary | dataTypeInstance=DataTypeInstance | defDataValue=[DefDataValue|ID])
	 */
	protected void sequence_DataTypeValue(ISerializationContext context, DataTypeValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataType returns DataType
	 *
	 * Constraint:
	 *     (
	 *         boolean='boolean' | 
	 *         booleanObj='Boolean' | 
	 *         short='short' | 
	 *         shortObj='Short' | 
	 *         int='int' | 
	 *         integer='Integer' | 
	 *         long='long' | 
	 *         longObj='Long' | 
	 *         float='float' | 
	 *         floatObj='Float' | 
	 *         double='double' | 
	 *         doubleObj='Double' | 
	 *         string='String' | 
	 *         defDataType=[DefDataType|ID]
	 *     )
	 */
	protected void sequence_DataType(ISerializationContext context, DataType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DefDataType returns DefDataType
	 *
	 * Constraint:
	 *     (name=ID fields+=InputParam*)
	 */
	protected void sequence_DefDataType(ISerializationContext context, DefDataType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DefDataValue returns DefDataValue
	 *
	 * Constraint:
	 *     (name=ID dataTypeInstance=DataTypeInstance)
	 */
	protected void sequence_DefDataValue(ISerializationContext context, DefDataValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.DEF_DATA_VALUE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.DEF_DATA_VALUE__NAME));
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.DEF_DATA_VALUE__DATA_TYPE_INSTANCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.DEF_DATA_VALUE__DATA_TYPE_INSTANCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDefDataValueAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getDefDataValueAccess().getDataTypeInstanceDataTypeInstanceParserRuleCall_3_0(), semanticObject.getDataTypeInstance());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DefFunction returns DefFunction
	 *
	 * Constraint:
	 *     (name=QualifiedName2 (inputParams+=InputParam inputParams+=InputParam*)? outputDataType=DataType functionBody=FunctionBody)
	 */
	protected void sequence_DefFunction(ISerializationContext context, DefFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DefImport returns DefImport
	 *
	 * Constraint:
	 *     name=QualifiedName
	 */
	protected void sequence_DefImport(ISerializationContext context, DefImport semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.DEF_IMPORT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.DEF_IMPORT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDefImportAccess().getNameQualifiedNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DefTest returns DefTest
	 *
	 * Constraint:
	 *     (name=ID defFunc=[DefFunction|QualifiedName] (dataTypeValues+=DataTypeValue dataTypeValues+=DataTypeValue*)? outputExpression=OutputExpression)
	 */
	protected void sequence_DefTest(ISerializationContext context, DefTest semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ExpOrIfStatement returns ExpOrIfStatement
	 *
	 * Constraint:
	 *     (outputExpression=OutputExpression | ifStatement=IfStatement)
	 */
	protected void sequence_ExpOrIfStatement(ISerializationContext context, ExpOrIfStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FunctionBody returns FunctionBody
	 *
	 * Constraint:
	 *     statement+=Statement*
	 */
	protected void sequence_FunctionBody(ISerializationContext context, FunctionBody semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     IfStatement returns IfStatement
	 *
	 * Constraint:
	 *     (
	 *         inputBoolExpression+=BoolExpression 
	 *         ((sign+='&&' | sign+='||') inputBoolExpression+=BoolExpression)* 
	 *         thenExpOrIfStatement=ExpOrIfStatement 
	 *         elseExpOrIfStatement=ExpOrIfStatement
	 *     )
	 */
	protected void sequence_IfStatement(ISerializationContext context, IfStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     InputParam returns InputParam
	 *
	 * Constraint:
	 *     (name=ID inputDataType=DataType)
	 */
	protected void sequence_InputParam(ISerializationContext context, InputParam semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.INPUT_PARAM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.INPUT_PARAM__NAME));
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.INPUT_PARAM__INPUT_DATA_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.INPUT_PARAM__INPUT_DATA_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getInputParamAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getInputParamAccess().getInputDataTypeDataTypeParserRuleCall_2_0(), semanticObject.getInputDataType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Literal2 returns Literal2
	 *
	 * Constraint:
	 *     (variable=QualifiedName | primary=Primary)
	 */
	protected void sequence_Literal2(ISerializationContext context, Literal2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Literal returns Literal
	 *
	 * Constraint:
	 *     (variable=QualifiedName | primary=Primary)
	 */
	protected void sequence_Literal(ISerializationContext context, Literal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (
	 *         (imports+=DefImport+ ((datavalues+=DefDataValue+ tests+=DefTest+) | tests+=DefTest+)) | 
	 *         (((imports+=DefImport+ datatypes+=DefDataType+) | datatypes+=DefDataType+) ((datavalues+=DefDataValue+ tests+=DefTest+) | tests+=DefTest+)) | 
	 *         (
	 *             (
	 *                 (imports+=DefImport+ ((datatypes+=DefDataType+ datavalues+=DefDataValue+) | datavalues+=DefDataValue+)) | 
	 *                 (datatypes+=DefDataType+ datavalues+=DefDataValue+) | 
	 *                 datavalues+=DefDataValue+
	 *             )? 
	 *             functions+=DefFunction+ 
	 *             tests+=DefTest+
	 *         ) | 
	 *         (datavalues+=DefDataValue+ tests+=DefTest+) | 
	 *         tests+=DefTest+
	 *     )?
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     OutputExpression returns Boolean
	 *
	 * Constraint:
	 *     valueBoolean=BOOLEAN
	 */
	protected void sequence_OutputExpression(ISerializationContext context, com.aestheticintegration.atto.itlDsl.Boolean semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.BOOLEAN__VALUE_BOOLEAN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.BOOLEAN__VALUE_BOOLEAN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOutputExpressionAccess().getValueBooleanBOOLEANTerminalRuleCall_0_1_0(), semanticObject.getValueBoolean());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     OutputExpression returns DataTypeInstance
	 *
	 * Constraint:
	 *     dataTypeInstance=DataTypeInstance
	 */
	protected void sequence_OutputExpression(ISerializationContext context, DataTypeInstance semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.DATA_TYPE_INSTANCE__DATA_TYPE_INSTANCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.DATA_TYPE_INSTANCE__DATA_TYPE_INSTANCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOutputExpressionAccess().getDataTypeInstanceDataTypeInstanceParserRuleCall_4_1_0(), semanticObject.getDataTypeInstance());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     OutputExpression returns DefDataValue
	 *
	 * Constraint:
	 *     valueDataValue=[DefDataValue|ID]
	 */
	protected void sequence_OutputExpression(ISerializationContext context, DefDataValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.DEF_DATA_VALUE__VALUE_DATA_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.DEF_DATA_VALUE__VALUE_DATA_VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOutputExpressionAccess().getValueDataValueDefDataValueIDTerminalRuleCall_5_1_0_1(), semanticObject.eGet(ItlDslPackage.Literals.DEF_DATA_VALUE__VALUE_DATA_VALUE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     OutputExpression returns Exception
	 *
	 * Constraint:
	 *     valueException=STRING
	 */
	protected void sequence_OutputExpression(ISerializationContext context, com.aestheticintegration.atto.itlDsl.Exception semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.EXCEPTION__VALUE_EXCEPTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.EXCEPTION__VALUE_EXCEPTION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOutputExpressionAccess().getValueExceptionSTRINGTerminalRuleCall_6_3_0(), semanticObject.getValueException());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     OutputExpression returns Float
	 *
	 * Constraint:
	 *     valueFloat=FLOAT
	 */
	protected void sequence_OutputExpression(ISerializationContext context, com.aestheticintegration.atto.itlDsl.Float semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.FLOAT__VALUE_FLOAT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.FLOAT__VALUE_FLOAT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOutputExpressionAccess().getValueFloatFLOATTerminalRuleCall_2_1_0(), semanticObject.getValueFloat());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     OutputExpression returns Integer
	 *
	 * Constraint:
	 *     valueInteger=INTEGER
	 */
	protected void sequence_OutputExpression(ISerializationContext context, com.aestheticintegration.atto.itlDsl.Integer semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.INTEGER__VALUE_INTEGER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.INTEGER__VALUE_INTEGER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOutputExpressionAccess().getValueIntegerINTEGERTerminalRuleCall_1_1_0(), semanticObject.getValueInteger());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     OutputExpression returns String
	 *
	 * Constraint:
	 *     valueString=STRING
	 */
	protected void sequence_OutputExpression(ISerializationContext context, com.aestheticintegration.atto.itlDsl.String semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.STRING__VALUE_STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.STRING__VALUE_STRING));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOutputExpressionAccess().getValueStringSTRINGTerminalRuleCall_3_1_0(), semanticObject.getValueString());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Primary returns Boolean
	 *
	 * Constraint:
	 *     valueBoolean=BOOLEAN
	 */
	protected void sequence_Primary(ISerializationContext context, com.aestheticintegration.atto.itlDsl.Boolean semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.BOOLEAN__VALUE_BOOLEAN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.BOOLEAN__VALUE_BOOLEAN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrimaryAccess().getValueBooleanBOOLEANTerminalRuleCall_0_1_0(), semanticObject.getValueBoolean());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Primary returns Float
	 *
	 * Constraint:
	 *     valueFloat=FLOAT
	 */
	protected void sequence_Primary(ISerializationContext context, com.aestheticintegration.atto.itlDsl.Float semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.FLOAT__VALUE_FLOAT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.FLOAT__VALUE_FLOAT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrimaryAccess().getValueFloatFLOATTerminalRuleCall_2_1_0(), semanticObject.getValueFloat());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Primary returns Integer
	 *
	 * Constraint:
	 *     valueInteger=INTEGER
	 */
	protected void sequence_Primary(ISerializationContext context, com.aestheticintegration.atto.itlDsl.Integer semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.INTEGER__VALUE_INTEGER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.INTEGER__VALUE_INTEGER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrimaryAccess().getValueIntegerINTEGERTerminalRuleCall_1_1_0(), semanticObject.getValueInteger());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Primary returns String
	 *
	 * Constraint:
	 *     valueString=STRING
	 */
	protected void sequence_Primary(ISerializationContext context, com.aestheticintegration.atto.itlDsl.String semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ItlDslPackage.Literals.STRING__VALUE_STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ItlDslPackage.Literals.STRING__VALUE_STRING));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrimaryAccess().getValueStringSTRINGTerminalRuleCall_3_1_0(), semanticObject.getValueString());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns Statement
	 *
	 * Constraint:
	 *     (ifStatement=IfStatement | outputExpression=OutputExpression)
	 */
	protected void sequence_Statement(ISerializationContext context, Statement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
