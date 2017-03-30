
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class DAODocumentoIdentidad implements IOperacion{
    
    private final String  _selectAll="select  * from documentoidentidad";    
    private Conector _con;
    private PreparedStatement pst =null;
    public List<EDocumentoIdentidad> ObtenerTodo(String x_tipoSelect)
    {
        List<EDocumentoIdentidad> lsidentidad=new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            ResultSet _rs = pst.executeQuery();
             
            while(_rs.next())
            {
                if(x_tipoSelect.length()>0)
                {
                    if(x_tipoSelect.equals(_rs.getString("doi_ccodigo")))
                        lsidentidad.add(new EDocumentoIdentidad(_rs.getString("doi_ccodigo"), _rs.getString("doc_cdescripcion")));
   
                }
                else   
                {
                     lsidentidad.add(new EDocumentoIdentidad(_rs.getString("doi_ccodigo"), _rs.getString("doc_cdescripcion")));
                }
            }
        }
        catch(Exception e)
        {_con.Cerrar();
        }
        finally{_con.Cerrar();}
        
        return lsidentidad;
    }

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
