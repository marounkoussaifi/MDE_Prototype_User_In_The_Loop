package MockupCompo;

import java.util.ArrayList;

import OCPlateforme.OCComponent;
import OCPlateforme.OCService;

public interface Container {
	public ArrayList<OCComponent> getComponents();

	public void addComponent(OCComponent c);

	public void removeComponent(OCComponent c);

	public void bind(OCService requiredService, OCService providedService);

	public void unbind(OCService requiredService, OCService providedService);
}
