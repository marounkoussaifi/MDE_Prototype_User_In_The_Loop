package Agent.Agir.GestionBinding;

import FacadeAdapter.*;
import MockupCompo.MockupComponent;
import OCPlateforme.OCService;

/**
 * Created by Utilisateur on 09/02/2017.
 */
public class GestionBinding implements IGestionBinding {
    private IBinding binding;
    private OCService serviceFromAgent;
    
    //Edited by Maroun on 02/12/2017
    // Empty declaration just to remove the errors from the edited bind function
    MockupComponent comp1, comp2;

    public GestionBinding(IBinding binding, OCService service) {
        this.binding = binding;
    	this.serviceFromAgent = service;
    }

    /**
     * Appelle le service binding pour bind 2 services
     * @param s1 
     * 			service 1 to bind
     * @param s2
     * 			service 2 to bind
     */
    @Override
    public void bind(OCService service) {
        try {
            this.binding.bind(this.serviceFromAgent, service, comp1, comp2);
        } catch (BindingFailure e) {

        }
    }

    public IBinding getBinding() {
        return binding;
    }
    
    public OCService getServiceFromAgent() {
        return serviceFromAgent;
    }
}
