package medium.services;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

import OCPlateforme.OCService;

import java.util.HashMap;

/**
 * Interface interne du Medium.
 */
public interface IListeAgents {

    /**
     * Retourne une map d'agents associé à leurs services.
     *
     * @return liste d'agents et services
     */
    HashMap<ReferenceAgent, OCService> getListAgents();
}
