
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DAOEmpresa implements IOperacion{

    private final String  _insertOne="";
    private final String  _updateOne="";
    private final String  _deleteOne="";
    //private final String  _selectOne="select  a.* from empresa a inner join sucursal as s on a.emp_ncodigo=s.emp_ncodigo where s.suc_ncodigo=?";
    private final String _selectOne="select * from vdetallesucursal where suc_ncodigo=?";
    private final String  _selectAll=""; 
    private Conector _con;
    private PreparedStatement pst =null;
    @Override
    public boolean Guardar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        EEmpresa _emp=null;
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOne);
            pst.setInt(1, o);
            ResultSet _rs = pst.executeQuery();            
            if(_rs.next())
            {  
                _emp=new EEmpresa( _rs.getInt("emp_ncodigo"),_rs.getString("emp_cruc"),_rs.getString("emp_cnombre"),_rs.getString("doi_ccodigo"),_rs.getString("emp_cclave"),_rs.getString("emp_cusuario"),_rs.getString("suc_cdireccion"), _rs.getString("ubi_cdepartamento"),_rs.getString("ubi_cprovincia"), _rs.getString("ubi_cdistrito"), _rs.getString("ubi_ccoddistri"));
            
            }
        }
        catch(Exception e)
        {
            _con.Cerrar();
        }
        finally
        {
            _con.Cerrar();
        }
        return _emp;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
