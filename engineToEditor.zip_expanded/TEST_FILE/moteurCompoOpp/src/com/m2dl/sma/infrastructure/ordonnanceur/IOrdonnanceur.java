package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

import java.util.List;

public interface IOrdonnanceur {

	void ordonnancer();

	void changerVitesse(EnumVitesse vitesse);

	void changerOrdonnancement(IStratOrdonnanceur stratOrdonnanceur);

	List<Agent> arreterOrdonnancement();

	void ordagentAjoute(Agent agent);

	void OrdagentRetire(Agent agent);

	
}
