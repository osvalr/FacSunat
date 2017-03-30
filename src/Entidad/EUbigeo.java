
package AccessoDato;

public class EUbigeo {
      private int ubi_ncodigo; 
      private String ubi_ccoddepa; 
      private String ubi_codpro; 
      private String ubi_ccoddistri; 
      private String ubi_cdepartamento; 
      private String ubi_cprovincia; 
      private String ubi_cdistrito;

    public EUbigeo() {
    }
  
    
    
    public EUbigeo(int ubi_ncodigo, String ubi_ccoddepa, String ubi_codpro, String ubi_ccoddistri, String ubi_cdepartamento, String ubi_cprovincia, String ubi_cdistrito) {
        this.ubi_ncodigo = ubi_ncodigo;
        this.ubi_ccoddepa = ubi_ccoddepa;
        this.ubi_codpro = ubi_codpro;
        this.ubi_ccoddistri = ubi_ccoddistri;
        this.ubi_cdepartamento = ubi_cdepartamento;
        this.ubi_cprovincia = ubi_cprovincia;
        this.ubi_cdistrito = ubi_cdistrito;
    }
    
    public int getUbi_ncodigo() {
        return ubi_ncodigo;
    }

    public void setUbi_ncodigo(int ubi_ncodigo) {
        this.ubi_ncodigo = ubi_ncodigo;
    }

    public String getUbi_ccoddepa() {
        return ubi_ccoddepa;
    }

    public void setUbi_ccoddepa(String ubi_ccoddepa) {
        this.ubi_ccoddepa = ubi_ccoddepa;
    }

    public String getUbi_codpro() {
        return ubi_codpro;
    }

    public void setUbi_codpro(String ubi_codpro) {
        this.ubi_codpro = ubi_codpro;
    }

    public String getUbi_ccoddistri() {
        return ubi_ccoddistri;
    }

    public void setUbi_ccoddistri(String ubi_ccoddistri) {
        this.ubi_ccoddistri = ubi_ccoddistri;
    }

    public String getUbi_cdepartamento() {
        return ubi_cdepartamento;
    }

    public void setUbi_cdepartamento(String ubi_cdepartamento) {
        this.ubi_cdepartamento = ubi_cdepartamento;
    }

    public String getUbi_cprovincia() {
        return ubi_cprovincia;
    }

    public void setUbi_cprovincia(String ubi_cprovincia) {
        this.ubi_cprovincia = ubi_cprovincia;
    }

    public String getUbi_cdistrito() {
        return ubi_cdistrito;
    }

    public void setUbi_cdistrito(String ubi_cdistrito) {
        this.ubi_cdistrito = ubi_cdistrito;
    }
      
    
}
