package Agent.CycleDeVie;

import Agent.Decider.ComposantDecider;
import Agent.Percevoir.ComposantPercevoir;
import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;
import OCPlateforme.OCService;

import com.m2dl.sma.infrastructure.etat.EtatAbstract;

import java.util.List;
import java.util.Optional;

/**
 * Created by Benjamin on 10/02/2017.
 */
public class EtatPercevoir extends Etat {

    private  ComposantPercevoir composantPercevoir;

    private OCService serviceAgent;


    public Optional<EtatAbstract> executer() {
        composantPercevoir.setReferenceAgent(super.getReferenceAgent());
        composantPercevoir.setCommunication(super.getCommunication());
        List<AbstractPerception> listePerceptions  = composantPercevoir.percevoir();
        ComposantDecider composantDecider = new ComposantDecider(serviceAgent);
        composantDecider.setListePerceptions(listePerceptions);
        EtatDecider etatDecider = new EtatDecider();
        etatDecider.setComposantDecider(composantDecider);
        etatDecider.setServiceAgent(serviceAgent);
        return Optional.ofNullable(etatDecider);
    }

    public ComposantPercevoir getComposantPercevoir() {
        return composantPercevoir;
    }

    public void setComposantPercevoir(ComposantPercevoir composantPercevoir) {
        this.composantPercevoir = composantPercevoir;
    }

    public OCService getServiceAgent() {
        return serviceAgent;
    }

    public  void setServiceAgent(OCService serviceAgent) {
        this.serviceAgent = serviceAgent;
    }
}
