
package AccessoDato;

public class EMotivoNota {
    private String mtv_ccodigo; 
    private String mtv_cdescripcion; 

    public EMotivoNota() {
    }

    public EMotivoNota(String mtv_ccodigo, String mtv_cdescripcion) {
        this.mtv_ccodigo = mtv_ccodigo;
        this.mtv_cdescripcion = mtv_cdescripcion;
    }
    
    public String getMtv_ccodigo() {
        return mtv_ccodigo;
    }

    public void setMtv_ccodigo(String mtv_ccodigo) {
        this.mtv_ccodigo = mtv_ccodigo;
    }

    public String getMtv_cdescripcion() {
        return mtv_cdescripcion;
    }

    public void setMtv_cdescripcion(String mtv_cdescripcion) {
        this.mtv_cdescripcion = mtv_cdescripcion;
    }
    
}
