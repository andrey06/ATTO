/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl;

import java.lang.String;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.Literal2#getVariable <em>Variable</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.Literal2#getPrimary <em>Primary</em>}</li>
 * </ul>
 *
 * @see com.aestheticintegration.atto.itlDsl.ItlDslPackage#getLiteral2()
 * @model
 * @generated
 */
public interface Literal2 extends EObject
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' attribute.
   * @see #setVariable(String)
   * @see com.aestheticintegration.atto.itlDsl.ItlDslPackage#getLiteral2_Variable()
   * @model
   * @generated
   */
  String getVariable();

  /**
   * Sets the value of the '{@link com.aestheticintegration.atto.itlDsl.Literal2#getVariable <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' attribute.
   * @see #getVariable()
   * @generated
   */
  void setVariable(String value);

  /**
   * Returns the value of the '<em><b>Primary</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primary</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary</em>' containment reference.
   * @see #setPrimary(Primary)
   * @see com.aestheticintegration.atto.itlDsl.ItlDslPackage#getLiteral2_Primary()
   * @model containment="true"
   * @generated
   */
  Primary getPrimary();

  /**
   * Sets the value of the '{@link com.aestheticintegration.atto.itlDsl.Literal2#getPrimary <em>Primary</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary</em>' containment reference.
   * @see #getPrimary()
   * @generated
   */
  void setPrimary(Primary value);

} // Literal2
