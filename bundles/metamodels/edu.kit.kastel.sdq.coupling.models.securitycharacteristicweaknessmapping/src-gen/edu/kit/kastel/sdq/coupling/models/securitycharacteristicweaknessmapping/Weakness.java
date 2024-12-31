/**
 */
package edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping;

import edu.kit.kastel.sdq.coupling.models.identifier.Entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Weakness</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness#getViolates <em>Violates</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingPackage#getWeakness()
 * @model
 * @generated
 */
public interface Weakness extends Entity {
	/**
	 * Returns the value of the '<em><b>Violates</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Violates</em>' reference list.
	 * @see edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecuritycharacteristicweaknessmappingPackage#getWeakness_Violates()
	 * @model required="true"
	 * @generated
	 */
	EList<SecurityCharacteristic> getViolates();

} // Weakness
