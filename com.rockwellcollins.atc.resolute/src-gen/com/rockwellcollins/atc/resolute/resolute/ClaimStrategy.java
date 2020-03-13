/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.StringLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Claim Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.ClaimStrategy#getVal <em>Val</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getClaimStrategy()
 * @model
 * @generated
 */
public interface ClaimStrategy extends EObject, NamedElement
{
  /**
   * Returns the value of the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' containment reference.
   * @see #setVal(StringLiteral)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getClaimStrategy_Val()
   * @model containment="true"
   * @generated
   */
  StringLiteral getVal();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.ClaimStrategy#getVal <em>Val</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' containment reference.
   * @see #getVal()
   * @generated
   */
  void setVal(StringLiteral value);

} // ClaimStrategy
