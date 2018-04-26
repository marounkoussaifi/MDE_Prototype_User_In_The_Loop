/*
 * Nom de classe : Sonde
 *
 * Description   : faire l'acquisition des composants d’une façon périodique, 
                   initialise la création d'agent pour les nouveaux services 
                   gère la disparition des composants et services 
 *
 * Version       : 2.0
 *
 * Date          : 11/05/2017
 * 
 * Copyright     : M2 DL , Sondes
 * Created       : Jaafar on 03/02/2017
 * Modified      : Sondes
 */

package sonde;

import com.m2dl.sma.infrastructure.fabrique.ICreationAgent;

import FacadeAdapter.AcquisitionFailure;
import FacadeAdapter.IAcquisition;
import log.Interfaces.ILogComposant;
import medium.services.IEnregistrement;
//ToDo 1 verifier l'imp de thread class Sonde implements runnable?
//ToDo 2 Revoir la construction du composant Sonde
import sonde.composants.GestionAgent;
import sonde.composants.GestionComposant;

public class Sonde {

	// Composants de Sonde
	// private PopUpPeriodicite popUpPeriodicite;
	private GestionAgent gestionAgent;
	private GestionComposant gestionComposant;

	// Services requis par la Sonde
	private IAcquisition acquisition;
	private ILogComposant logComposant;
	private IEnregistrement enregistrement;
	private ICreationAgent creationAgent;
	
	public Sonde(IAcquisition acquisition, ILogComposant logComposant, IEnregistrement enregistrement, ICreationAgent creationAgent) {
		super();
		this.enregistrement = enregistrement;
		this.creationAgent = creationAgent;
		this.acquisition = acquisition;
		this.logComposant = logComposant;
		gestionAgent = new GestionAgent(creationAgent, enregistrement);
		gestionComposant = new GestionComposant(gestionAgent, acquisition, logComposant);
        //PopUpPeriodicite popUpPeriodicite = new PopUpPeriodicite();
	}
	
	/**
	 * Le thread sonde périodiquement l'environnement
	 */
	private Thread t = new Thread() {
		@Override
		public void run() {
			while (true) {
				try {
					//System.out.println("##Les composants apparus sont: ");
					gestionComposant.acquisitionComposantsApparus();
					//System.out.println("##Les composants disparus sont:");
					gestionComposant.acquisitionComposantsDisparus();
					// Provisoirement on fixe la periodicité pour le test
					// Thread.sleep(PopUpPeriodicite.getPeriodicite());
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (AcquisitionFailure e) {
					e.printStackTrace();
				}
			}
		}
	};

	public void run() {
		t.start();
	}
}
