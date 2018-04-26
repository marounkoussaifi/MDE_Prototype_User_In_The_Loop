package OCPlateforme;
import java.util.ArrayList;

import MockupCompo.AddLinkException;
import MockupCompo.RemoveLinkException;

public abstract class OCService {
	
	protected ArrayList<OCService> linkedServices;

	public ArrayList<OCService> getLinkedServices() {
		return linkedServices;
	}
	public abstract void addLink(OCService s) throws AddLinkException;
	public abstract void removeLink(OCService s) throws RemoveLinkException;
}
