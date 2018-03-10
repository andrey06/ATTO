/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl;

import java.lang.String;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.IfStatement#getInputBoolExpression <em>Input Bool Expression</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.IfStatement#getSign <em>Sign</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.IfStatement#getThenExpOrIfStatement <em>Then Exp Or If Statement</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.IfStatement#getElseExpOrIfStatement <em>Else Exp Or If Statement</em>}</li>
 * </ul>
 *
 * @see com.aestheticintegration.atto.itlDsl.ItlDslPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends EObject
{
  /**
   * Returns the value of the '<em><b>Input Bool Expression</b></em>' containment reference list.
   * The list contents are of type {@link com.aestheticintegration.atto.itlDsl.BoolExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Input Bool Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input Bool Expression</em>' containment reference list.
   * @see com.aestheticintegration.atto.itlDsl.ItlDslPackage#getIfStatement_InputBoolExpression()
   * @model containment="true"
   * @generated
   */
  EList<BoolExpression> getInputBoolExpression();

  /**
   * Returns the value of the '<em><b>Sign</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sign</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sign</em>' attribute list.
   * @see com.aestheticintegration.atto.itlDsl.ItlDslPackage#getIfStatement_Sign()
   * @model unique="false"
   * @generated
   */
  EList<String> getSign();

  /**
   * Returns the value of the '<em><b>Then Exp Or If Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Exp Or If Statement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Exp Or If Statement</em>' containment reference.
   * @see #setThenExpOrIfStatement(ExpOrIfStatement)
   * @see com.aestheticintegration.atto.itlDsl.ItlDslPackage#getIfStatement_ThenExpOrIfStatement()
   * @model containment="true"
   * @generated
   */
  ExpOrIfStatement getThenExpOrIfStatement();

  /**
   * Sets the value of the '{@link com.aestheticintegration.atto.itlDsl.IfStatement#getThenExpOrIfStatement <em>Then Exp Or If Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Exp Or If Statement</em>' containment reference.
   * @see #getThenExpOrIfStatement()
   * @generated
   */
  void setThenExpOrIfStatement(ExpOrIfStatement value);

  /**
   * Returns the value of the '<em><b>Else Exp Or If Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Exp Or If Statement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Exp Or If Statement</em>' containment reference.
   * @see #setElseExpOrIfStatement(ExpOrIfStatement)
   * @see com.aestheticintegration.atto.itlDsl.ItlDslPackage#getIfStatement_ElseExpOrIfStatement()
   * @model containment="true"
   * @generated
   */
  ExpOrIfStatement getElseExpOrIfStatement();

  /**
   * Sets the value of the '{@link com.aestheticintegration.atto.itlDsl.IfStatement#getElseExpOrIfStatement <em>Else Exp Or If Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Exp Or If Statement</em>' containment reference.
   * @see #getElseExpOrIfStatement()
   * @generated
   */
  void setElseExpOrIfStatement(ExpOrIfStatement value);

} // IfStatement
