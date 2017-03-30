
package AccessoDato;

import Utilidad.Conector;
import Utilidad.InstanciaEntidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAODetFactura implements IOperacion{

    private final String _insertOne="insert into detallefactura (fac_ncodigo, art_ncodigo,dfa_ccantidad, dfa_fvalorunitario, dfa_fvalortotal,dfa_fvaloritemigv,art_cafectacion,pve_ctipoafectacion,dfa_fdescuento,dfa_fvalorsubtotal,dfa_fvalorventa,uni_ncodigo) values (?,?,?,?,?,?,?,?,?,?,?,?) returning dfa_ncodigo;";
    private final String _updateOne="";
    private final String _deleteOne="";
    private final String _selectone="select \n" +
"dfa_ncodigo,\n" +
"fac_ncodigo,\n" +
"art_ncodigo,\n" +
"dfa_ccantidad,\n" +
"dfa_fvalorunitario,\n" +
"dfa_fvalortotal,\n" +
"dfa_fvaloritemigv,\n" +
"dfa_foexonerada,\n" +
"dfa_fogravada,\n" +
"dfa_foinafecta\n" +
"from detallefactura where fac_ncodigo=?;";
    private final String _selecttAll="select \n" +
"dfa_ncodigo,\n" +
"fac_ncodigo,\n" +
"art_ncodigo,\n" +
"dfa_ccantidad,\n" +
"dfa_fvalorunitario,\n" +
"dfa_fvalortotal,\n" +
"dfa_fvaloritemigv,\n" +
"dfa_foexonerada,\n" +
"dfa_fogravada,\n" +
"dfa_foinafecta\n" +
"from detallefactura";
    private final String _selectAllxCabecera="  select * from vdetallefactura where fac_ncodigo=?";
    private Conector _con;
    private PreparedStatement pst =null;
    @Override
    public boolean Guardar(Object o) {
            EFacturaDetalle _detalle=(EFacturaDetalle)o;
            try
            {
            pst=_con.RecibirQuer(_insertOne);
            pst.setInt(1, _detalle.getFac_ncodigo());
            pst.setInt(2, _detalle.getArt_ncodigo());
            pst.setInt(3, _detalle.getDfa_ccantidad());
            pst.setDouble(4, _detalle.getDfa_fvalorunitario());
            pst.setDouble(5, _detalle.getDfa_fvalortotal());
            pst.setDouble(6, _detalle.getDfa_fvaloritemigv());
            //se omitieron los 3 campos de afectacion
            pst.setString(7, _detalle.getArt_cafectacion());
            pst.setInt(8, _detalle.getPve_ctipoafectacion());
            pst.setDouble(9, _detalle.getDfa_fdescuento());
            pst.setDouble(10, _detalle.getDfa_fvalorsubtotal());
            pst.setDouble(11, _detalle.getDfa_fvalorventa());
            pst.setInt(12, _detalle.getUni_ncodigo());
            
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
                 return true;
        }
        catch(Exception e)
        {   e.printStackTrace();  }
        finally
        {
        }
            return false;
    }

    @Override
    public boolean Modificar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(int o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ObtenerUno(int o) {
        
        EFacturaDetalle _detalle=null;
//            _con= new Conector();
//            _con.Abrir();
//            try
//            {
//            pst=_con.RecibirQuer(_selectone);
//            ResultSet _rs = _con.EjecutarQuery(pst);
//            //if(_rs.next())
//                // _detalle = (new EFacturaDetalle(_rs.getInt("dfa_ncodigo"),_rs.getInt("fac_ncodigo"),_rs.getInt("art_ncodigo"),_rs.getInt("dfa_ccantidad"),_rs.getDouble("dfa_fvalorunitario"),_rs.getDouble("dfa_fvalortotal"),_rs.getDouble("dfa_fvaloritemigv")));
//                 
//        }
//        catch(Exception e)
//        {
//        _con.Cerrar();
//        }
//        finally
//        {
//         _con.Cerrar();
//        }
            return _detalle;
    }

    @Override
    public List<?> ObtenerTodos() {
        
            List<EFacturaDetalle> _lsdetalle= new ArrayList<>();
            _con= new Conector();
            _con.Abrir();
            try
            {
            pst=_con.RecibirQuer(_selecttAll);
            ResultSet _rs = _con.EjecutarQuery(pst);
           // while(_rs.next())
                // _lsdetalle.add(new EFacturaDetalle(_rs.getInt("dfa_ncodigo"),_rs.getInt("fac_ncodigo"),_rs.getInt("art_ncodigo"),_rs.getInt("dfa_ccantidad"),_rs.getDouble("dfa_fvalorunitario"),_rs.getDouble("dfa_fvalortotal"),_rs.getDouble("dfa_fvaloritemigv")));
                 
        }
        catch(Exception e)
        {
        _con.Cerrar();
        }
        finally
        {
         _con.Cerrar();
        }
            return _lsdetalle;
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
     public List<EFacturaDetalle> ObtenerTodosxIdCabecera(int x_codigo) {
        
        List<EFacturaDetalle> _lsdetalle= new ArrayList<>();
        _con= new Conector();
        _con.Abrir();
       try
       {
            pst=_con.RecibirQuer(_selectAllxCabecera);
            pst.setInt(1, x_codigo);
            ResultSet _rs = _con.EjecutarQuery(pst);
            while(_rs.next())
                  _lsdetalle.add(new  EFacturaDetalle(_rs.getInt("dfa_ncodigo"),_rs.getInt("fac_ncodigo"), _rs.getInt("art_ncodigo"),_rs.getInt("dfa_ccantidad") ,_rs.getDouble("dfa_fvalorunitario"),_rs.getDouble("dfa_fvalortotal") ,_rs.getDouble("dfa_fvaloritemigv"),_rs.getDouble("dfa_foexonerada"),_rs.getDouble("dfa_fogravada"),_rs.getDouble("dfa_foinafecta") ,_rs.getString("art_cafectacion") ,_rs.getDouble("dfa_fdescuento") ,_rs.getDouble("dfa_fvalorsubtotal"),_rs.getDouble("dfa_fvalorventa"),_rs.getInt("pve_ctipoafectacion"),_rs.getString("art_cdescripcion"),_rs.getString("categoria"),_rs.getString("afe_cdescripcion"),_rs.getInt("uni_ncodigo"),_rs.getString("uni_cdescripcion"),InstanciaEntidad.UNCHANGUE));
        }
        catch(Exception e)
        {
        _con.Cerrar();
        }
        finally
        {
         _con.Cerrar();
        }
            return _lsdetalle;
    }
    
}
