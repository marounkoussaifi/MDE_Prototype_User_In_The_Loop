package interceptorCompo;

import OCPlateforme.OCComponent;

/**
 * Created by seb on 03/02/17.
 */
public interface ILogComposant {

	/**
	 * Log l'apparition d'un composant.
	 * 
	 * @param composant
	 *            Le composant apparu.
	 */
	void logApparitionComposant(OCComponent composant);

	/**
	 * Log la disparition du composant au logger.
	 * 
	 * @param component
	 *            Le composant disparu.
	 */
	void logDisparitionComposant(OCComponent component);
}
