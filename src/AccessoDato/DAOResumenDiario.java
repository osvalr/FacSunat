
package AccessoDato;
import AccessoDato.EResumenDiario;
import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOResumenDiario {
    
        private final String _selectxdia="select * from obtenerresumendiario_ss()";
        private Conector _con;
        private PreparedStatement pst =null;
        public List<EResumenDiario>  ObtenerResumenDiario()
    {
        List<EResumenDiario> _lsresumen = new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectxdia);
            ResultSet _rs = pst.executeQuery();

            while(_rs.next())
                _lsresumen.add(new EResumenDiario(_rs.getInt(1),_rs.getString(2),_rs.getString(3),_rs.getInt(4),_rs.getInt(5),_rs.getFloat(6),_rs.getFloat(7),_rs.getFloat(8),_rs.getFloat(9),_rs.getFloat(10)));
        }
        catch(Exception e)
        {
            _con.Cerrar();
        }
        finally{
            _con.Cerrar();
        }
        
        return _lsresumen;
    }

}
