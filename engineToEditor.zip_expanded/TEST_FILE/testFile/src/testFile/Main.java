package testFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) {
		try {
		     // FileInputStream fis = new FileInputStream(new File("C:/Users/med/Desktop/stage/extract_data/MyLog_2017-05-18_104349001"));
		      //BufferedInputStream bis = new BufferedInputStream(fis);
			 BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Users/med/Desktop/stage/extract_data/MyLog_2017-05-18_104349001")));
			 BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/med/Desktop/stage/extract_data/MyLog1.xml"));
			 //bw.write("eeeee");
			 //PrintWriter pWriter = new PrintWriter(bw, true);
		     // FileOutputStream fos = new FileOutputStream(new File("C:/Users/med/Desktop/stage/extract_data/MyLog.xml"));
		      //BufferedOutputStream bos = new BufferedOutputStream(fos);
		      String ligne ;
		      int i=0;
		   
    		  bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n <myapp:Container xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance \" xmlns:myapp=\"http://test/1.0\"> \n");

		      while ((ligne = reader.readLine()) != null)
		    	  {if(ligne.contains("- bind"))
		    	 {
		    		  String[] st = ligne.split(" ");
		    		  String s=st[13].substring(1);	  
		    		  int j = Integer.parseInt(s);
			    		 int k =j-1;
			    		//bw.write(""+k);
		    		  //String[] sb = ligne.sp
		    		  bw.write("<component componentName=\""+st[7]+  "\" >\n");
		    		  bw.write("<service xsi:type=\"myapp:ProvidedService\" ServiceName=\" "+st[4]+"\" requiredservice=\"//@component."+k+"/@service.0\"/>\n");
		    		  bw.write("<service xsi:type=\"myapp:RequiredService\" ServiceName=\" "+st[10]+"'\" providedservice=\"//@component."+k+"/@service.1\"/>\n");
		    		  bw.write("</component>\n");
		    		  bw.write("<component componentName=\""+st[13]+  "\" >\n");
		    		  bw.write("<service xsi:type=\"myapp:RequiredService\" ServiceName=\" "+st[10]+"'\" providedservice=\"//@component."+k+"/@service.1\"/>\n");
		    		  bw.write("</component>\n");
		    		 
		    		/*  bw.write("<component componentName=\" "+st[13]+ "\" >\n");
		    		  bw.write("</component>\n");*/
		    		/*  bw.write("  <PBindComponent> "+st[7]+" <PBindComponent/> \n");
		    		  bw.write("  <providedService> "+st[4]+" <providedService/> \n");
		    		  bw.write("  <RBindComponent> "+st[13]+" <RBindComponent/> \n");
		    		  bw.write(" <bind/> \n"); */
		    		 
		    		  i+=1;
		    		 

		    		//bw.write(" <bind> "+st[13]+" <bind/>");
		    		// pWriter.println(" yyyyyy");
		    		
		                   // System.out.println(ligne);
		    		// pWriter.print(nom+":"+numero);
		    	       // pWriter.close() ;
		    	         
		                }
		      //if(ligne.contains("- unbind"))
		    	// {
		    		 /* String[] st = ligne.split(" ");
		    		  bw.write("<unbind> \n");
		    		  bw.write(" <PUnbindComponent> "+st[7]+" <PUnbindComponent/> \n");
		    		  bw.write(" <providedService> "+st[4]+" <providedService/> \n");
		    		  bw.write(" <RUnbindComponent> "+st[13]+" <RUnbindComponent/> \n");
		    		  bw.write("<unbind/> \n");
		                   // System.out.println(ligne);
		                }
		      
		      if(ligne.contains("- Apparition"))
		    	 {    if(ligne.contains("Required=[]")  ){
		    		  String[] st = ligne.split(" ");
		    		  bw.write("<apparition> \n");
		    		  bw.write(" <providedService> "+st[4]+" <providedService/> \n");
		    		  bw.write(" <Pcomponent> "+st[7]+" <componentName/> \n");
		    		  bw.write("<apparition/> \n");
		    	
		                   // System.out.println(ligne);}
		                }
		    	 else if (ligne.contains("Provided=[]")) {
		    		 String[] st = ligne.split(" ");
		    		  if (ligne.contains(",")){
		    			  bw.write("<apparition> \n");
		    			  bw.write(" <requiredService1> "+st[11]+" <requiredService1/> \n");
		    		         } 
		    	
		    		  bw.write(" <requiredService2> "+st[5]+" <requiredService2/> \n");
		    		  bw.write(" <PComponent> "+st[8]+" <PComponent/> \n");
		    		 // bw.write(" <PComponent> "+st[14]+" <PComponent/> \n");
		    		  bw.write("<apparition/> \n");
                       
					
				}
		    	  
		    	  }
		      if(ligne.contains("- Disparition"))
		    	 {    if(ligne.contains("Required=[]")  ){
		    		  String[] st = ligne.split(" ");
		    		  bw.write("<disparition> \n");
		    		  bw.write(" <providedService> "+st[4]+" <providedService/> \n");
		    		  bw.write(" <PComponent> "+st[7]+" <PComponent/> \n");
		    		  bw.write("<disparition/> \n");
		    		
		    	
		                   // System.out.println(ligne);}
		                }
		    	 else if (ligne.contains("Provided=[]")) {
		    		 String[] st = ligne.split(" ");
		    		  if (ligne.contains(",")){
		    			  bw.write("<disparition> \n");
		    			  bw.write(" <requiredService1> "+st[11]+" <requiredService1/> \n");
		    		         } 
		    	
		    		  bw.write(" <requiredService2> "+st[5]+" <requiredService2/> \n");
		    		  bw.write(" <RComponent> "+st[8]+" <RComponent/> \n");
		    		  bw.write("<disparition/> \n");
		    	                                    }
		    	 }*/
		    		 
						//System.out.println("Nom = "+st[1]);
	                    //System.out.println(ligne);
		    		 // System.out.println("nom : "+ st[0]);
		    	  //} 
	                
		      //pWriter.write( ligne);
		      //bis.close();
		     // pWriter.close() ;}
		     //bw.close();
		     }
		      bw.write("</myapp:Container> \n");
		      bw.close();
		    } catch (IOException e) {
		      //e.printStackTrace();
		    	System.out.println(e.toString());
		    }

	}
}

