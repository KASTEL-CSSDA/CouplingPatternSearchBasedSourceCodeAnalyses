/**
 */
package edu.kit.kastel.sdq.coupling.models.couplinggraph;

import edu.kit.kastel.sdq.coupling.models.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphFactory
 * @model kind="package"
 * @generated
 */
public interface CouplinggraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "couplinggraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/couplinggraph";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "couplinggraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CouplinggraphPackage eINSTANCE = edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplinggraphPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplingGraphImpl <em>Coupling Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplingGraphImpl
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplinggraphPackageImpl#getCouplingGraph()
	 * @generated
	 */
	int COUPLING_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUPLING_GRAPH__NODES = 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUPLING_GRAPH__EDGES = 1;

	/**
	 * The number of structural features of the '<em>Coupling Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUPLING_GRAPH_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Coupling Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUPLING_GRAPH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.EdgeImpl
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplinggraphPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__ID = IdentifierPackage.IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = IdentifierPackage.IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__DESTINATION = IdentifierPackage.IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Security Characteristics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SECURITY_CHARACTERISTICS = IdentifierPackage.IDENTIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = IdentifierPackage.IDENTIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = IdentifierPackage.IDENTIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.NodeImpl
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplinggraphPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = IdentifierPackage.IDENTIFIED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CLASS_NAME = IdentifierPackage.IDENTIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__METHOD_NAME = IdentifierPackage.IDENTIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__START_LINE = IdentifierPackage.IDENTIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__END_LINE = IdentifierPackage.IDENTIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Weaknesses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__WEAKNESSES = IdentifierPackage.IDENTIFIED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = IdentifierPackage.IDENTIFIED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = IdentifierPackage.IDENTIFIED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.MethodIdentificationImpl <em>Method Identification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.MethodIdentificationImpl
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplinggraphPackageImpl#getMethodIdentification()
	 * @generated
	 */
	int METHOD_IDENTIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_IDENTIFICATION__CLASS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_IDENTIFICATION__METHOD_NAME = 1;

	/**
	 * The feature id for the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_IDENTIFICATION__START_LINE = 2;

	/**
	 * The feature id for the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_IDENTIFICATION__END_LINE = 3;

	/**
	 * The number of structural features of the '<em>Method Identification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_IDENTIFICATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Method Identification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_IDENTIFICATION_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph <em>Coupling Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coupling Graph</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph
	 * @generated
	 */
	EClass getCouplingGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph#getNodes()
	 * @see #getCouplingGraph()
	 * @generated
	 */
	EReference getCouplingGraph_Nodes();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edges</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplingGraph#getEdges()
	 * @see #getCouplingGraph()
	 * @generated
	 */
	EReference getCouplingGraph_Edges();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge#getDestination()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Destination();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge#getSecurityCharacteristics <em>Security Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Security Characteristics</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge#getSecurityCharacteristics()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_SecurityCharacteristics();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.Node#getWeaknesses <em>Weaknesses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Weaknesses</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.Node#getWeaknesses()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Weaknesses();

	/**
	 * Returns the meta object for class '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.MethodIdentification <em>Method Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Identification</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.MethodIdentification
	 * @generated
	 */
	EClass getMethodIdentification();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.MethodIdentification#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.MethodIdentification#getClassName()
	 * @see #getMethodIdentification()
	 * @generated
	 */
	EAttribute getMethodIdentification_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.MethodIdentification#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.MethodIdentification#getMethodName()
	 * @see #getMethodIdentification()
	 * @generated
	 */
	EAttribute getMethodIdentification_MethodName();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.MethodIdentification#getStartLine <em>Start Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Line</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.MethodIdentification#getStartLine()
	 * @see #getMethodIdentification()
	 * @generated
	 */
	EAttribute getMethodIdentification_StartLine();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.MethodIdentification#getEndLine <em>End Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Line</em>'.
	 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.MethodIdentification#getEndLine()
	 * @see #getMethodIdentification()
	 * @generated
	 */
	EAttribute getMethodIdentification_EndLine();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CouplinggraphFactory getCouplinggraphFactory();

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
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplingGraphImpl <em>Coupling Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplingGraphImpl
		 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplinggraphPackageImpl#getCouplingGraph()
		 * @generated
		 */
		EClass COUPLING_GRAPH = eINSTANCE.getCouplingGraph();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUPLING_GRAPH__NODES = eINSTANCE.getCouplingGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUPLING_GRAPH__EDGES = eINSTANCE.getCouplingGraph_Edges();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.EdgeImpl
		 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplinggraphPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__DESTINATION = eINSTANCE.getEdge_Destination();

		/**
		 * The meta object literal for the '<em><b>Security Characteristics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SECURITY_CHARACTERISTICS = eINSTANCE.getEdge_SecurityCharacteristics();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.NodeImpl
		 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplinggraphPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Weaknesses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__WEAKNESSES = eINSTANCE.getNode_Weaknesses();

		/**
		 * The meta object literal for the '{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.MethodIdentificationImpl <em>Method Identification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.MethodIdentificationImpl
		 * @see edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.CouplinggraphPackageImpl#getMethodIdentification()
		 * @generated
		 */
		EClass METHOD_IDENTIFICATION = eINSTANCE.getMethodIdentification();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_IDENTIFICATION__CLASS_NAME = eINSTANCE.getMethodIdentification_ClassName();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_IDENTIFICATION__METHOD_NAME = eINSTANCE.getMethodIdentification_MethodName();

		/**
		 * The meta object literal for the '<em><b>Start Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_IDENTIFICATION__START_LINE = eINSTANCE.getMethodIdentification_StartLine();

		/**
		 * The meta object literal for the '<em><b>End Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_IDENTIFICATION__END_LINE = eINSTANCE.getMethodIdentification_EndLine();

	}

} //CouplinggraphPackage
