/*
 * Nom de classe : GestionAgent
 *
 * Description   : initialise la création d'agent pour les nouveaux services 
                   gère la disparition des composants et des services 
 *
 * Version       : 2.0
 *
 * Date          : 11/05/2017
 * 
 * Copyright     : M2 DL , Sondes
 * Created       : Jaafar on 03/02/2017
 * Modified      : Sondes
 */

package sonde.composants;

import MockupCompo.*;
import OCPlateforme.OCService;
import medium.composants.Record;
import medium.services.IEnregistrement;
import sonde.services.IDisparitionComposant;
import sonde.services.INotification;

import com.m2dl.sma.infrastructure.agent.*;
import com.m2dl.sma.infrastructure.etat.Etat1;
import com.m2dl.sma.infrastructure.fabrique.ICreationAgent;

import Agent.CycleDeVie.EtatPercevoir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionAgent implements INotification, IDisparitionComposant {

	//Services Requis
	private ICreationAgent iCreationAgent;
	private IEnregistrement iEnregistrement;
	
	
	private Map<OCService, ReferenceAgent> listRefAgent = new HashMap<OCService, ReferenceAgent>();
	private Map<ReferenceAgent, OCService> listAssocAgentServiceDisparus = new HashMap<ReferenceAgent, OCService>();

	/**
	 * Constructeur
	 * 
	 * @param creationAgent
	 * @param enregistrement
	 */
	public GestionAgent(ICreationAgent creationAgent, IEnregistrement enregistrement) {
		this.iCreationAgent = creationAgent;
		this.iEnregistrement = enregistrement;
	}

	@Override
	/**
	 * Création d'un agent (état initial=perception) pour chaque service apparu
	 */
	public void servicesApparus(ArrayList<OCService> listServicesApparus) {
		for (OCService service : listServicesApparus) {
			EtatPercevoir etatPercevoir = new EtatPercevoir();
		    Etat1 etat = new Etat1();
			etatPercevoir.setServiceAgent(service);
			ReferenceAgent refAgent = iCreationAgent.creer(etat);
			listRefAgent.put(service, refAgent);
			// Enregistrement de l'association agent/service dans le composant Record de Medium
			iEnregistrement.addAgent(refAgent, service);
			/*// Pour tracer :
			Record r = (Record) iEnregistrement;
			System.out.println("##La liste des agents apparus et leurs services associés ~~~~ " + r.getListAgents());
			*/
		}
	}

	public Map<OCService, ReferenceAgent> getListRefAgent() {
		return listRefAgent;
	}

	@Override
	/**
	 * Suppression de tous les agents associés aux services disparus
	 */
	public void servicesDisparus(ArrayList<OCService> listServicesDisparus) {
		for (OCService service : listServicesDisparus) {
			ReferenceAgent refAgent = listRefAgent.get(service);
			iEnregistrement.removeAgent(refAgent);
			// Construction de la liste d'association agent/service disparu
			// A quoi ça sert?
			listAssocAgentServiceDisparus.put(refAgent, service);
			/*
			 * Pour tracer : System.out.println("La liste de services disparus"
			 * + listAssocAgentServiceDisparus); Record r = (Record)
			 * enregistrement;
			 * System.out.println("##La liste des agents disparus ~~~~ " +
			 * r.getListAgents());
			 */
		}
	}

	// ToDo voir à quoi sert cette méthode qui l'appelle
	public boolean verifierServiceDisparu(ReferenceAgent ref) {

		OCService service = listAssocAgentServiceDisparus.get(ref);
		if (service == null) {

			return false;

		} else {

			listAssocAgentServiceDisparus.remove(ref);
			listRefAgent.remove(service);

			return true;
		}
	}
}
