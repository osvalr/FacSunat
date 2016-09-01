
package AccessoDato;

import java.util.List;

public interface IOperacion {
    
    public boolean Guardar(Object o);
    public boolean Modificar(Object o);
    public boolean Eliminar(int o);
    public Object ObtenerUno(int o);
    public List<?> ObtenerTodos();
    
    
    
}
