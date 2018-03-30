/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl.util;

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
import com.aestheticintegration.atto.itlDsl.Null;
import com.aestheticintegration.atto.itlDsl.OutputExpression;
import com.aestheticintegration.atto.itlDsl.Primary;
import com.aestheticintegration.atto.itlDsl.Statement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.aestheticintegration.atto.itlDsl.ItlDslPackage
 * @generated
 */
public class ItlDslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ItlDslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ItlDslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ItlDslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ItlDslSwitch<Adapter> modelSwitch =
    new ItlDslSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseDefImport(DefImport object)
      {
        return createDefImportAdapter();
      }
      @Override
      public Adapter caseDefDataType(DefDataType object)
      {
        return createDefDataTypeAdapter();
      }
      @Override
      public Adapter caseDefDataValue(DefDataValue object)
      {
        return createDefDataValueAdapter();
      }
      @Override
      public Adapter caseDataTypeInstance(DataTypeInstance object)
      {
        return createDataTypeInstanceAdapter();
      }
      @Override
      public Adapter caseDefFunction(DefFunction object)
      {
        return createDefFunctionAdapter();
      }
      @Override
      public Adapter caseInputParam(InputParam object)
      {
        return createInputParamAdapter();
      }
      @Override
      public Adapter caseDataType(DataType object)
      {
        return createDataTypeAdapter();
      }
      @Override
      public Adapter caseFunctionBody(FunctionBody object)
      {
        return createFunctionBodyAdapter();
      }
      @Override
      public Adapter caseStatement(Statement object)
      {
        return createStatementAdapter();
      }
      @Override
      public Adapter caseIfStatement(IfStatement object)
      {
        return createIfStatementAdapter();
      }
      @Override
      public Adapter caseExpOrIfStatement(ExpOrIfStatement object)
      {
        return createExpOrIfStatementAdapter();
      }
      @Override
      public Adapter caseBoolExpression(BoolExpression object)
      {
        return createBoolExpressionAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseLiteral2(Literal2 object)
      {
        return createLiteral2Adapter();
      }
      @Override
      public Adapter casePrimary(Primary object)
      {
        return createPrimaryAdapter();
      }
      @Override
      public Adapter caseOutputExpression(OutputExpression object)
      {
        return createOutputExpressionAdapter();
      }
      @Override
      public Adapter caseDefTest(DefTest object)
      {
        return createDefTestAdapter();
      }
      @Override
      public Adapter caseDataTypeValue(DataTypeValue object)
      {
        return createDataTypeValueAdapter();
      }
      @Override
      public Adapter caseBoolean(com.aestheticintegration.atto.itlDsl.Boolean object)
      {
        return createBooleanAdapter();
      }
      @Override
      public Adapter caseInteger(com.aestheticintegration.atto.itlDsl.Integer object)
      {
        return createIntegerAdapter();
      }
      @Override
      public Adapter caseFloat(com.aestheticintegration.atto.itlDsl.Float object)
      {
        return createFloatAdapter();
      }
      @Override
      public Adapter caseString(com.aestheticintegration.atto.itlDsl.String object)
      {
        return createStringAdapter();
      }
      @Override
      public Adapter caseNull(Null object)
      {
        return createNullAdapter();
      }
      @Override
      public Adapter caseException(com.aestheticintegration.atto.itlDsl.Exception object)
      {
        return createExceptionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.DefImport <em>Def Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.DefImport
   * @generated
   */
  public Adapter createDefImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.DefDataType <em>Def Data Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.DefDataType
   * @generated
   */
  public Adapter createDefDataTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.DefDataValue <em>Def Data Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.DefDataValue
   * @generated
   */
  public Adapter createDefDataValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.DataTypeInstance <em>Data Type Instance</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.DataTypeInstance
   * @generated
   */
  public Adapter createDataTypeInstanceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.DefFunction <em>Def Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.DefFunction
   * @generated
   */
  public Adapter createDefFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.InputParam <em>Input Param</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.InputParam
   * @generated
   */
  public Adapter createInputParamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.DataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.DataType
   * @generated
   */
  public Adapter createDataTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.FunctionBody <em>Function Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.FunctionBody
   * @generated
   */
  public Adapter createFunctionBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.Statement
   * @generated
   */
  public Adapter createStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.IfStatement
   * @generated
   */
  public Adapter createIfStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.ExpOrIfStatement <em>Exp Or If Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.ExpOrIfStatement
   * @generated
   */
  public Adapter createExpOrIfStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.BoolExpression <em>Bool Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.BoolExpression
   * @generated
   */
  public Adapter createBoolExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.Literal2 <em>Literal2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.Literal2
   * @generated
   */
  public Adapter createLiteral2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.Primary <em>Primary</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.Primary
   * @generated
   */
  public Adapter createPrimaryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.OutputExpression <em>Output Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.OutputExpression
   * @generated
   */
  public Adapter createOutputExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.DefTest <em>Def Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.DefTest
   * @generated
   */
  public Adapter createDefTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.DataTypeValue <em>Data Type Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.DataTypeValue
   * @generated
   */
  public Adapter createDataTypeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.Boolean <em>Boolean</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.Boolean
   * @generated
   */
  public Adapter createBooleanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.Integer <em>Integer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.Integer
   * @generated
   */
  public Adapter createIntegerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.Float <em>Float</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.Float
   * @generated
   */
  public Adapter createFloatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.String <em>String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.String
   * @generated
   */
  public Adapter createStringAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.Null <em>Null</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.Null
   * @generated
   */
  public Adapter createNullAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.aestheticintegration.atto.itlDsl.Exception <em>Exception</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.aestheticintegration.atto.itlDsl.Exception
   * @generated
   */
  public Adapter createExceptionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //ItlDslAdapterFactory
