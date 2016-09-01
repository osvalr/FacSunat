
package Negocio;

import AccessoDato.DAODetFactura;
import AccessoDato.EFacturaDetalle;
import java.util.ArrayList;
import java.util.List;

public class BFacturaDetalle {

    private DAODetFactura _daodetalle;
    private EFacturaDetalle _efacturadet;
    public BFacturaDetalle() {
        _daodetalle = new DAODetFactura();
    } 
    
    public void Guardar( List<EFacturaDetalle> x_detalle, int x_codigo)
    {
        try            
        {
            for (int i=0;i<=x_detalle.size();i++)
            {
                _efacturadet=x_detalle.get(i);
                _efacturadet.setFac_ncodigo(x_codigo);
                if(null!=_efacturadet.getM_instancia())
                switch (_efacturadet.getM_instancia()) {
                    case NEW:
                        _daodetalle.Guardar(_efacturadet);
                        break;
                    case MODIFY:
                        _daodetalle.Modificar(_efacturadet);
                        break;
                    case DELETE:
                        _daodetalle.Modificar(_efacturadet);
                        break;
                    default:
                        break;
                }
            }
        }
        catch(Exception e)
        {
        
        }
    }
    
    public List<EFacturaDetalle> AccionObtenerAllxCabecera(int x_codigo)
    {
        List<EFacturaDetalle> _lsefacturadetalle=new ArrayList<>();
        try {
            _lsefacturadetalle=_daodetalle.ObtenerTodosxIdCabecera(x_codigo);
        } catch (Exception e) {
        }
        return _lsefacturadetalle;
    }
    
    
}
