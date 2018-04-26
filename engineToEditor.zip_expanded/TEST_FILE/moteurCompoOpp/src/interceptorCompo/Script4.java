package interceptorCompo;

import java.security.AllPermission;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import FacadeAdapter.UnbindingFailure;
import MockupCompo.MockupComponent;
import MockupCompo.MockupService;
import MockupCompo.MultiLinkMockupService;
import MockupCompo.SingleLinkMockupService;
import MockupCompo.Way;
import OCPlateforme.OCService;

public class Script4 {

	public static void main(String[] args) {
		// MockupContainer container = new MockupContainer();
		Interceptor i = new Interceptor();

		// Construction du composant "A"

		ArrayList<OCService> providedByA = new ArrayList<OCService>();
		ArrayList<OCService> requiredByA = new ArrayList<OCService>();
		
		MockupService JdeA = new SingleLinkMockupService("J", "A", Way.REQUIRED);
		requiredByA.add(JdeA);
		MockupService KdeA = new SingleLinkMockupService("K", "A", Way.REQUIRED);
		requiredByA.add(KdeA);
		MockupService IdeA = new SingleLinkMockupService("I", "A", Way.PROVIDED);
		providedByA.add(IdeA);
		
		MockupComponent A = new MockupComponent("A", providedByA, requiredByA);
		Record.allComponents.add(A);
		
		i.getF1().addComponent(A);

		ArrayList<OCService> providedByC = new ArrayList<OCService>();
		ArrayList<OCService> requiredByC = new ArrayList<OCService>();

		MockupService JdeC = new SingleLinkMockupService("J", "C", Way.PROVIDED);
		providedByC.add(JdeC);
		MockupService KdeC = new SingleLinkMockupService("K", "C", Way.PROVIDED);
		providedByC.add(KdeC);

		MockupComponent C = new MockupComponent("C", providedByC, requiredByC);
		Record.allComponents.add(C);
		
		i.getF1().addComponent(C);
		i.bind(JdeA, JdeC, A, C);

		// Construction du composant "D"
		ArrayList<OCService> providedByD = new ArrayList<OCService>();
		ArrayList<OCService> requiredByD = new ArrayList<OCService>();

		MockupService KdeD = new MultiLinkMockupService("K", "D", Way.PROVIDED);
		MockupService TdeD = new MultiLinkMockupService("T", "D", Way.PROVIDED);
		providedByD.add(KdeD);
		providedByD.add(TdeD);
		
		MockupComponent D = new MockupComponent("D", providedByD, requiredByD);
		Record.allComponents.add(D);
		
		// Construction du composant "D"
		ArrayList<OCService> providedByF = new ArrayList<OCService>();
		ArrayList<OCService> requiredByF = new ArrayList<OCService>();

		MockupService KdeF = new MultiLinkMockupService("K", "F", Way.PROVIDED);
		MockupService TdeF = new MultiLinkMockupService("T", "F", Way.REQUIRED);
		providedByF.add(KdeF);
		requiredByF.add(TdeF);
		
		MockupComponent F = new MockupComponent("F", providedByF, requiredByF);
		Record.allComponents.add(F);
		
		i.getF1().addComponent(D);
		i.getF1().addComponent(F);
		
		
		
		
		i.bind(KdeA, KdeD, A, D);
		
		
		
		//i.bind(TdeF, TdeD, F, D);
		
		
		
		//Edited on 02/02/2018
		try{
			/*
			Gson gson = new GsonBuilder().create();
			String records = gson.toJson(requiredByA);
			System.out.println(records);
			*/
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		// Edited on 02/12/2017
		Record.TransformToModelXML();
	}

}
