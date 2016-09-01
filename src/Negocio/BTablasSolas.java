
package Negocio;

import AccessoDato.DAOTablasSolas;
import AccessoDato.EDocumento;
import AccessoDato.EMotivoNota;
import AccessoDato.EPais;
import java.util.ArrayList;
import java.util.List;

public class BTablasSolas {
    
    private DAOTablasSolas _daotablassolas;
    
    public BTablasSolas() {
        _daotablassolas= new DAOTablasSolas();
    }
    public float Obtenerigv()
    {
        return _daotablassolas.Obtenerigv();
    }
    
    public List<EDocumento> ObtenerTodoDocumentos()
    {
        List<EDocumento> _lsdoc = new ArrayList<>();
        try
        {
            _lsdoc=_daotablassolas.ObtenerDocumento();
        }
        catch(Exception e)
        {
        
        }        
        return _lsdoc;
    }
    
    public List<EPais> ObtenerTodosPaises()
    {
        List<EPais> _lspaises = new ArrayList<>();
        try {
            _lspaises=_daotablassolas.ObtenerTodosPais();
        } catch (Exception e) {
        }
        return _lspaises;
    }
    
    public List<EMotivoNota> ObtenerTodosMotivoNota()
    {
        List<EMotivoNota> _lsmotivo = new ArrayList<>();
        try {
            _lsmotivo=_daotablassolas.ObtenerTodosMotivosNota();
        } catch (Exception e) {
        }
        return _lsmotivo;
    }
}
