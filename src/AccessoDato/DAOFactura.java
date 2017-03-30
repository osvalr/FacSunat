
package AccessoDato;

import Utilidad.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOFactura implements IOperacion{

    private final String _insertOne="insert into factura(cli_ncodigo,ley_ncodigo,fac_dfechaemision,fac_cdescripcion,fac_cestado,fac_cclasepago,fac_cserie,fac_cnumero,fac_cfirmadigital,fac_fimportesubtotal,\n" +
                                                        "fac_ftotal,fac_fiigv,fac_cnumeroguia,doc_ccodigo,mon_ncodigo,suc_ncodigo,ven_ncodigo,fac_ftotalexonerado,fac_ftotalinafecto,dir_ncodigo,pla_ncodigo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning fac_ncodigo;";
    private final String _updateOne="";
    private final String _deleteOne="";
    private final String _selectone="select * from vfactura where fac_ncodigo=?";
    private final String _selecttAll="select * from vfactura ";
    private final String  _selectOnexSerieNumero="select * from vfactura where fac_cserie=? and fac_cnumero=? and rel_codigo is  null";
    private final String _updateFacura_SerieNumeroNoteCredito=" update factura set rel_codigo=?  where fac_ncodigo=?";
    //fecha:2016-12-27
    //autor:yasmani
    //descripcion:select por serie, numero y tipo de documento para el proceso de anulado.
    private final String selectxSerieNumeroTipo="select * from vfactura where fac_cserie=? and fac_cnumero=? and doc_ccodigo=?";
    private Conector _con;
    private PreparedStatement pst =null;
    @Override
    public boolean Guardar(Object o) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            _con= new Conector();
//            _con.Abrir();
            EFactura _fac=(EFactura)o;
            try
            {
            pst=_con.RecibirQuer(_insertOne);
            //pst.setInt(1, _fac.getFac_ncodigo());
            pst.setInt(1, _fac.getCli_ncodigo());
            pst.setInt(2, _fac.getLey_ncodigo());
            pst.setDate(3, _fac.getFac_dfechaemision());
            pst.setString(4, _fac.getFac_cdescripcion());
            pst.setString(5, _fac.getFac_cestado());
            pst.setString(6, _fac.getFac_cclasepago());
            pst.setString(7, _fac.getFac_cserie());
            pst.setString(8, _fac.getFac_cnumero());
            pst.setString(9, _fac.getFac_firmadigital());
            pst.setDouble(10, _fac.getFac_fimportesubtotal());
            pst.setDouble(11, _fac.getFac_ftotal());
            pst.setDouble(12, _fac.getFac_igv());
            //Se omiten 4 campos adicionales
            pst.setString(13, _fac.getFac_nnumeroguia());
            pst.setString(14,_fac.getDoc_ccodigo());
            pst.setString(15, _fac.getMon_ccodigo());
            pst.setInt(16, _fac.getSuc_ncodigo());
            pst.setInt(17, _fac.getVe_ncodigo());
            pst.setDouble(18, _fac.getFac_ftotalexonerado());
            pst.setDouble(19, _fac.getFac_ftotalexonerado());
            //add dd-MM-yyyy:13-08-216
            pst.setInt(20, _fac.getDir_ncodigo());
            pst.setInt(21, _fac.getPla_ncodigo());
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
            {
                _fac.setFac_ncodigo(_rs.getInt("fac_ncodigo"));
                ((EFactura)o).setFac_ncodigo(_fac.getFac_ncodigo());
                 return true;
            }
        }
        catch(Exception e)
        {
        //_con.Cerrar();
        }
        finally
        {
         //_con.Cerrar();
        }
            return false;
    }

    @Override
    public boolean Modificar(Object o) {
            EFactura _fac=(EFactura)o;
            try
            {
                pst=_con.RecibirQuer(_insertOne);
                pst.setInt(1, _fac.getCli_ncodigo());
                pst.setInt(2, _fac.getLey_ncodigo());
                pst.setDate(3, _fac.getFac_dfechaemision());
                pst.setString(4, _fac.getFac_cdescripcion());
                pst.setString(5, _fac.getFac_cestado());
                pst.setString(6, _fac.getFac_cclasepago());
                pst.setString(7, _fac.getFac_cserie());
                pst.setString(8, _fac.getFac_cnumero());
                pst.setString(9, _fac.getFac_firmadigital());
                pst.setDouble(10, _fac.getFac_fimportesubtotal());
                pst.setDouble(11, _fac.getFac_ftotal());
                pst.setDouble(12, _fac.getFac_igv());
                pst.setString(13, _fac.getFac_nnumeroguia());
                pst.setString(14,_fac.getDoc_ccodigo());
                pst.setString(15, _fac.getMon_ccodigo());
                pst.setInt(16, _fac.getFac_ncodigo());

            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
            {
                 return true;
            }

        }
        catch(Exception e)
        {
//        _con.Cerrar();
        }
        finally
        {
//         _con.Cerrar();
        }
            return false;
    }

    @Override
    public boolean Eliminar(int o) {
       _con= new Conector();
            _con.Abrir();
            try
            {
            pst=_con.RecibirQuer(_insertOne);
            pst.setInt(1, o);
            
            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
            {
                 return true;
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
            return false;
    }

    @Override
    public Object ObtenerUno(int o) {
       EFactura _efactura = null;
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectone);
            pst.setInt(1, o);
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
                 _efactura=new EFactura(_rs.getInt("fac_ncodigo"),_rs.getString("fac_dfechaemision"),_rs.getString("fac_cserie"),_rs.getString("fac_cnumero"),_rs.getString("fac_tipodoc"),_rs.getString("fac_estado"),_rs.getString("fac_estadopago"),_rs.getString("mon_csimbolo"),_rs.getString("cli_crazonsocial"),_rs.getDouble("fac_subtotal"),_rs.getDouble("fac_total"),_rs.getDouble("exonerado"),_rs.getDouble("inafecto"),_rs.getString("fac_vendedor"),_rs.getInt("cli_ncodigo"),_rs.getInt("ley_ncodigo"),_rs.getString("fac_cclasepago"),_rs.getString("doc_ccodigo"),_rs.getString("mon_ncodigo"),_rs.getInt("ven_ncodigo"),_rs.getInt("suc_ncodigo"),_rs.getString("fac_cestado"),_rs.getString("fac_cdescripcion"),_rs.getDouble("fac_fiigv"));
        }
        catch(Exception e)
        {}
        finally{_con.Cerrar();}
        return _efactura;
    }

    @Override
    public List<EFactura> ObtenerTodos() {
       List<EFactura> _lsfactura = new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selecttAll);
            ResultSet _rs = _con.EjecutarQuery(pst);
            while(_rs.next())
            {
                 EFactura obj=new EFactura(_rs.getInt("fac_ncodigo"),_rs.getString("fac_dfechaemision"),_rs.getString("fac_cserie"),_rs.getString("fac_cnumero"),_rs.getString("fac_tipodoc"),_rs.getString("fac_estado"),_rs.getString("fac_estadopago"),_rs.getString("mon_csimbolo"),_rs.getString("cli_crazonsocial"),_rs.getDouble("fac_subtotal"),_rs.getDouble("fac_total"),_rs.getDouble("exonerado"),_rs.getDouble("inafecto"),_rs.getString("fac_vendedor"),_rs.getInt("cli_ncodigo"),_rs.getInt("ley_ncodigo"),_rs.getString("fac_cclasepago"),_rs.getString("doc_ccodigo"),_rs.getString("mon_ncodigo"),_rs.getInt("ven_ncodigo"),_rs.getInt("suc_ncodigo"),_rs.getString("fac_cestado"),_rs.getString("fac_cdescripcion"),_rs.getDouble("fac_fiigv"));
                 _lsfactura.add(obj);
            }
        }
        catch(Exception e)
        {}finally{_con.Cerrar();}
        
        return _lsfactura;
    }
    public EFactura ObtenerUnoxSerieNumero(String x_serie ,String x_numero)
    {
        EFactura _efactura =null;
        try {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOnexSerieNumero);
            pst.setString(1, x_serie);
            pst.setString(2, x_numero);
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
                 _efactura=new EFactura(_rs.getInt("fac_ncodigo"),_rs.getString("fac_dfechaemision"),_rs.getString("fac_cserie"),_rs.getString("fac_cnumero"),_rs.getString("fac_tipodoc"),_rs.getString("fac_estado"),_rs.getString("fac_estadopago"),_rs.getString("mon_csimbolo"),_rs.getString("cli_crazonsocial"),_rs.getDouble("fac_subtotal"),_rs.getDouble("fac_total"),_rs.getDouble("exonerado"),_rs.getDouble("inafecto"),_rs.getString("fac_vendedor"),_rs.getInt("cli_ncodigo"),_rs.getInt("ley_ncodigo"),_rs.getString("fac_cclasepago"),_rs.getString("doc_ccodigo"),_rs.getString("mon_ncodigo"),_rs.getInt("ven_ncodigo"),_rs.getInt("suc_ncodigo"),_rs.getString("fac_cestado"),_rs.getString("fac_cdescripcion"),_rs.getDouble("fac_fiigv"));
        } catch (Exception e) {
        }
        finally{_con.Cerrar();}
        return _efactura;
    }
    public Conector getCon() {
        return _con;
    }

    public void setCon(Conector _con) {
        this._con = _con;
    }
    public boolean VerificarFacturaxSerieNumero(String x_serie ,String x_numero)
    {
        try {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOnexSerieNumero);
            pst.setString(1, x_serie);
            pst.setString(2, x_numero);
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
                return true;
        } catch (Exception e) {
        }
        finally{_con.Cerrar();}
        return false;
    }

    public boolean ActualizaFactura_SerieNumeroNotacredito(String x_serie_numero_iddoc,int x_codigo) {
        boolean r=false;
        try {
            
            getCon().con.setAutoCommit(false);
            pst=getCon().RecibirQuer(_updateFacura_SerieNumeroNoteCredito);
            pst.setString(1, x_serie_numero_iddoc);
            pst.setInt(2, x_codigo);
            int  _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                 r= true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public EFactura buscarxSerieNumeroTipo(String x_tipo,String x_serie,String x_numero)
    {
        EFactura _efacura=null;
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(selectxSerieNumeroTipo);
            //pst.setString(1, x_tipo);// no tiene tipo
            pst.setString(1, x_serie);
            pst.setString(2, x_numero);
            pst.setString(3, x_tipo);
            
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
                 _efacura=new EFactura(_rs.getInt("fac_ncodigo"),_rs.getString("fac_dfechaemision"),_rs.getString("fac_cserie"),_rs.getString("fac_cnumero"),_rs.getString("fac_tipodoc"),_rs.getString("fac_estado"),_rs.getString("fac_estadopago"),_rs.getString("mon_csimbolo"),_rs.getString("cli_crazonsocial"),_rs.getDouble("fac_subtotal"),_rs.getDouble("fac_total"),_rs.getDouble("exonerado"),_rs.getDouble("inafecto"),_rs.getString("fac_vendedor"),_rs.getInt("cli_ncodigo"),_rs.getInt("ley_ncodigo"),_rs.getString("fac_cclasepago"),_rs.getString("doc_ccodigo"),_rs.getString("mon_ncodigo"),_rs.getInt("ven_ncodigo"),_rs.getInt("suc_ncodigo"),_rs.getString("fac_cestado"),_rs.getString("fac_cdescripcion"),_rs.getDouble("fac_fiigv"));

        }
        catch(Exception e)
        {
            _con.Cerrar();
            System.out.println("Erro: "+e.getMessage());
        }
        
        return _efacura;
    }
    
    
}
