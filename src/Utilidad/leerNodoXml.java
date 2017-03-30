
package Utilidad;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class leerNodoXml {
    private valorResumenFirma valorNodos;
    private String tagNodo; 
    public leerNodoXml() {
    }
    
    public void buscarNodo(String x_strNodoTag,String x_strAsignature)
    {
        try
        {
                DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
                Document doc = dbuilder.parse(valorNodos.getRutaxml());
                doc.getDocumentElement().normalize();
                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                NodeList nlist = doc.getElementsByTagName(x_strNodoTag);
                String nodoDigester=nlist.item(0).getChildNodes().item(0).getTextContent();
                //System.out.println("Nodo :"+nodoDigester);
                nlist = doc.getElementsByTagName(x_strAsignature);
                String nodoAsignature=nlist.item(0).getChildNodes().item(0).getTextContent();
                if(!nodoDigester.equals("") &&!nodoAsignature.equals("") )
                {
                    valorNodos.setDigestValue(nodoDigester);
                    valorNodos.setSignatureValue(nodoAsignature);
                }
        }catch(Exception e)
        {
            System.out.println("Error :"+e.getMessage());
        }
    }

    

    public void setValorNodos(valorResumenFirma valorNodos) {
        this.valorNodos = valorNodos;
    }

    public valorResumenFirma getValorNodo()
    {
        return this.valorNodos;
    }
    

    
}
