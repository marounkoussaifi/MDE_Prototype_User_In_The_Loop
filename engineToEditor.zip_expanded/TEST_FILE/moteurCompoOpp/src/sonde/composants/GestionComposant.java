/*
 * Nom de classe : GestionComposant
 *
 * Description   : récupére et trace le log des composants/services apparus ou disparus 
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

import FacadeAdapter.*;
import log.Interfaces.ILogComposant;
import sonde.services.IConfiguration;
import sonde.services.INotification;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import MockupCompo.*;
import OCPlateforme.OCComponent;
import OCPlateforme.OCService;

public class GestionComposant implements IConfiguration {

	private INotification notification;
	private IAcquisition acquisition;
	private ILogComposant logger;
	private int periodicite;
	// private PopUpSondageFréquence periodiciterSondage;

	// Constructeur
	public GestionComposant(INotification notification, IAcquisition acquisition, ILogComposant logger) {
		// this.periodicite = per;
		this.notification = notification;
		this.acquisition = acquisition;
		this.logger = logger;
	}

	public int getPeriodicite() {
		return periodicite;
	}

	@Override
	public void setPeriodicite(int valeur) {
		this.periodicite = valeur;
	}

	/**
	 * Récuperer et Sauvgarder les composants apparus Envoyer la listes de ces
	 * services à GestionAgent
	 * 
	 * @throws AcquisitionFailure
	 */
	public void acquisitionComposantsApparus() throws AcquisitionFailure {

		Set<OCComponent> listComposants = acquisition.getNewComponents();
		//System.out.println("listComposants = " + listComposants);
		for (OCComponent composant : listComposants) {

			logger.logApparitionComposant(composant);
			ArrayList<OCService> servicesFournis = composant.getProvidedServices();
			ArrayList<OCService> servicesRequis = composant.getRequiredServices();

			System.out.println("servicesFournis = " + servicesFournis);
			System.out.println("servicesRequis = " + servicesRequis);
			System.out.println("Notif  =" + notification);

			if (servicesFournis != null) {
				notification.servicesApparus(servicesFournis);
			}

			if (servicesRequis != null) {
				notification.servicesApparus(servicesRequis);
			}

		}
	}

	/**
	 * Récuperer et Sauvgarder les composants disparus Envoyer la listes de ces
	 * services à GestionAgent
	 *
	 * @throws AcquisitionFailure
	 */
	public void acquisitionComposantsDisparus() throws AcquisitionFailure {

		Set<OCComponent> listComposants = acquisition.getDisappearedComponents();
		//System.out.println("listComposants = " + listComposants);
		for (OCComponent composant : listComposants) {

			logger.logDisparitionComposant(composant);
			ArrayList<OCService> servicesFournis = composant.getProvidedServices();
			ArrayList<OCService> servicesRequis = composant.getRequiredServices();

			System.out.println("servicesFournis = " + servicesFournis);
			System.out.println("servicesRequis = " + servicesRequis);
			System.out.println("Notif  =" + notification);

			if (servicesFournis != null) {
				notification.servicesDisparus(servicesFournis);
			}

			if (servicesRequis != null) {
				notification.servicesDisparus(servicesRequis);
			}
		}
	}

}
