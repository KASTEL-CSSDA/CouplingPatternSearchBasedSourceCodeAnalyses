/**
 */
package edu.kit.kastel.sdq.coupling.models.couplinggraph.impl;

import edu.kit.kastel.sdq.coupling.models.couplinggraph.CouplinggraphPackage;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.MethodIdentification;
import edu.kit.kastel.sdq.coupling.models.couplinggraph.Node;

import edu.kit.kastel.sdq.coupling.models.identifier.impl.IdentifiedElementImpl;

import edu.kit.kastel.sdq.coupling.models.securitycharacteristicweaknessmapping.Weakness;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.NodeImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.NodeImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.NodeImpl#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.NodeImpl#getEndLine <em>End Line</em>}</li>
 *   <li>{@link edu.kit.kastel.sdq.coupling.models.couplinggraph.impl.NodeImpl#getWeaknesses <em>Weaknesses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends IdentifiedElementImpl implements Node {
	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected String methodName = METHOD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected static final int START_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected int startLine = START_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected static final int END_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected int endLine = END_LINE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWeaknesses() <em>Weaknesses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeaknesses()
	 * @generated
	 * @ordered
	 */
	protected EList<Weakness> weaknesses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CouplinggraphPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CouplinggraphPackage.NODE__CLASS_NAME, oldClassName,
					className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodName(String newMethodName) {
		String oldMethodName = methodName;
		methodName = newMethodName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CouplinggraphPackage.NODE__METHOD_NAME, oldMethodName,
					methodName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartLine() {
		return startLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartLine(int newStartLine) {
		int oldStartLine = startLine;
		startLine = newStartLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CouplinggraphPackage.NODE__START_LINE, oldStartLine,
					startLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndLine() {
		return endLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndLine(int newEndLine) {
		int oldEndLine = endLine;
		endLine = newEndLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CouplinggraphPackage.NODE__END_LINE, oldEndLine,
					endLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Weakness> getWeaknesses() {
		if (weaknesses == null) {
			weaknesses = new EObjectResolvingEList<Weakness>(Weakness.class, this,
					CouplinggraphPackage.NODE__WEAKNESSES);
		}
		return weaknesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CouplinggraphPackage.NODE__CLASS_NAME:
			return getClassName();
		case CouplinggraphPackage.NODE__METHOD_NAME:
			return getMethodName();
		case CouplinggraphPackage.NODE__START_LINE:
			return getStartLine();
		case CouplinggraphPackage.NODE__END_LINE:
			return getEndLine();
		case CouplinggraphPackage.NODE__WEAKNESSES:
			return getWeaknesses();
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
		case CouplinggraphPackage.NODE__CLASS_NAME:
			setClassName((String) newValue);
			return;
		case CouplinggraphPackage.NODE__METHOD_NAME:
			setMethodName((String) newValue);
			return;
		case CouplinggraphPackage.NODE__START_LINE:
			setStartLine((Integer) newValue);
			return;
		case CouplinggraphPackage.NODE__END_LINE:
			setEndLine((Integer) newValue);
			return;
		case CouplinggraphPackage.NODE__WEAKNESSES:
			getWeaknesses().clear();
			getWeaknesses().addAll((Collection<? extends Weakness>) newValue);
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
		case CouplinggraphPackage.NODE__CLASS_NAME:
			setClassName(CLASS_NAME_EDEFAULT);
			return;
		case CouplinggraphPackage.NODE__METHOD_NAME:
			setMethodName(METHOD_NAME_EDEFAULT);
			return;
		case CouplinggraphPackage.NODE__START_LINE:
			setStartLine(START_LINE_EDEFAULT);
			return;
		case CouplinggraphPackage.NODE__END_LINE:
			setEndLine(END_LINE_EDEFAULT);
			return;
		case CouplinggraphPackage.NODE__WEAKNESSES:
			getWeaknesses().clear();
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
		case CouplinggraphPackage.NODE__CLASS_NAME:
			return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
		case CouplinggraphPackage.NODE__METHOD_NAME:
			return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
		case CouplinggraphPackage.NODE__START_LINE:
			return startLine != START_LINE_EDEFAULT;
		case CouplinggraphPackage.NODE__END_LINE:
			return endLine != END_LINE_EDEFAULT;
		case CouplinggraphPackage.NODE__WEAKNESSES:
			return weaknesses != null && !weaknesses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MethodIdentification.class) {
			switch (derivedFeatureID) {
			case CouplinggraphPackage.NODE__CLASS_NAME:
				return CouplinggraphPackage.METHOD_IDENTIFICATION__CLASS_NAME;
			case CouplinggraphPackage.NODE__METHOD_NAME:
				return CouplinggraphPackage.METHOD_IDENTIFICATION__METHOD_NAME;
			case CouplinggraphPackage.NODE__START_LINE:
				return CouplinggraphPackage.METHOD_IDENTIFICATION__START_LINE;
			case CouplinggraphPackage.NODE__END_LINE:
				return CouplinggraphPackage.METHOD_IDENTIFICATION__END_LINE;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MethodIdentification.class) {
			switch (baseFeatureID) {
			case CouplinggraphPackage.METHOD_IDENTIFICATION__CLASS_NAME:
				return CouplinggraphPackage.NODE__CLASS_NAME;
			case CouplinggraphPackage.METHOD_IDENTIFICATION__METHOD_NAME:
				return CouplinggraphPackage.NODE__METHOD_NAME;
			case CouplinggraphPackage.METHOD_IDENTIFICATION__START_LINE:
				return CouplinggraphPackage.NODE__START_LINE;
			case CouplinggraphPackage.METHOD_IDENTIFICATION__END_LINE:
				return CouplinggraphPackage.NODE__END_LINE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (className: ");
		result.append(className);
		result.append(", methodName: ");
		result.append(methodName);
		result.append(", startLine: ");
		result.append(startLine);
		result.append(", endLine: ");
		result.append(endLine);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
