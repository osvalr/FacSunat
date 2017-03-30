
package Negocio;

import AccessoDato.DAOEmpresa;
import AccessoDato.EEmpresa;

public class BEmpresa {
    private DAOEmpresa _daoempresa;

    public BEmpresa() {
        _daoempresa= new DAOEmpresa();
    }
    public EEmpresa ObtenerUno(int x_codigo)
    {
        EEmpresa _empresa=null;
        try
        {
            _empresa=(EEmpresa) _daoempresa.ObtenerUno(x_codigo);
        }
        catch(Exception e)
        {
        
        }
        
        return _empresa;
    }
    
    public EEmpresa AccionObtenerDatosEmpresaDocumentoBaja()
    {
        return _daoempresa.ObtenerDatosResumen();
    }
    
            
}
