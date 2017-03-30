
package Negocio;

import AccessoDato.DAOFactura;
import AccessoDato.DAORelacionDocumento;
import AccessoDato.DAORelacionadoDocumentoDetalle;
import AccessoDato.ERelacionadoDocumentoDetalle;
import AccessoDato.ERelacionadoDocumento;
import Utilidad.Conector;
import Utilidad.InstanciaEntidad;
import java.util.List;

public class BRelacionadoDocumento {
    private DAORelacionDocumento _daorelaciondoc;
    DAORelacionadoDocumentoDetalle _daodetalle;
    DAOFactura _daofactura;
    private Conector _con;
    public BRelacionadoDocumento() {
        _daorelaciondoc= new DAORelacionDocumento();
    }
    
    public boolean Guardar(ERelacionadoDocumento x_relacion , List<ERelacionadoDocumentoDetalle> x_detalledocumento)
    {
        boolean r=false;
        try {
            _con= new Conector(true);
            _con.con.setAutoCommit(false);
            _con.Abrir();
            _daorelaciondoc.setCon(_con);
            if(x_relacion.getM_instancia()==InstanciaEntidad.NEW)
            {
                if(_daorelaciondoc.Guardar(x_relacion))
                {
                    ERelacionadoDocumentoDetalle _detalle;
                    _daodetalle= new DAORelacionadoDocumentoDetalle();
                    _daodetalle.setCon(_con);
                    for(int i=0;i<=x_detalledocumento.size()-1;i++)
                    {
                        _detalle=x_detalledocumento.get(i);
                        _detalle.setRel_ncodigo(x_relacion.getRel_ncodigo());
                        if(_detalle.getM_instancia()==InstanciaEntidad.NEW)
                        {
                            r=_daodetalle.Guardar(_detalle);
                        }
                        if(_detalle.getM_instancia()==InstanciaEntidad.MODIFY)
                        {
                            r=_daodetalle.Modificar(_detalle);
                        }
                        if(!r)
                            break;
                    }
                    if(r)
                    {
                        _daofactura = new DAOFactura();
                        _daofactura.setCon(_con);
                        r=_daofactura.ActualizaFactura_SerieNumeroNotacredito(x_relacion.getRel_cserie()+"-"+x_relacion.getRel_cnumero()+"-"+x_relacion.getDoc_ccodigo(),x_relacion.getFac_ncodigo());
                    }
                }
                if(r)
                    _con.con.commit();
                else
                    _con.con.rollback();
            }
            else if(x_relacion.getM_instancia()==InstanciaEntidad.MODIFY)
            {
                if(_daorelaciondoc.Modificar(x_relacion))
                {
                
                }
            }
        } catch (Exception e) {
            System.out.print("Error :"+e.getMessage());
            _con.Cerrar();
        }
        finally{_con.Cerrar();}
        return r;
    }
    
}
