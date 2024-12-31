/**
 */
package edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SecuritycharacteristicweaknessmappingFactoryImpl extends EFactoryImpl
		implements SecuritycharacteristicweaknessmappingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SecuritycharacteristicweaknessmappingFactory init() {
		try {
			SecuritycharacteristicweaknessmappingFactory theSecuritycharacteristicweaknessmappingFactory = (SecuritycharacteristicweaknessmappingFactory) EPackage.Registry.INSTANCE
					.getEFactory(SecuritycharacteristicweaknessmappingPackage.eNS_URI);
			if (theSecuritycharacteristicweaknessmappingFactory != null) {
				return theSecuritycharacteristicweaknessmappingFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SecuritycharacteristicweaknessmappingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecuritycharacteristicweaknessmappingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT:
			return createSecurityCharacteristicWeaknessMappingRoot();
		case SecuritycharacteristicweaknessmappingPackage.WEAKNESS:
			return createWeakness();
		case SecuritycharacteristicweaknessmappingPackage.SECURITY_CHARACTERISTIC:
			return createSecurityCharacteristic();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityCharacteristicWeaknessMappingRoot createSecurityCharacteristicWeaknessMappingRoot() {
		SecurityCharacteristicWeaknessMappingRootImpl securityCharacteristicWeaknessMappingRoot = new SecurityCharacteristicWeaknessMappingRootImpl();
		return securityCharacteristicWeaknessMappingRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Weakness createWeakness() {
		WeaknessImpl weakness = new WeaknessImpl();
		return weakness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityCharacteristic createSecurityCharacteristic() {
		SecurityCharacteristicImpl securityCharacteristic = new SecurityCharacteristicImpl();
		return securityCharacteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecuritycharacteristicweaknessmappingPackage getSecuritycharacteristicweaknessmappingPackage() {
		return (SecuritycharacteristicweaknessmappingPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SecuritycharacteristicweaknessmappingPackage getPackage() {
		return SecuritycharacteristicweaknessmappingPackage.eINSTANCE;
	}

} //SecuritycharacteristicweaknessmappingFactoryImpl
