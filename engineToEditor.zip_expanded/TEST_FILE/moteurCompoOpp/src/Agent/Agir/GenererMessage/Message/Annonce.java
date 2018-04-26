package Agent.Agir.GenererMessage.Message;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

import FacadeAdapter.*;
import OCPlateforme.OCService;;

/**
 * Created by Utilisateur on 10/02/2017.
 */
public class Annonce extends MessageAgent {
	
	/**
	 * Creer une annonce
	 * @param service
	 * 			service de l'agent annonceur
	 * @param ref
	 * 			reference de l'agent annonceur
	 */
    public Annonce(OCService service, ReferenceAgent ref) {
        this.service = service;
        this.referenceAgent = ref;
    }
}
