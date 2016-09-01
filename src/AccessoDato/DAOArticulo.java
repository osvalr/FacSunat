
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOArticulo {
    private final String _insertOne="insert into articulo(art_cdescripcion,uni_ncodigo,art_ccodigo,art_ccodbarra,art_cafectacion) values(?,?,?,?,?) returning art_ncodigo;";
    private final String _updateOne="update articulo set art_cdescripcion=?,uni_ncodigo=?,art_ccodigo=?,art_ccodbarra=?,art_cafectacion=? where art_ncodigo=?";
    private final String _delteOne="delete * from art_ncodigo=?";
    private final String  _selectAll="select  a.art_ncodigo,a.art_cdescripcion,a.uni_ncodigo,a.art_ccodigo,a.art_ccodbarra,a.art_cafectacion,u.uni_cdescripcion from articulo a\n" +
"inner join unidad u on u.uni_ncodigo=a.uni_ncodigo";
    private final String  _selectone="select  * from articulo where art_ncodigo=?";
    private Conector _con;
    private PreparedStatement pst =null;
    public boolean Guardar(EArticulo x_ar)
    {
        try
        {
//            _con= new Conector();
//            _con.Abrir();
            pst=_con.RecibirQuer(_insertOne);
            pst.setString(1, x_ar.getArt_cdescripcion());
            pst.setInt(2, x_ar.getUni_ncodigo());
            pst.setString(3, x_ar.getArt_ccodigo());
            pst.setString(4, x_ar.getArt_ccodbarra());
            pst.setString(5, x_ar.getArt_cafectacion());
             ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
            {
                x_ar.setArt_ncodigo(_rs.getInt("art_ncodigo"));
                 return true;
            }   
        }
        catch(Exception e)
        {
//             _con.Cerrar();
        }
        finally{
//            _con.Cerrar();
        }
        return false;
    }
    
    public boolean Modificar(EArticulo x_ar)
    {
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_updateOne);
            pst.setString(1, x_ar.getArt_cdescripcion());
            pst.setInt(2, x_ar.getUni_ncodigo());
            pst.setString(3, x_ar.getArt_ccodigo());
            pst.setString(4, x_ar.getArt_ccodbarra());
            pst.setString(5, x_ar.getArt_cafectacion());
            pst.setInt(6, x_ar.getArt_ncodigo());
            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
            {              
                 return true;
            }    
        }
        catch(Exception e)
        {
//             _con.Cerrar();
        }
        finally{
//            _con.Cerrar();
        }
        return false;
    }
    
    public List<EArticulo>  ObtenerTodos()
    {
        List<EArticulo> _lsarticulo = new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            ResultSet _rs = pst.executeQuery();

            while(_rs.next())
            {
                _lsarticulo.add(new EArticulo(_rs.getInt("art_ncodigo"),_rs.getString("art_cdescripcion"),_rs.getInt("uni_ncodigo"),_rs.getString("art_ccodigo"),_rs.getString("art_ccodbarra"),_rs.getString("art_cafectacion"),_rs.getString("uni_cdescripcion")));
            }
        }
        catch(Exception e)
        {
            _con.Cerrar();
        }
        finally{
                    _con.Cerrar();
        }
        
        return _lsarticulo;
    }
    
     public EArticulo  ObtenerUno(int x_cod)
    {
        EArticulo _earticulo = null;
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectone);
            pst.setInt(1, x_cod);
            ResultSet _rs = pst.executeQuery();
            while(_rs.next())
            {
                _earticulo=new EArticulo(_rs.getInt("art_ncodigo"),_rs.getString("art_cdescripcion"),_rs.getInt("uni_ncodigo"),_rs.getString("art_ccodigo"),_rs.getString("art_ccodbarra"),_rs.getString("art_cafectacion"));
            }
        }
        catch(Exception e)
        {
            _con.Cerrar();
        }
        finally{
            _con.Cerrar();
        }
        
        return _earticulo;
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
     
}
