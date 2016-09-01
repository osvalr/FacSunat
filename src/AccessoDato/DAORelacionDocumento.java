
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DAORelacionDocumento implements IOperacion{

    private final String _insertOne="insert into RelacionadoDocumento\n" +
                                    "(rel_dfechaemision,fac_ncodigo,doc_ccodigo,mtv_ccodigo,rel_cserie,rel_cnumero,rel_cdescripcion,rel_fsubtotal,rel_ftotal,rel_cmoneda,\n" +
                                    "suc_ncodigo ,ven_ncodigo,rel_cclasepago,rel_cestado,rel_figv,rel_ftotalexonerado,rel_ftotalinafecto,rel_ftotalisc,rel_ftotalotrostributos)\n" +
                                    " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning rel_ncodigo";
//    private final String _insertOne="";
    private final String _updateOne="";
    private final String _delteOne="";
    private final String  _selectAll="";
    private final String  _selectone="";
    private Conector _con;
    private PreparedStatement pst =null;
    @Override
    public boolean Guardar(Object o) {
        ERelacionadoDocumento _relacion = (ERelacionadoDocumento) o;
        try {
                pst=_con.RecibirQuer(_insertOne);
                pst.setDate(1, _relacion.getRel_dfechaemision());
                pst.setInt(2, _relacion.getFac_ncodigo());
                pst.setString(3, _relacion.getDoc_ccodigo());
                pst.setString(4, _relacion.getMtv_ccodigo());
                pst.setString(5, _relacion.getRel_cserie());
                pst.setString(6, _relacion.getRel_cnumero());
                pst.setString(7, _relacion.getRel_cdescripcion());
                pst.setDouble(8, _relacion.getRel_fsubtotal());
                pst.setDouble(9, _relacion.getRel_ftotal());
                pst.setString(10, _relacion.getRel_cmoneda());
                pst.setInt(11, _relacion.getSuc_ncodigo());
                pst.setInt(12, _relacion.getVen_ncodigo());
                pst.setString(13, _relacion.getRel_clasepago());
                pst.setString(14, _relacion.getRel_cestado());
                pst.setDouble(15, _relacion.getRel_figv());
                pst.setDouble(16, _relacion.getRel_ftotalexonerado());
                pst.setDouble(17, _relacion.getRel_ftotalinafecto());
                pst.setDouble(18, _relacion.getRel_ftotalisc());
                pst.setDouble(19, _relacion.getRel_ftotalotrostributos());
                 ResultSet _rs = _con.EjecutarQuery(pst);
                if(_rs.next())
                {    _relacion.setRel_ncodigo(_rs.getInt("rel_ncodigo"));
                return true;}
        } catch (Exception e) { e.printStackTrace(); }
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
