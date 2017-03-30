
package AccessoDato;

import Utilidad.InstanciaEntidad;

public class EDescuentoFactura {
    private int suc_ncodigo; 
    private int dsa_ncodigo; 
    private double dsa_fporcentaje;
    private double dsa_flimite;
    private String doc_ncodigo;
    private String doc_cdescripcion;
    private String suc_cdescripcion;
    private InstanciaEntidad m_instancia;
    private int cds_ncodigo;
    public EDescuentoFactura() {
    }

    public EDescuentoFactura(int x_dsa_ncodigo,double x_fporcentaje,double x_limite,String x_docncodigo,int x_cdsncodigo,String x_doccdescripcion,InstanciaEntidad x_instancia)
    {
        this.dsa_ncodigo=x_dsa_ncodigo;
        this.dsa_fporcentaje=x_fporcentaje;
        this.dsa_flimite=x_limite;
        this.doc_ncodigo=x_docncodigo;
        this.cds_ncodigo=x_cdsncodigo;
        this.doc_cdescripcion=x_doccdescripcion;
        this.m_instancia=x_instancia;
    }
//    public EDescuentoFactura(int suc_ncodigo, int dsa_ncodigo, double dsa_fporcentaje, double dsa_flimite,String doc_codigo,String documentodescripcion,String sucursaldescripcion,InstancaEntidad x_instancia,int x_cds_ncodigo) {
//        this.suc_ncodigo = suc_ncodigo;
//        this.dsa_ncodigo = dsa_ncodigo;
//        this.dsa_fporcentaje = dsa_fporcentaje;
//        this.dsa_flimite = dsa_flimite;
//        this.doc_ncodigo=doc_codigo;
//        this.doc_cdescripcion=documentodescripcion;
//        this.suc_cdescripcion=sucursaldescripcion;
//        this.m_instancia=x_instancia;
//        this.cds_ncodigo=x_cds_ncodigo;
//    }

    public int getSuc_ncodigo() {
        return suc_ncodigo;
    }

    public void setSuc_ncodigo(int suc_ncodigo) {
        this.suc_ncodigo = suc_ncodigo;
    }

    public int getDsa_ncodigo() {
        return dsa_ncodigo;
    }

    public void setDsa_ncodigo(int dsa_ncodigo) {
        this.dsa_ncodigo = dsa_ncodigo;
    }

    public double getDsa_fporcentaje() {
        return dsa_fporcentaje;
    }

    public void setDsa_fporcentaje(double dsa_fporcentaje) {
        this.dsa_fporcentaje = dsa_fporcentaje;
    }

    public double getDsa_flimite() {
        return dsa_flimite;
    }

    public void setDsa_flimite(double dsa_flimite) {
        this.dsa_flimite = dsa_flimite;
    }

    public String getDoc_ncodigo() {
        return doc_ncodigo;
    }

    public void setDoc_ncodigo(String doc_ncodigo) {
        this.doc_ncodigo = doc_ncodigo;
    }

    public InstanciaEntidad getM_instancia() {
        return m_instancia;
    }

    public void setM_instancia(InstanciaEntidad m_instancia) {
        this.m_instancia = m_instancia;
    }

    public String getDoc_cdescripcion() {
        return doc_cdescripcion;
    }

    public void setDoc_cdescripcion(String doc_cdescripcion) {
        this.doc_cdescripcion = doc_cdescripcion;
    }

    public String getSuc_cdescripcion() {
        return suc_cdescripcion;
    }

    public void setSuc_cdescripcion(String suc_cdescripcion) {
        this.suc_cdescripcion = suc_cdescripcion;
    }

    public int getCds_ncodigo() {
        return cds_ncodigo;
    }

    public void setCds_ncodigo(int cds_ncodigo) {
        this.cds_ncodigo = cds_ncodigo;
    }
    
    
}
