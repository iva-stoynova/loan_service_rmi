/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package m22763project4;

import java.io.File;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Iwa Stojnowa
 */
public class Rates {

    private static final String RATES_FILE = "ratesfile";
   
    public static HashMap<String, RateExchange> loadRates(Logs logger)
    {
        HashMap<String, RateExchange> hashmapResult = new HashMap<String, RateExchange>();
        
        // load rates

        try
        {
            File file = new File(Logs.getString(RATES_FILE));
            if (file.isFile())
            {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(file);
                doc.getDocumentElement().normalize();
                NodeList currencies = doc.getElementsByTagName("currency");

                for (int i = 0; i < currencies.getLength(); i++)
                {
                    Node currencyNode = currencies.item(i);
                    if (currencyNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        RateExchange excnangeRate = new RateExchange();
                        Element currencyElement = (Element) currencyNode;
                        excnangeRate.setCode(currencyElement.getElementsByTagName("CODE").item(0).getChildNodes().item(0).getNodeValue());
                        excnangeRate.setRate(Double.parseDouble(currencyElement.getElementsByTagName("RATE").item(0).getChildNodes().item(0).getNodeValue()));
                        hashmapResult.put(excnangeRate.getCode(), excnangeRate);
                    }
                }
                logger.log("Successfully loaded " + hashmapResult.size() + " rates...");
                return hashmapResult;
            } 
            else
            {
                logger.log("Error opening rates file");
                return null;
            }
        } 
        catch (Exception ex)
        {
            logger.log("Error loading rates " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }

    }

}
