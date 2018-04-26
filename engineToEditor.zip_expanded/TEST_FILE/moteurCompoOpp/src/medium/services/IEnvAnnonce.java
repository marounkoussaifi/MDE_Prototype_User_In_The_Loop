package medium.services;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import Agent.Agir.GenererMessage.Message.Annonce;
import OCPlateforme.OCService;

import java.util.HashMap;

/**
 * Interface interne du Medium.
 */
public interface IEnvAnnonce {

    /**
     * Envoi une annonce.
     *
     * @param refAgents map d'agents possible destinataire ainsi que leurs services
     * @param ann       annonce
     */
    void sendAnnonce(HashMap<ReferenceAgent, OCService> refAgents, Annonce ann);
}
