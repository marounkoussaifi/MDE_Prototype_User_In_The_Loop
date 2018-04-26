package Agent.Percevoir.LireMessageSonde;

import Agent.Percevoir.CreerPerception.FabriqueAbstractPerception;
import Agent.Percevoir.CreerPerception.ICreerPerception;
import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;
import medium.services.IEnregistrement;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.fabrique.ICreationAgent;

import sonde.composants.GestionAgent;
import sonde.services.IDisparitionComposant;

/**
 * Created by Kévin on 09/02/2017.
 */
public class LireMessageSonde implements ILireMessageSonde{

    private ICreerPerception creerPerception;
    private IDisparitionComposant disparitionComposant;
    private ICreationAgent creationService;
	private IEnregistrement enregistrement;

    public LireMessageSonde() {
        this.creerPerception = new FabriqueAbstractPerception();
        this.disparitionComposant = new GestionAgent(creationService, enregistrement);
    }

    @Override
    public AbstractPerception lireSonde(ReferenceAgent referenceAgent) {
        return creerPerception.creerPerception(disparitionComposant.verifierServiceDisparu(referenceAgent));
    }
}
