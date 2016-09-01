
package Utilidad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Comprimir {
    private String rutaXml="";
    private String rutazip="";
    File archivoxml =null;
    File archivorar=null;
     private void ZipFile()
    {
        try
        {
            archivorar= new File(rutazip);//-------------------------------------------------------ZIP
             if(archivorar.isFile())
                 archivorar.delete();
             byte[] buffer =new byte[(int)archivoxml.length()];
             FileOutputStream fos= new FileOutputStream(rutazip);
             ZipOutputStream _mizip = new ZipOutputStream(fos);
             ZipEntry ze= new ZipEntry(archivoxml.getName());
             _mizip.putNextEntry(ze);
             FileInputStream in = new FileInputStream(rutaXml);
             int _tamanio;
             while((_tamanio=in.read(buffer))>0)
                 _mizip.write(buffer, 0, _tamanio);                
             _mizip.closeEntry();
             _mizip.close();
             fos.close();
        }catch(Exception e)
        {System.out.println("Problemas al generar zip :"+e.getMessage());}
    }

    public String getRutaXml() {
        return rutaXml;
    }

    public void setRutaXml(String rutaXml) {
        this.rutaXml = rutaXml;
    }

    public String getRutazip() {
        return rutazip;
    }

    public void setRutazip(String rutazip) {
        this.rutazip = rutazip;
    }
}
