package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.m2dl.sma.infrastructure.Infrastructure;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.AnnuaireImpl;
import com.m2dl.sma.infrastructure.etat.Etat1;

import Agent.Agir.GenererMessage.Message.Annonce;
import Agent.Agir.GenererMessage.Message.MessageAgent;
import MockupCompo.AddLinkException;
import MockupCompo.MockupComponent;
import MockupCompo.MockupService;
import MockupCompo.MultiLinkMockupService;
import MockupCompo.RemoveLinkException;
import MockupCompo.Way;
import MockupFacadeAdapter.MockupFacadeAdapter;
import OCPlateforme.OCService;
import log.implementations.LogComp;
import medium.Medium;
import medium.composants.Mediator;
import medium.composants.MessageReceiver;
import medium.composants.MessageSender;
import medium.composants.Record;
import sonde.Sonde;
import unifieur.implementations.AlwaysTrueMatching;

public class TestMedium {

	public static void main(String[] args) {

		MockupFacadeAdapter mockupFacadeAdapter = new MockupFacadeAdapter();
		Infrastructure infrastructure = new Infrastructure();
		AlwaysTrueMatching alwaysTrueMatching = new AlwaysTrueMatching();
		Medium medium = new Medium(infrastructure, alwaysTrueMatching);
		LogComp logger = new LogComp(); // Lot Log
		Sonde sonde = new Sonde(mockupFacadeAdapter, logger, medium, infrastructure);
		sonde.run();

		// Construction du composant "C1"
		ArrayList<OCService> providedByC1 = new ArrayList<OCService>();
		MockupService JdeC1 = new MultiLinkMockupService("J", "C1", Way.PROVIDED);
		providedByC1.add(JdeC1);
		ArrayList<OCService> requiredByC1 = new ArrayList<OCService>();
		MockupComponent C1 = new MockupComponent("B2", providedByC1, requiredByC1);

		// Ajout de C1 dans le container
		// pause(p);
		mockupFacadeAdapter.addComponent(C1);

		// Construction du composant "C2"
		ArrayList<OCService> requiredByC2 = new ArrayList<OCService>();
		MockupService KdeC2 = new MultiLinkMockupService("K", "C2", Way.REQUIRED);
		requiredByC2.add(KdeC2);
		ArrayList<OCService> providedByC2 = new ArrayList<OCService>();
		MockupComponent C2 = new MockupComponent("C2", providedByC2, requiredByC2);

		// Ajout de C2 dans le container
		mockupFacadeAdapter.addComponent(C2);

		pause(6000);
		System.out.println("****listeAgents" + medium.getRecord().getListAgents());

		Set<ReferenceAgent> e = medium.getRecord().getListAgents().keySet();
		ReferenceAgent annonceur = null;
		for (ReferenceAgent a : e)
			annonceur = a;

		Annonce ann = new Annonce(JdeC1, annonceur);
		medium.annoncer(ann);

	}

	public static void pause(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}