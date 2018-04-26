/*
 * Nom de classe : Record
 *
 * Description   : permet de stocker les agents disponibles
 * 
 * Version       : 2.0
 *
 * Date          : 11/05/2017
 * 
 * Copyright     : M2 DL , Sondes
 * Created       : 
 * Modified      : Sondes
 */

package medium.composants;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

import OCPlateforme.OCService;
import medium.services.IEnregistrement;
import medium.services.IListeAgents;

import java.util.HashMap;
import java.util.Set;

public class Record implements IListeAgents, IEnregistrement {
	/**
	 * Liste des agents disponibles associées Ã  leurs services.
	 */
	private HashMap<ReferenceAgent, OCService> agents = new HashMap<>();

	/**
	 * Ajoute un agent disponible Ã  la liste.
	 *
	 * @param ref
	 *            nouvel agent
	 * @param service
	 *            service de l'agent
	 */
	@Override
	public void addAgent(ReferenceAgent agent, OCService service) {
		this.agents.put(agent, service);

	}

	/**
	 * Enlève l'agent "agent" de la liste des agents disponibles.
	 *
	 * @param Ref
	 *            agent disparu
	 */
	@Override
	public void removeAgent(ReferenceAgent agent) {
		this.agents.remove(agent);
	}

	/**
	 * Retourne la map des agents disponibles et leurs services associÃ©.
	 *
	 * @return liste d'agents et services
	 */

	@Override
	public HashMap<ReferenceAgent, OCService> getListAgents() {
		return this.agents;
	}
}
