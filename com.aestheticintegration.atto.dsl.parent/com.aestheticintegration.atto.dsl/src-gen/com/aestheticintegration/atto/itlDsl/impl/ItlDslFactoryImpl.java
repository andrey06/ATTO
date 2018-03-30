/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl.impl;

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
import com.aestheticintegration.atto.itlDsl.ItlDslFactory;
import com.aestheticintegration.atto.itlDsl.ItlDslPackage;
import com.aestheticintegration.atto.itlDsl.Literal;
import com.aestheticintegration.atto.itlDsl.Literal2;
import com.aestheticintegration.atto.itlDsl.Model;
import com.aestheticintegration.atto.itlDsl.Null;
import com.aestheticintegration.atto.itlDsl.OutputExpression;
import com.aestheticintegration.atto.itlDsl.Primary;
import com.aestheticintegration.atto.itlDsl.Primitives;
import com.aestheticintegration.atto.itlDsl.Statement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ItlDslFactoryImpl extends EFactoryImpl implements ItlDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ItlDslFactory init()
  {
    try
    {
      ItlDslFactory theItlDslFactory = (ItlDslFactory)EPackage.Registry.INSTANCE.getEFactory(ItlDslPackage.eNS_URI);
      if (theItlDslFactory != null)
      {
        return theItlDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ItlDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ItlDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ItlDslPackage.MODEL: return createModel();
      case ItlDslPackage.DEF_IMPORT: return createDefImport();
      case ItlDslPackage.DEF_DATA_TYPE: return createDefDataType();
      case ItlDslPackage.DEF_DATA_VALUE: return createDefDataValue();
      case ItlDslPackage.DATA_TYPE_INSTANCE: return createDataTypeInstance();
      case ItlDslPackage.DEF_FUNCTION: return createDefFunction();
      case ItlDslPackage.INPUT_PARAM: return createInputParam();
      case ItlDslPackage.DATA_TYPE: return createDataType();
      case ItlDslPackage.FUNCTION_BODY: return createFunctionBody();
      case ItlDslPackage.STATEMENT: return createStatement();
      case ItlDslPackage.IF_STATEMENT: return createIfStatement();
      case ItlDslPackage.EXP_OR_IF_STATEMENT: return createExpOrIfStatement();
      case ItlDslPackage.BOOL_EXPRESSION: return createBoolExpression();
      case ItlDslPackage.LITERAL: return createLiteral();
      case ItlDslPackage.LITERAL2: return createLiteral2();
      case ItlDslPackage.PRIMARY: return createPrimary();
      case ItlDslPackage.OUTPUT_EXPRESSION: return createOutputExpression();
      case ItlDslPackage.DEF_TEST: return createDefTest();
      case ItlDslPackage.DATA_TYPE_VALUE: return createDataTypeValue();
      case ItlDslPackage.BOOLEAN: return createBoolean();
      case ItlDslPackage.INTEGER: return createInteger();
      case ItlDslPackage.FLOAT: return createFloat();
      case ItlDslPackage.STRING: return createString();
      case ItlDslPackage.NULL: return createNull();
      case ItlDslPackage.EXCEPTION: return createException();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ItlDslPackage.PRIMITIVES:
        return createPrimitivesFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ItlDslPackage.PRIMITIVES:
        return convertPrimitivesToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefImport createDefImport()
  {
    DefImportImpl defImport = new DefImportImpl();
    return defImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefDataType createDefDataType()
  {
    DefDataTypeImpl defDataType = new DefDataTypeImpl();
    return defDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefDataValue createDefDataValue()
  {
    DefDataValueImpl defDataValue = new DefDataValueImpl();
    return defDataValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataTypeInstance createDataTypeInstance()
  {
    DataTypeInstanceImpl dataTypeInstance = new DataTypeInstanceImpl();
    return dataTypeInstance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefFunction createDefFunction()
  {
    DefFunctionImpl defFunction = new DefFunctionImpl();
    return defFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputParam createInputParam()
  {
    InputParamImpl inputParam = new InputParamImpl();
    return inputParam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType createDataType()
  {
    DataTypeImpl dataType = new DataTypeImpl();
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionBody createFunctionBody()
  {
    FunctionBodyImpl functionBody = new FunctionBodyImpl();
    return functionBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfStatement createIfStatement()
  {
    IfStatementImpl ifStatement = new IfStatementImpl();
    return ifStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpOrIfStatement createExpOrIfStatement()
  {
    ExpOrIfStatementImpl expOrIfStatement = new ExpOrIfStatementImpl();
    return expOrIfStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolExpression createBoolExpression()
  {
    BoolExpressionImpl boolExpression = new BoolExpressionImpl();
    return boolExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal2 createLiteral2()
  {
    Literal2Impl literal2 = new Literal2Impl();
    return literal2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Primary createPrimary()
  {
    PrimaryImpl primary = new PrimaryImpl();
    return primary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputExpression createOutputExpression()
  {
    OutputExpressionImpl outputExpression = new OutputExpressionImpl();
    return outputExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefTest createDefTest()
  {
    DefTestImpl defTest = new DefTestImpl();
    return defTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataTypeValue createDataTypeValue()
  {
    DataTypeValueImpl dataTypeValue = new DataTypeValueImpl();
    return dataTypeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public com.aestheticintegration.atto.itlDsl.Boolean createBoolean()
  {
    BooleanImpl boolean_ = new BooleanImpl();
    return boolean_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public com.aestheticintegration.atto.itlDsl.Integer createInteger()
  {
    IntegerImpl integer = new IntegerImpl();
    return integer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public com.aestheticintegration.atto.itlDsl.Float createFloat()
  {
    FloatImpl float_ = new FloatImpl();
    return float_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public com.aestheticintegration.atto.itlDsl.String createString()
  {
    StringImpl string = new StringImpl();
    return string;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Null createNull()
  {
    NullImpl null_ = new NullImpl();
    return null_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public com.aestheticintegration.atto.itlDsl.Exception createException()
  {
    ExceptionImpl exception = new ExceptionImpl();
    return exception;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Primitives createPrimitivesFromString(EDataType eDataType, String initialValue)
  {
    Primitives result = Primitives.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertPrimitivesToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ItlDslPackage getItlDslPackage()
  {
    return (ItlDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ItlDslPackage getPackage()
  {
    return ItlDslPackage.eINSTANCE;
  }

} //ItlDslFactoryImpl
