
package AccessoDato;

public class EArticulo {
    private int art_ncodigo;
    private String art_cdescripcion;    
    private int uni_ncodigo;    
    private String art_ccodigo;
    private String art_ccodbarra;
    private String art_cafectacion;
    private String uni_cdescripcion;
   


    public EArticulo() {
    }

    public EArticulo(int art_ncodigo, String art_cdescripcion, int uni_ncodigo, String art_ccodigo, String art_ccodbarra, String art_cafectacion) {
        this.art_ncodigo = art_ncodigo;
        this.art_cdescripcion = art_cdescripcion;
        this.uni_ncodigo = uni_ncodigo;
        this.art_ccodigo = art_ccodigo;
        this.art_ccodbarra = art_ccodbarra;
        this.art_cafectacion = art_cafectacion;
    }

    public EArticulo(int art_ncodigo, String art_cdescripcion, int uni_ncodigo, String art_ccodigo, String art_ccodbarra, String art_cafectacion, String uni_cdescripcion) {
        this.art_ncodigo = art_ncodigo;
        this.art_cdescripcion = art_cdescripcion;
        this.uni_ncodigo = uni_ncodigo;
        this.art_ccodigo = art_ccodigo;
        this.art_ccodbarra = art_ccodbarra;
        this.art_cafectacion = art_cafectacion;
        this.uni_cdescripcion = uni_cdescripcion;
    }

   

    
    public int getArt_ncodigo() {
        return art_ncodigo;
    }

    public void setArt_ncodigo(int art_ncodigo) {
        this.art_ncodigo = art_ncodigo;
    }

    public String getArt_cdescripcion() {
        return art_cdescripcion;
    }

    public void setArt_cdescripcion(String art_cdescripcion) {
        this.art_cdescripcion = art_cdescripcion;
    }


    public int getUni_ncodigo() {
        return uni_ncodigo;
    }

    public void setUni_ncodigo(int uni_ncodigo) {
        this.uni_ncodigo = uni_ncodigo;
    }

    public String getArt_ccodigo() {
        return art_ccodigo;
    }

    public void setArt_ccodigo(String art_ccodigo) {
        this.art_ccodigo = art_ccodigo;
    }

    public String getArt_ccodbarra() {
        return art_ccodbarra;
    }

    public void setArt_ccodbarra(String art_ccodbarra) {
        this.art_ccodbarra = art_ccodbarra;
    }

    public String getArt_cafectacion() {
        return art_cafectacion;
    }

    public void setArt_cafectacion(String art_cafectacion) {
        this.art_cafectacion = art_cafectacion;
    }

    public String getUni_cdescripcion() {
        return uni_cdescripcion;
    }

    public void setUni_cdescripcion(String uni_cdescripcion) {
        this.uni_cdescripcion = uni_cdescripcion;
    }
    
    
            
}
