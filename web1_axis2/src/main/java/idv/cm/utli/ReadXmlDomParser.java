package idv.cm.utli;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.naming.Context;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXmlDomParser {

	public Logger LOGGER = LogManager.getLogger(this.getClass());

	public String getStr() {

		// Instantiate the Factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		StringBuffer str = new StringBuffer();

		try (InputStream is = readXmlFileIntoInputStream("web.xml")) {

			// parse XML file
			DocumentBuilder db = dbf.newDocumentBuilder();

			// read from a project's resources folder
			Document doc = db.parse(is);

			str.append("Root Element :" + doc.getDocumentElement().getNodeName());
			System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
			str.append("------");
			System.out.println("------");

			if (doc.hasChildNodes()) {
				printNote(doc.getChildNodes(), str);
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	private static void printNote(NodeList nodeList, StringBuffer str) {

		for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);

			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				// get node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent());
				str.append("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				str.append("Node Value =" + tempNode.getTextContent());

				if (tempNode.hasAttributes()) {

					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());
						str.append("attr name : " + node.getNodeName());
						str.append("attr value : " + node.getNodeValue());
					}

				}

				if (tempNode.hasChildNodes()) {
					// loop again if has child nodes
					printNote(tempNode.getChildNodes(), str);
				}

				System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
				str.append("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
			}

		}

	}

	// read file from project resource's folder.
	private static InputStream readXmlFileIntoInputStream(final String fileName) {
//		System.out.println(ReadXmlDomParser.class.getClassLoader().getSystemResource(fileName));
//		System.out.println(ReadXmlDomParser.class.getClassLoader().getResource(fileName));
		// getResource from "Resources"
		System.out.println(ReadXmlDomParser.class.getClassLoader().getResourceAsStream(fileName));
	
		return ReadXmlDomParser.class.getClassLoader().getResourceAsStream(fileName);
	}
	
	public String getAlexaRanking() {

        String result = "undefined";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

        	

            try (InputStream is = readXmlFileIntoInputStream("web.xml")) {

                // unknown XML better turn on this
                dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

                DocumentBuilder dBuilder = dbf.newDocumentBuilder();
                
                Document doc = dBuilder.parse(is); // inputStream can not be null
                
                NodeList nodeList = null;
                if(doc.hasChildNodes()) {
                	nodeList = doc.getChildNodes();
                }else {
                	return null;
                }
                Element element = doc.getDocumentElement();

                nodeList = element.getElementsByTagName("res-ref-name");
                if (nodeList.getLength() > 0) {
                	for(int i=0;i<nodeList.getLength();i++) {
                		Node node = (Element) nodeList.item(i);
                		String ranking = node.getTextContent();
                		 if (!"".equals(ranking)) {
                             result = ranking;
                             LOGGER.info("catched");
                         }
                	}
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("web.xml db - "+result);

        return result;
    }
	
	public String readTest() {
		InputStream is = ReadXmlDomParser.readXmlFileIntoInputStream("web.xml");
		StringBuffer sb = new StringBuffer();
		try {
			if(is.available()>0) {
				System.out.println("web.xml is avaliable");
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				while(br.ready()) {
				     sb.append(br.readLine());
				     sb.append("\n");
				}
			}else {
				System.out.println("web.xml is Unavaliable");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test Finished!");
		return sb.toString();
	}
	
	public static void main(String[] arg) {
		ReadXmlDomParser reader = new ReadXmlDomParser();
		System.out.println(reader.getStr());
		
	}

}
