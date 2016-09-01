
package AccessoDato;


public class EDocumento {
     private String doc_ccodigo;
     private String doc_cdescripcion;

    public EDocumento() {
    }

    public EDocumento(String doc_ccodigo, String doc_cdescripcion) {
        this.doc_ccodigo = doc_ccodigo;
        this.doc_cdescripcion = doc_cdescripcion;
    }

    public String getDoc_ccodigo() {
        return doc_ccodigo;
    }

    public void setDoc_ccodigo(String doc_ccodigo) {
        this.doc_ccodigo = doc_ccodigo;
    }

    public String getDoc_cdescripcion() {
        return doc_cdescripcion;
    }

    public void setDoc_cdescripcion(String doc_cdescripcion) {
        this.doc_cdescripcion = doc_cdescripcion;
    }
     
     
}
