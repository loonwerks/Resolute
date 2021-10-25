/**
 */
package com.rockwellcollins.atc.resolute.resolute.impl;

import com.rockwellcollins.atc.resolute.resolute.AnalysisStatement;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;
import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.impl.AnnexSubclauseImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.impl.ResoluteSubclauseImpl#getAnalyses <em>Analyses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResoluteSubclauseImpl extends AnnexSubclauseImpl implements ResoluteSubclause
{
  /**
   * The cached value of the '{@link #getAnalyses() <em>Analyses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnalyses()
   * @generated
   * @ordered
   */
  protected EList<AnalysisStatement> analyses;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResoluteSubclauseImpl()
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
    return ResolutePackage.Literals.RESOLUTE_SUBCLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AnalysisStatement> getAnalyses()
  {
    if (analyses == null)
    {
      analyses = new EObjectContainmentEList<AnalysisStatement>(AnalysisStatement.class, this, ResolutePackage.RESOLUTE_SUBCLAUSE__ANALYSES);
    }
    return analyses;
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
      case ResolutePackage.RESOLUTE_SUBCLAUSE__ANALYSES:
        return ((InternalEList<?>)getAnalyses()).basicRemove(otherEnd, msgs);
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
      case ResolutePackage.RESOLUTE_SUBCLAUSE__ANALYSES:
        return getAnalyses();
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
      case ResolutePackage.RESOLUTE_SUBCLAUSE__ANALYSES:
        getAnalyses().clear();
        getAnalyses().addAll((Collection<? extends AnalysisStatement>)newValue);
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
      case ResolutePackage.RESOLUTE_SUBCLAUSE__ANALYSES:
        getAnalyses().clear();
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
      case ResolutePackage.RESOLUTE_SUBCLAUSE__ANALYSES:
        return analyses != null && !analyses.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ResoluteSubclauseImpl
