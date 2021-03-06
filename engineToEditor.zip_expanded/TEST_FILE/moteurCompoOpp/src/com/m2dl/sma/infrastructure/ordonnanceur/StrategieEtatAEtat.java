package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.etat.Etat1;
import com.m2dl.sma.infrastructure.etat.EtatAbstract;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StrategieEtatAEtat implements IStratOrdonnanceur {

	private List<Agent> listOrdonnancement; // liste d'ordonnancement des agents
	private List<OrdonnanceurListener> listListenerPourOrdonnanceur;
	private Map<Agent, EtatAbstract> listEtatAgent;
	private int vitesse;
	private boolean run = true;
	/*Etat1 etatInitial = new Etat1();
	Agent agent1 = new Agent(etatInitial);
	Agent agent2 = new Agent(etatInitial);
	Agent agent3 = new Agent(etatInitial);*/

	public StrategieEtatAEtat(List<Agent> listAgent, List<OrdonnanceurListener> listListenerActuels) {
		listOrdonnancement = listAgent;
		/*listAgent.add(agent1);
		listAgent.add(agent2);
		listAgent.add(agent3);*/
		listListenerPourOrdonnanceur = listListenerActuels;
		listEtatAgent = new HashMap<>();
		listOrdonnancement.forEach(agent -> listEtatAgent.put(agent, agent.getEtatInitial()));
		changerVitesse(EnumVitesse.CENT);

	}

	@Override
	public void ordonnancer() {
		run = true;
		Agent agentCourant;
		EtatAbstract etatCourant;
		while (run) {
			agentCourant = listOrdonnancement.get(0);
			etatCourant = listEtatAgent.get(agentCourant);
			try {
				TimeUnit.MICROSECONDS.sleep(vitesse);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			changerEtatAgent(agentCourant, etatCourant.executer().orElseGet(agentCourant::getEtatInitial));
			listOrdonnancement.remove(agentCourant);
			listOrdonnancement.add(agentCourant);
			System.out.println("listOrdonnancement" + getListOrdonnancement());
			System.out.println("ListEtatAgent" + getListEtatAgent());

		}
	}

	public Map<Agent, EtatAbstract> getListEtatAgent() {
		return listEtatAgent;
	}

	public List<Agent> getListOrdonnancement() {
		return listOrdonnancement;
	}

	private void changerEtatAgent(Agent agentCourant, EtatAbstract etatAbstract) {
		listListenerPourOrdonnanceur.forEach(ordonnanceurListener -> ordonnanceurListener
				.changementEtat(agentCourant.getReferenceAgent(), etatAbstract));
		listEtatAgent.put(agentCourant, etatAbstract);
	}

	@Override
	public void changerVitesse(EnumVitesse vitesse) {
		switch (vitesse) {
		case CENT:
			this.vitesse = 10;
			break;
		case SOIXANTE_QUINZE:
			this.vitesse = 15;
			break;
		case CINQUANTE:
			this.vitesse = 20;
			break;
		case VINGT_CINQ:
			this.vitesse = 50;
			break;
		case DIX:
			this.vitesse = 100;
			break;
		}
	}

	@Override
	public List<Agent> arreterOrdonnancement() {
		run = false;
		return listOrdonnancement;
	}

	@Override
	public void addOrdonnaceurListener(OrdonnanceurListener ordonnanceurListener) {
		listListenerPourOrdonnanceur.add(ordonnanceurListener);
	}

	@Override
	public void agentAjoute(Agent agent) {
		listOrdonnancement.add(agent);
		listEtatAgent.put(agent, agent.getEtatInitial());
	}

	@Override
	public void agentRetire(Agent agent) {
		listOrdonnancement.remove(agent);
		listEtatAgent.remove(agent);
	}

}
