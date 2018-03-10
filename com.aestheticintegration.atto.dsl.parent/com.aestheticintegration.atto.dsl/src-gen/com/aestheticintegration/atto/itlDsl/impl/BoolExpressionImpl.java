/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl.impl;

import com.aestheticintegration.atto.itlDsl.BoolExpression;
import com.aestheticintegration.atto.itlDsl.ItlDslPackage;
import com.aestheticintegration.atto.itlDsl.Literal;

import java.lang.String;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bool Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.BoolExpressionImpl#getLiteralLeft <em>Literal Left</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.BoolExpressionImpl#getSign <em>Sign</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.BoolExpressionImpl#getLiteralRight <em>Literal Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoolExpressionImpl extends MinimalEObjectImpl.Container implements BoolExpression
{
  /**
   * The cached value of the '{@link #getLiteralLeft() <em>Literal Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLiteralLeft()
   * @generated
   * @ordered
   */
  protected Literal literalLeft;

  /**
   * The default value of the '{@link #getSign() <em>Sign</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSign()
   * @generated
   * @ordered
   */
  protected static final String SIGN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSign() <em>Sign</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSign()
   * @generated
   * @ordered
   */
  protected String sign = SIGN_EDEFAULT;

  /**
   * The cached value of the '{@link #getLiteralRight() <em>Literal Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLiteralRight()
   * @generated
   * @ordered
   */
  protected Literal literalRight;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BoolExpressionImpl()
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
    return ItlDslPackage.Literals.BOOL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal getLiteralLeft()
  {
    return literalLeft;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLiteralLeft(Literal newLiteralLeft, NotificationChain msgs)
  {
    Literal oldLiteralLeft = literalLeft;
    literalLeft = newLiteralLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ItlDslPackage.BOOL_EXPRESSION__LITERAL_LEFT, oldLiteralLeft, newLiteralLeft);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLiteralLeft(Literal newLiteralLeft)
  {
    if (newLiteralLeft != literalLeft)
    {
      NotificationChain msgs = null;
      if (literalLeft != null)
        msgs = ((InternalEObject)literalLeft).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.BOOL_EXPRESSION__LITERAL_LEFT, null, msgs);
      if (newLiteralLeft != null)
        msgs = ((InternalEObject)newLiteralLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.BOOL_EXPRESSION__LITERAL_LEFT, null, msgs);
      msgs = basicSetLiteralLeft(newLiteralLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.BOOL_EXPRESSION__LITERAL_LEFT, newLiteralLeft, newLiteralLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSign()
  {
    return sign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSign(String newSign)
  {
    String oldSign = sign;
    sign = newSign;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.BOOL_EXPRESSION__SIGN, oldSign, sign));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal getLiteralRight()
  {
    return literalRight;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLiteralRight(Literal newLiteralRight, NotificationChain msgs)
  {
    Literal oldLiteralRight = literalRight;
    literalRight = newLiteralRight;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ItlDslPackage.BOOL_EXPRESSION__LITERAL_RIGHT, oldLiteralRight, newLiteralRight);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLiteralRight(Literal newLiteralRight)
  {
    if (newLiteralRight != literalRight)
    {
      NotificationChain msgs = null;
      if (literalRight != null)
        msgs = ((InternalEObject)literalRight).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.BOOL_EXPRESSION__LITERAL_RIGHT, null, msgs);
      if (newLiteralRight != null)
        msgs = ((InternalEObject)newLiteralRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.BOOL_EXPRESSION__LITERAL_RIGHT, null, msgs);
      msgs = basicSetLiteralRight(newLiteralRight, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.BOOL_EXPRESSION__LITERAL_RIGHT, newLiteralRight, newLiteralRight));
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
      case ItlDslPackage.BOOL_EXPRESSION__LITERAL_LEFT:
        return basicSetLiteralLeft(null, msgs);
      case ItlDslPackage.BOOL_EXPRESSION__LITERAL_RIGHT:
        return basicSetLiteralRight(null, msgs);
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
      case ItlDslPackage.BOOL_EXPRESSION__LITERAL_LEFT:
        return getLiteralLeft();
      case ItlDslPackage.BOOL_EXPRESSION__SIGN:
        return getSign();
      case ItlDslPackage.BOOL_EXPRESSION__LITERAL_RIGHT:
        return getLiteralRight();
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
      case ItlDslPackage.BOOL_EXPRESSION__LITERAL_LEFT:
        setLiteralLeft((Literal)newValue);
        return;
      case ItlDslPackage.BOOL_EXPRESSION__SIGN:
        setSign((String)newValue);
        return;
      case ItlDslPackage.BOOL_EXPRESSION__LITERAL_RIGHT:
        setLiteralRight((Literal)newValue);
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
      case ItlDslPackage.BOOL_EXPRESSION__LITERAL_LEFT:
        setLiteralLeft((Literal)null);
        return;
      case ItlDslPackage.BOOL_EXPRESSION__SIGN:
        setSign(SIGN_EDEFAULT);
        return;
      case ItlDslPackage.BOOL_EXPRESSION__LITERAL_RIGHT:
        setLiteralRight((Literal)null);
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
      case ItlDslPackage.BOOL_EXPRESSION__LITERAL_LEFT:
        return literalLeft != null;
      case ItlDslPackage.BOOL_EXPRESSION__SIGN:
        return SIGN_EDEFAULT == null ? sign != null : !SIGN_EDEFAULT.equals(sign);
      case ItlDslPackage.BOOL_EXPRESSION__LITERAL_RIGHT:
        return literalRight != null;
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
    result.append(" (sign: ");
    result.append(sign);
    result.append(')');
    return result.toString();
  }

} //BoolExpressionImpl