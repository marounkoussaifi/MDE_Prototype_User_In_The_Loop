/**
 */
package myapp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provided Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link myapp.ProvidedService#getRequiredservice <em>Requiredservice</em>}</li>
 * </ul>
 *
 * @see myapp.MyappPackage#getProvidedService()
 * @model
 * @generated
 */
public interface ProvidedService extends Service {
	/**
	 * Returns the value of the '<em><b>Requiredservice</b></em>' reference list.
	 * The list contents are of type {@link myapp.RequiredService}.
	 * It is bidirectional and its opposite is '{@link myapp.RequiredService#getProvidedservice <em>Providedservice</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requiredservice</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requiredservice</em>' reference list.
	 * @see myapp.MyappPackage#getProvidedService_Requiredservice()
	 * @see myapp.RequiredService#getProvidedservice
	 * @model opposite="providedservice"
	 * @generated
	 */
	EList<RequiredService> getRequiredservice();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<RequiredService> Get();

} // ProvidedService
