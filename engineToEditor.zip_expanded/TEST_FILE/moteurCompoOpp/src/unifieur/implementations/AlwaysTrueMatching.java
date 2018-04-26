package unifieur.implementations;

import OCPlateforme.OCService;
import unifieur.services.IMatching;

/**
 * Le rôle de l'Unifieur est de proposer un service permettant de savoir si
 * deux OCService sont compatibles.
 */
public class AlwaysTrueMatching implements IMatching {

	/**
	 * Match retourne si oui ou non deux OCService sont compatibles.
	 *
	 * @param serviceA
	 *            OCService A
	 * @param serviceB
	 *            OCService B
	 * @return boolean
	 */
	@Override
	public boolean match(OCService serviceA, OCService serviceB) {
		
		if (serviceA == null || serviceB == null) {
			return false;
		} else {

			return true;
			// return
			// serviceA.getLinkedServices().equals(serviceB.getLinkedServices());

		}
	}
}
