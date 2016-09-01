
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAOUbigeo implements IOperacion{
    
    private final String  _selectOnlyDepartaento="select distinct ubi_ccoddepa,ubi_cdepartamento from ubigeo order by 1 ";
    private final String  _selectOnlyProvincia="select distinct ubi_codpro,ubi_cprovincia from ubigeo where left(ubi_codpro,2)=? and ubi_cprovincia<>'' order by 1 ";
    private final String  _selectOnlyDistrito="select distinct ubi_ccoddistri,ubi_cdistrito from ubigeo where left(ubi_ccoddistri,4)=? and ubi_cdistrito<>'' order by 1 ";   
    private final String  _selectOnlyid="select  * from ubigeo where ubi_ccoddistri=?";
    private final String  _selectOnlynodigo="select  * from ubigeo where ubi_ncodigo=?";
    private Conector _con;
    private PreparedStatement pst =null;
    private int tiposelec;
    private String codigo;
   
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
        EUbigeo _eubigeo=null;
         try
         {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOnlyid);
            pst.setString(1, codigo);
            ResultSet _rs = pst.executeQuery();
            if(_rs.next())
                _eubigeo=new EUbigeo(_rs.getInt("ubi_ncodigo"), _rs.getString("ubi_ccoddepa"), _rs.getString("ubi_codpro"), _rs.getString("ubi_ccoddistri"), _rs.getString("ubi_cdepartamento"), _rs.getString("ubi_cprovincia"), _rs.getString("ubi_cdistrito"));
         }
         catch(Exception e)
         {
             e.printStackTrace();
             _con.Cerrar();
         }finally{_con.Cerrar();}
         
         return _eubigeo;
    }

    @Override
    public List<?> ObtenerTodos() {
        
        List<EUbigeo> _lsubigeo=new ArrayList<>();
        _con= new Conector();
        ResultSet _rs;
            try
            {
                 _con.Abrir();
                switch (tiposelec)
                {
                    case 1://departamento
                        pst=_con.RecibirQuer(_selectOnlyDepartaento);
                        _rs = _con.EjecutarQuery(pst);            
                        while(_rs.next())
                            _lsubigeo.add(new EUbigeo(0,_rs.getString("ubi_ccoddepa"),"","",_rs.getString("ubi_cdepartamento"),"",""));

                    break;
                    case 2://provincia
                        pst=_con.RecibirQuer(_selectOnlyProvincia);
                        pst.setString(1, codigo);
                        _rs = _con.EjecutarQuery(pst);            
                        while(_rs.next())
                            _lsubigeo.add(new EUbigeo(0,"",_rs.getString("ubi_codpro"),"","",_rs.getString("ubi_cprovincia"),""));
                    break;
                    case 3://distrito
                        pst=_con.RecibirQuer(_selectOnlyDistrito);
                        pst.setString(1, codigo);
                        _rs = _con.EjecutarQuery(pst);            
                        while(_rs.next())
                            _lsubigeo.add(new EUbigeo(0,"","",_rs.getString("ubi_ccoddistri"),"","",_rs.getString("ubi_cdistrito")));
                    break;
                }
            }
            catch(Exception e)
            {
             _con.Cerrar();
            }
            finally{_con.Cerrar();}
                    
        return _lsubigeo;
    }

    public int getTiposelec() {
        return tiposelec;
    }

    public void setTiposelec(int tiposelec) {
        this.tiposelec = tiposelec;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Object ObtenerUnoxCodigo(int o) {
        EUbigeo _eubigeo=null;
         try
         {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOnlynodigo);
            pst.setInt(1, o);
            ResultSet _rs = pst.executeQuery();
            if(_rs.next())
                _eubigeo=new EUbigeo(_rs.getInt("ubi_ncodigo"), _rs.getString("ubi_ccoddepa"), _rs.getString("ubi_codpro"), _rs.getString("ubi_ccoddistri"), _rs.getString("ubi_cdepartamento"), _rs.getString("ubi_cprovincia"), _rs.getString("ubi_cdistrito"));
         }
         catch(Exception e)
         {_con.Cerrar(); }
         finally{_con.Cerrar();}
         return _eubigeo;
    }
    
    
    
}
