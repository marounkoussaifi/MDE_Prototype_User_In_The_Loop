package MockupCompo;

import java.util.ArrayList;

import OCPlateforme.OCService;

public abstract class MockupService extends OCService {
	protected String name;
	private String owner;
	private Way myWay;
	String connectedToSameServiceOfWhichComponent = "";

	public MockupService(String name, String ownerComponentName, Way myWay) {
		this.name = name;
		this.owner = ownerComponentName;
		this.myWay = myWay;
		this.linkedServices = new ArrayList<OCService>();
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

	public Way getWay() {
		return myWay;
	}

	public String getConnectedToSameServiceOfWhichComponent() {
		return connectedToSameServiceOfWhichComponent;
	}

	public void setConnectedToSameServiceOfWhichComponent(String connectedToSameServiceOfWhichComponent) {
		this.connectedToSameServiceOfWhichComponent = connectedToSameServiceOfWhichComponent;
	}

	
	//Edited on 29/11/2017
	public String toString() {
		// return "Service "+name+" of Component "+ownerComponentName+" Links :
		// "+linkedServices;
		return "Service " + name +" of Component "+owner;
	}
}
