/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Filter Map Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr#getMap <em>Map</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr#getArgs <em>Args</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr#getFilter <em>Filter</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getListFilterMapExpr()
 * @model
 * @generated
 */
public interface ListFilterMapExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Map</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Map</em>' containment reference.
   * @see #setMap(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getListFilterMapExpr_Map()
   * @model containment="true"
   * @generated
   */
  Expr getMap();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr#getMap <em>Map</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Map</em>' containment reference.
   * @see #getMap()
   * @generated
   */
  void setMap(Expr value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.resolute.resolute.Arg}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getListFilterMapExpr_Args()
   * @model containment="true"
   * @generated
   */
  EList<Arg> getArgs();

  /**
   * Returns the value of the '<em><b>Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filter</em>' containment reference.
   * @see #setFilter(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getListFilterMapExpr_Filter()
   * @model containment="true"
   * @generated
   */
  Expr getFilter();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr#getFilter <em>Filter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filter</em>' containment reference.
   * @see #getFilter()
   * @generated
   */
  void setFilter(Expr value);

} // ListFilterMapExpr
