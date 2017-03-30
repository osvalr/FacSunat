
package AccessoDato;

public class EResumenDiario {
    
    private int id;
    private String tipodocumento;
    private String num_serie;
    private int ini_rango;
    private int fin_rango;
    private float vtagravada;
    private float vtaexonerada;
    private float vtainafecta;
    private float igvt;
    private float imptotal;

    public EResumenDiario() {
    }

    public EResumenDiario(int id, String tipodocumento, String num_serie, int ini_rango, int fin_rango, float vtagravada, float vtaexonerada, float vtainafecta, float igvt, float imptotal) {
        this.id = id;
        this.tipodocumento = tipodocumento;
        this.num_serie = num_serie;
        this.ini_rango = ini_rango;
        this.fin_rango = fin_rango;
        this.vtagravada = vtagravada;
        this.vtaexonerada = vtaexonerada;
        this.vtainafecta = vtainafecta;
        this.igvt = igvt;
        this.imptotal = imptotal;
    }

    public float getImptotal() {
        return imptotal;
    }

    public void setImptotal(float imptotal) {
        this.imptotal = imptotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public int getIni_rango() {
        return ini_rango;
    }

    public void setIni_rango(int ini_rango) {
        this.ini_rango = ini_rango;
    }

    public int getFin_rango() {
        return fin_rango;
    }

    public void setFin_rango(int fin_rango) {
        this.fin_rango = fin_rango;
    }

    public float getVtagravada() {
        return vtagravada;
    }

    public void setVtagravada(float vtagravada) {
        this.vtagravada = vtagravada;
    }

    public float getVtaexonerada() {
        return vtaexonerada;
    }

    public void setVtaexonerada(float vtaexonerada) {
        this.vtaexonerada = vtaexonerada;
    }

    public float getVtainafecta() {
        return vtainafecta;
    }

    public void setVtainafecta(float vtainafecta) {
        this.vtainafecta = vtainafecta;
    }

    public float getIgvt() {
        return igvt;
    }

    public void setIgvt(float igvt) {
        this.igvt = igvt;
    }
    
    
}
