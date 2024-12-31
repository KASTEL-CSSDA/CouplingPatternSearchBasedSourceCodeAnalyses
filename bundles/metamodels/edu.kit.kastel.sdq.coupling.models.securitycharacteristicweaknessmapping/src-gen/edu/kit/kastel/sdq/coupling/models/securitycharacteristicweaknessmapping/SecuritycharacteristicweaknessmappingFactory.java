/**
 */
package edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingPackage
 * @generated
 */
public interface SecuritycharacteristicweaknessmappingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SecuritycharacteristicweaknessmappingFactory eINSTANCE = edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecuritycharacteristicweaknessmappingFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Security Characteristic Weakness Mapping Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Security Characteristic Weakness Mapping Root</em>'.
	 * @generated
	 */
	SecurityCharacteristicWeaknessMappingRoot createSecurityCharacteristicWeaknessMappingRoot();

	/**
	 * Returns a new object of class '<em>Weakness</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Weakness</em>'.
	 * @generated
	 */
	Weakness createWeakness();

	/**
	 * Returns a new object of class '<em>Security Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Security Characteristic</em>'.
	 * @generated
	 */
	SecurityCharacteristic createSecurityCharacteristic();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SecuritycharacteristicweaknessmappingPackage getSecuritycharacteristicweaknessmappingPackage();

} //SecuritycharacteristicweaknessmappingFactory
