package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.IAgentListener;

import java.util.List;

public interface IStratOrdonnanceur extends IAgentListener {
	void ordonnancer();

	void changerVitesse(EnumVitesse vitesse);

	List<Agent> arreterOrdonnancement();

	void addOrdonnaceurListener(OrdonnanceurListener ordonnanceurListener);

	public void agentAjoute(Agent agent);

	public void agentRetire(Agent agent);
}
