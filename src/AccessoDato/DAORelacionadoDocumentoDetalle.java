
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DAORelacionadoDocumentoDetalle implements IOperacion{
    
    private final String _insertOne="insert into RelacionadoDetalle(rel_ncodigo,rde_ccantidad,rde_fvalorunitario,rde_fvalortotal,rde_fvaloritemigv,rde_foexonerada,rde_fogravada,rel_foinafecta,art_cafectacion,\n" +
                                    "rde_fdescuento,rde_fvalorsubtotal,rde_fvalorventa,rde_ctipoafectacion,art_ncodigo,uni_ncodigo)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning rde_ncodigo";
    private final String _updateOne="";
    private final String _deleteOne="";
    private final String _selectone="";
    private final String _selecttAll="";
    private Conector _con;
    private PreparedStatement pst =null;

    @Override
    public boolean Guardar(Object o) {
            ERelacionadoDocumentoDetalle _detalle=(ERelacionadoDocumentoDetalle)o;
            try
            {
                pst=_con.RecibirQuer(_insertOne);
                pst.setInt(1, _detalle.getRel_ncodigo());
                pst.setInt(2, _detalle.getRde_ccantidad());
                pst.setDouble(3, _detalle.getRde_fvalorunitario());
                pst.setDouble(4, _detalle.getRde_fvalortotal());
                pst.setDouble(5, _detalle.getRde_fvaloritemigv());
                pst.setDouble(6, _detalle.getRde_foexonerada());
                pst.setDouble(7, _detalle.getRde_fogravada());
                pst.setDouble(8, _detalle.getRel_foinafecta());
                pst.setString(9, _detalle.getArt_cafectacion());
                pst.setDouble(10, _detalle.getRde_fdescuento());
                pst.setDouble(11, _detalle.getRde_fvalorsubtotal());
                pst.setDouble(12, _detalle.getRde_fvalorventa());
                pst.setInt(13, _detalle.getRde_ctipoafectacion());
                pst.setInt(14, _detalle.getArt_ncodigo());
                pst.setInt(15, _detalle.getUni_ncodigo());
                ResultSet _rs = _con.EjecutarQuery(pst);
                if(_rs.next())
                {  _detalle.setRde_ncodigo(_rs.getInt("rde_ncodigo"));
                return true;}
        }
        catch(Exception e)
        {}
        finally
        {}
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
    
}
