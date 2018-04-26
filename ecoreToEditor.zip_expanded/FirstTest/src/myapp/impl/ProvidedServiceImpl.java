/**
 */
package myapp.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import myapp.MyappPackage;
import myapp.ProvidedService;
import myapp.RequiredService;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Provided Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link myapp.impl.ProvidedServiceImpl#getRequiredservice <em>Requiredservice</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProvidedServiceImpl extends ServiceImpl implements ProvidedService {
	/**
	 * The cached value of the '{@link #getRequiredservice() <em>Requiredservice</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredservice()
	 * @generated
	 * @ordered
	 */
	protected EList<RequiredService> requiredservice;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProvidedServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MyappPackage.Literals.PROVIDED_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequiredService> getRequiredservice() {
		if (requiredservice == null) {
			requiredservice = new EObjectWithInverseResolvingEList.ManyInverse<RequiredService>(RequiredService.class, this, MyappPackage.PROVIDED_SERVICE__REQUIREDSERVICE, MyappPackage.REQUIRED_SERVICE__PROVIDEDSERVICE);
		}
		return requiredservice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequiredService> Get() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MyappPackage.PROVIDED_SERVICE__REQUIREDSERVICE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredservice()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MyappPackage.PROVIDED_SERVICE__REQUIREDSERVICE:
				return ((InternalEList<?>)getRequiredservice()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MyappPackage.PROVIDED_SERVICE__REQUIREDSERVICE:
				return getRequiredservice();
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
			case MyappPackage.PROVIDED_SERVICE__REQUIREDSERVICE:
				getRequiredservice().clear();
				getRequiredservice().addAll((Collection<? extends RequiredService>)newValue);
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
			case MyappPackage.PROVIDED_SERVICE__REQUIREDSERVICE:
				getRequiredservice().clear();
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
			case MyappPackage.PROVIDED_SERVICE__REQUIREDSERVICE:
				return requiredservice != null && !requiredservice.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MyappPackage.PROVIDED_SERVICE___GET:
				return Get();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ProvidedServiceImpl
