package com.m2dl.sma.infrastructure.fabrique;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.etat.EtatAbstract;

public interface ICreationAgent {

	ReferenceAgent creer(EtatAbstract etatInitial);

}
