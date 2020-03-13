/**
 */
package com.rockwellcollins.atc.resolute.resolute.impl;

import com.rockwellcollins.atc.resolute.resolute.ClaimBody;
import com.rockwellcollins.atc.resolute.resolute.ClaimText;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Claim Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimBodyImpl#getClaim <em>Claim</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimBodyImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClaimBodyImpl extends DefinitionBodyImpl implements ClaimBody
{
  /**
   * The cached value of the '{@link #getClaim() <em>Claim</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClaim()
   * @generated
   * @ordered
   */
  protected EList<ClaimText> claim;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<NamedElement> attributes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClaimBodyImpl()
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
    return ResolutePackage.Literals.CLAIM_BODY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ClaimText> getClaim()
  {
    if (claim == null)
    {
      claim = new EObjectContainmentEList<ClaimText>(ClaimText.class, this, ResolutePackage.CLAIM_BODY__CLAIM);
    }
    return claim;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<NamedElement> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<NamedElement>(NamedElement.class, this, ResolutePackage.CLAIM_BODY__ATTRIBUTES);
    }
    return attributes;
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
      case ResolutePackage.CLAIM_BODY__CLAIM:
        return ((InternalEList<?>)getClaim()).basicRemove(otherEnd, msgs);
      case ResolutePackage.CLAIM_BODY__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
      case ResolutePackage.CLAIM_BODY__CLAIM:
        return getClaim();
      case ResolutePackage.CLAIM_BODY__ATTRIBUTES:
        return getAttributes();
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
      case ResolutePackage.CLAIM_BODY__CLAIM:
        getClaim().clear();
        getClaim().addAll((Collection<? extends ClaimText>)newValue);
        return;
      case ResolutePackage.CLAIM_BODY__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends NamedElement>)newValue);
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
      case ResolutePackage.CLAIM_BODY__CLAIM:
        getClaim().clear();
        return;
      case ResolutePackage.CLAIM_BODY__ATTRIBUTES:
        getAttributes().clear();
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
      case ResolutePackage.CLAIM_BODY__CLAIM:
        return claim != null && !claim.isEmpty();
      case ResolutePackage.CLAIM_BODY__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ClaimBodyImpl
