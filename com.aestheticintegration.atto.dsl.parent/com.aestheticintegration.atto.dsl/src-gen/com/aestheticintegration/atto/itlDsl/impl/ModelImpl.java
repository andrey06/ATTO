/**
 * generated by Xtext 2.12.0
 */
package com.aestheticintegration.atto.itlDsl.impl;

import com.aestheticintegration.atto.itlDsl.DefDataType;
import com.aestheticintegration.atto.itlDsl.DefDataValue;
import com.aestheticintegration.atto.itlDsl.DefFunction;
import com.aestheticintegration.atto.itlDsl.DefImport;
import com.aestheticintegration.atto.itlDsl.DefTest;
import com.aestheticintegration.atto.itlDsl.ItlDslPackage;
import com.aestheticintegration.atto.itlDsl.Model;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.ModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.ModelImpl#getDatatypes <em>Datatypes</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.ModelImpl#getDatavalues <em>Datavalues</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.ModelImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link com.aestheticintegration.atto.itlDsl.impl.ModelImpl#getTests <em>Tests</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<DefImport> imports;

  /**
   * The cached value of the '{@link #getDatatypes() <em>Datatypes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDatatypes()
   * @generated
   * @ordered
   */
  protected EList<DefDataType> datatypes;

  /**
   * The cached value of the '{@link #getDatavalues() <em>Datavalues</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDatavalues()
   * @generated
   * @ordered
   */
  protected EList<DefDataValue> datavalues;

  /**
   * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctions()
   * @generated
   * @ordered
   */
  protected EList<DefFunction> functions;

  /**
   * The cached value of the '{@link #getTests() <em>Tests</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTests()
   * @generated
   * @ordered
   */
  protected EList<DefTest> tests;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return ItlDslPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DefImport> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<DefImport>(DefImport.class, this, ItlDslPackage.MODEL__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DefDataType> getDatatypes()
  {
    if (datatypes == null)
    {
      datatypes = new EObjectContainmentEList<DefDataType>(DefDataType.class, this, ItlDslPackage.MODEL__DATATYPES);
    }
    return datatypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DefDataValue> getDatavalues()
  {
    if (datavalues == null)
    {
      datavalues = new EObjectContainmentEList<DefDataValue>(DefDataValue.class, this, ItlDslPackage.MODEL__DATAVALUES);
    }
    return datavalues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DefFunction> getFunctions()
  {
    if (functions == null)
    {
      functions = new EObjectContainmentEList<DefFunction>(DefFunction.class, this, ItlDslPackage.MODEL__FUNCTIONS);
    }
    return functions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DefTest> getTests()
  {
    if (tests == null)
    {
      tests = new EObjectContainmentEList<DefTest>(DefTest.class, this, ItlDslPackage.MODEL__TESTS);
    }
    return tests;
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
      case ItlDslPackage.MODEL__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case ItlDslPackage.MODEL__DATATYPES:
        return ((InternalEList<?>)getDatatypes()).basicRemove(otherEnd, msgs);
      case ItlDslPackage.MODEL__DATAVALUES:
        return ((InternalEList<?>)getDatavalues()).basicRemove(otherEnd, msgs);
      case ItlDslPackage.MODEL__FUNCTIONS:
        return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
      case ItlDslPackage.MODEL__TESTS:
        return ((InternalEList<?>)getTests()).basicRemove(otherEnd, msgs);
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
      case ItlDslPackage.MODEL__IMPORTS:
        return getImports();
      case ItlDslPackage.MODEL__DATATYPES:
        return getDatatypes();
      case ItlDslPackage.MODEL__DATAVALUES:
        return getDatavalues();
      case ItlDslPackage.MODEL__FUNCTIONS:
        return getFunctions();
      case ItlDslPackage.MODEL__TESTS:
        return getTests();
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
      case ItlDslPackage.MODEL__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends DefImport>)newValue);
        return;
      case ItlDslPackage.MODEL__DATATYPES:
        getDatatypes().clear();
        getDatatypes().addAll((Collection<? extends DefDataType>)newValue);
        return;
      case ItlDslPackage.MODEL__DATAVALUES:
        getDatavalues().clear();
        getDatavalues().addAll((Collection<? extends DefDataValue>)newValue);
        return;
      case ItlDslPackage.MODEL__FUNCTIONS:
        getFunctions().clear();
        getFunctions().addAll((Collection<? extends DefFunction>)newValue);
        return;
      case ItlDslPackage.MODEL__TESTS:
        getTests().clear();
        getTests().addAll((Collection<? extends DefTest>)newValue);
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
      case ItlDslPackage.MODEL__IMPORTS:
        getImports().clear();
        return;
      case ItlDslPackage.MODEL__DATATYPES:
        getDatatypes().clear();
        return;
      case ItlDslPackage.MODEL__DATAVALUES:
        getDatavalues().clear();
        return;
      case ItlDslPackage.MODEL__FUNCTIONS:
        getFunctions().clear();
        return;
      case ItlDslPackage.MODEL__TESTS:
        getTests().clear();
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
      case ItlDslPackage.MODEL__IMPORTS:
        return imports != null && !imports.isEmpty();
      case ItlDslPackage.MODEL__DATATYPES:
        return datatypes != null && !datatypes.isEmpty();
      case ItlDslPackage.MODEL__DATAVALUES:
        return datavalues != null && !datavalues.isEmpty();
      case ItlDslPackage.MODEL__FUNCTIONS:
        return functions != null && !functions.isEmpty();
      case ItlDslPackage.MODEL__TESTS:
        return tests != null && !tests.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl