
package AccessoDato;

import Utilidad.Conector;
import Utilidad.InstanciaEntidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAODescuentoCabecera implements IOperacion{

    private final String  _insertOne="insert into DescuentoCabecera(cds_cnombre,suc_ncodigo) values (?,?) returning cds_ncodigo;";
    private final String  _updateOne="update DescuentoCabecera set cds_cnombre=?,suc_ncodigo=? where cds_ncodigo=?;";
    private final String  _selectOne="select * from vdescuentocabecera where cds_ncodigo=?";
    private final String  _selectAll="select * from vdescuentocabecera";    
    private Conector _con;
    private PreparedStatement pst =null;
    @Override
    public boolean Guardar(Object o) {
        try
        {
            EDescuentoCabecera _cabecera=(EDescuentoCabecera) o;
            pst=_con.RecibirQuer(_insertOne);
            pst.setString(1, _cabecera.getCds_cnombre());
            pst.setInt(2, _cabecera.getSuc_ncodigo());
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
            {    
                _cabecera.setCds_ncodigo(_rs.getInt("cds_ncodigo"));
                return true;
            }
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
            EDescuentoCabecera _cabecera=(EDescuentoCabecera) o;
            pst=_con.RecibirQuer(_updateOne);
            pst.setString(1, _cabecera.getCds_cnombre());
            pst.setInt(2, _cabecera.getSuc_ncodigo());
            pst.setInt(3, _cabecera.getCds_ncodigo());
            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                 return true;
        }
        catch(Exception e)
        {    }
        finally
        {   }
        return false;
    }

    @Override
    public boolean Eliminar(int o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ObtenerUno(int o) {
        
         EDescuentoCabecera _escuento =null;
        try
        {
            _con=new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOne);
            pst.setInt(1, o);
            ResultSet _rs = pst.executeQuery();
            if(_rs.next())
                _escuento=(new EDescuentoCabecera(_rs.getInt("cds_ncodigo"),_rs.getString("cds_cnombre"),_rs.getInt("suc_ncodigo"),_rs.getString("suc_calias"),_rs.getString("suc_cdireccion"),InstanciaEntidad.UNCHANGUE));
        }catch(Exception e)
        {_con.Cerrar();}
        finally{_con.Cerrar();}
        return _escuento;
    }

    @Override
    public List<?> ObtenerTodos() {
        
         List<EDescuentoCabecera> _lsdescuento = new ArrayList<>();
        try
        {
            _con=new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            ResultSet _rs = pst.executeQuery();
            while(_rs.next())
                _lsdescuento.add(new EDescuentoCabecera(_rs.getInt("cds_ncodigo"),_rs.getString("cds_cnombre"),_rs.getInt("suc_ncodigo"),_rs.getString("suc_calias"),_rs.getString("suc_cdireccion"),InstanciaEntidad.UNCHANGUE));

        }catch(Exception e)
        {_con.Cerrar();}
        finally{_con.Cerrar();}
        return _lsdescuento;
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
    
    
}
