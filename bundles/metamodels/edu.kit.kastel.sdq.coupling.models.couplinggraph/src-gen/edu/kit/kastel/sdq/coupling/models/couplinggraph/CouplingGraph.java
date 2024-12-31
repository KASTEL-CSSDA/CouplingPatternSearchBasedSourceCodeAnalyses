/**
 */
package edu.kit.kastel.sdq.coupling.models.couplinggraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Coupling Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphPackage#getCouplingGraph()
 * @model
 * @generated
 */
public interface CouplingGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphPackage#getCouplingGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' reference list.
	 * The list contents are of type {@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' reference list.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphPackage#getCouplingGraph_Edges()
	 * @model
	 * @generated
	 */
	EList<Edge> getEdges();

} // CouplingGraph
