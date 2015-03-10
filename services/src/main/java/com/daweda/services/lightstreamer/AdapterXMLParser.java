package com.daweda.services.lightstreamer;

import com.daweda.services.exception.AdapterNotFoundException;
import com.daweda.services.model.lightstreamer.Adapter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Alexandr_Shegeda on 24.02.2015.
 */
public class AdapterXMLParser
{
    private String adaptersPropertyFile = "META-INF/adapters.xml";

    public Adapter getAdapter(String adapterName) throws AdapterNotFoundException {
       Adapter adapter = findAdapter(adapterName);
        if (adapter == null)
        {
            throw new AdapterNotFoundException();
        }
        return adapter;
    }

    private Adapter findAdapter(String adapter)
    {
        Adapter result = null;
        try {
            File file = new File(getClass().getClassLoader().getResource(adaptersPropertyFile).toURI());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("adapter");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE )
                {
                    Element eElement = (Element) nNode;
                    if( eElement.getAttribute("name").equals(adapter))
                    {
                        String host = eElement.getElementsByTagName("host").item(0).getTextContent();
                        String port = eElement.getElementsByTagName("port").item(0).getTextContent();
                        result = new Adapter(adapter,host,port);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
