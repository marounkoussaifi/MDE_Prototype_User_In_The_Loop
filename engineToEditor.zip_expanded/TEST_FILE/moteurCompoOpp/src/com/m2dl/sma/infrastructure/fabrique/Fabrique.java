/*
 * Nom de classe : Fabrique
 *
 * Description   : permet de gérer la création et le suicide des agents dans l’infrastructure.
 * 
 * Version       : 2.0
 *
 * Date          : 11/05/2017
 * 
 * Copyright     : M2 DL , Sondes
 * Created       :
 * Modified      : Sondes
 */

package com.m2dl.sma.infrastructure.fabrique;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.IAnnuaire;
import com.m2dl.sma.infrastructure.etat.EtatAbstract;
import com.m2dl.sma.infrastructure.ordonnanceur.Ordonnanceur;

public class Fabrique implements ICreationAgent, ISuicideService {
	private final IAnnuaire annuaire;
	private final Ordonnanceur ordonnanceur;

	public Fabrique(IAnnuaire annuaire, Ordonnanceur ordonnanceur) {
		this.annuaire = annuaire;
		this.ordonnanceur = ordonnanceur;
	}

	@Override
	public ReferenceAgent creer(EtatAbstract etatInitial) {
		Agent agent = new Agent(etatInitial);
		etatInitial.setCommunication(annuaire);
		etatInitial.setSuicideService(this);
		annuaire.addAgent(agent);
		ordonnanceur.ordagentAjoute(agent);
		return agent.getReferenceAgent();
	}

	@Override
	public void seSuicider(ReferenceAgent referenceAgent) {
		annuaire.removeAgent(referenceAgent);
		//ordonnanceur.OrdagentRetire(agent); //le parmaètre agent??
	}

}
