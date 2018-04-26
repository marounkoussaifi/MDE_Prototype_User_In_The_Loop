package interceptorCompo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import MockupCompo.MockupComponent;
import MockupCompo.MockupService;
import OCPlateforme.OCService;

public class Record {
	
	//public static ArrayList<MockupComponent> allComponents = new ArrayList<>();
	
	//Edited on 29/11/2017
	public static ArrayList<MockupComponent> allComponents = new ArrayList<>();
	
	public void RecordBind(OCService requiredService, OCService providedService) {
		
		ArrayList<OCService> providedList = new ArrayList<OCService>();
		ArrayList<OCService> requiredList = new ArrayList<OCService>();
		providedList.add(providedService);
		requiredList.add(requiredService);
		//Iterator <OCService> it = providedList.iterator();
		
		//MockupComponent comp = new MockupComponent();
			 try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/koussaifi/runtime-SiriusConfiguration3/runtime-SiriusConfiguration3.zip_expanded/runtime-SiriusConfiguration3/FirstTest_modelingProject/MyApp.myapp"));
				 //BufferedReader reader = new BufferedReader(,1000);
				 //String ligne;
				int k=1;
				 bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n <myapp:Container xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance \" xmlns:myapp=\"http://test/1.0\"> \n");
				for (int i = 0; i < providedList.size(); i++)
				{
					
				//bw.write("<component componentName=\" "+((MockupService)providedService).getLinkedServices().hashCode() + "\" >\n");
					
				bw.write("<component componentName=\""+((MockupService)requiredList.get(i)).getOwner() + "\" >\n");
				bw.write("<service xsi:type=\"myapp:ProvidedService\" ServiceName=\""+((MockupService)requiredList.get(i)).getName()+"\" requiredservice=\"//@component."+k+"/@service.0\"/>\n");
				bw.write("</component>\n");
				
				bw.write("<component componentName=\""+((MockupService)providedList.get(i)).getOwner() + "\" >\n");
				bw.write("<service xsi:type=\"myapp:RequiredService\" ServiceName=\""+((MockupService)providedList.get(i)).getName()+"\" providedservice=\"//@component."+(k-1)+"/@service.0\"/>\n");
				bw.write("</component>\n");
				
				//bw.write("<component componentName=\" "+((MockupService)providedService).getName() + "\" >\n");
				//bw.write("<component componentName=\" "+((MockupService)requiredService).getOwner()+ "\" >\n");
				bw.write("</myapp:Container> \n");
			    bw.close();
				}
				
