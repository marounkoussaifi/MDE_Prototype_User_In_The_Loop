package com.m2dl.sma.infrastructure.annuaire;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import com.m2dl.sma.infrastructure.communication.IMessageAgent;

public interface IAnnuaire extends ICommunication, IGestionAgent {

	void ajouterAgentListener(IAgentListener agentListener);

	void retirerAgentListener(IAgentListener agentListener);

	void ajouterMessageAgentListener(IMessageAgentListener messageAgentListener);

	void retirerMessageAgentListener(IMessageAgentListener messageAgentListener);

	List<IMessageAgentListener> getMessageAgentListeners();

	ConcurrentMap<ReferenceAgent, ConcurrentLinkedQueue<IMessageAgent>>  getAgentsMessagesQueues();

	ConcurrentMap<ReferenceAgent, Agent> getAgents();

}
