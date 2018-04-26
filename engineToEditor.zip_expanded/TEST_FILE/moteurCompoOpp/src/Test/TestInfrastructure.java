package Test;


import com.m2dl.sma.infrastructure.Infrastructure;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.etat.Etat1;
import com.m2dl.sma.infrastructure.ordonnanceur.StrategieClassique;

public class TestInfrastructure {

	public static void main(String[] args) {

		Infrastructure infrastructure = new Infrastructure();
		MessageAgentTest msg = new MessageAgentTest();
		Etat1 etatInitial = new Etat1();
        
		
		ReferenceAgent ref1;
		ReferenceAgent ref2;
		ReferenceAgent ref3;
		ReferenceAgent ref4;

		ref1 = infrastructure.creer(etatInitial);
		ref2 = infrastructure.creer(etatInitial);
		ref3 = infrastructure.creer(etatInitial);
		ref4 = infrastructure.creer(etatInitial);

		System.out.println(ref1);
		System.out.println(ref2);
		System.out.println(ref3);
		System.out.println(ref4);

		// infrastructure.seSuicider(ref1);

		infrastructure.envoyerMessage(ref2, ref3, msg);

		pause(2000);

		//infrastructure.diffuserMessage(ref2, msg);

		  
		 
	 
		
		//StrategieClassique stragEtat = new StrategieClassique(new ArrayList<>(), new ArrayList<>());
		//infrastructure.changerOrdonnancement(stragEtat);
	
		
		  
		//infrastructure.ordonnancer(); 

	}

	public static void pause(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}
}
