package MockupFacadeAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import MockupCompo.*;
import OCPlateforme.OCComponent;
import OCPlateforme.OCService;
import FacadeAdapter.*;

/**
 * Modified by Sondes
 *
 */
public class MockupFacadeAdapter extends MockupContainer implements IBinding, IAcquisition, IAddRemove {
    
	protected ArrayList<OCComponent> componentList = new ArrayList<OCComponent>();
	protected ArrayList<OCService> serviceList = new ArrayList<OCService>();
	protected Set<OCComponent> appearedComponentSet = new HashSet<OCComponent>();
	protected Set<OCComponent> disappearedComponentSet = new HashSet<OCComponent>();
	protected Set<OCComponent> existingComponentSet = new HashSet<OCComponent>();
	protected Set<OCService> appearedServiceSet = new HashSet<OCService>();
	protected Set<OCService> disappearedServiceSet = new HashSet<OCService>();
	protected Set<OCService> existingServiceSet = new HashSet<OCService>();
	
	/**
	 * 
	 */
	public Set<OCComponent> getNewComponents() throws AcquisitionFailure {
		appearedComponentSet.removeAll(disappearedComponentSet); // pour les apparitions �ph�m�res....
		Set<OCComponent> result = new HashSet<OCComponent>();
		result.addAll(appearedComponentSet);
		appearedComponentSet.clear(); // clear � chaque appel
		return result;
	}
	public Set<OCComponent> getDisappearedComponents() throws AcquisitionFailure {
		Set<OCComponent> result = new HashSet<OCComponent>();
		result.addAll(disappearedComponentSet);
		disappearedComponentSet.clear(); // clear � chaque appel
		return result;
	}
	public Set<OCComponent> getCurrentComponents() throws AcquisitionFailure {
		return existingComponentSet;
	}
	public Set<OCService> getNewServices() throws AcquisitionFailure {
		appearedServiceSet.removeAll(disappearedServiceSet); // pour les apparitions �ph�m�res....
		Set<OCService> result = new HashSet<OCService>();
		result.addAll(appearedServiceSet);
		appearedServiceSet.clear(); // clear � chaque appel
		return result;
	}
	public Set<OCService> getDisappearedServices() throws AcquisitionFailure {
		Set<OCService> result = new HashSet<OCService>();
		result.addAll(disappearedServiceSet);
		disappearedServiceSet.clear(); // clear � chaque appel
		return result;
	}
	public Set<OCService> getCurrentServices() throws AcquisitionFailure {
		return existingServiceSet;
	}
	public void bind(OCService Service1, OCService Service2, MockupComponent comp1, MockupComponent comp2) {
		int index1 = serviceList.indexOf(Service1);
		MockupService service1 = (MockupService) serviceList.get(index1);
		int index2 = serviceList.indexOf(Service2);
		MockupService service2 = (MockupService) serviceList.get(index2);
		if ((service1.getWay() == Way.REQUIRED) && (service2.getWay() == Way.PROVIDED)) {
			super.bind(service1, service2);
		} else if ((service2.getWay() == Way.REQUIRED) && (service1.getWay() == Way.PROVIDED)) {
			super.bind(service2, service1);
		}
	}
	public void unbind(OCService Service1, OCService Service2) {

		int index1 = serviceList.indexOf(Service1);
		MockupService service1 = (MockupService) serviceList.get(index1);
		int index2 = serviceList.indexOf(Service2);
		MockupService service2 = (MockupService) serviceList.get(index2);
		if ((service1.getWay() == Way.REQUIRED) && (service2.getWay() == Way.PROVIDED)) {
			super.unbind(service1, service2);
		} else if ((service2.getWay() == Way.REQUIRED) && (service1.getWay() == Way.PROVIDED)) {
			super.unbind(service2, service1);
		}
	}
	public void addComponent(OCComponent component) {
		super.addComponent(component);
		// Composants : enregistrer l'association puis l'apparition
		componentList.add(component);
		appearedComponentSet.add(component);
		existingComponentSet.add(component);

		// Services : enregistrer les associations puis les apparitions
		for (int i = 0; i < component.getProvidedServices().size(); i++) {
			serviceList.add(component.getProvidedServices().get(i));
		}
		for (int i = 0; i < component.getRequiredServices().size(); i++) {
			serviceList.add(component.getRequiredServices().get(i));
		}
		appearedServiceSet.addAll(component.getProvidedServices());
		existingServiceSet.addAll(component.getProvidedServices());
		appearedServiceSet.addAll(component.getRequiredServices());
		existingServiceSet.addAll(component.getRequiredServices());
	}
	public void removeComponent(OCComponent component) {
		super.removeComponent(component);
		int index;
		index = componentList.indexOf(component);
		disappearedComponentSet.add(componentList.get(index));
		existingComponentSet.remove(componentList.get(index));
		componentList.remove(index);
		for (int i = 0; i < component.getProvidedServices().size(); i++) {
			index = serviceList.indexOf(component.getProvidedServices().get(i));
			disappearedServiceSet.add(serviceList.get(index));
			existingServiceSet.remove(serviceList.get(index));
			serviceList.remove(index);
		}
		for (int i = 0; i < component.getRequiredServices().size(); i++) {
			index = serviceList.indexOf(component.getRequiredServices().get(i));
			disappearedServiceSet.add(serviceList.get(index));
			existingServiceSet.remove(serviceList.get(index));
			serviceList.remove(index);
		}
	}
}
