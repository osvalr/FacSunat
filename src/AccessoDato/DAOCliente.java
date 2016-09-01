
package AccessoDato;

import Utilidad.Conector;
import Utilidad.DisplayValue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;


public class DAOCliente {
    
    private final String  _insertOne="insert into cliente(cli_crazonsocial,cli_cnumerodoc,cli_cdireccionfiscal,doi_ccodigo,cli_ncodubigeo) values (?,?,?,?,?) RETURNING cli_ncodigo;";
    private final String  _updateOne="update  cliente\n" +
"set \n" +
"cli_crazonsocial=?,cli_cnumerodoc=?,\n" +
"cli_cdireccionfiscal=?,doi_ccodigo=?,\n" +
"cli_ncodubigeo=? where cli_ncodigo=?";
    private final String  _deleteOne="delete * from cliente where cli_ncodigo=?";
    private final String  _selectOne="select  * from cliente c where c.cli_ncodigo=?";
    
    private final String  _selectAll="select * from vcliente";
    //optenemos todos los clientes por razon social y que sean reistrados como personas juridicas
    private final String  _selectAllxRucandnombre="select * from vcliente where cli_crazonsocial like ? and doi_ccodigo=?";
    //optenemos todos los clientes por razon social y que esten registrados con documentos distinto a juridicos
    private final String  _selectAllnoRucandnombre="select * from vcliente where cli_crazonsocial like ? and doi_ccodigo!=?";
     //optenemos todos los clientes por numero documento y que sean registrados como personas juridicas
    private final String  _selectAllxRucnumeroDocumento="select * from vcliente where cli_cnumerodoc like ? and doi_ccodigo=?";
    //optenemos todos los clientes por razon social y que esten registrados con documento distinto a ruc
    private final String  _selectAllnoRucnumeroDocumento="select * from vcliente where cli_cnumerodoc like ? and doi_ccodigo!=?";
    private Conector _con;
    private PreparedStatement pst =null;
    public Boolean Guardar(ECliente x_cliente)
    {
        try
        {
            pst=_con.RecibirQuer(_insertOne);
            pst.setString(1, x_cliente.getCli_crazon());
            pst.setString(2, x_cliente.getCli_cnumerodoc());
            pst.setString(3, x_cliente.getCli_cdireccionfiscal());
            pst.setString(4, x_cliente.getCoi_ccodigo());
            pst.setInt(5, x_cliente.getCli_ncodubigeo());
            
            ResultSet _rs = _con.EjecutarQuery(pst);
            if(_rs.next())
            {
                x_cliente.setCli_ncodigo(_rs.getInt("cli_ncodigo"));
                 return true;
            }
        }
        catch(Exception e)
        {
        }
        finally
        {
        }
            return false;
    }
    public Boolean Modificar(ECliente x_cliente)
    {
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_updateOne);
            pst.setString(1, x_cliente.getCli_crazon());
            pst.setString(2, x_cliente.getCli_cnumerodoc());
            pst.setString(3, x_cliente.getCli_cdireccionfiscal());
            pst.setString(4, x_cliente.getCoi_ccodigo());            
            pst.setInt(5, x_cliente.getCli_ncodubigeo());
            pst.setInt(6, x_cliente.getCli_ncodigo());
            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {//_con.Cerrar();
        }    
        return false;
    }
    public boolean Eliminar(int x_codigo)
    {
        boolean _f=false;
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_insertOne);
            pst.setInt(1, x_codigo);
            int _rs = _con.EjecutarQueryUpdate(pst);
            if(_rs>0)
                _f=true;
        }
        catch(Exception e)
        {_con.Cerrar();}
        finally{_con.Cerrar();}
        return _f;
    }
    public List<ECliente> ObtenerTodos()
    {
        List<ECliente> _lscliente = new ArrayList<>();
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectAll);
            ResultSet _rs = pst.executeQuery();
            while(_rs.next())
                _lscliente.add(new ECliente(_rs.getInt("cli_ncodigo"), _rs.getString("cli_crazonsocial"),_rs.getString("cli_cnumerodoc"),_rs.getString("cli_cdireccionfiscal"),_rs.getString("doi_ccodigo"),_rs.getString("doc_cdescripcion")));
        }
        catch(Exception e)
        {_con.Cerrar();}
        finally{_con.Cerrar();}
        return _lscliente;
    }
    
    public ECliente ObtenerUno(int x_idCli)
    {
       ECliente _ecliente=null;
        try
        {
            _con= new Conector();
            _con.Abrir();
            pst=_con.RecibirQuer(_selectOne);
            pst.setInt(1, x_idCli);
            ResultSet _rs = pst.executeQuery();
            if(_rs.next())
                _ecliente = new ECliente(_rs.getInt("cli_ncodigo"), _rs.getString("cli_crazonsocial"),_rs.getString("cli_cnumerodoc"),_rs.getString("cli_cdireccionfiscal"),_rs.getString("doi_ccodigo"),_rs.getInt("cli_ncodubigeo"));
        }
        catch(Exception e)
        {_con.Cerrar();}
        finally{_con.Cerrar();}
        return _ecliente;
    }
    public DefaultComboBoxModel AcctionFiltrarClientexTipoDocumento( String x_busca,String x_DocumentoTipo )
    {
        DefaultComboBoxModel _cmbrpta=null;
        try {
            _con= new Conector();
            _con.Abrir();
            if(x_DocumentoTipo.equals("01"))
                pst=_con.RecibirQuer(_selectAllxRucnumeroDocumento);
            else
                pst=_con.RecibirQuer(_selectAllnoRucnumeroDocumento);
            pst.setString(1, x_busca+"%");
            pst.setString(2, "6");
            ResultSet _rs = pst.executeQuery();
            Vector _item = new Vector();
            _item.addElement(new DisplayValue("Elegir","-1"));

            while(_rs.next())
                _item.addElement(new DisplayValue(_rs.getString("cli_cnumerodoc"),_rs.getInt("cli_ncodigo")));
            _cmbrpta = new DefaultComboBoxModel(_item);
        } catch (Exception e) {  _con.Cerrar();        }
        finally{ _con.Cerrar();}
        return _cmbrpta;
    }
