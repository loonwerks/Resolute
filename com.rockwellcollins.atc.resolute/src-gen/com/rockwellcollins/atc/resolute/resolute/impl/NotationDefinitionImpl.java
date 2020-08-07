/**
 */
package com.rockwellcollins.atc.resolute.resolute.impl;

import com.rockwellcollins.atc.resolute.resolute.NotationDefinition;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notation Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.impl.NotationDefinitionImpl#getNotation <em>Notation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NotationDefinitionImpl extends DefinitionImpl implements NotationDefinition
{
  /**
   * The default value of the '{@link #getNotation() <em>Notation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNotation()
   * @generated
   * @ordered
   */
  protected static final String NOTATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNotation() <em>Notation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNotation()
   * @generated
   * @ordered
   */
  protected String notation = NOTATION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NotationDefinitionImpl()
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
    return ResolutePackage.Literals.NOTATION_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getNotation()
  {
    return notation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNotation(String newNotation)
  {
    String oldNotation = notation;
    notation = newNotation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ResolutePackage.NOTATION_DEFINITION__NOTATION, oldNotation, notation));
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
      case ResolutePackage.NOTATION_DEFINITION__NOTATION:
        return getNotation();
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
      case ResolutePackage.NOTATION_DEFINITION__NOTATION:
        setNotation((String)newValue);
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
      case ResolutePackage.NOTATION_DEFINITION__NOTATION:
        setNotation(NOTATION_EDEFAULT);
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
      case ResolutePackage.NOTATION_DEFINITION__NOTATION:
        return NOTATION_EDEFAULT == null ? notation != null : !NOTATION_EDEFAULT.equals(notation);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (notation: ");
    result.append(notation);
    result.append(')');
    return result.toString();
  }

} //NotationDefinitionImpl