				//bw.write("<component componentName=\" "++ "\" >\n");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		/*System.out.println("Binding command: " + requiredService + " --- " + providedService
				+ " .................................");
		try {
			requiredService.addLink(providedService);
			providedService.addLink(requiredService);
			System.out.println("Binding success: " + requiredService + " --- " + providedService);
		} catch (AddLinkException e) {
			e.printStackTrace();
		}*/
		
	}
	
	//Service presenter
	public static void TransformToModelXML(){
		try{
			// Open the model XML file
			//BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/koussaifi/Desktop/Model_Test.xml"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/koussaifi/runtime-SiriusConfiguration3/FirstTest_modelingProject/MyApp.myapp"));
			//write the first line
			bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n <myapp:Container xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" "
					+ "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance \" xmlns:myapp=\"http://test/1.0\"> \n");
			// Writing the XML of the model starting from the first
			for(int k=0; k<allComponents.size(); k++){
				if(isBindedWithAnotherComponent(allComponents.get(k))){
					bw.write("<component componentName=\""+allComponents.get(k).getName()+ "\">\n");
					if (allComponents.get(k).getProvidedServices().size() != 0){
						for(int i=0; i<allComponents.get(k).getProvidedServices().size(); i++){
							MockupService serv = (MockupService) allComponents.get(k).getProvidedServices().get(i);
							if(!serv.getConnectedToSameServiceOfWhichComponent().equalsIgnoreCase("")) {
								bw.write("<service xsi:type=\"myapp:ProvidedService\" ServiceName=\""+serv.getName()+"\" "
										+ "requiredservice=\"//@component."+findCompNumber(allComponents.get(k), serv, "Provided", "Comp")+
										"/@service."+findCompNumber(allComponents.get(k), serv, "Provided", "Serv")+"\"/>\n");
							} else {
								bw.write("<service xsi:type=\"myapp:ProvidedService\" ServiceName=\""+serv.getName()+"\"/>\n");
							}
						}
					}
					if (allComponents.get(k).getRequiredServices().size() != 0){
						for(int i=0; i<allComponents.get(k).getRequiredServices().size(); i++){
							MockupService serv = (MockupService) allComponents.get(k).getRequiredServices().get(i);
							if(!serv.getConnectedToSameServiceOfWhichComponent().equalsIgnoreCase("")) {
								bw.write("<service xsi:type=\"myapp:RequiredService\" ServiceName=\""+serv.getName()+"\" "
										+ "providedservice=\"//@component."+findCompNumber(allComponents.get(k), serv, "Required", "Comp")+
										"/@service."+findCompNumber(allComponents.get(k), serv, "Required", "Serv")+"\"/>\n");
							} else {
								bw.write("<service xsi:type=\"myapp:RequiredService\" ServiceName=\""+serv.getName()+"\"/>\n");
							}
						}
					}
					bw.write("</component>\n");
				}else{
					bw.write("<component componentName=\""+allComponents.get(k).getName()+ "\">\n");
					if (allComponents.get(k).getProvidedServices().size() != 0){
						for(int i=0; i<allComponents.get(k).getProvidedServices().size(); i++){
							MockupService serv = (MockupService) allComponents.get(k).getProvidedServices().get(i);
							if(!serv.getConnectedToSameServiceOfWhichComponent().equalsIgnoreCase("")) {
								bw.write("<service xsi:type=\"myapp:ProvidedService\" ServiceName=\""+serv.getName()+"\" "
										+ "requiredservice=\"//@component."+findCompNumber(allComponents.get(k), serv, "Provided", "Comp")+
										"/@service."+findCompNumber(allComponents.get(k), serv, "Provided", "Serv")+"\"/>\n");
							} else {
								bw.write("<service xsi:type=\"myapp:ProvidedService\" ServiceName=\""+serv.getName()+"\"/>\n");
							}
						}
					}
					if (allComponents.get(k).getRequiredServices().size() != 0){
						for(int i=0; i<allComponents.get(k).getRequiredServices().size(); i++){
							MockupService serv = (MockupService) allComponents.get(k).getRequiredServices().get(i);
							if(!serv.getConnectedToSameServiceOfWhichComponent().equalsIgnoreCase("")) {
								bw.write("<service xsi:type=\"myapp:RequiredService\" ServiceName=\""+serv.getName()+"\" "
										+ "providedservice=\"//@component."+findCompNumber(allComponents.get(k), serv, "Required", "Comp")+
										"/@service."+findCompNumber(allComponents.get(k), serv, "Required", "Serv")+"\"/>\n");
							} else {
								bw.write("<service xsi:type=\"myapp:RequiredService\" ServiceName=\""+serv.getName()+"\"/>\n");
							}
						}
					}
					bw.write("</component>\n");
				}
			}
			// Writing the endlines of the XML
			bw.write("</myapp:Container> \n");
			
			// Saving the file
		    bw.close();
		} catch (Exception e){
		    System.out.println("Error : ");
			System.out.println(e.getMessage());
		}
	}
	
	public static int findCompNumber(MockupComponent comp, MockupService serv, String serviceType, String findIndexOfWhat){
		int index = 0;
		for (int i=0; i<allComponents.size(); i++){
			if (!allComponents.get(i).getName().equalsIgnoreCase(comp.getName())){
				switch (serviceType) {
				case "Required":
					for(int j=0; j<allComponents.get(i).getProvidedServices().size(); j++){
						MockupService provServ = (MockupService) allComponents.get(i).getProvidedServices().get(j);
						if(provServ.getName().equalsIgnoreCase(serv.getName()) 
								&& provServ.getConnectedToSameServiceOfWhichComponent().equalsIgnoreCase(comp.getName())){
							switch (findIndexOfWhat) {
							case "Comp":
								index = i;
								break;

							case "Serv":
								index = j;
								break;
							}
						}
					}
					break;
				case "Provided":
					for(int j=0; j<allComponents.get(i).getRequiredServices().size(); j++){
						MockupService provServ = (MockupService) allComponents.get(i).getRequiredServices().get(j);
						if(provServ.getName().equalsIgnoreCase(serv.getName()) 
								&& provServ.getConnectedToSameServiceOfWhichComponent().equalsIgnoreCase(comp.getName())){
							switch (findIndexOfWhat) {
							case "Comp":
								index = i;
								break;

							case "Serv":
								int incrementIndex = 0;
								if(!allComponents.get(i).getProvidedServices().isEmpty()){
									incrementIndex = allComponents.get(i).getProvidedServices().size();
								}
								index = j + incrementIndex;
								break;
							}
						}
					}
					break;
				}
			}
		}
		
		return index;
	}
	
	public static boolean isBindedWithAnotherComponent(MockupComponent comp){
		boolean isBinded = false;
		int numberOfBindedProvidedServices = 0, numberOfBindedRequiredServices = 0;
		for(int i=0; i<comp.getProvidedServices().size(); i++){
			MockupService serv = (MockupService) comp.getProvidedServices().get(i);
			if(!serv.getConnectedToSameServiceOfWhichComponent().equals("")){
				numberOfBindedProvidedServices++;
			}
		}
		for(int i=0; i<comp.getRequiredServices().size(); i++){
			MockupService serv = (MockupService) comp.getRequiredServices().get(i);
			if(!serv.getConnectedToSameServiceOfWhichComponent().equals("")){
				numberOfBindedRequiredServices++;
			}
		}
		if(numberOfBindedProvidedServices > 0 
				|| numberOfBindedRequiredServices > 0){
			isBinded = true;
		}
		return isBinded;
	}
	
	// Save the history of the components that used while binding two services
	// Also the binded services are considered is this function, in the ArrayList allComponents there is the history of the services
	// that are connected together
	public void saveBindedComponents(MockupComponent comp1, MockupComponent comp2){
		if(!allComponents.isEmpty()){
			boolean isComp1Available = false, isComp2Available = false;
			for(int i = 0; i < allComponents.size(); i++){
				if(allComponents.get(i).getName().equalsIgnoreCase(comp1.getName())){
					isComp1Available = true;
				} else if (allComponents.get(i).getName().equalsIgnoreCase(comp2.getName())){
					isComp2Available = true;
				}
			}
			if(!isComp1Available){
				allComponents.add(comp1);
			} else if (!isComp2Available){
				allComponents.add(comp2);
			}
		} else {
			allComponents.add(comp1);
			allComponents.add(comp2);
		}
	}
}