//    public DefaultComboBoxModel AcctionFiltrarClientexNombrecliente( String x_busca,String x_DocumentoTipo )
//    {
//        DefaultComboBoxModel _cmbrpta=null;
//        try {
//            _con= new Conector();
//            _con.Abrir();
//            if(x_DocumentoTipo.equals("01"))
//                pst=_con.RecibirQuer(_selectAllxRucandnombre);
//            else
//                pst=_con.RecibirQuer(_selectAllnoRucandnombre);
//            pst.setString(1, x_busca+"%");
//            pst.setString(2, "6");
//            ResultSet _rs = pst.executeQuery();
//            Vector _item = new Vector();
//            while(_rs.next())
//                _item.addElement(new DisplayValue(_rs.getString("cli_crazonsocial"),_rs.getInt("cli_ncodigo")));
//            _cmbrpta = new DefaultComboBoxModel(_item);
//        } catch (Exception e) {  _con.Cerrar();        }
//        finally{ _con.Cerrar();}
//        return _cmbrpta;
//    }
    public Conector getCon() {
        return _con;
    }
    public void setCon(Conector _con) {
        this._con = _con;
    }
    public List<ECliente> listarAcctionFiltrarClientexNombrecliente( String x_busca,String x_DocumentoTipo )
    {
        List<ECliente> _lscliente = new ArrayList<>();
        try {
            _con= new Conector();
            _con.Abrir();
            if(x_DocumentoTipo.equals("01"))
                pst=_con.RecibirQuer(_selectAllxRucandnombre);
            else
                pst=_con.RecibirQuer(_selectAllnoRucandnombre);
            pst.setString(1, x_busca+"%");
            pst.setString(2, "6");
            ResultSet _rs = pst.executeQuery();
            while(_rs.next())
                _lscliente.add(new ECliente(_rs.getInt("cli_ncodigo"), _rs.getString("cli_crazonsocial"),_rs.getString("cli_cnumerodoc"),_rs.getString("cli_cdireccionfiscal"),_rs.getString("doi_ccodigo"),_rs.getString("doc_cdescripcion")));
        } catch (Exception e) {  _con.Cerrar();        }
        finally{ _con.Cerrar();}
        return _lscliente;
    }
}
