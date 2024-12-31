/**
 */
package edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping;

import edu.kit.kastel.sdq.coupling.models.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingFactory
 * @model kind="package"
 * @generated
 */
public interface SecuritycharacteristicweaknessmappingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "securitycharacteristicweaknessmapping";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/securitycharacteristicweaknessmapping";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "securitycharacteristicweaknessmapping";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SecuritycharacteristicweaknessmappingPackage eINSTANCE = edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecuritycharacteristicweaknessmappingPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecurityCharacteristicWeaknessMappingRootImpl <em>Security Characteristic Weakness Mapping Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecurityCharacteristicWeaknessMappingRootImpl
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecuritycharacteristicweaknessmappingPackageImpl#getSecurityCharacteristicWeaknessMappingRoot()
	 * @generated
	 */
	int SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Weaknesses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__WEAKNESSES = 0;

	/**
	 * The feature id for the '<em><b>Security Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__SECURITY_CHARACTERISTICS = 1;

	/**
	 * The number of structural features of the '<em>Security Characteristic Weakness Mapping Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Security Characteristic Weakness Mapping Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.WeaknessImpl <em>Weakness</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.WeaknessImpl
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecuritycharacteristicweaknessmappingPackageImpl#getWeakness()
	 * @generated
	 */
	int WEAKNESS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAKNESS__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAKNESS__NAME = IdentifierPackage.ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Violates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAKNESS__VIOLATES = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Weakness</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAKNESS_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Weakness</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAKNESS_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecurityCharacteristicImpl <em>Security Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecurityCharacteristicImpl
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecuritycharacteristicweaknessmappingPackageImpl#getSecurityCharacteristic()
	 * @generated
	 */
	int SECURITY_CHARACTERISTIC = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CHARACTERISTIC__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CHARACTERISTIC__NAME = IdentifierPackage.ENTITY__NAME;

	/**
	 * The number of structural features of the '<em>Security Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CHARACTERISTIC_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Security Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_CHARACTERISTIC_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot <em>Security Characteristic Weakness Mapping Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Characteristic Weakness Mapping Root</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot
	 * @generated
	 */
	EClass getSecurityCharacteristicWeaknessMappingRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot#getWeaknesses <em>Weaknesses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Weaknesses</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot#getWeaknesses()
	 * @see #getSecurityCharacteristicWeaknessMappingRoot()
	 * @generated
	 */
	EReference getSecurityCharacteristicWeaknessMappingRoot_Weaknesses();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot#getSecurityCharacteristics <em>Security Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Security Characteristics</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot#getSecurityCharacteristics()
	 * @see #getSecurityCharacteristicWeaknessMappingRoot()
	 * @generated
	 */
	EReference getSecurityCharacteristicWeaknessMappingRoot_SecurityCharacteristics();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness <em>Weakness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Weakness</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness
	 * @generated
	 */
	EClass getWeakness();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness#getViolates <em>Violates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Violates</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness#getViolates()
	 * @see #getWeakness()
	 * @generated
	 */
	EReference getWeakness_Violates();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic <em>Security Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Characteristic</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic
	 * @generated
	 */
	EClass getSecurityCharacteristic();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SecuritycharacteristicweaknessmappingFactory getSecuritycharacteristicweaknessmappingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecurityCharacteristicWeaknessMappingRootImpl <em>Security Characteristic Weakness Mapping Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecurityCharacteristicWeaknessMappingRootImpl
		 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecuritycharacteristicweaknessmappingPackageImpl#getSecurityCharacteristicWeaknessMappingRoot()
		 * @generated
		 */
		EClass SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT = eINSTANCE.getSecurityCharacteristicWeaknessMappingRoot();

		/**
		 * The meta object literal for the '<em><b>Weaknesses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__WEAKNESSES = eINSTANCE
				.getSecurityCharacteristicWeaknessMappingRoot_Weaknesses();

		/**
		 * The meta object literal for the '<em><b>Security Characteristics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__SECURITY_CHARACTERISTICS = eINSTANCE
				.getSecurityCharacteristicWeaknessMappingRoot_SecurityCharacteristics();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.WeaknessImpl <em>Weakness</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.WeaknessImpl
		 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecuritycharacteristicweaknessmappingPackageImpl#getWeakness()
		 * @generated
		 */
		EClass WEAKNESS = eINSTANCE.getWeakness();

		/**
		 * The meta object literal for the '<em><b>Violates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WEAKNESS__VIOLATES = eINSTANCE.getWeakness_Violates();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecurityCharacteristicImpl <em>Security Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecurityCharacteristicImpl
		 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl.SecuritycharacteristicweaknessmappingPackageImpl#getSecurityCharacteristic()
		 * @generated
		 */
		EClass SECURITY_CHARACTERISTIC = eINSTANCE.getSecurityCharacteristic();

	}

} //SecuritycharacteristicweaknessmappingPackage
