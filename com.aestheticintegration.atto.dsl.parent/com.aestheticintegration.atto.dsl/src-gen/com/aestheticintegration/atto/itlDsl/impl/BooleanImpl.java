/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl.impl;

import com.aestheticintegration.atto.itlDsl.ItlDslPackage;

import java.lang.Boolean;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.BooleanImpl#getValueBoolean <em>Value Boolean</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanImpl extends PrimaryImpl implements com.aestheticintegration.atto.itlDsl.Boolean
{
  /**
   * The default value of the '{@link #getValueBoolean() <em>Value Boolean</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueBoolean()
   * @generated
   * @ordered
   */
  protected static final Boolean VALUE_BOOLEAN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValueBoolean() <em>Value Boolean</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueBoolean()
   * @generated
   * @ordered
   */
  protected Boolean valueBoolean = VALUE_BOOLEAN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BooleanImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ItlDslPackage.Literals.BOOLEAN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Boolean getValueBoolean()
  {
    return valueBoolean;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueBoolean(Boolean newValueBoolean)
  {
    Boolean oldValueBoolean = valueBoolean;
    valueBoolean = newValueBoolean;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.BOOLEAN__VALUE_BOOLEAN, oldValueBoolean, valueBoolean));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ItlDslPackage.BOOLEAN__VALUE_BOOLEAN:
        return getValueBoolean();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ItlDslPackage.BOOLEAN__VALUE_BOOLEAN:
        setValueBoolean((Boolean)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ItlDslPackage.BOOLEAN__VALUE_BOOLEAN:
        setValueBoolean(VALUE_BOOLEAN_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ItlDslPackage.BOOLEAN__VALUE_BOOLEAN:
        return VALUE_BOOLEAN_EDEFAULT == null ? valueBoolean != null : !VALUE_BOOLEAN_EDEFAULT.equals(valueBoolean);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (valueBoolean: ");
    result.append(valueBoolean);
    result.append(')');
    return result.toString();
  }

} //BooleanImpl