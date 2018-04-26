package interceptorCompo;

import java.util.ArrayList;

import MockupCompo.MockupComponent;
import MockupCompo.MockupService;
import MockupCompo.Way;
import OCPlateforme.OCService;

public class CompAndService {

	MockupComponent component;
	ArrayList<OCService> providedByComp = new ArrayList<OCService>();
	ArrayList<OCService> requiredByComp = new ArrayList<OCService>();
	
	public CompAndService(MockupComponent component){
		this.component = component;
	}
	
	public void addService(MockupService service){
		if(service.getWay().equals(Way.REQUIRED)){
			this.requiredByComp.add(service);
		}else if(service.getWay().equals(Way.PROVIDED)){
			this.providedByComp.add(service);
		}
	}
	
}
