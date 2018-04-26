package test2;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Test2 {

   public static void main(String[] args) {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setIgnoringComments(true);
      factory.setIgnoringElementContentWhitespace(true);
      try {
         factory.setValidating(true);
         DocumentBuilder builder = factory.newDocumentBuilder();
         ErrorHandler errHandler = new ErrorHandler() {
			
			@Override
			public void warning(SAXParseException exception) throws SAXException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void error(SAXParseException exception) throws SAXException {
				// TODO Auto-generated method stub
				
			}
		};
         builder.setErrorHandler(errHandler);
         File fileXML = new File("C:/Users/med/Desktop/stage/extract_data/test.xml");
         Document xml;
         try {
            xml = builder.parse(fileXML);
            Element racine = xml.getDocumentElement();
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(racine.getNodeName());
            createJTree(racine, root);
            
            JFrame fenetre = new JFrame();
            fenetre.setLocationRelativeTo(null);
            fenetre.setSize(300, 400);
            fenetre.add(new JScrollPane(new JTree(root)));
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setVisible(true);
            
         } catch (SAXParseException e) { }
      } catch (ParserConfigurationException e) {
         e.printStackTrace();
      } catch (SAXException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   /**
    * M�thode qui va parser le contenu d'un noeud
    * @param n
    * @param tab
    * @return
    */
   public static void createJTree(Node n, DefaultMutableTreeNode treeNode){
      
      if(n instanceof Element){
         
         //Nous sommes donc bien sur un �l�ment de notre document
         //Nous castons l'objet de type Node en type Element
         Element element = (Element)n;
        
         //nous contr�lons la liste des attributs pr�sents
         if(n.getAttributes() != null && n.getAttributes().getLength() > 0){
            
            //nous pouvons r�cup�rer la liste des attributs dans une Map
            NamedNodeMap att = n.getAttributes();
            int nbAtt = att.getLength();
            
            //nous parcourons tous les noeuds pour les afficher
            for(int j = 0; j < nbAtt; j++){
               Node noeud = att.item(j);
               //On r�cup�re le nom de l'attribut et sa valeur gr�ce � ces deux m�thodes
               DefaultMutableTreeNode attribut = new DefaultMutableTreeNode ("ATTRIBUT : " + noeud.getNodeName() + "=" + noeud.getNodeValue());
               treeNode.add(attribut);
            }
         }
        
         //Nous allons maintenant traiter les noeuds enfants du noeud en cours de traitement
         int nbChild = n.getChildNodes().getLength();
         //Nous r�cup�rons la liste des noeuds enfants
         NodeList list = n.getChildNodes();
         
         //nous parcourons la liste des noeuds
         for(int i = 0; i < nbChild; i++){
            Node n2 = list.item(i);
            
            //si le noeud enfant est un Element, nous le traitons
            if (n2 instanceof Element){
               //System.out.println("VALUE : " + n2.getNodeValue() + " " + n2.getNodeName());
               DefaultMutableTreeNode noeud = new DefaultMutableTreeNode(n2.getNodeName());
              
               //Pour afficher les valeurs des noeuds
               if(n2.getTextContent() != null && n2.getTextContent().trim() != "" && n2.getChildNodes().getLength() == 1){
                  DefaultMutableTreeNode value = new DefaultMutableTreeNode("VALEUR : " + n2.getTextContent());
                  noeud.add(value);
               }    
               //appel r�cursif � la m�thode pour le traitement du noeud et de ses enfants 
               createJTree(n2, noeud);
               treeNode.add(noeud);
            }            
         }
      }
   }   
}