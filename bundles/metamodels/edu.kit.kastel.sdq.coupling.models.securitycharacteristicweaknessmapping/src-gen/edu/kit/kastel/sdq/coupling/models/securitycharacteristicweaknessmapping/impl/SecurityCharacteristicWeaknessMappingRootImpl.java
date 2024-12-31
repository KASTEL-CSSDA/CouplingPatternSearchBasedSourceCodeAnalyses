/**
 */
package edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingPackage;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Security Characteristic Weakness Mapping Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecurityCharacteristicWeaknessMappingRootImpl#getWeaknesses <em>Weaknesses</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecurityCharacteristicWeaknessMappingRootImpl#getSecurityCharacteristics <em>Security Characteristics</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecurityCharacteristicWeaknessMappingRootImpl extends MinimalEObjectImpl.Container
		implements SecurityCharacteristicWeaknessMappingRoot {
	/**
	 * The cached value of the '{@link #getWeaknesses() <em>Weaknesses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeaknesses()
	 * @generated
	 * @ordered
	 */
	protected EList<Weakness> weaknesses;

	/**
	 * The cached value of the '{@link #getSecurityCharacteristics() <em>Security Characteristics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityCharacteristics()
	 * @generated
	 * @ordered
	 */
	protected EList<SecurityCharacteristic> securityCharacteristics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SecurityCharacteristicWeaknessMappingRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecuritycharacteristicweaknessmappingPackage.Literals.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Weakness> getWeaknesses() {
		if (weaknesses == null) {
			weaknesses = new EObjectContainmentEList<Weakness>(Weakness.class, this,
					SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__WEAKNESSES);
		}
		return weaknesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SecurityCharacteristic> getSecurityCharacteristics() {
		if (securityCharacteristics == null) {
			securityCharacteristics = new EObjectContainmentEList<SecurityCharacteristic>(SecurityCharacteristic.class,
					this,
					SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__SECURITY_CHARACTERISTICS);
		}
		return securityCharacteristics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__WEAKNESSES:
			return ((InternalEList<?>) getWeaknesses()).basicRemove(otherEnd, msgs);
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__SECURITY_CHARACTERISTICS:
			return ((InternalEList<?>) getSecurityCharacteristics()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__WEAKNESSES:
			return getWeaknesses();
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__SECURITY_CHARACTERISTICS:
			return getSecurityCharacteristics();
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
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__WEAKNESSES:
			getWeaknesses().clear();
			getWeaknesses().addAll((Collection<? extends Weakness>) newValue);
			return;
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__SECURITY_CHARACTERISTICS:
			getSecurityCharacteristics().clear();
			getSecurityCharacteristics().addAll((Collection<? extends SecurityCharacteristic>) newValue);
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
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__WEAKNESSES:
			getWeaknesses().clear();
			return;
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__SECURITY_CHARACTERISTICS:
			getSecurityCharacteristics().clear();
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
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__WEAKNESSES:
			return weaknesses != null && !weaknesses.isEmpty();
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__SECURITY_CHARACTERISTICS:
			return securityCharacteristics != null && !securityCharacteristics.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SecurityCharacteristicWeaknessMappingRootImpl
