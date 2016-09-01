
package AccessoDato;

import Utilidad.Conector;
import Utilidad.InstancaEntidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOENumero implements IOperacion{

    private final String  _insertOne="insert into numero(num_cserie,num_cnumero,suc_ncodigo,doc_ccodigo,par_ncodigo)values(?,?,?,?,?) returning num_ncodigo;";
    private final String  _updateOne="update numero set num_cserie=?,num_cnumero=?,suc_ncodigo=?,doc_ccodigo=?,par_ncodigo=? where num_ncodigo=?";
    private final String  _deleteOne="";
    private final String  _selectOne="";
    private final String  _selectAll="";  
    private final String _selectxParametro="select  * from vdetallenumeroxparametro where par_ncodigo=?";
    private final String _selectxCodigoNumero="select * from vdetallenumeroxparametro where num_ncodigo=?";
    private final String _updateInremento="update numero set num_cnumero=? where num_ncodigo=?";
    private int codigo;
    private Conector _con;
    private PreparedStatement pst =null;
    @Override
    public boolean Guardar(Object o) {
        
        try {
            ENumero _numero=(ENumero) o;
            pst=_con.RecibirQuer(_insertOne);
            pst.setString(1, _numero.getNum_cserie());
            pst.setString(2, _numero.getNum_cnumero());
            pst.setInt(3, _numero.getSuc_ncodigo());
            pst.setString(4, _numero.getDoc_ccodigo());
            pst.setInt(5, _numero.getPar_ncodigo());
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
                _numero.setNum_ncodigo(_rs.getInt("num_ncodigo"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Modificar(Object o) {
        try {
            ENumero _numero=(ENumero) o;
            pst=_con.RecibirQuer(_updateOne);
            pst.setString(1, _numero.getNum_cserie());
            pst.setString(2, _numero.getNum_cnumero());
            pst.setInt(3, _numero.getSuc_ncodigo());
            pst.setString(4, _numero.getDoc_ccodigo());
            pst.setInt(5, _numero.getPar_ncodigo());
            pst.setInt(6, _numero.getNum_ncodigo());
            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                 return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean Eliminar(int o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ObtenerUno(int o) {
        List<ENumero> _lsnumero =new ArrayList<>();
        try {
            _con= new Conector();
            _con.Abrir();
             pst=_con.RecibirQuer(_selectxParametro);
             pst.setInt(1, o);
             ResultSet _rs = pst.executeQuery();
             while(_rs.next())
                _lsnumero.add(new ENumero(_rs.getInt("num_ncodigo"), _rs.getString("num_cserie"),_rs.getString("num_cnumero"),_rs.getInt("suc_ncodigo"),_rs.getString("doc_ccodigo"),_rs.getInt("par_ncodigo"),_rs.getString("doc_cdescripcion"),_rs.getString("suc_calias"),InstancaEntidad.UNCHANGUE));

        } catch (Exception e) { e.printStackTrace();
        }
        finally{_con.Cerrar();}
        return _lsnumero;
    }

    @Override
    public List<?> ObtenerTodos() {
//        List<ENumero> _lsnumero = new ArrayList<>();
//         try
//         {
//            _con= new Conector();
//            _con.Abrir();
//            pst=_con.RecibirQuer(_selectxParametro);
//            pst.setInt(1, codigo);
//            ResultSet _rs = pst.executeQuery();
//            while(_rs.next())
//                _lsnumero.add(new ENumero(_rs.getInt("num_ncodigo"), _rs.getString("num_cserie"),_rs.getString("num_cnumero"),_rs.getInt("suc_ncodigo"),_rs.getString("doc_ccodigo"),_rs.getInt("par_ncodigo")));
//         }
//         catch(Exception e)
//         {   }
//         return _lsnumero;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public boolean IncrementarNumero(int x_numero,int x_num_ncodigo)
    {
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_updateInremento);
            pst.setString(1, String.valueOf(x_numero));
            pst.setInt(2, x_num_ncodigo);
            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                return true;
        }
        catch(Exception e)
        {        }
        return false;
    }

    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }

    public ENumero ObtenerObtenerUnoxNumero(int x_codigo)
    {
        ENumero _lsnumero =null;
        try {
            _con= new Conector();
            _con.Abrir();
             pst=_con.RecibirQuer(_selectxCodigoNumero);
             pst.setInt(1, x_codigo);
             ResultSet _rs = pst.executeQuery();
             if(_rs.next())
                _lsnumero=(new ENumero(_rs.getInt("num_ncodigo"), _rs.getString("num_cserie"),_rs.getString("num_cnumero"),_rs.getInt("suc_ncodigo"),_rs.getString("doc_ccodigo"),_rs.getInt("par_ncodigo"),_rs.getString("doc_cdescripcion"),_rs.getString("suc_calias"),InstancaEntidad.UNCHANGUE));

        } catch (Exception e) { e.printStackTrace();
        _con.Cerrar();
        }
        finally{_con.Cerrar();}
        return _lsnumero;
    }
    
    public boolean  VerificarSerieNumero(int x_codigo)
    {
        boolean _f=false;
        try {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer("select verificarserienumero_ssf(?)");
            pst.setInt(1, x_codigo);
            ResultSet _rs=_con.EjecutarQuery(pst);
            if(_rs.next())
                _f=_rs.getBoolean(1);
        } catch (Exception e) {
            System.out.println("Error en :"+e.getMessage());
            _con.Cerrar();
        }finally{_con.Cerrar();}
        return _f;
    }
    
    
}
