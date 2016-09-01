
package AccessoDato;

public class EUnidad {
    private int uni_ncodigo;
    private String uni_cdescripcion;

    public int getUni_ncodigo() {
        return uni_ncodigo;
    }

    public void setUni_ncodigo(int uni_ncodigo) {
        this.uni_ncodigo = uni_ncodigo;
    }

    public String getUni_cdescripcion() {
        return uni_cdescripcion;
    }

    public void setUni_cdescripcion(String uni_cdescripcion) {
        this.uni_cdescripcion = uni_cdescripcion;
    }

    public EUnidad(int uni_ncodigo, String uni_cdescripcion) {
        this.uni_ncodigo = uni_ncodigo;
        this.uni_cdescripcion = uni_cdescripcion;
    }

    public EUnidad() {
    }
            
}
