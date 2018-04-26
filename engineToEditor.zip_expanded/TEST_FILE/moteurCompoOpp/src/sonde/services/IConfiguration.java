package sonde.services;

/**
 * Created by Jaafar on 03/02/2017.
 */
public interface IConfiguration {

    /**
     * Permet de définir la périodicité de la sonde en fonction
     * de la valeur saisie par l'utilisateur
     *
     * @param valeur saisie sur la Jframe
     * 
     */
    void setPeriodicite(int valeur);
}
