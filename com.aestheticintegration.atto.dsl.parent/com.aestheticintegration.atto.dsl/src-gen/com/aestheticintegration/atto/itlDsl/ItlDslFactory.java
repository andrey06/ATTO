/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.aestheticintegration.atto.itlDsl.ItlDslPackage
 * @generated
 */
public interface ItlDslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ItlDslFactory eINSTANCE = com.aestheticintegration.atto.itlDsl.impl.ItlDslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Def Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Def Import</em>'.
   * @generated
   */
  DefImport createDefImport();

  /**
   * Returns a new object of class '<em>Def Data Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Def Data Type</em>'.
   * @generated
   */
  DefDataType createDefDataType();

  /**
   * Returns a new object of class '<em>Def Data Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Def Data Value</em>'.
   * @generated
   */
  DefDataValue createDefDataValue();

  /**
   * Returns a new object of class '<em>Data Type Instance</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type Instance</em>'.
   * @generated
   */
  DataTypeInstance createDataTypeInstance();

  /**
   * Returns a new object of class '<em>Def Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Def Function</em>'.
   * @generated
   */
  DefFunction createDefFunction();

  /**
   * Returns a new object of class '<em>Input Param</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input Param</em>'.
   * @generated
   */
  InputParam createInputParam();

  /**
   * Returns a new object of class '<em>Data Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type</em>'.
   * @generated
   */
  DataType createDataType();

  /**
   * Returns a new object of class '<em>Function Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Body</em>'.
   * @generated
   */
  FunctionBody createFunctionBody();

  /**
   * Returns a new object of class '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement</em>'.
   * @generated
   */
  Statement createStatement();

  /**
   * Returns a new object of class '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Statement</em>'.
   * @generated
   */
  IfStatement createIfStatement();

  /**
   * Returns a new object of class '<em>Exp Or If Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exp Or If Statement</em>'.
   * @generated
   */
  ExpOrIfStatement createExpOrIfStatement();

  /**
   * Returns a new object of class '<em>Bool Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Expression</em>'.
   * @generated
   */
  BoolExpression createBoolExpression();

  /**
   * Returns a new object of class '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal</em>'.
   * @generated
   */
  Literal createLiteral();

  /**
   * Returns a new object of class '<em>Literal2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal2</em>'.
   * @generated
   */
  Literal2 createLiteral2();

  /**
   * Returns a new object of class '<em>Primary</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary</em>'.
   * @generated
   */
  Primary createPrimary();

  /**
   * Returns a new object of class '<em>Output Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Output Expression</em>'.
   * @generated
   */
  OutputExpression createOutputExpression();

  /**
   * Returns a new object of class '<em>Def Test</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Def Test</em>'.
   * @generated
   */
  DefTest createDefTest();

  /**
   * Returns a new object of class '<em>Data Type Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type Value</em>'.
   * @generated
   */
  DataTypeValue createDataTypeValue();

  /**
   * Returns a new object of class '<em>Boolean</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean</em>'.
   * @generated
   */
  Boolean createBoolean();

  /**
   * Returns a new object of class '<em>Integer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer</em>'.
   * @generated
   */
  Integer createInteger();

  /**
   * Returns a new object of class '<em>Float</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Float</em>'.
   * @generated
   */
  Float createFloat();

  /**
   * Returns a new object of class '<em>String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String</em>'.
   * @generated
   */
  String createString();

  /**
   * Returns a new object of class '<em>Exception</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exception</em>'.
   * @generated
   */
  Exception createException();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ItlDslPackage getItlDslPackage();

} //ItlDslFactory