package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.IReferenceAgentListener;
import com.m2dl.sma.infrastructure.etat.EtatAbstract;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StrategieClassique implements IStratOrdonnanceur {

	private List<Agent> listOrdonnancement; // les agents observ�s
	private List<OrdonnanceurListener> listListenerPourOrdonnanceur; // Liste
																		// des
																		// observateurs
	private int vitesse;
	private boolean run = true;
	// Etat1 etatInitial = new Etat1();
	// Agent agent1 = new Agent(etatInitial);
	// Agent agent2 = new Agent(etatInitial);
	// Agent agent3 = new Agent(etatInitial);

	public StrategieClassique(List<Agent> listAgents, List<OrdonnanceurListener> listListenerActuels) {
		listOrdonnancement = listAgents;
		/*
		 * listAgents.add(agent1); listAgents.add(agent2);
		 * listAgents.add(agent3);
		 */
		listListenerPourOrdonnanceur = listListenerActuels;
		changerVitesse(EnumVitesse.CENT);
	}

	@Override
	public void ordonnancer() {
		run = true;
		Agent agentCourant;
		while (run) {
			agentCourant = listOrdonnancement.get(0);
			cycleDeVie(agentCourant.getReferenceAgent(), agentCourant.getEtatInitial());
			listOrdonnancement.remove(agentCourant);
			listOrdonnancement.add(agentCourant);

			System.out.println("listOrdonnancement" + getListOrdonnancement());
		}
	}

	public List<Agent> getListOrdonnancement() {
		return listOrdonnancement;
	}

	private void cycleDeVie(ReferenceAgent agentCourantReference, EtatAbstract etatAbstract) {
		listListenerPourOrdonnanceur.forEach(
				ordonnanceurListener -> ordonnanceurListener.changementEtat(agentCourantReference, etatAbstract));
		try {
			TimeUnit.MICROSECONDS.sleep(vitesse);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		etatAbstract.executer().ifPresent(iEtat -> cycleDeVie(agentCourantReference, iEtat));
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

	public List<OrdonnanceurListener> getListListenerPourOrdonnanceur() {
		return listListenerPourOrdonnanceur;
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
	}

	public List<IReferenceAgentListener> getReferenceAgentListeners() {
		return null;
	}

	@Override
	public void agentRetire(Agent agent) {
		listOrdonnancement.remove(agent);
	}
}
