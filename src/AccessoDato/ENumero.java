
package AccessoDato;

import Utilidad.InstancaEntidad;

public class ENumero {
    private int num_ncodigo;
    private String num_cserie;
    private String num_cnumero;
    private int suc_ncodigo;
    private String doc_ccodigo;
    private int par_ncodigo;
    private String doc_cdescripcion;
    private String suc_calias;
    private InstancaEntidad m_instancia;        
    public ENumero() {
    }

    public ENumero(int num_ncodigo, String num_cserie, String num_cnumero, int suc_ncodigo, String doc_ccodigo, int par_ncodigo,String x_docuemntodescripcion,String x_sucalias,InstancaEntidad x_instancia) {
        this.num_ncodigo = num_ncodigo;
        this.num_cserie = num_cserie;
        this.num_cnumero = num_cnumero;
        this.suc_ncodigo = suc_ncodigo;
        this.doc_ccodigo = doc_ccodigo;
        this.par_ncodigo = par_ncodigo;
        this.doc_cdescripcion=x_docuemntodescripcion;
        this.suc_calias=x_sucalias;
        m_instancia=x_instancia;
    }

    public int getNum_ncodigo() {
        return num_ncodigo;
    }

    public void setNum_ncodigo(int num_ncodigo) {
        this.num_ncodigo = num_ncodigo;
    }

    public String getNum_cserie() {
        return num_cserie;
    }

    public void setNum_cserie(String num_cserie) {
        this.num_cserie = num_cserie;
    }

    public String getNum_cnumero() {
        return num_cnumero;
    }

    public void setNum_cnumero(String num_cnumero) {
        this.num_cnumero = num_cnumero;
    }

    public int getSuc_ncodigo() {
        return suc_ncodigo;
    }

    public void setSuc_ncodigo(int suc_ncodigo) {
        this.suc_ncodigo = suc_ncodigo;
    }

    public String getDoc_ccodigo() {
        return doc_ccodigo;
    }

    public void setDoc_ccodigo(String doc_ccodigo) {
        this.doc_ccodigo = doc_ccodigo;
    }

    public int getPar_ncodigo() {
        return par_ncodigo;
    }

    public void setPar_ncodigo(int par_ncodigo) {
        this.par_ncodigo = par_ncodigo;
    }

    public String getDoc_cdescripcion() {
        return doc_cdescripcion;
    }

    public void setDoc_cdescripcion(String doc_cdescripcion) {
        this.doc_cdescripcion = doc_cdescripcion;
    }

    public String getSuc_calias() {
        return suc_calias;
    }

    public void setSuc_calias(String suc_calias) {
        this.suc_calias = suc_calias;
    }

    public InstancaEntidad getM_instancia() {
        return m_instancia;
    }

    public void setM_instancia(InstancaEntidad m_instancia) {
        this.m_instancia = m_instancia;
    }
    
    
  
}
