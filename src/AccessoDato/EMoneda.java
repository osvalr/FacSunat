
package AccessoDato;

public class EMoneda {
    private String mon_ncodigo;
    private String mon_cdescripcion;
    private String mon_cpais;
    private String mon_csimbolo;

    public EMoneda(String mon_ncodigo, String mon_cdescripcion, String mon_cpais, String mon_csimbolo) {
        this.mon_ncodigo = mon_ncodigo;
        this.mon_cdescripcion = mon_cdescripcion;
        this.mon_cpais = mon_cpais;
        this.mon_csimbolo = mon_csimbolo;
    }

    

    public EMoneda() {
    }

    public String getMon_ncodigo() {
        return mon_ncodigo;
    }

    public void setMon_ncodigo(String mon_ncodigo) {
        this.mon_ncodigo = mon_ncodigo;
    }

    public String getMon_cdescripcion() {
        return mon_cdescripcion;
    }

    public void setMon_cdescripcion(String mon_cdescripcion) {
        this.mon_cdescripcion = mon_cdescripcion;
    }

    public String getMon_cpais() {
        return mon_cpais;
    }

    public void setMon_cpais(String mon_cpais) {
        this.mon_cpais = mon_cpais;
    }

    public String getMon_csimbolo() {
        return mon_csimbolo;
    }

    public void setMon_csimbolo(String mon_csimbolo) {
        this.mon_csimbolo = mon_csimbolo;
    }
    
    
}
