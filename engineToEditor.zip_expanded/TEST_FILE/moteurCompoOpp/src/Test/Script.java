package Test;

import java.util.ArrayList;
import com.m2dl.sma.infrastructure.Infrastructure;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.etat.Etat1;
import com.m2dl.sma.infrastructure.ordonnanceur.StrategieClassique;

import MockupCompo.MockupComponent;
import MockupCompo.MockupService;
import MockupCompo.MultiLinkMockupService;
import MockupCompo.Way;
import MockupFacadeAdapter.MockupFacadeAdapter;
import OCPlateforme.OCService;
import log.implementations.LogComp;
import medium.Medium;
import medium.composants.Record;
import sonde.Sonde;
import unifieur.implementations.AlwaysTrueMatching;

public class Script {
	
	public static void main(String[] args) {

		int p = 2500;
		
	//Les composants testés
		
		MockupFacadeAdapter mockupFacadeAdapter = new MockupFacadeAdapter();
		Infrastructure infrastructure = new Infrastructure();
		AlwaysTrueMatching alwaysTrueMatching = new AlwaysTrueMatching();
		Medium medium = new Medium(infrastructure, alwaysTrueMatching);
		LogComp logger = new LogComp(); //Lot Log
		Sonde sonde = new Sonde(mockupFacadeAdapter ,logger, medium, infrastructure);
		sonde.run();
	
		MessageAgentTest msg = new MessageAgentTest();
		//RelaisImpl relais = new RelaisImpl((IBinding) mockupFacadeAdapter, (ILogDecision) logger);
		// PopUpFréquenceSondage popUpFréquenceSondage = new PopUpFréquenceSondage();

		// Construction du composant "B2"
		ArrayList<OCService> providedByB2 = new ArrayList<OCService>();
		MockupService JdeB2 = new MultiLinkMockupService("J", "B2", Way.PROVIDED);
		providedByB2.add(JdeB2);
		ArrayList<OCService> requiredByB2 = new ArrayList<OCService>();
		MockupComponent B2 = new MockupComponent("B2", providedByB2, requiredByB2);

		// Ajout de B2 dans le container
		// pause(p);
		mockupFacadeAdapter.addComponent(B2);

		// Construction du composant "B3"

		ArrayList<OCService> providedByB3 = new ArrayList<OCService>();
		MockupService JdeB3 = new MultiLinkMockupService("J", "B3", Way.PROVIDED);
		providedByB3.add(JdeB3);
		ArrayList<OCService> requiredByB3 = new ArrayList<OCService>();
		MockupComponent B3 = new MockupComponent("B3", providedByB3, requiredByB3);

		// Ajout de B3 dans le container
		mockupFacadeAdapter.addComponent(B3);
		
		pause(7000);
		System.out.println("ListeAgents"+medium.getRecord().getListAgents());
		System.out.println("c'est la liste des agents d'Ordonnancement  : "+ ((StrategieClassique) (infrastructure.getOrdonnanceur().getStratOrdonnanceur()))
						.getListOrdonnancement());

	      Etat1 etatInitial = new Etat1();
	      Agent agent1 = new Agent(etatInitial);
	      Agent agent2 = new Agent(etatInitial); 
		  ReferenceAgent expediteur = agent1.getReferenceAgent(); 
		  ReferenceAgent to = agent2.getReferenceAgent(); 
		  //infrastructure.diffuserMessage(expediteur, msg);
	      infrastructure.envoyerMessage(expediteur, to, msg);

   		  System.out.println("la liste des Réferences/Messages:"+ infrastructure.getAnnuaire().getAgentsMessagesQueues());
		
	   	  System.out.println("la liste des References/Agents :" + infrastructure.getAnnuaire().getAgents()); 
		//infrastructure.ordonnancer();
		
		pause(5000);
		logger.getLogFilehandler().close(); // solution provisoire pour éviter les .lck
	}

	public static void pause(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
