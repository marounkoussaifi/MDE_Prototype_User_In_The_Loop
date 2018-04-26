package sonde.services;

import java.util.ArrayList;

import OCPlateforme.OCService;


/**
 * Created by Jaafar on 03/02/2017.
 */
public interface INotification {

    /**
     * Communique la liste des services apparus au composant GestionAgent
     *
     * @param listServicesApparus les services apparus
     */
    void servicesApparus(ArrayList<OCService> listServicesApparus);

    /**
     * Communique la liste des service disparus au composant GestionAgent
     *
     * @param listServicesDisparus les services disparus
     */
    void servicesDisparus(ArrayList<OCService> listServicesDisparus);
}
