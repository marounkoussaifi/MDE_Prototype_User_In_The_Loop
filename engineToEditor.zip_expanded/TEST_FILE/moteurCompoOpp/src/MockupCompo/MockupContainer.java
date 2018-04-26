package MockupCompo;

import java.util.ArrayList;

import OCPlateforme.OCComponent;
import OCPlateforme.OCService;

public class MockupContainer implements Container {
	private ArrayList<OCComponent> componentList = new ArrayList<OCComponent>();;

	public ArrayList<OCComponent> getComponents() {
		return componentList;
	}

	public void addComponent(OCComponent c) {
		componentList.add(c);
	}

	public void removeComponent(OCComponent c) {
		componentList.remove(c);
	}

	public void bind(OCService requiredService, OCService providedService) {
		System.out.println("Binding command: " + requiredService + " --- " + providedService
				+ " .................................");
		try {
			requiredService.addLink(providedService);
			providedService.addLink(requiredService);
			System.out.println("Binding success: " + requiredService + " --- " + providedService);
		} catch (AddLinkException e) {
			e.printStackTrace();
		}
	}

	public void unbind(OCService requiredService, OCService providedService) {
		System.out.println("Unbinding command: " + requiredService + " --- " + providedService
				+ " ...............................");
		try {
			requiredService.removeLink(providedService);
			providedService.removeLink(requiredService);
			System.out.println("Unbinding success: " + requiredService + " --- " + providedService);
		} catch (RemoveLinkException e) {
			e.printStackTrace();
		}
	}
}
