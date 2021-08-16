/**
 * Copyright (c) 2021, Collins Aerospace.
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
 * Generated by Xtext version 2.25.0.
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexLibrary;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getResoluteLibrary()
 * @model
 * @generated
 */
public interface ResoluteLibrary extends EObject, AnnexLibrary
{
  /**
   * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.resolute.resolute.Definition}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definitions</em>' containment reference list.
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getResoluteLibrary_Definitions()
   * @model containment="true"
   * @generated
   */
  EList<Definition> getDefinitions();

} // ResoluteLibrary
