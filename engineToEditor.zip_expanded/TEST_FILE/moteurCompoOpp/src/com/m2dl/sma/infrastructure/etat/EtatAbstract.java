package com.m2dl.sma.infrastructure.etat;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import com.m2dl.sma.infrastructure.fabrique.ISuicideService;

import java.util.Optional;

public abstract class EtatAbstract {

	private ICommunication communication;

	private ISuicideService suicideService;

	private ReferenceAgent referenceAgent;

	public ICommunication getCommunication() {
		return communication;
	}

	public void setCommunication(ICommunication communication) {
		this.communication = communication;
	}

	public ISuicideService getSuicideService() {
		return suicideService;
	}

	public void setSuicideService(ISuicideService suicideService) {
		this.suicideService = suicideService;
	}

	public ReferenceAgent getReferenceAgent() {
		return referenceAgent;
	}

	public void setReferenceAgent(ReferenceAgent referenceAgent) {
		this.referenceAgent = referenceAgent;
	}

	public abstract Optional<EtatAbstract> executer(); // retourne le IEtat
														// suivant dans le cycle
														// ou �null� si le cycle
														// est termin�
}
