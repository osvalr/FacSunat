
package Negocio;

import AccessoDato.DAOResumenDiario;
import AccessoDato.EResumenDiario;
import java.util.List;

public class BResumenDiario {
    private DAOResumenDiario resumendiario;

    public BResumenDiario() {
        resumendiario= new DAOResumenDiario();
    }
    
    public List<EResumenDiario> AccionObtenerResumenDiario()
    {
        return resumendiario.ObtenerResumenDiario();
    }
    
}
