/**
 */
package edu.kit.kastel.sdq.coupling.models.couplinggraph.impl;

import edu.kit.kastel.sdq.coupling.models.couplinggraph.*;

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
public class CouplinggraphFactoryImpl extends EFactoryImpl implements CouplinggraphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CouplinggraphFactory init() {
		try {
			CouplinggraphFactory theCouplinggraphFactory = (CouplinggraphFactory) EPackage.Registry.INSTANCE
					.getEFactory(CouplinggraphPackage.eNS_URI);
			if (theCouplinggraphFactory != null) {
				return theCouplinggraphFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CouplinggraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CouplinggraphFactoryImpl() {
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
		case CouplinggraphPackage.COUPLING_GRAPH:
			return createCouplingGraph();
		case CouplinggraphPackage.EDGE:
			return createEdge();
		case CouplinggraphPackage.NODE:
			return createNode();
		case CouplinggraphPackage.METHOD_IDENTIFICATION:
			return createMethodIdentification();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CouplingGraph createCouplingGraph() {
		CouplingGraphImpl couplingGraph = new CouplingGraphImpl();
		return couplingGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge createEdge() {
		EdgeImpl edge = new EdgeImpl();
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodIdentification createMethodIdentification() {
		MethodIdentificationImpl methodIdentification = new MethodIdentificationImpl();
		return methodIdentification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CouplinggraphPackage getCouplinggraphPackage() {
		return (CouplinggraphPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CouplinggraphPackage getPackage() {
		return CouplinggraphPackage.eINSTANCE;
	}

} //CouplinggraphFactoryImpl
