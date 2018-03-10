/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl.impl;

import com.aestheticintegration.atto.itlDsl.IfStatement;
import com.aestheticintegration.atto.itlDsl.ItlDslPackage;
import com.aestheticintegration.atto.itlDsl.OutputExpression;
import com.aestheticintegration.atto.itlDsl.Statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.StatementImpl#getIfStatement <em>If Statement</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.StatementImpl#getOutputExpression <em>Output Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatementImpl extends MinimalEObjectImpl.Container implements Statement
{
  /**
   * The cached value of the '{@link #getIfStatement() <em>If Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIfStatement()
   * @generated
   * @ordered
   */
  protected IfStatement ifStatement;

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
  protected StatementImpl()
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
    return ItlDslPackage.Literals.STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfStatement getIfStatement()
  {
    return ifStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIfStatement(IfStatement newIfStatement, NotificationChain msgs)
  {
    IfStatement oldIfStatement = ifStatement;
    ifStatement = newIfStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ItlDslPackage.STATEMENT__IF_STATEMENT, oldIfStatement, newIfStatement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIfStatement(IfStatement newIfStatement)
  {
    if (newIfStatement != ifStatement)
    {
      NotificationChain msgs = null;
      if (ifStatement != null)
        msgs = ((InternalEObject)ifStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.STATEMENT__IF_STATEMENT, null, msgs);
      if (newIfStatement != null)
        msgs = ((InternalEObject)newIfStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.STATEMENT__IF_STATEMENT, null, msgs);
      msgs = basicSetIfStatement(newIfStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.STATEMENT__IF_STATEMENT, newIfStatement, newIfStatement));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ItlDslPackage.STATEMENT__OUTPUT_EXPRESSION, oldOutputExpression, newOutputExpression);
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
        msgs = ((InternalEObject)outputExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.STATEMENT__OUTPUT_EXPRESSION, null, msgs);
      if (newOutputExpression != null)
        msgs = ((InternalEObject)newOutputExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ItlDslPackage.STATEMENT__OUTPUT_EXPRESSION, null, msgs);
      msgs = basicSetOutputExpression(newOutputExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ItlDslPackage.STATEMENT__OUTPUT_EXPRESSION, newOutputExpression, newOutputExpression));
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
      case ItlDslPackage.STATEMENT__IF_STATEMENT:
        return basicSetIfStatement(null, msgs);
      case ItlDslPackage.STATEMENT__OUTPUT_EXPRESSION:
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
      case ItlDslPackage.STATEMENT__IF_STATEMENT:
        return getIfStatement();
      case ItlDslPackage.STATEMENT__OUTPUT_EXPRESSION:
        return getOutputExpression();
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
      case ItlDslPackage.STATEMENT__IF_STATEMENT:
        setIfStatement((IfStatement)newValue);
        return;
      case ItlDslPackage.STATEMENT__OUTPUT_EXPRESSION:
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
      case ItlDslPackage.STATEMENT__IF_STATEMENT:
        setIfStatement((IfStatement)null);
        return;
      case ItlDslPackage.STATEMENT__OUTPUT_EXPRESSION:
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
      case ItlDslPackage.STATEMENT__IF_STATEMENT:
        return ifStatement != null;
      case ItlDslPackage.STATEMENT__OUTPUT_EXPRESSION:
        return outputExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //StatementImpl
