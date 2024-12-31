/**
 */
package edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl;

import edu.kit.kastel.sdq.coupling.models.identifier.impl.EntityImpl;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingPackage;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Weakness</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.WeaknessImpl#getViolates <em>Violates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WeaknessImpl extends EntityImpl implements Weakness {
	/**
	 * The cached value of the '{@link #getViolates() <em>Violates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViolates()
	 * @generated
	 * @ordered
	 */
	protected EList<SecurityCharacteristic> violates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WeaknessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecuritycharacteristicweaknessmappingPackage.Literals.WEAKNESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SecurityCharacteristic> getViolates() {
		if (violates == null) {
			violates = new EObjectResolvingEList<SecurityCharacteristic>(SecurityCharacteristic.class, this,
					SecuritycharacteristicweaknessmappingPackage.WEAKNESS__VIOLATES);
		}
		return violates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SecuritycharacteristicweaknessmappingPackage.WEAKNESS__VIOLATES:
			return getViolates();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SecuritycharacteristicweaknessmappingPackage.WEAKNESS__VIOLATES:
			getViolates().clear();
			getViolates().addAll((Collection<? extends SecurityCharacteristic>) newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
		case SecuritycharacteristicweaknessmappingPackage.WEAKNESS__VIOLATES:
			getViolates().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SecuritycharacteristicweaknessmappingPackage.WEAKNESS__VIOLATES:
			return violates != null && !violates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WeaknessImpl
