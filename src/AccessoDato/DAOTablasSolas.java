
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOTablasSolas {
    
    private final String _selectigv="select tas_fporcentaje from tasas where tas_ncodigo=?";
    private final String _selectdocumento="select  doc_ccodigo,doc_cdescripcion from documento";
    private final String _selectallpais="select * from pais;";
    private final String _selectmotivonotacredito="select  * from motivonotacredito";
    private Conector _con;
    private PreparedStatement pst =null;
    private float  m_igv;
    public float Obtenerigv()
    {
        m_igv=0;
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectigv);
            pst.setInt(1, 1);
             ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
                  m_igv= _rs.getFloat("tas_fporcentaje");                 
        }
        catch(Exception e)
        {
            e.printStackTrace();
             _con.Cerrar();
        }
        finally
        {
         _con.Cerrar();
        }
        return m_igv;
    }
    public List<EDocumento> ObtenerDocumento()
    {
        List<EDocumento> _lsdocumento = new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectdocumento);
            ResultSet _rs = _con.EjecutarQuery(pst);
            while(_rs.next())
                _lsdocumento.add(new EDocumento(_rs.getString("doc_ccodigo"), _rs.getString("doc_cdescripcion")));             
        }
        catch(Exception e)
        {   _con.Cerrar();     }
        finally
        { _con.Cerrar();   }
        return _lsdocumento;
    }
    public List<EPais> ObtenerTodosPais()
    {
        List<EPais> _lspais= new ArrayList<>();
        try {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectallpais);
            ResultSet _rs = _con.EjecutarQuery(pst);
            while(_rs.next())
                _lspais.add(new EPais(_rs.getInt("pai_ncodigo"), _rs.getString("pai_cnombre")));  
        } catch (Exception e) {
            e.printStackTrace();
            _con.Cerrar();
        }
        finally{_con.Cerrar();}
        return _lspais;
    }
    
    public List<EMotivoNota> ObtenerTodosMotivosNota()
    {
        List<EMotivoNota> _lsmotivonota =new ArrayList<>();
        try {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectmotivonotacredito);
            ResultSet _rs = _con.EjecutarQuery(pst);
            while(_rs.next())
                _lsmotivonota.add(new EMotivoNota(_rs.getString("mtv_ccodigo"), _rs.getString("mtv_cdescripcion"))); 
        } catch (Exception e) {
            e.printStackTrace();
            _con.Cerrar();
        }finally{_con.Cerrar();}
        return _lsmotivonota;
    }
}
