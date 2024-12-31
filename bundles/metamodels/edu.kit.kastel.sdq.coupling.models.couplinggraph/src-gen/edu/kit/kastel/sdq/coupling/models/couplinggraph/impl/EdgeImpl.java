/**
 */
package edu.kit.kastel.sdq.coupling.models.couplinggraph.impl;

import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphPackage;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Edge;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;

import edu.kit.kastel.sdq.coupling.models.identifier.impl.IdentifiedElementImpl;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.SecurityCharacteristic;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.EdgeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.EdgeImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.EdgeImpl#getSecurityCharacteristics <em>Security Characteristics</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EdgeImpl extends IdentifiedElementImpl implements Edge {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Node source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected Node destination;

	/**
	 * The cached value of the '{@link #getSecurityCharacteristics() <em>Security Characteristics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityCharacteristics()
	 * @generated
	 * @ordered
	 */
	protected EList<SecurityCharacteristic> securityCharacteristics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CouplinggraphPackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (Node) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CouplinggraphPackage.EDGE__SOURCE,
							oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Node newSource) {
		Node oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CouplinggraphPackage.EDGE__SOURCE, oldSource,
					source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject) destination;
			destination = (Node) eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CouplinggraphPackage.EDGE__DESTINATION,
							oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(Node newDestination) {
		Node oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CouplinggraphPackage.EDGE__DESTINATION,
					oldDestination, destination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SecurityCharacteristic> getSecurityCharacteristics() {
		if (securityCharacteristics == null) {
			securityCharacteristics = new EObjectResolvingEList<SecurityCharacteristic>(SecurityCharacteristic.class,
					this, CouplinggraphPackage.EDGE__SECURITY_CHARACTERISTICS);
		}
		return securityCharacteristics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CouplinggraphPackage.EDGE__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case CouplinggraphPackage.EDGE__DESTINATION:
			if (resolve)
				return getDestination();
			return basicGetDestination();
		case CouplinggraphPackage.EDGE__SECURITY_CHARACTERISTICS:
			return getSecurityCharacteristics();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CouplinggraphPackage.EDGE__SOURCE:
			setSource((Node) newValue);
			return;
		case CouplinggraphPackage.EDGE__DESTINATION:
			setDestination((Node) newValue);
			return;
		case CouplinggraphPackage.EDGE__SECURITY_CHARACTERISTICS:
			getSecurityCharacteristics().clear();
			getSecurityCharacteristics().addAll((Collection<? extends SecurityCharacteristic>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CouplinggraphPackage.EDGE__SOURCE:
			setSource((Node) null);
			return;
		case CouplinggraphPackage.EDGE__DESTINATION:
			setDestination((Node) null);
			return;
		case CouplinggraphPackage.EDGE__SECURITY_CHARACTERISTICS:
			getSecurityCharacteristics().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CouplinggraphPackage.EDGE__SOURCE:
			return source != null;
		case CouplinggraphPackage.EDGE__DESTINATION:
			return destination != null;
		case CouplinggraphPackage.EDGE__SECURITY_CHARACTERISTICS:
			return securityCharacteristics != null && !securityCharacteristics.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EdgeImpl
