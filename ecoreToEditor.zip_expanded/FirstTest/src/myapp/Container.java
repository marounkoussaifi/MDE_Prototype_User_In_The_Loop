/**
 */
package myapp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link myapp.Container#getComponent <em>Component</em>}</li>
 * </ul>
 *
 * @see myapp.MyappPackage#getContainer()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SingletonComponent'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot SingletonComponent='self.component->forAll(c1, c2 | c1 <> c2 implies c1.componentName<>c2.componentName)'"
 * @generated
 */
public interface Container extends EObject {
	/**
	 * Returns the value of the '<em><b>Component</b></em>' containment reference list.
	 * The list contents are of type {@link myapp.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' containment reference list.
	 * @see myapp.MyappPackage#getContainer_Component()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getComponent();

} // Container
