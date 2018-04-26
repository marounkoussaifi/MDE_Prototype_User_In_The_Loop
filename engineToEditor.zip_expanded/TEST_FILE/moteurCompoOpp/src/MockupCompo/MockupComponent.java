package MockupCompo;

import java.util.ArrayList;

import OCPlateforme.OCComponent;
import OCPlateforme.OCService;

public class MockupComponent extends OCComponent {
	protected String name;
	
	//ajouté
	public MockupComponent()
	{
		
	}

	public MockupComponent(String name, ArrayList<OCService> providedservices, ArrayList<OCService> requiredServices) {
		this.name = name;
		this.providedServices = providedservices;
		this.requiredServices = requiredServices;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	//Edited on 29/11/2017
	public String toString() {
		return "Component " + name + " Provides " + providedServices + " & Requires " + requiredServices + "]";

	}
}
