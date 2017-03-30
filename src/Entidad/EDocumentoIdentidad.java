
package AccessoDato;

public class EDocumentoIdentidad {
    private String doi_ccodigo;
    private String doi_cdescripcion;

    public EDocumentoIdentidad(String doi_ccodigo, String doi_cdescripcion) {
        this.doi_ccodigo = doi_ccodigo;
        this.doi_cdescripcion = doi_cdescripcion;
    }

    public String getDoi_ccodigo() {
        return doi_ccodigo;
    }

    public void setDoi_ccodigo(String doi_ccodigo) {
        this.doi_ccodigo = doi_ccodigo;
    }

    public String getDoi_cdescripcion() {
        return doi_cdescripcion;
    }

    public void setDoi_cdescripcion(String doi_cdescripcion) {
        this.doi_cdescripcion = doi_cdescripcion;
    }
    
}
