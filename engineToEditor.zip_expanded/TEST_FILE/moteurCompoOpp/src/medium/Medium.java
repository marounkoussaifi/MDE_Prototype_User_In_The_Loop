/*
 * Nom de classe : Medium
 *
 * Description   : Cette classe va gérer les différents composants du Medium
 * Version       : 2.0
 *
 * Date          : 31/05/2017
 * 
 * Copyright     : M2 DL , Sondes
 * Created       : M2 DL
 * Modified      : Sondes
 */

package medium;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;

import Agent.Agir.GenererMessage.Message.Annonce;
import OCPlateforme.OCService;
import medium.composants.Mediator;
import medium.composants.MessageReceiver;
import medium.composants.MessageSender;
import medium.composants.Record;
import medium.services.IAcheminement;
import medium.services.IEnregistrement;
import unifieur.services.IMatching;

public class Medium implements IEnregistrement, IAcheminement {

	private MessageSender messageSender;
	private MessageReceiver messageReceiver;
	private Mediator mediator;
	private Record record;

	public Medium(ICommunication communication, IMatching matching) {
		record = new Record();
		messageSender = new MessageSender();
		mediator = new Mediator(record, messageSender);
		messageReceiver = new MessageReceiver(mediator);
		messageSender.setMatching(matching);
		messageSender.setCommunication(communication); // binding requis de
														// messageSender avec
														// fourni
														// d'infrastructure
	}

	@Override
	public void annoncer(Annonce ann) {
		messageReceiver.annoncer(ann);
	}

	@Override
	public void addAgent(ReferenceAgent agent, OCService service) {
		record.addAgent(agent, service);
	}

	@Override
	public void removeAgent(ReferenceAgent agent) {
		record.removeAgent(agent);
	}

	public Record getRecord() {
		return record;
	}

}
