
package AccessoDato;

import Utilidad.Conector;
import Utilidad.InstanciaEntidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAODescuentoFactura implements IOperacion{

    private final String  _insertOne="insert into descuentoadicional(dsa_fporcentaje,dsa_flimite,doc_ncodigo,cds_ncodigo)values(?,?,?,?)returning dsa_ncodigo;";
    private final String  _updateOne="update descuentoadicional set dsa_fporcentaje=?,dsa_flimite=?,doc_ncodigo=? where dsa_ncodigo=?";
    private final String  _deleteOne="";
    private final String  _selectAllxSucursal="select * from vdetalledescuento where cds_ncodigo=?";
    private final String  _selectAll="select * from vdescuentosglobal";    
    private Conector _con;
    private PreparedStatement pst =null;
    @Override
    public boolean Guardar(Object o) {
        try
        {
            EDescuentoFactura _edescuento=(EDescuentoFactura) o;
            pst=_con.RecibirQuer(_insertOne);
            pst.setDouble(1, _edescuento.getDsa_fporcentaje());
            pst.setDouble(2, _edescuento.getDsa_flimite());
            pst.setString(3, _edescuento.getDoc_ncodigo());    
            pst.setInt(4, _edescuento.getCds_ncodigo());
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
                 return true;
            if(_con.EjecutarQuery(pst).getRow()>0)
                return true;
        }
        catch(Exception e)
        {        }
        finally
        {        }
        return false;
    }
    @Override
    public boolean Modificar(Object o) {
         try
        {
            EDescuentoFactura _edescuento=(EDescuentoFactura) o;
            pst=_con.RecibirQuer(_updateOne);
            pst.setDouble(1, _edescuento.getDsa_fporcentaje());
            pst.setDouble(2, _edescuento.getDsa_flimite());
            pst.setString(3, _edescuento.getDoc_ncodigo());
            pst.setInt(4, _edescuento.getCds_ncodigo());
            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                 return true;
            if(_con.EjecutarQuery(pst).getRow()>0)
                return true;
        }
        catch(Exception e)
        {
        }
        finally
        {   }
        return false;
    }
    
    @Override
    public boolean Eliminar(int o) {
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ObtenerUno(int o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> ObtenerTodos() {
        List<EDescuentoFactura> _lsdescuento = new ArrayList<>();
//        try
//        {
//             _con=new Conector();
//            _con.Abrir();
//            pst=_con.RecibirQuer(_selectAll);
//            ResultSet _rs = pst.executeQuery();
//            while(_rs.next())
//                _lsdescuento.add(new EDescuentoFactura(_rs.getInt("dsa_ncodigo"),_rs.getDouble("dsa_fporcentaje"),_rs.getDouble("dsa_flimite"),_rs.getString("doc_ncodigo"),_rs.getInt("cds_ncodigo"),_rs.getString("doc_cdescripcion"),InstancaEntidad.UNCHANGUE));
//
//        }catch(Exception e)
//        {}
        return _lsdescuento;
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
    
     public List<EDescuentoFactura> ObtenerDescuentoxSucursal(int x_codsucursal) {
        List<EDescuentoFactura> _lsdescuento = new ArrayList<>();
        try
        {
            _con=new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAllxSucursal);
            pst.setInt(1, x_codsucursal);
            ResultSet _rs = pst.executeQuery();
            while(_rs.next())
                _lsdescuento.add(new EDescuentoFactura(_rs.getInt("dsa_ncodigo"),_rs.getDouble("dsa_fporcentaje"),_rs.getDouble("dsa_flimite"),_rs.getString("doc_ncodigo"),_rs.getInt("cds_ncodigo"),_rs.getString("doc_cdescripcion"),InstanciaEntidad.UNCHANGUE));

        }catch(Exception e)
        {}
        return _lsdescuento;
    }
    
    
}
