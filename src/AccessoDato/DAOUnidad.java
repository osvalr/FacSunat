
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOUnidad implements IOperacion {
     private Conector _con;
     private PreparedStatement pst =null;
     private final String  _selectAll="select * from unidad";
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
       List<EUnidad> _lseunidad = new ArrayList<>();
         try
         {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            ResultSet _rs = pst.executeQuery();
            while(_rs.next())
                _lseunidad.add(new EUnidad(_rs.getInt("uni_ncodigo"), _rs.getString("uni_cdescripcion")));
         }
         catch(Exception e)
         {_con.Cerrar();}
         finally{_con.Cerrar();}
         
         return _lseunidad;
    }

}
