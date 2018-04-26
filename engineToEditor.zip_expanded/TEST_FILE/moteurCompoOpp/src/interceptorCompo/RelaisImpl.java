/*
 * Nom de classe : RelaisImpl
 *
 * Description   : reçoit les décisions de connexion ou déconnexion des Agents. 
 *                 et transmettre ces décisions vers l’extérieur
 * Version       : 2.0
 *
 * Date          : 11/05/2017
 * 
 * Copyright     : M2 DL , Sondes
 * Created       : Seb on 03/02/17
 * Modified      : Sondes
 */

package interceptorCompo;

import FacadeAdapter.*;
import MockupCompo.MockupComponent;
import MockupCompo.MockupService;
import OCPlateforme.OCService;
import log.Interfaces.ILogDecision;

public class RelaisImpl implements IBinding {

	private ILogDecision log;
	private IBinding binding;
	private Record myRecord = new Record();

	/**
	 * Constructeur
	 * 
	 * @param binding
	 *            L'interface Binding.
	 * @param log
	 *            L'interface ILogDecision
	 */
	public RelaisImpl(IBinding binding, ILogDecision log) {
		this.binding = binding;
		this.log = log;
	}

	public void unbind(OCService service1, OCService service2) throws UnbindingFailure {
		try {
			this.log.logUnbinding(service1, service2);
			this.binding.unbind(service1, service2);
			setUnBinds((MockupService) service1, (MockupService) service2);
		} catch (UnbindingFailure e) {
			e.printStackTrace();
		}
	}

	@Override
	public void bind(OCService service1, OCService service2, MockupComponent comp1, MockupComponent comp2)
			throws BindingFailure {
		try {
			this.binding.bind(service1, service2, comp1, comp2);
			this.log.logBinding(service1, service2);
			setBinds((MockupService) service1, (MockupService) service2);
			myRecord.saveBindedComponents(comp1, comp2);

		} catch (BindingFailure e) {
			e.printStackTrace();
		}
		
	}
	
	public static void setBinds (MockupService service1, MockupService service2){
		service1.setConnectedToSameServiceOfWhichComponent(service2.getOwner());
		service2.setConnectedToSameServiceOfWhichComponent(service1.getOwner());
	}
	
	public static void setUnBinds (MockupService service1, MockupService service2){
		service1.setConnectedToSameServiceOfWhichComponent("");
		service2.setConnectedToSameServiceOfWhichComponent("");
	}
}
