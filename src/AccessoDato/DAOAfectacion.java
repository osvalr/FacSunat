
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOAfectacion implements IOperacion{

    private final String  _insertOne="";
    private final String  _updateOne="";
    private final String  _deleteOne="";
    private final String  _selectOne="";
    private final String  _selectxtipo="select * from afectacion where upper(afe_cdescripcion) like ?"; 
    private Conector _con;
    private String _codigo;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> ObtenerTodos() {
        
        List<EAfectacion> _lsafect=new ArrayList<>();
        _con= new Conector();
        
        try
        {
            _con.Abrir();
            pst=_con.RecibirQuer(_selectxtipo);
            pst.setString(1, getCodigo().toUpperCase()+"%");
            ResultSet _rs = pst.executeQuery();            
            while(_rs.next())
            {  
                _lsafect.add(new EAfectacion(_rs.getInt("afe_ncodigo"),_rs.getString("afe_cdescripcion")));
            
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
        
        return _lsafect;    
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCodigo() {
        return _codigo;
    }

    public void setCodigo(String _codigo) {
        this._codigo = _codigo;
    }
    
    
}
