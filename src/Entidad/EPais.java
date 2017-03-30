
package AccessoDato;

public class EPais {
    private int pai_ncodigo; 
    private String pai_cnombre;

    public EPais() {
    }

    public EPais(int pai_ncodigo, String pai_cnombre) {
        this.pai_ncodigo = pai_ncodigo;
        this.pai_cnombre = pai_cnombre;
    }
    

    public int getPai_ncodigo() {
        return pai_ncodigo;
    }

    public void setPai_ncodigo(int pai_ncodigo) {
        this.pai_ncodigo = pai_ncodigo;
    }

    public String getPai_cnombre() {
        return pai_cnombre;
    }

    public void setPai_cnombre(String pai_cnombre) {
        this.pai_cnombre = pai_cnombre;
    }
    
}
