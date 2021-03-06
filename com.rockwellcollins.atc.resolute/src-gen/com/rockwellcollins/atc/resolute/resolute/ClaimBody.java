/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Claim Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.ClaimBody#getClaim <em>Claim</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.ClaimBody#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getClaimBody()
 * @model
 * @generated
 */
public interface ClaimBody extends DefinitionBody
{
  /**
   * Returns the value of the '<em><b>Claim</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.resolute.resolute.ClaimText}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Claim</em>' containment reference list.
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getClaimBody_Claim()
   * @model containment="true"
   * @generated
   */
  EList<ClaimText> getClaim();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.NamedElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getClaimBody_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<NamedElement> getAttributes();

} // ClaimBody
