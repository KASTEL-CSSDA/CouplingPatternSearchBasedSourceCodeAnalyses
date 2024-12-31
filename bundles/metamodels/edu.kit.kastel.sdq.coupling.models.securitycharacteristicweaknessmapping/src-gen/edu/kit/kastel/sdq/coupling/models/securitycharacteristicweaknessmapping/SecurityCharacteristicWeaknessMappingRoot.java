/**
 */
package edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Security Characteristic Weakness Mapping Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot#getWeaknesses <em>Weaknesses</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristicWeaknessMappingRoot#getSecurityCharacteristics <em>Security Characteristics</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingPackage#getSecurityCharacteristicWeaknessMappingRoot()
 * @model
 * @generated
 */
public interface SecurityCharacteristicWeaknessMappingRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Weaknesses</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weaknesses</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingPackage#getSecurityCharacteristicWeaknessMappingRoot_Weaknesses()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Weakness> getWeaknesses();

	/**
	 * Returns the value of the '<em><b>Security Characteristics</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Characteristics</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingPackage#getSecurityCharacteristicWeaknessMappingRoot_SecurityCharacteristics()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<SecurityCharacteristic> getSecurityCharacteristics();

} // SecurityCharacteristicWeaknessMappingRoot
