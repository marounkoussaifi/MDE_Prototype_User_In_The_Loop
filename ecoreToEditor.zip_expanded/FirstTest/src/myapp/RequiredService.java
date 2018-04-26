/**
 */
package myapp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Required Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link myapp.RequiredService#getProvidedservice <em>Providedservice</em>}</li>
 * </ul>
 *
 * @see myapp.MyappPackage#getRequiredService()
 * @model
 * @generated
 */
public interface RequiredService extends Service {
	/**
	 * Returns the value of the '<em><b>Providedservice</b></em>' reference list.
	 * The list contents are of type {@link myapp.ProvidedService}.
	 * It is bidirectional and its opposite is '{@link myapp.ProvidedService#getRequiredservice <em>Requiredservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providedservice</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providedservice</em>' reference list.
	 * @see myapp.MyappPackage#getRequiredService_Providedservice()
	 * @see myapp.ProvidedService#getRequiredservice
	 * @model opposite="requiredservice"
	 * @generated
	 */
	EList<ProvidedService> getProvidedservice();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ProvidedService> Get();

} // RequiredService
