package Agent.CycleDeVie;

import Agent.Agir.ComposantAgir;
import com.m2dl.sma.infrastructure.etat.EtatAbstract;

import java.util.Optional;

/**
 * Created by Benjamin on 10/02/2017.
 */
public class EtatAgir extends Etat {

    private ComposantAgir composantAgir;


    public Optional<EtatAbstract> executer() {
        composantAgir.agir();
        return Optional.ofNullable(null);
    }

    public ComposantAgir getComposantAgir() {
        return composantAgir;
    }

    public void setComposantAgir(ComposantAgir composantAgir) {
        this.composantAgir = composantAgir;
    }
}
