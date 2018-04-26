package medium.services;

import Agent.Agir.GenererMessage.Message.Annonce;

/**
 * Interface interne du Medium.
 */
public interface IRecAnnonce {

    /**
     * Transmet une annonce.
     *
     * @param ann annonce
     */
    void addAnnonce(Annonce ann);
}
