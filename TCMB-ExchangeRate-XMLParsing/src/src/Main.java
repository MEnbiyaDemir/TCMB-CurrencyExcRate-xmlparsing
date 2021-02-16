package src;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		URL url= new URL("https://www.tcmb.gov.tr/kurlar/today.xml");
        Document document=builder.parse(url.openStream());
        NodeList nodelist=document.getElementsByTagName("Currency");
        
        ArrayList<String> name=new ArrayList();
        ArrayList<Double> rate=new ArrayList();
        ArrayList<Integer> unit=new ArrayList();
        
    	NodeList list=document.getElementsByTagName("Currency");

    	for(int i=0;i<list.getLength();i++){
    		Node n =list.item(i);
    		Element e=(Element)n;

    		
    		name.add(e.getElementsByTagName("Isim").item(0).getTextContent());
    		rate.add(Double.parseDouble(e.getElementsByTagName("ForexBuying").item(0).getTextContent()));
    		unit.add(Integer.parseInt(e.getElementsByTagName("Unit").item(0).getTextContent()));
    		System.out.println("Ýsim: " + name.get(i));
    		System.out.println("Kur: " + rate.get(i));
    		System.out.println("Birim: " + unit.get(i));
    		System.out.println("-------------------------");

    		
    	}
		}catch (IOException | ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{}
        
        
        
        
	}

}
