/**
 */
package edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.impl;

import edu.kit.kastel.sdq.coupling.models.identifier.IdentifierPackage;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingFactory;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingPackage;
import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SecuritycharacteristicweaknessmappingPackageImpl extends EPackageImpl
		implements SecuritycharacteristicweaknessmappingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securityCharacteristicWeaknessMappingRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass weaknessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securityCharacteristicEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SecuritycharacteristicweaknessmappingPackageImpl() {
		super(eNS_URI, SecuritycharacteristicweaknessmappingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link SecuritycharacteristicweaknessmappingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SecuritycharacteristicweaknessmappingPackage init() {
		if (isInited)
			return (SecuritycharacteristicweaknessmappingPackage) EPackage.Registry.INSTANCE
					.getEPackage(SecuritycharacteristicweaknessmappingPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSecuritycharacteristicweaknessmappingPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SecuritycharacteristicweaknessmappingPackageImpl theSecuritycharacteristicweaknessmappingPackage = registeredSecuritycharacteristicweaknessmappingPackage instanceof SecuritycharacteristicweaknessmappingPackageImpl
				? (SecuritycharacteristicweaknessmappingPackageImpl) registeredSecuritycharacteristicweaknessmappingPackage
				: new SecuritycharacteristicweaknessmappingPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSecuritycharacteristicweaknessmappingPackage.createPackageContents();

		// Initialize created meta-data
		theSecuritycharacteristicweaknessmappingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSecuritycharacteristicweaknessmappingPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SecuritycharacteristicweaknessmappingPackage.eNS_URI,
				theSecuritycharacteristicweaknessmappingPackage);
		return theSecuritycharacteristicweaknessmappingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecurityCharacteristicWeaknessMappingRoot() {
		return securityCharacteristicWeaknessMappingRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecurityCharacteristicWeaknessMappingRoot_Weaknesses() {
		return (EReference) securityCharacteristicWeaknessMappingRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecurityCharacteristicWeaknessMappingRoot_SecurityCharacteristics() {
		return (EReference) securityCharacteristicWeaknessMappingRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWeakness() {
		return weaknessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWeakness_Violates() {
		return (EReference) weaknessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecurityCharacteristic() {
		return securityCharacteristicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecuritycharacteristicweaknessmappingFactory getSecuritycharacteristicweaknessmappingFactory() {
		return (SecuritycharacteristicweaknessmappingFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		securityCharacteristicWeaknessMappingRootEClass = createEClass(SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT);
		createEReference(securityCharacteristicWeaknessMappingRootEClass,
				SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__WEAKNESSES);
		createEReference(securityCharacteristicWeaknessMappingRootEClass,
				SECURITY_CHARACTERISTIC_WEAKNESS_MAPPING_ROOT__SECURITY_CHARACTERISTICS);

		weaknessEClass = createEClass(WEAKNESS);
		createEReference(weaknessEClass, WEAKNESS__VIOLATES);

		securityCharacteristicEClass = createEClass(SECURITY_CHARACTERISTIC);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		IdentifierPackage theIdentifierPackage = (IdentifierPackage) EPackage.Registry.INSTANCE
				.getEPackage(IdentifierPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		weaknessEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		securityCharacteristicEClass.getESuperTypes().add(theIdentifierPackage.getEntity());

		// Initialize classes, features, and operations; add parameters
		initEClass(securityCharacteristicWeaknessMappingRootEClass, SecurityCharacteristicWeaknessMappingRoot.class,
				"SecurityCharacteristicWeaknessMappingRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSecurityCharacteristicWeaknessMappingRoot_Weaknesses(), this.getWeakness(), null,
				"weaknesses", null, 1, -1, SecurityCharacteristicWeaknessMappingRoot.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityCharacteristicWeaknessMappingRoot_SecurityCharacteristics(),
				this.getSecurityCharacteristic(), null, "securityCharacteristics", null, 1, -1,
				SecurityCharacteristicWeaknessMappingRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(weaknessEClass, Weakness.class, "Weakness", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWeakness_Violates(), this.getSecurityCharacteristic(), null, "violates", null, 1, -1,
				Weakness.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(securityCharacteristicEClass, SecurityCharacteristic.class, "SecurityCharacteristic", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SecuritycharacteristicweaknessmappingPackageImpl
