/*
 * Nom de classe : MessageSender
 *
 * Description   :MessageSender fait appel aux services du composant Unifieur pour filtrer les
 *                agents compatibles avec l'agent émetteur de l'annonce. 
 *                L'envoi des annonces est réalisé graçe Ã  l'interface Communication.
 * Version       : 2.0
 *
 * Date          : 31/05/2017
 * 
 * Copyright     : M2 DL , Sondes
 * Created       : M2 DL
 * Modified      : Sondes
 */
package medium.composants;

import Agent.Agir.GenererMessage.Message.Annonce;
import OCPlateforme.OCService;
import medium.services.IEnvAnnonce;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import unifieur.services.IMatching;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MessageSender implements IEnvAnnonce {

	private IMatching matching;
	private ICommunication communication;

	// binding des services requis
	public void setMatching(IMatching matching) {
		this.matching = matching;
	}

	public void setCommunication(ICommunication communication) {
		this.communication = communication;
	}

	/**
	 * Envoi l'annonce ann aux agents compatibles.
	 *
	 * @param agents
	 *            liste d'agents possible destinataire ainsi que leurs services
	 * @param ann
	 *            annonce
	 */
	@Override
	public void sendAnnonce(HashMap<ReferenceAgent, OCService> agents, Annonce ann) {
		System.out.println("***************annonce************" + ann);

		Set cles = agents.keySet();
		Iterator it = cles.iterator();
		while (it.hasNext()) {
			ReferenceAgent cle = (ReferenceAgent) it.next();
			System.out.println("*************** itereteur*************" + cle);

			OCService valeur = agents.get(cle);
			System.out.println("*************** itereteur*************" + valeur);

			if (match(ann, valeur)) {
				communication.diffuserMessage(cle, ann);
				System.out.println("====Msg envoyé====");
			}
		}
	}

	/**
	 * Return always true
	 *
	 * @param ann
	 *            annonces
	 * @param service
	 *            Service
	 * @return boolean
	 */
	private boolean match(Annonce ann, OCService service) {

		return (matching.match(ann.getService(), service));
	}
}
