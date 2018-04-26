package interceptorCompo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import MockupCompo.MockupComponent;
import MockupCompo.MockupService;
import MockupCompo.MultiLinkMockupService;
import MockupCompo.SingleLinkMockupService;
import MockupCompo.Way;
import OCPlateforme.OCService;

public class Testing {

	
	public static void main(String[] args) {
	
		ArrayList<CompAndService> listOfCompAndServ = new ArrayList<>();
		
		//Component
		MockupComponent A = new MockupComponent();
		A.setName("A");
		//Services
		MockupService JdeA = new SingleLinkMockupService("J", "A", Way.REQUIRED);
		MockupService KdeA = new SingleLinkMockupService("K", "A", Way.REQUIRED);
		MockupService IdeA = new SingleLinkMockupService("I", "A", Way.PROVIDED);
		CompAndService comp = new CompAndService(A);
		comp.addService(JdeA);
		comp.addService(KdeA);
		comp.addService(IdeA);
		//Adding the comp to the list
		listOfCompAndServ.add(comp);
    }
}
