package com.m2dl.sma.infrastructure;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.AnnuaireImpl;
import com.m2dl.sma.infrastructure.annuaire.IAnnuaire;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import com.m2dl.sma.infrastructure.communication.IMessageAgent;
import com.m2dl.sma.infrastructure.etat.EtatAbstract;
import com.m2dl.sma.infrastructure.fabrique.Fabrique;
import com.m2dl.sma.infrastructure.fabrique.ICreationAgent;
import com.m2dl.sma.infrastructure.fabrique.ISuicideService;
import com.m2dl.sma.infrastructure.ordonnanceur.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Modified by Sondes
 * 
 * @author Lenovo
 * 
 * Infrastructure fournit le service ICreationAgent(création d'un agent)
 *
 */
public class Infrastructure implements ICreationAgent, ISuicideService, ICommunication, IOrdonnanceur {
	
	private Fabrique fabrique;
	private Ordonnanceur ordonnanceur;// pourquoi pas IOrdonnanceur ?
	private IAnnuaire annuaire;

	public Infrastructure() {
		ordonnanceur = new Ordonnanceur(new StrategieClassique(new ArrayList<>(), new ArrayList<>()));
		annuaire = new AnnuaireImpl();
		fabrique = new Fabrique(annuaire, ordonnanceur);
	}
	@Override
	public void seSuicider(ReferenceAgent agent) {
		fabrique.seSuicider(agent);
	}
	@Override
	public void ordonnancer() {
		ordonnanceur.ordonnancer();
	}
	@Override
	public void changerVitesse(EnumVitesse vitesse) {
		ordonnanceur.changerVitesse(vitesse);
	}

	@Override
	public void changerOrdonnancement(IStratOrdonnanceur stratOrdonnanceur) {
		ordonnanceur.changerOrdonnancement(stratOrdonnanceur);
	}

	@Override
	public List<Agent> arreterOrdonnancement() {
		return ordonnanceur.arreterOrdonnancement();
	}

	public void envoyerMessage(ReferenceAgent expediteur, ReferenceAgent destinataire, IMessageAgent IMessageAgent) {
		annuaire.envoyerMessage(expediteur, destinataire, IMessageAgent);
	}

	public void diffuserMessage(ReferenceAgent expediteur, IMessageAgent IMessageAgent) {
		annuaire.diffuserMessage(expediteur, IMessageAgent);
	}

	@Override
	public Optional<IMessageAgent> recevoirMessage(ReferenceAgent destinataire) {
		return annuaire.recevoirMessage(destinataire);
	}

	@Override
	public ReferenceAgent creer(EtatAbstract etatInitial) {
		ReferenceAgent ref = fabrique.creer(etatInitial);
		// ordonnanceur.OrdagentAjoute(agent);
		return (ref);
	}

	public IAnnuaire getAnnuaire() {
		return annuaire;
	}

	public Ordonnanceur getOrdonnanceur() {
		return ordonnanceur;
	}

	@Override
	public void ordagentAjoute(Agent agent) {

		ordonnanceur.ordagentAjoute(agent);
	}

	@Override
	public void OrdagentRetire(Agent agent) {

		ordonnanceur.OrdagentRetire(agent);
	}

}
