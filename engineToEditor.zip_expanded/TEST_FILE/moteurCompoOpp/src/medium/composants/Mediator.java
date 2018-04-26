/*
 * Nom de classe : Mediator
 *
 * Description   :  Ce composant est un médiateur entre le composant MessageSender et les deux
 *                  composants Record et MessageReceiver.
 * Version       : 2.0
 *
 * Date          : 31/05/2017
 * 
 * Copyright     : M2 DL , Sondes
 * Created       : M2 DL
 * Modified      : Sondes
 */
package medium.composants;

import Agent.Agir.GenererMessage.Message.Annonce;
import medium.services.IEnvAnnonce;
import medium.services.IListeAgents;
import medium.services.IRecAnnonce;

public class Mediator implements IRecAnnonce {

	private IListeAgents record; // requis listerAgent de Record
	private IEnvAnnonce messageSender; // requis envAnnonce de MessageSender

	public Mediator(IListeAgents record, IEnvAnnonce messageSender) {
		super();
		this.record = record;
		this.messageSender = messageSender;
	}

	/**
	 * Transmet l'annonce ann ainsi que la liste des agents disponibles au
	 * composant MessageSender.
	 *
	 * @param ann
	 *            annonce
	 */

	@Override
	public void addAnnonce(Annonce ann) {

		messageSender.sendAnnonce(record.getListAgents(), ann);
	}
}
