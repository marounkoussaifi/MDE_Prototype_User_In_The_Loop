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
 * An implementation of the model object '<em><b>Required Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link myapp.impl.RequiredServiceImpl#getProvidedservice <em>Providedservice</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequiredServiceImpl extends ServiceImpl implements RequiredService {
	/**
	 * The cached value of the '{@link #getProvidedservice() <em>Providedservice</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedservice()
	 * @generated
	 * @ordered
	 */
	protected EList<ProvidedService> providedservice;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequiredServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MyappPackage.Literals.REQUIRED_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProvidedService> getProvidedservice() {
		if (providedservice == null) {
			providedservice = new EObjectWithInverseResolvingEList.ManyInverse<ProvidedService>(ProvidedService.class, this, MyappPackage.REQUIRED_SERVICE__PROVIDEDSERVICE, MyappPackage.PROVIDED_SERVICE__REQUIREDSERVICE);
		}
		return providedservice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProvidedService> Get() {
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
			case MyappPackage.REQUIRED_SERVICE__PROVIDEDSERVICE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProvidedservice()).basicAdd(otherEnd, msgs);
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
			case MyappPackage.REQUIRED_SERVICE__PROVIDEDSERVICE:
				return ((InternalEList<?>)getProvidedservice()).basicRemove(otherEnd, msgs);
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
			case MyappPackage.REQUIRED_SERVICE__PROVIDEDSERVICE:
				return getProvidedservice();
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
			case MyappPackage.REQUIRED_SERVICE__PROVIDEDSERVICE:
				getProvidedservice().clear();
				getProvidedservice().addAll((Collection<? extends ProvidedService>)newValue);
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
			case MyappPackage.REQUIRED_SERVICE__PROVIDEDSERVICE:
				getProvidedservice().clear();
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
			case MyappPackage.REQUIRED_SERVICE__PROVIDEDSERVICE:
				return providedservice != null && !providedservice.isEmpty();
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
			case MyappPackage.REQUIRED_SERVICE___GET:
				return Get();
		}
		return super.eInvoke(operationID, arguments);
	}

} //RequiredServiceImpl
