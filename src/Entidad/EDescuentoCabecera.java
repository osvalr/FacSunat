
package AccessoDato;

import Utilidad.InstanciaEntidad;

public class EDescuentoCabecera {
    private int cds_ncodigo;
    private String cds_cnombre;
    private InstanciaEntidad m_instancia;
    private int suc_ncodigo;
    private String suc_calias;
    private String suc_cdireccion;
    public EDescuentoCabecera() {
    }

    public EDescuentoCabecera(int cds_ncodigo, String cds_cnombre,int sucncodigo,String x_alias,String x_direccion,InstanciaEntidad x_instancia) {
        this.cds_ncodigo = cds_ncodigo;
        this.cds_cnombre = cds_cnombre;
        this.suc_ncodigo=sucncodigo;
        this.suc_calias=x_alias;
        this.suc_cdireccion=x_direccion;
        this.m_instancia=x_instancia;
    }

    public int getCds_ncodigo() {
        return cds_ncodigo;
    }

    public void setCds_ncodigo(int cds_ncodigo) {
        this.cds_ncodigo = cds_ncodigo;
    }

    public String getCds_cnombre() {
        return cds_cnombre;
    }

    public void setCds_cnombre(String cds_cnombre) {
        this.cds_cnombre = cds_cnombre;
    }

    public InstanciaEntidad getM_instancia() {
        return m_instancia;
    }

    public void setM_instancia(InstanciaEntidad m_instancia) {
        this.m_instancia = m_instancia;
    }

    public int getSuc_ncodigo() {
        return suc_ncodigo;
    }

    public void setSuc_ncodigo(int suc_ncodigo) {
        this.suc_ncodigo = suc_ncodigo;
    }

    public String getSuc_calias() {
        return suc_calias;
    }

    public void setSuc_calias(String suc_calias) {
        this.suc_calias = suc_calias;
    }

    public String getSuc_cdireccion() {
        return suc_cdireccion;
    }

    public void setSuc_cdireccion(String suc_cdireccion) {
        this.suc_cdireccion = suc_cdireccion;
    }
    
    
}
