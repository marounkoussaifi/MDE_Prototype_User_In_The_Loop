package FacadeAdapter;
import MockupCompo.*;
import OCPlateforme.OCService;

/**
 * Binding Interface : connection of two component's services in a component framework
 * @version 0.1.0
 */
public interface IBinding {
		
	/**
	 * Bind 2 services of components
	 * @param service1
	 * @param service2
	 */
	public void bind(OCService service1, OCService service2, MockupComponent comp1, MockupComponent comp2) throws BindingFailure;
	
	/**
	 * Unbind 2 connected services
	 * @param service1
	 * @param service2
	 */
	public void unbind(OCService service1, OCService service2) throws UnbindingFailure;
}
