package interceptorCompo;

import java.sql.Savepoint;
import java.util.ArrayList;

import FacadeAdapter.IBinding;
import FacadeAdapter.UnbindingFailure;
import OCPlateforme.OCService;
import MockupCompo.*;
import MockupFacadeAdapter.MockupFacadeAdapter;

public class Interceptor  implements IBinding {

	 private Record myRecord;
	private MockupFacadeAdapter myFacadeAdapter;
	
	
	@Override
	public void bind(OCService service1, OCService service2, MockupComponent comp1, MockupComponent comp2) {
		myFacadeAdapter.bind(service1, service2);
		setBinds((MockupService) service1, (MockupService) service2);
		//myRecord.RecordBind(service1, service2);
		
		//Edited on 29/11/2017
		//myRecord.saveBinds((MockupService)service1, (MockupService)service2);
		//MockupService serv1 = (MockupService) service1;
		//MockupService serv2 = (MockupService) service2;
		
		/*
		ArrayList<OCService> providedByComp1 = new ArrayList<OCService>();
		ArrayList<OCService> RequiredByComp1 = new ArrayList<OCService>();
		RequiredByComp1.add(service1);
		MockupComponent comp1 = new MockupComponent(serv1.getOwner(), providedByComp1, RequiredByComp1);
		
		ArrayList<OCService> providedByComp2 = new ArrayList<OCService>();
		ArrayList<OCService> RequiredByComp2 = new ArrayList<OCService>();
		providedByComp2.add(service2);
		MockupComponent comp2 = new MockupComponent(serv1.getOwner(), providedByComp2, RequiredByComp2);
		
		myRecord.saveComp(comp1 , comp2);
		*/
		
		//Edited on 02/12/2017
		myRecord.saveBindedComponents(comp1, comp2);
	}
	
	public Record getE() {
		return myRecord;
	}


	public void setE(Record e) {
		this.myRecord = e;
	}


	public MockupFacadeAdapter getF1() {
		return myFacadeAdapter;
	}


	public void setF1(MockupFacadeAdapter f1) {
		this.myFacadeAdapter = f1;
	}


	public Interceptor() {
		myRecord=new Record();
		myFacadeAdapter=new MockupFacadeAdapter();
	}

	@Override
	public void unbind(OCService service1, OCService service2) throws UnbindingFailure {
		myFacadeAdapter.unbind(service1, service2);
		setUnBinds((MockupService) service1, (MockupService) service2);
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
