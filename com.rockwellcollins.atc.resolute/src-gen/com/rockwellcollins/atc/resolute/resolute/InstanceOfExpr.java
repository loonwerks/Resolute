/**
 */
package com.rockwellcollins.atc.resolute.resolute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Of Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr#getExpr <em>Expr</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getInstanceOfExpr()
 * @model
 * @generated
 */
public interface InstanceOfExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getInstanceOfExpr_Expr()
   * @model containment="true"
   * @generated
   */
  Expr getExpr();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expr value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(BaseType)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getInstanceOfExpr_Type()
   * @model containment="true"
   * @generated
   */
  BaseType getType();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(BaseType value);

} // InstanceOfExpr
