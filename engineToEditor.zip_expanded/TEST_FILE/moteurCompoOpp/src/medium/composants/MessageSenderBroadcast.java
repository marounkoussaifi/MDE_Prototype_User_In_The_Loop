/*
 * Nom de classe : MessageSenderBroadcast
 *
 * Description   : Version Broadcast de MessageSender.
 *                 L'annonce reçu via le Mediator est envoyée à toute la liste des agents disponibles.
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

import java.util.HashMap;
import java.util.Map;

public class MessageSenderBroadcast implements IEnvAnnonce {

	// private IMatching matching;
	private ICommunication communication;

	/**
	 * Envoi l'annonce "ann" Ã  tous les agents de la map.
	 *
	 * @param agents
	 *            map d'agents possible destinataire ainsi que leurs services
	 * @param ann
	 *            annonce
	 */
	@Override
	public void sendAnnonce(HashMap<ReferenceAgent, OCService> agents, Annonce ann) {
		for (Map.Entry<ReferenceAgent, OCService> agent : agents.entrySet()) {
			communication.diffuserMessage(agent.getKey(), ann);

		}
	}
}
