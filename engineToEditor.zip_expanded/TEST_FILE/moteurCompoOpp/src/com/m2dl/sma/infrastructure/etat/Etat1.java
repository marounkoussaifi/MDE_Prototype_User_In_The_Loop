package com.m2dl.sma.infrastructure.etat;

import java.util.Optional;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;

import Agent.Agir.GenererMessage.IGenererMessage;
import Agent.Agir.GenererMessage.Message.Annonce;
import Agent.Agir.GenererMessage.Message.Reponse;
import Agent.Decider.ComposantCreationDecision.DecisionGenererMessage;
import OCPlateforme.OCService;

public class Etat1 extends EtatAbstract {
	private ICommunication communication;
	private OCService service;
	private ReferenceAgent referenceAgent;
	private ReferenceAgent to;
	private IGenererMessage genererMessage;
	private DecisionGenererMessage decision;

	public Optional<EtatAbstract> executer() {

		System.out.println("dans Etat1, executer");
		communication.diffuserMessage(referenceAgent, new Annonce(service, referenceAgent));
		// communication.envoyerMessage(referenceAgent, to, new Reponse(service,
		// to));
		// genererMessage.genererMessage(((DecisionGenererMessage)
		// decision).getType(), ((DecisionGenererMessage) decision).getRefTo());

		return Optional.ofNullable(null); // pas d'état suivant
	}

}
