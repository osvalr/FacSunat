
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOMoneda implements IOperacion{

    private final String  _insertOne="";
    private final String  _updateOne="";
    private final String  _deleteOne="";
    private final String  _selectOne="";
    private final String  _selectAll="select  * from moneda;";    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> ObtenerTodos() {
        
        List<EMoneda> _lsemoneda=new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            ResultSet _rs = pst.executeQuery();
            while(_rs.next())
                    _lsemoneda.add(new EMoneda(_rs.getString("mon_ncodigo"),_rs.getString("mon_cdescripcion"),_rs.getString("mon_cpais"),_rs.getString("mon_csimbolo")));
            
        }
        catch(Exception e)
        {
             _con.Cerrar();
        }
        finally
        {     _con.Cerrar();}
       
        return _lsemoneda;
    }
    
}
