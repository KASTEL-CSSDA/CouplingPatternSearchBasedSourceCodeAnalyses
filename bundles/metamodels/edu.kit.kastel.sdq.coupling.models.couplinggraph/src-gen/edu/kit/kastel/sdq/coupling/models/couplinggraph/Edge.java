/**
 */
package edu.kit.kastel.sdq.coupling.models.couplinggraph;

import edu.kit.kastel.sdq.coupling.models.identifier.IdentifiedElement;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge#getDestination <em>Destination</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge#getSecurityCharacteristics <em>Security Characteristics</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends IdentifiedElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphPackage#getEdge_Source()
	 * @model required="true"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(Node)
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphPackage#getEdge_Destination()
	 * @model required="true"
	 * @generated
	 */
	Node getDestination();

	/**
	 * Sets the value of the '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(Node value);

	/**
	 * Returns the value of the '<em><b>Security Characteristics</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Characteristics</em>' reference list.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphPackage#getEdge_SecurityCharacteristics()
	 * @model
	 * @generated
	 */
	EList<SecurityCharacteristic> getSecurityCharacteristics();

} // Edge
