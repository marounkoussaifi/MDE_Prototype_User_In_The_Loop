package Agent.Decider.ComposantTraitementReponse;

import Agent.Decider.ComposantCreationDecision.AbstractDecision;
import Agent.Percevoir.CreerPerception.Perceptions.PerceptionReponse;

import java.util.List;

/**
 * Created by qsaieb on 10/02/2017.
 */
public interface ITraitementReponse {

  public AbstractDecision traiter(List<PerceptionReponse> listePerceptionReponse);
}
