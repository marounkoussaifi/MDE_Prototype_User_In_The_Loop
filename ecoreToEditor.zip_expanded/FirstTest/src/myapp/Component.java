/**
 */
package myapp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link myapp.Component#getComponentName <em>Component Name</em>}</li>
 *   <li>{@link myapp.Component#getService <em>Service</em>}</li>
 * </ul>
 *
 * @see myapp.MyappPackage#getComponent()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SingletonService'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot SingletonService='self.service->forAll(i1, i2 | i1 <> i2 implies i1.ServiceName<>i2.ServiceName)'"
 * @generated
 */
public interface Component extends EObject {
	/**
	 * Returns the value of the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Name</em>' attribute.
	 * @see #setComponentName(String)
	 * @see myapp.MyappPackage#getComponent_ComponentName()
	 * @model required="true"
	 * @generated
	 */
	String getComponentName();

	/**
	 * Sets the value of the '{@link myapp.Component#getComponentName <em>Component Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Name</em>' attribute.
	 * @see #getComponentName()
	 * @generated
	 */
	void setComponentName(String value);

	/**
	 * Returns the value of the '<em><b>Service</b></em>' containment reference list.
	 * The list contents are of type {@link myapp.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' containment reference list.
	 * @see myapp.MyappPackage#getComponent_Service()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Service> getService();

} // Component
