/**
 * Copyright (c) 2023, Collins Aerospace.
 * Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
 * including any software or models in source or binary form, as well as any drawings, specifications, 
 * and documentation (collectively "the Data"), to deal in the Data without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or 
 * substantial portions of the Data.
 * 
 * THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
 * 
 * Generated by Xtext version 2.27.0.
 */
package com.rockwellcollins.atc.resolute.resolute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Then Else Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getCond <em>Cond</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getThen <em>Then</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getIfThenElseExpr()
 * @model
 * @generated
 */
public interface IfThenElseExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cond</em>' containment reference.
   * @see #setCond(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getIfThenElseExpr_Cond()
   * @model containment="true"
   * @generated
   */
  Expr getCond();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getCond <em>Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cond</em>' containment reference.
   * @see #getCond()
   * @generated
   */
  void setCond(Expr value);

  /**
   * Returns the value of the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' containment reference.
   * @see #setThen(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getIfThenElseExpr_Then()
   * @model containment="true"
   * @generated
   */
  Expr getThen();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getThen <em>Then</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' containment reference.
   * @see #getThen()
   * @generated
   */
  void setThen(Expr value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getIfThenElseExpr_Else()
   * @model containment="true"
   * @generated
   */
  Expr getElse();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
  void setElse(Expr value);

} // IfThenElseExpr
