/**
 */
package edu.kit.kastel.sdq.coupling.models.couplinggraph;

import edu.kit.kastel.sdq.coupling.models.identifier.IdentifiedElement;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Node#getWeaknesses <em>Weaknesses</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends IdentifiedElement, MethodIdentification {
	/**
	 * Returns the value of the '<em><b>Weaknesses</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weaknesses</em>' reference list.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphPackage#getNode_Weaknesses()
	 * @model
	 * @generated
	 */
	EList<Weakness> getWeaknesses();

} // Node
