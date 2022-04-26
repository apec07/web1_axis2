package idv.cm.db.listener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import idv.cm.utli.ReadXmlDomParser;

/**
 * Application Lifecycle Listener implementation class DbFinder
 *
 */
public class DbFinder implements ServletContextListener {

	public static String dbStr ;
	public static Logger LOGGER = LogManager.getLogger(DbFinder.class);
    /**
     * Default constructor. 
     */
    public DbFinder() {
        dbStr = new String();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext ctx = sce.getServletContext();
    	String dbStr = ctx.getRealPath("/WEB-INF/web.xml");
    	LOGGER.info("LOGGER Test");
    	System.out.println("init DbFinder");
    	System.out.println(dbStr);
    	System.out.println("===========================");
    	System.out.println(getDBPath(dbStr));
       	ctx.setAttribute("dbStr", getDBPath(dbStr));
    }
    
	private String getDBPath(String webPath) {

        String result = "undefined";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            try (InputStream is = new FileInputStream(webPath)) {

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
        LOGGER.info("readDB");
        System.out.println("ReadXmlDomParser getDBPath Method");
        System.out.println("web.xml db - "+result);

        return result;
    }
    
	
}
