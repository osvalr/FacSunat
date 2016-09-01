
package Utilidad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Descomprimir {
    private String errReferenceID=""; 
    private String errResponseCode="";
    private String errDescription=""; 
    public boolean Descomprimir(String x_ruta)  
    {
        boolean _rpta=true;
        try
        {
              String Directorio=x_ruta.substring(0, x_ruta.length()-3);
              String _rutaArchivoDescomprimido="";
              byte[] buffer = new byte[1024];
              File folder = new File(Directorio);
              if(folder.exists())
                  folder.delete();
              folder.mkdir();
              ZipInputStream zis = new ZipInputStream(new FileInputStream(x_ruta));
              ZipEntry ze = zis.getNextEntry();
              File archivo = new File(x_ruta);
              String NombreArchivoXml =archivo.getName().substring(0, archivo.getName().length()-4)+".xml";
              while(ze!=null)
              {
                  String _filename=ze.getName();
                  _rutaArchivoDescomprimido=Directorio+File.separator+NombreArchivoXml;
                  File newfile = new File(_rutaArchivoDescomprimido);
                  System.out.println("file unzip : "+ newfile.getAbsoluteFile());
                  FileOutputStream fos = new FileOutputStream(newfile);
                  int len;
                  while((len=zis.read(buffer))>0)
                  {
                      fos.write(buffer,0,len);
                  }
                  fos.close();
                  ze=zis.getNextEntry();
              }
              zis.closeEntry();
              zis.close();
              System.out.println("unzip Done");
              File xmlfile =new File(_rutaArchivoDescomprimido);
              if(xmlfile.exists())
              {
                  DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
                  DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
                  Document doc = dbuilder.parse(xmlfile);
                  doc.getDocumentElement().normalize();
                  System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                  NodeList nlist = doc.getElementsByTagName("cac:DocumentResponse");
                  errReferenceID=  nlist.item(0).getChildNodes().item(1).getChildNodes().item(1).getTextContent();
                  errResponseCode= nlist.item(0).getChildNodes().item(1).getChildNodes().item(3).getTextContent();
                  errDescription= nlist.item(0).getChildNodes().item(1).getChildNodes().item(5).getTextContent();
                  if(Integer.parseInt(errResponseCode)>0)
                  {
                      System.out.println("ResponseCode  :" + errReferenceID);
                      System.out.println("Description :" + errDescription);
                      _rpta=false;
                  }
              }
        }
        catch(Exception e)
        {
            System.out.println("Error leendo nodo: " + e.getMessage());
        }
        return _rpta;
    }   

    public String getErrReferenceID() {
        return errReferenceID;
    }

    public void setErrReferenceID(String errReferenceID) {
        this.errReferenceID = errReferenceID;
    }

    public String getErrResponseCode() {
        return errResponseCode;
    }

    public void setErrResponseCode(String errResponseCode) {
        this.errResponseCode = errResponseCode;
    }

    public String getErrDescription() {
        return errDescription;
    }

    public void setErrDescription(String errDescription) {
        this.errDescription = errDescription;
    }
}
