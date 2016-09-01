
package AccessoDato;


public class EAfectacion {
    
    private int afe_ncodigo;
    private String afe_cdescripcion;

    public EAfectacion() {
    }

    public EAfectacion(int afe_ncodigo, String afe_cdescripcion) {
        this.afe_ncodigo = afe_ncodigo;
        this.afe_cdescripcion = afe_cdescripcion;
    }

    public int getAfe_ncodigo() {
        return afe_ncodigo;
    }

    public void setAfe_ncodigo(int afe_ncodigo) {
        this.afe_ncodigo = afe_ncodigo;
    }

    public String getAfe_cdescripcion() {
        return afe_cdescripcion;
    }

    public void setAfe_cdescripcion(String afe_cdescripcion) {
        this.afe_cdescripcion = afe_cdescripcion;
    }
    
    
}
