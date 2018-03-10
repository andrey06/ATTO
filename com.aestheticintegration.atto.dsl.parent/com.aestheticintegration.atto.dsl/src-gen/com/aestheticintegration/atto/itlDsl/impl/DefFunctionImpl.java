/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl.impl;

import com.aestheticintegration.atto.itlDsl.DataType;
import com.aestheticintegration.atto.itlDsl.DefFunction;
import com.aestheticintegration.atto.itlDsl.FunctionBody;
import com.aestheticintegration.atto.itlDsl.InputParam;
import com.aestheticintegration.atto.itlDsl.ItlDslPackage;

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
 * An implementation of the model object '<em><b>Def Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.DefFunctionImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.DefFunctionImpl#getInputParams <em>Input Params</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.DefFunctionImpl#getOutputDataType <em>Output Data Type</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.DefFunctionImpl#getFunctionBody <em>Function Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefFunctionImpl extends MinimalEObjectImpl.Container implements DefFunction
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
   * The cached value of the '{@link #getInputParams() <em>Input Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputParams()
   * @generated
   * @ordered
   */
  protected EList<InputParam> inputParams;

  /**
   * The cached value of the '{@link #getOutputDataType() <em>Output Data Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputDataType()
   * @generated
   * @ordered
   */
  protected DataType outputDataType;

  /**
   * The cached value of the '{@link #getFunctionBody() <em>Function Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionBody()
   * @generated
   * @ordered
   */
  protected FunctionBody functionBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefFunctionImpl()
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
    return ItlDslPackage.Literals.DEF_FUNCTION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.DEF_FUNCTION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InputParam> getInputParams()
  {
    if (inputParams == null)
    {
      inputParams = new EObjectContainmentEList<InputParam>(InputParam.class, this, ItlDslPackage.DEF_FUNCTION__INPUT_PARAMS);
    }
    return inputParams;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType getOutputDataType()
  {
    return outputDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutputDataType(DataType newOutputDataType, NotificationChain msgs)
  {
    DataType oldOutputDataType = outputDataType;
    outputDataType = newOutputDataType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ItlDslPackage.DEF_FUNCTION__OUTPUT_DATA_TYPE, oldOutputDataType, newOutputDataType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutputDataType(DataType newOutputDataType)
  {
    if (newOutputDataType != outputDataType)
    {
      NotificationChain msgs = null;
      if (outputDataType != null)
        msgs = ((InternalEObject)outputDataType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.DEF_FUNCTION__OUTPUT_DATA_TYPE, null, msgs);
      if (newOutputDataType != null)
        msgs = ((InternalEObject)newOutputDataType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.DEF_FUNCTION__OUTPUT_DATA_TYPE, null, msgs);
      msgs = basicSetOutputDataType(newOutputDataType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.DEF_FUNCTION__OUTPUT_DATA_TYPE, newOutputDataType, newOutputDataType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionBody getFunctionBody()
  {
    return functionBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunctionBody(FunctionBody newFunctionBody, NotificationChain msgs)
  {
    FunctionBody oldFunctionBody = functionBody;
    functionBody = newFunctionBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ItlDslPackage.DEF_FUNCTION__FUNCTION_BODY, oldFunctionBody, newFunctionBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunctionBody(FunctionBody newFunctionBody)
  {
    if (newFunctionBody != functionBody)
    {
      NotificationChain msgs = null;
      if (functionBody != null)
        msgs = ((InternalEObject)functionBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.DEF_FUNCTION__FUNCTION_BODY, null, msgs);
      if (newFunctionBody != null)
        msgs = ((InternalEObject)newFunctionBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.DEF_FUNCTION__FUNCTION_BODY, null, msgs);
      msgs = basicSetFunctionBody(newFunctionBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.DEF_FUNCTION__FUNCTION_BODY, newFunctionBody, newFunctionBody));
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
      case ItlDslPackage.DEF_FUNCTION__INPUT_PARAMS:
        return ((InternalEList<?>)getInputParams()).basicRemove(otherEnd, msgs);
      case ItlDslPackage.DEF_FUNCTION__OUTPUT_DATA_TYPE:
        return basicSetOutputDataType(null, msgs);
      case ItlDslPackage.DEF_FUNCTION__FUNCTION_BODY:
        return basicSetFunctionBody(null, msgs);
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
      case ItlDslPackage.DEF_FUNCTION__NAME:
        return getName();
      case ItlDslPackage.DEF_FUNCTION__INPUT_PARAMS:
        return getInputParams();
      case ItlDslPackage.DEF_FUNCTION__OUTPUT_DATA_TYPE:
        return getOutputDataType();
      case ItlDslPackage.DEF_FUNCTION__FUNCTION_BODY:
        return getFunctionBody();
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
      case ItlDslPackage.DEF_FUNCTION__NAME:
        setName((String)newValue);
        return;
      case ItlDslPackage.DEF_FUNCTION__INPUT_PARAMS:
        getInputParams().clear();
        getInputParams().addAll((Collection<? extends InputParam>)newValue);
        return;
      case ItlDslPackage.DEF_FUNCTION__OUTPUT_DATA_TYPE:
        setOutputDataType((DataType)newValue);
        return;
      case ItlDslPackage.DEF_FUNCTION__FUNCTION_BODY:
        setFunctionBody((FunctionBody)newValue);
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
      case ItlDslPackage.DEF_FUNCTION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ItlDslPackage.DEF_FUNCTION__INPUT_PARAMS:
        getInputParams().clear();
        return;
      case ItlDslPackage.DEF_FUNCTION__OUTPUT_DATA_TYPE:
        setOutputDataType((DataType)null);
        return;
      case ItlDslPackage.DEF_FUNCTION__FUNCTION_BODY:
        setFunctionBody((FunctionBody)null);
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
      case ItlDslPackage.DEF_FUNCTION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ItlDslPackage.DEF_FUNCTION__INPUT_PARAMS:
        return inputParams != null && !inputParams.isEmpty();
      case ItlDslPackage.DEF_FUNCTION__OUTPUT_DATA_TYPE:
        return outputDataType != null;
      case ItlDslPackage.DEF_FUNCTION__FUNCTION_BODY:
        return functionBody != null;
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

} //DefFunctionImpl
