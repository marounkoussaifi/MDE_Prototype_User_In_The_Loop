package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.etat.EtatAbstract;

public interface OrdonnanceurListener {

	void changementEtat(ReferenceAgent referenceAgent, EtatAbstract etatAbstract);
}
