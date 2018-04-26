package Agent.CycleDeVie;

import com.m2dl.sma.infrastructure.etat.EtatAbstract;

import java.util.Optional;

/**
 * Created by Benjamin on 10/02/2017.
 */
public abstract class Etat extends EtatAbstract {

    public abstract Optional<EtatAbstract> executer();
}
