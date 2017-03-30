
package AccessoDato;

import Utilidad.Conector;
import Utilidad.InstanciaEntidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOPrecioVenta {
     private final String  _insertOne="insert into precioventa (art_ncodigo,pve_fpreciounitario,Pve_fprecioventa,pve_figv,pve_ctipoprecio,uni_ncodigo,pve_cmoneda,pve_ccodbarra,pve_ncantidad,pve_nporcentaje,pve_ctipoafectacion) values(?,?,?,?,?,?,?,?,?,?,?) returning pve_ncodigo;";
    private final String  _updateOne="update precioventa set art_ncodigo=?,pve_fpreciounitario=?,pve_fprecioventa=?,pve_figv=?,pve_ctipoprecio=?,uni_ncodigo=?,pve_cmoneda=?,pve_ccodbarra=?,pve_ncantidad=?,pve_nporcentaje=?,pve_ctipoafectacion=? where pve_ncodigo=?";
    private final String  _deleteOne="delete  from precioventa where pve_ncodigo=?";
    private final String  _selectAllxidArticulo="select * from VpreciosDetalle where art_ncodigo=?";
    private final String  _selectAllDetalle="select * from VpreciosDetalle";
    private final String _selectOneDetalle="select * from VpreciosDetalle where pve_ncodigo=? ";
    private final String  _selectAllDetallexCaracter="select * from VpreciosDetalle where art_cdescripcion like ?";
    private Conector _con;
    private PreparedStatement pst =null;
    
    public Boolean Guardar(EPrecioVenta x_precio)
    {
        try
        {
//            _con= new Conector();
//            _con.Abrir();
            pst=_con.RecibirQuer(_insertOne);
            pst.setInt(1, x_precio.getArt_ncodigo());
            pst.setFloat(2, x_precio.getPve_fpreciounitario());
            pst.setFloat(3, x_precio.getPve_fprecioventa());
            pst.setFloat(4, x_precio.getPve_figv());
            pst.setString(5, x_precio.getPve_ctipoprecio());
            pst.setInt(6, x_precio.getUni_ccodigo());
            pst.setString(7, x_precio.getPve_cmoneda());
            pst.setString(8, x_precio.getPve_ccodbarra());
            pst.setInt(9, x_precio.getPve_ncantidad());
            pst.setInt(10, x_precio.getPve_nporcentajedescuento());
            pst.setString(11, x_precio.getPve_ctipoafectacion());
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
            {
                 return true;
            }
            if(_con.EjecutarQuery(pst).getRow()>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
//        _con.Cerrar();
        }
        finally
        {
//         _con.Cerrar();
        }
            return false;
    }
    
    public Boolean Modificar(EPrecioVenta x_precio)
    {
        try
        {
//            _con= new Conector();
//            _con.Abrir();
            pst=_con.RecibirQuer(_updateOne);
            pst.setInt(1, x_precio.getArt_ncodigo());
            pst.setFloat(2, x_precio.getPve_fpreciounitario());
            pst.setFloat(3, x_precio.getPve_fprecioventa());
            pst.setFloat(4, x_precio.getPve_figv());
            pst.setString(5, x_precio.getPve_ctipoprecio());
            pst.setInt(6, x_precio.getUni_ccodigo());
            pst.setString(7, x_precio.getPve_cmoneda());
            pst.setString(8, x_precio.getPve_ccodbarra());
            pst.setInt(9, x_precio.getPve_ncantidad());
            pst.setInt(10,x_precio.getPve_nporcentajedescuento());
            pst.setString(11, x_precio.getPve_ctipoafectacion());
            pst.setInt(12, x_precio.getPve_ncodigo());

            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
            {
                 return true;
            }
            if(_con.EjecutarQuery(pst).getRow()>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
//        _con.Cerrar();
        }
        finally
        {
//         _con.Cerrar();
        }
            return false;
    }
    
    public Boolean Eliminar(int x_precio )
    {
        try
        {
//            _con= new Conector();
//            _con.Abrir();
            pst=_con.RecibirQuer(_deleteOne);
            pst.setInt(1, x_precio);
            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
            {
             return true;
            }
            if(_con.EjecutarQuery(pst).getRow()>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
//        _con.Cerrar();
        }
        finally
        {
//         _con.Cerrar();
        }
            return false;
    }
    
    public List<EPrecioVenta> ObtenerTodos(int x_codigo)//Es llamado del el buscar de Articulo
    {
        List<EPrecioVenta> _lseprecio = new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAllxidArticulo);
            pst.setInt(1, x_codigo);
            ResultSet _rs = _con.EjecutarQuery(pst);
            while(_rs.next())
                 _lseprecio.add(new EPrecioVenta(_rs.getInt("pve_ncodigo"),_rs.getInt("art_ncodigo"),_rs.getFloat("Pve_fpreciounitario"),_rs.getFloat("pve_fprecioventa"),_rs.getFloat("pve_figv"),_rs.getString("pve_ctipoprecio"),InstanciaEntidad.UNCHANGUE,_rs.getInt("uni_ncodigo"),_rs.getString("pve_cmoneda"),_rs.getString("pve_ccodbarra"),_rs.getString("uni_cdescripcion"),_rs.getInt("pve_ncantidad"),_rs.getInt("pve_nporcentaje"),_rs.getString("pve_ctipoafectacion"),_rs.getString("art_cafectacion"),_rs.getString("afedescripcion"),_rs.getString("art_cdescripcion"),_rs.getString(_insertOne)));
        }
        catch(Exception e)
        {}
        
        return _lseprecio;
    }
    public List<EPrecioVenta> ObtenerDetalle()//es llamado desde la ventana de busqueda producto factura.
    {
        List<EPrecioVenta> _lseprecio = new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAllDetalle);
            ResultSet _rs = _con.EjecutarQuery(pst);
            while(_rs.next())
                  _lseprecio.add(new EPrecioVenta(_rs.getInt("pve_ncodigo"),_rs.getInt("art_ncodigo"),_rs.getFloat("Pve_fpreciounitario"),_rs.getFloat("pve_fprecioventa"),_rs.getFloat("pve_figv"),_rs.getString("pve_ctipoprecio"),InstanciaEntidad.UNCHANGUE,_rs.getInt("uni_ncodigo"),_rs.getString("pve_cmoneda"),_rs.getString("pve_ccodbarra"),_rs.getString("uni_cdescripcion"),_rs.getInt("pve_ncantidad"),_rs.getInt("pve_nporcentaje"),_rs.getString("pve_ctipoafectacion"),_rs.getString("art_cafectacion"),_rs.getString("afedescripcion"),_rs.getString("art_cdescripcion"),_rs.getString("art_ccodigo")));
        }
        catch(Exception e)
        { _con.Cerrar();}
        finally
        { _con.Cerrar();}
        return _lseprecio;
    }
    
    public EPrecioVenta ObtenerUno(int x_codigo)
    {
        EPrecioVenta _eprecio =null;
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOneDetalle);
            pst.setInt(1, x_codigo);
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
                  _eprecio=(new EPrecioVenta(_rs.getInt("pve_ncodigo"),_rs.getInt("art_ncodigo"),_rs.getFloat("Pve_fpreciounitario"),_rs.getFloat("pve_fprecioventa"),_rs.getFloat("pve_figv"),_rs.getString("pve_ctipoprecio"),InstanciaEntidad.UNCHANGUE,_rs.getInt("uni_ncodigo"),_rs.getString("pve_cmoneda"),_rs.getString("pve_ccodbarra"),_rs.getString("uni_cdescripcion"),_rs.getInt("pve_ncantidad"),_rs.getInt("pve_nporcentaje"),_rs.getString("pve_ctipoafectacion"),_rs.getString("art_cafectacion"),_rs.getString("afedescripcion"),_rs.getString("art_cdescripcion"),_rs.getString("art_ccodigo")));
        }
        catch(Exception e)
        {}
        return _eprecio;
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }

    public List<EPrecioVenta> ObtenerDetallexCaracter(String x_caracter) {
         List<EPrecioVenta> _lseprecio = new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAllDetallexCaracter);
            pst.setString(1, x_caracter+"%");
            ResultSet _rs = _con.EjecutarQuery(pst);
            while(_rs.next())
               _lseprecio.add(new EPrecioVenta(_rs.getInt("pve_ncodigo"),_rs.getInt("art_ncodigo"),_rs.getFloat("Pve_fpreciounitario"),_rs.getFloat("pve_fprecioventa"),_rs.getFloat("pve_figv"),_rs.getString("pve_ctipoprecio"),InstanciaEntidad.UNCHANGUE,_rs.getInt("uni_ncodigo"),_rs.getString("pve_cmoneda"),_rs.getString("pve_ccodbarra"),_rs.getString("uni_cdescripcion"),_rs.getInt("pve_ncantidad"),_rs.getInt("pve_nporcentaje"),_rs.getString("pve_ctipoafectacion"),_rs.getString("art_cafectacion"),_rs.getString("afedescripcion"),_rs.getString("art_cdescripcion"),_rs.getString("art_ccodigo")));
        }
        catch(Exception e)
        { _con.Cerrar();}
        finally
        { _con.Cerrar();}
        return _lseprecio;
    }
    
    
}
