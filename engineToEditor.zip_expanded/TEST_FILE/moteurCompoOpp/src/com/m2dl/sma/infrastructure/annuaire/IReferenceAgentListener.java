package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

public interface IReferenceAgentListener {

	void agentAjoute(ReferenceAgent referenceAgent);

	void agentRetire(ReferenceAgent referenceAgent);
}
