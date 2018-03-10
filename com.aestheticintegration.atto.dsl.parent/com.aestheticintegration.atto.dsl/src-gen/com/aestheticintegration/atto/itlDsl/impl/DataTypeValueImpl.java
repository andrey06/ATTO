/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl.impl;

import com.aestheticintegration.atto.itlDsl.DataTypeInstance;
import com.aestheticintegration.atto.itlDsl.DataTypeValue;
import com.aestheticintegration.atto.itlDsl.DefDataValue;
import com.aestheticintegration.atto.itlDsl.ItlDslPackage;
import com.aestheticintegration.atto.itlDsl.Primary;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.DataTypeValueImpl#getPrimary <em>Primary</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.DataTypeValueImpl#getDataTypeInstance <em>Data Type Instance</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.DataTypeValueImpl#getDefDataValue <em>Def Data Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataTypeValueImpl extends MinimalEObjectImpl.Container implements DataTypeValue
{
  /**
   * The cached value of the '{@link #getPrimary() <em>Primary</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimary()
   * @generated
   * @ordered
   */
  protected Primary primary;

  /**
   * The cached value of the '{@link #getDataTypeInstance() <em>Data Type Instance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataTypeInstance()
   * @generated
   * @ordered
   */
  protected DataTypeInstance dataTypeInstance;

  /**
   * The cached value of the '{@link #getDefDataValue() <em>Def Data Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefDataValue()
   * @generated
   * @ordered
   */
  protected DefDataValue defDataValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DataTypeValueImpl()
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
    return ItlDslPackage.Literals.DATA_TYPE_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Primary getPrimary()
  {
    return primary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrimary(Primary newPrimary, NotificationChain msgs)
  {
    Primary oldPrimary = primary;
    primary = newPrimary;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ItlDslPackage.DATA_TYPE_VALUE__PRIMARY, oldPrimary, newPrimary);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrimary(Primary newPrimary)
  {
    if (newPrimary != primary)
    {
      NotificationChain msgs = null;
      if (primary != null)
        msgs = ((InternalEObject)primary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.DATA_TYPE_VALUE__PRIMARY, null, msgs);
      if (newPrimary != null)
        msgs = ((InternalEObject)newPrimary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.DATA_TYPE_VALUE__PRIMARY, null, msgs);
      msgs = basicSetPrimary(newPrimary, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.DATA_TYPE_VALUE__PRIMARY, newPrimary, newPrimary));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataTypeInstance getDataTypeInstance()
  {
    return dataTypeInstance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDataTypeInstance(DataTypeInstance newDataTypeInstance, NotificationChain msgs)
  {
    DataTypeInstance oldDataTypeInstance = dataTypeInstance;
    dataTypeInstance = newDataTypeInstance;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ItlDslPackage.DATA_TYPE_VALUE__DATA_TYPE_INSTANCE, oldDataTypeInstance, newDataTypeInstance);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataTypeInstance(DataTypeInstance newDataTypeInstance)
  {
    if (newDataTypeInstance != dataTypeInstance)
    {
      NotificationChain msgs = null;
      if (dataTypeInstance != null)
        msgs = ((InternalEObject)dataTypeInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.DATA_TYPE_VALUE__DATA_TYPE_INSTANCE, null, msgs);
      if (newDataTypeInstance != null)
        msgs = ((InternalEObject)newDataTypeInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.DATA_TYPE_VALUE__DATA_TYPE_INSTANCE, null, msgs);
      msgs = basicSetDataTypeInstance(newDataTypeInstance, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.DATA_TYPE_VALUE__DATA_TYPE_INSTANCE, newDataTypeInstance, newDataTypeInstance));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefDataValue getDefDataValue()
  {
    if (defDataValue != null && defDataValue.eIsProxy())
    {
      InternalEObject oldDefDataValue = (InternalEObject)defDataValue;
      defDataValue = (DefDataValue)eResolveProxy(oldDefDataValue);
      if (defDataValue != oldDefDataValue)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ItlDslPackage.DATA_TYPE_VALUE__DEF_DATA_VALUE, oldDefDataValue, defDataValue));
      }
    }
    return defDataValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefDataValue basicGetDefDataValue()
  {
    return defDataValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefDataValue(DefDataValue newDefDataValue)
  {
    DefDataValue oldDefDataValue = defDataValue;
    defDataValue = newDefDataValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.DATA_TYPE_VALUE__DEF_DATA_VALUE, oldDefDataValue, defDataValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ItlDslPackage.DATA_TYPE_VALUE__PRIMARY:
        return basicSetPrimary(null, msgs);
      case ItlDslPackage.DATA_TYPE_VALUE__DATA_TYPE_INSTANCE:
        return basicSetDataTypeInstance(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case ItlDslPackage.DATA_TYPE_VALUE__PRIMARY:
        return getPrimary();
      case ItlDslPackage.DATA_TYPE_VALUE__DATA_TYPE_INSTANCE:
        return getDataTypeInstance();
      case ItlDslPackage.DATA_TYPE_VALUE__DEF_DATA_VALUE:
        if (resolve) return getDefDataValue();
        return basicGetDefDataValue();
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
      case ItlDslPackage.DATA_TYPE_VALUE__PRIMARY:
        setPrimary((Primary)newValue);
        return;
      case ItlDslPackage.DATA_TYPE_VALUE__DATA_TYPE_INSTANCE:
        setDataTypeInstance((DataTypeInstance)newValue);
        return;
      case ItlDslPackage.DATA_TYPE_VALUE__DEF_DATA_VALUE:
        setDefDataValue((DefDataValue)newValue);
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
      case ItlDslPackage.DATA_TYPE_VALUE__PRIMARY:
        setPrimary((Primary)null);
        return;
      case ItlDslPackage.DATA_TYPE_VALUE__DATA_TYPE_INSTANCE:
        setDataTypeInstance((DataTypeInstance)null);
        return;
      case ItlDslPackage.DATA_TYPE_VALUE__DEF_DATA_VALUE:
        setDefDataValue((DefDataValue)null);
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
      case ItlDslPackage.DATA_TYPE_VALUE__PRIMARY:
        return primary != null;
      case ItlDslPackage.DATA_TYPE_VALUE__DATA_TYPE_INSTANCE:
        return dataTypeInstance != null;
      case ItlDslPackage.DATA_TYPE_VALUE__DEF_DATA_VALUE:
        return defDataValue != null;
    }
    return super.eIsSet(featureID);
  }

} //DataTypeValueImpl
