/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl.impl;

import com.aestheticintegration.atto.itlDsl.DataTypeValue;
import com.aestheticintegration.atto.itlDsl.DefFunction;
import com.aestheticintegration.atto.itlDsl.DefTest;
import com.aestheticintegration.atto.itlDsl.ItlDslPackage;
import com.aestheticintegration.atto.itlDsl.OutputExpression;

import java.lang.String;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Def Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.DefTestImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.DefTestImpl#getDefFunc <em>Def Func</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.DefTestImpl#getDataTypeValues <em>Data Type Values</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.DefTestImpl#getOutputExpression <em>Output Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefTestImpl extends MinimalEObjectImpl.Container implements DefTest
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getDefFunc() <em>Def Func</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefFunc()
   * @generated
   * @ordered
   */
  protected DefFunction defFunc;

  /**
   * The cached value of the '{@link #getDataTypeValues() <em>Data Type Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataTypeValues()
   * @generated
   * @ordered
   */
  protected EList<DataTypeValue> dataTypeValues;

  /**
   * The cached value of the '{@link #getOutputExpression() <em>Output Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputExpression()
   * @generated
   * @ordered
   */
  protected OutputExpression outputExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefTestImpl()
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
    return ItlDslPackage.Literals.DEF_TEST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.DEF_TEST__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefFunction getDefFunc()
  {
    if (defFunc != null && defFunc.eIsProxy())
    {
      InternalEObject oldDefFunc = (InternalEObject)defFunc;
      defFunc = (DefFunction)eResolveProxy(oldDefFunc);
      if (defFunc != oldDefFunc)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ItlDslPackage.DEF_TEST__DEF_FUNC, oldDefFunc, defFunc));
      }
    }
    return defFunc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefFunction basicGetDefFunc()
  {
    return defFunc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefFunc(DefFunction newDefFunc)
  {
    DefFunction oldDefFunc = defFunc;
    defFunc = newDefFunc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.DEF_TEST__DEF_FUNC, oldDefFunc, defFunc));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DataTypeValue> getDataTypeValues()
  {
    if (dataTypeValues == null)
    {
      dataTypeValues = new EObjectContainmentEList<DataTypeValue>(DataTypeValue.class, this, ItlDslPackage.DEF_TEST__DATA_TYPE_VALUES);
    }
    return dataTypeValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputExpression getOutputExpression()
  {
    return outputExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutputExpression(OutputExpression newOutputExpression, NotificationChain msgs)
  {
    OutputExpression oldOutputExpression = outputExpression;
    outputExpression = newOutputExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ItlDslPackage.DEF_TEST__OUTPUT_EXPRESSION, oldOutputExpression, newOutputExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutputExpression(OutputExpression newOutputExpression)
  {
    if (newOutputExpression != outputExpression)
    {
      NotificationChain msgs = null;
      if (outputExpression != null)
        msgs = ((InternalEObject)outputExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.DEF_TEST__OUTPUT_EXPRESSION, null, msgs);
      if (newOutputExpression != null)
        msgs = ((InternalEObject)newOutputExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.DEF_TEST__OUTPUT_EXPRESSION, null, msgs);
      msgs = basicSetOutputExpression(newOutputExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.DEF_TEST__OUTPUT_EXPRESSION, newOutputExpression, newOutputExpression));
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
      case ItlDslPackage.DEF_TEST__DATA_TYPE_VALUES:
        return ((InternalEList<?>)getDataTypeValues()).basicRemove(otherEnd, msgs);
      case ItlDslPackage.DEF_TEST__OUTPUT_EXPRESSION:
        return basicSetOutputExpression(null, msgs);
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
      case ItlDslPackage.DEF_TEST__NAME:
        return getName();
      case ItlDslPackage.DEF_TEST__DEF_FUNC:
        if (resolve) return getDefFunc();
        return basicGetDefFunc();
      case ItlDslPackage.DEF_TEST__DATA_TYPE_VALUES:
        return getDataTypeValues();
      case ItlDslPackage.DEF_TEST__OUTPUT_EXPRESSION:
        return getOutputExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ItlDslPackage.DEF_TEST__NAME:
        setName((String)newValue);
        return;
      case ItlDslPackage.DEF_TEST__DEF_FUNC:
        setDefFunc((DefFunction)newValue);
        return;
      case ItlDslPackage.DEF_TEST__DATA_TYPE_VALUES:
        getDataTypeValues().clear();
        getDataTypeValues().addAll((Collection<? extends DataTypeValue>)newValue);
        return;
      case ItlDslPackage.DEF_TEST__OUTPUT_EXPRESSION:
        setOutputExpression((OutputExpression)newValue);
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
      case ItlDslPackage.DEF_TEST__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ItlDslPackage.DEF_TEST__DEF_FUNC:
        setDefFunc((DefFunction)null);
        return;
      case ItlDslPackage.DEF_TEST__DATA_TYPE_VALUES:
        getDataTypeValues().clear();
        return;
      case ItlDslPackage.DEF_TEST__OUTPUT_EXPRESSION:
        setOutputExpression((OutputExpression)null);
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
      case ItlDslPackage.DEF_TEST__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ItlDslPackage.DEF_TEST__DEF_FUNC:
        return defFunc != null;
      case ItlDslPackage.DEF_TEST__DATA_TYPE_VALUES:
        return dataTypeValues != null && !dataTypeValues.isEmpty();
      case ItlDslPackage.DEF_TEST__OUTPUT_EXPRESSION:
        return outputExpression != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //DefTestImpl