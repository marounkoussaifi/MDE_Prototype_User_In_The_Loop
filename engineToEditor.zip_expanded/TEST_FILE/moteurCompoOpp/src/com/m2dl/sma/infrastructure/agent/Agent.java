package com.m2dl.sma.infrastructure.agent;

import com.m2dl.sma.infrastructure.etat.EtatAbstract;

public class Agent {
	private final ReferenceAgent referenceAgent;
	private final EtatAbstract etatInitial;

	public Agent(EtatAbstract etatInitial) {
		this.etatInitial = etatInitial;
		this.referenceAgent = new ReferenceAgent();
		this.etatInitial.setReferenceAgent(this.referenceAgent);
	}
	public ReferenceAgent getReferenceAgent() {
		return referenceAgent;
	}
	public EtatAbstract getEtatInitial() {
		return etatInitial;
	}
}
