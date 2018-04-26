/*
 * Nom de classe : MessageReceiver
 *
 * Description   : Composant récupérant l'annonce d'un agent. Sa méthode "annoncer" est
 *                  accessible via l'interface Acheminement.
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
import medium.services.IAcheminement;
import medium.services.IRecAnnonce;

public class MessageReceiver implements IAcheminement {

	private IRecAnnonce recAnnonce; // requis = transmission message annonce a
									// Mediator

	public MessageReceiver(IRecAnnonce recAnnonce) {
		super();
		this.recAnnonce = recAnnonce;
	}

	/**
	 * Permet Ã  un agent de s'annoncer. Transmet l'annonce au mediator.
	 *
	 * @param ann
	 *            annonce
	 */

	@Override
	public void annoncer(Annonce ann) {
		recAnnonce.addAnnonce(ann);
	}

	public IRecAnnonce getRecAnnonce() {
		return recAnnonce;
	}
}
