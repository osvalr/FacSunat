
package Utilidad;

import AccessoDato.ECliente;
import static com.lowagie.text.Annotation.URL;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class BuscarRucOnline {
    String m_strRutaImg="http://www.sunat.gob.pe/cl-ti-itmrconsruc/captcha?accion=image";
    String m_strRutaPeticion="http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS03Alias?accion=consPorRuc&nroRuc=";
    URL _url;
    BufferedImage _image;
    CookieManager _cookiemanager;
    CookieHandler _cookiehandler;
    HttpURLConnection _con=null;
    public ECliente ecliente=null;
    public ImageIcon refrescar()
    {
         try
        {
            _cookiemanager = new CookieManager();
            _cookiemanager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            _cookiehandler.setDefault(_cookiemanager);
            _url = new URL(m_strRutaImg);
            _con=(HttpURLConnection)_url.openConnection();
            CookieStore cookiejar = _cookiemanager.getCookieStore();
            _con.connect();
            _image = ImageIO.read(_url);
            // lbcapchar.setIcon(new ImageIcon(_image));
            return   new ImageIcon(_image);       
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No hay conexion a internet.");
            //System.out.println("Erro refrescando:"+e.getMessage());
             
        }finally
         {
            _con.disconnect();
         }
         return null;
    }
    
    public boolean realizarBusqueda(String x_ruc,String x_codigo)
    {
         try
            {
                String _ruc=x_ruc;//txtrucbuscar.getText().trim();
                String _capchar=x_codigo;//txtcodigobuscar.getText().toUpperCase().trim();
                String strtemp=m_strRutaPeticion;
                m_strRutaPeticion=m_strRutaPeticion+_ruc+"&codigo="+_capchar+"&tipodoc=1";
                _url = new URL(m_strRutaPeticion);               
                _con=(HttpURLConnection)_url.openConnection();
                _con.setRequestMethod("POST");
                _con.connect();
                BufferedReader _rd = new BufferedReader(new InputStreamReader(_con.getInputStream(),"ISO-8859-1") );    
                String _linea;
                String _contenido="";
                StringBuilder _response = new StringBuilder();
                while((_linea=_rd.readLine())!=null)
                {
                    _response.append(_linea);
                    _response.append('\n');
                }                
                _rd.close();
                Document _doc = Jsoup.parse(_response.toString());
                Element _title=_doc.select("TITLE").first();
                if(".:: Pagina de Error ::.".equals(_title.text())||".:: Pagina de Mensajes ::.".equals(_title.text())||"Documento sin título".equals(_title.text()))
                {
                    // refrescar();
                    return false;
                }                
                else 
                {
                    ecliente = new  ECliente();
                    _contenido="OK: Respuesta\n";
                    Element _tablaHtml =_doc.select("table").get(0);
                    Elements _filas =_tablaHtml.select("tr");
                    //obteniendo el ruc
                    Element _fila=_filas.get(5);
                    Elements _columna=_fila.select("td");
                    _contenido+=_columna.text();
                    String tmp=_columna.text();
                    tmp=tmp.substring(4, 16).trim();
                    ecliente.setCli_cnumerodoc(tmp);
                    int indice =_columna.text().indexOf("-");
                    tmp=_columna.text();
                    tmp=tmp.substring(indice+1, tmp.length()).trim();
                    //tmp=tmp.replace("-", "");
                    tmp=tmp.replace("(", " ");
                    tmp=tmp.replace(")", " ");
                    tmp=tmp.replace("&", "");
                    tmp=tmp.replace("'", "");
                    tmp=tmp.replace(",", "");
                    ecliente.setCli_crazon(tmp);
                    if(_ruc.subSequence(0, 2).equals("20"))
                         _fila=_filas.get(11);
                    else
                        _fila=_filas.get(12);
                    _columna=_fila.select("td");
                    _contenido+="\n"+_columna.text();
                    tmp=_columna.text();
                    indice=tmp.indexOf(":");
                    tmp=tmp.replace("-", "");
                    tmp=tmp.replace("(", " ");
                    tmp=tmp.replace(")", " ");
                    tmp=tmp.replace("&", "");
                    tmp=tmp.replace("'", "");
                    tmp=tmp.replace(",", "");
                    //Obteniendo direccion
                    int indice2=tmp.length();
                    tmp=tmp.substring(indice+1, indice2).trim();
                    ecliente.setCli_cdireccionfiscal(tmp);
                    ecliente.setCoi_ccodigo("6");
                    //leerDatosBuscados();
                }

                //limpiar();
               // refrescar();
                m_strRutaPeticion=strtemp;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "No hay conexion a internet.");
             
            }finally
            {
                _con.disconnect();
            }
         return true;
    }
}
