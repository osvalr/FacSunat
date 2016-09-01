
package AccessoDato;

import Utilidad.InstancaEntidad;

public class EVendedor {
    private int ven_ncodigo;
    private String ven_nombres;
    private String ven_cpaterno;
    private String ven_materno;
    private String doc_ccodigo; 
    private String doi_cdescripcion;
    private InstancaEntidad m_instanciaentidad;
    private String ven_cnumero;
    public EVendedor()
    {}
    public EVendedor(int ven_ncodigo, String ven_nombres, String ven_cpaterno, String ven_materno, String doi_ccodigo, String x_numero,String doi_cdescripcion,InstancaEntidad x_instancia) {
        this.ven_ncodigo = ven_ncodigo;
        this.ven_nombres = ven_nombres;
        this.ven_cpaterno = ven_cpaterno;
        this.ven_materno = ven_materno;
        this.doc_ccodigo = doi_ccodigo;
        this.ven_cnumero=x_numero;
        this.doi_cdescripcion = doi_cdescripcion;        
        this.m_instanciaentidad=x_instancia;
    }
//    public EVendedor(int ven_ncodigo, String ven_nombres, String ven_cpaterno, String ven_materno, String doi_ccodigo) {
//        this.ven_ncodigo = ven_ncodigo;
//        this.ven_nombres = ven_nombres;
//        this.ven_cpaterno = ven_cpaterno;
//        this.ven_materno = ven_materno;
//        this.doc_ccodigo = doi_ccodigo;
//    }
    
    public int getVen_ncodigo() {
        return ven_ncodigo;
    }

    public void setVen_ncodigo(int ven_ncodigo) {
        this.ven_ncodigo = ven_ncodigo;
    }

    public String getVen_nombres() {
        return ven_nombres;
    }

    public void setVen_nombres(String ven_nombres) {
        this.ven_nombres = ven_nombres;
    }

    public String getVen_cpaterno() {
        return ven_cpaterno;
    }

    public void setVen_cpaterno(String ven_cpaterno) {
        this.ven_cpaterno = ven_cpaterno;
    }

    public String getVen_materno() {
        return ven_materno;
    }

    public void setVen_materno(String ven_materno) {
        this.ven_materno = ven_materno;
    }

    public String getDoi_ccodigo() {
        return doc_ccodigo;
    }

    public void setDoi_ccodigo(String doi_ccodigo) {
        this.doc_ccodigo = doi_ccodigo;
    }

    public String getDoi_cdescripcion() {
        return doi_cdescripcion;
    }

    public void setDoi_cdescripcion(String doi_cdescripcion) {
        this.doi_cdescripcion = doi_cdescripcion;
    }

    public InstancaEntidad getM_instanciaentidad() {
        return m_instanciaentidad;
    }

    public void setM_instanciaentidad(InstancaEntidad m_instanciaentidad) {
        this.m_instanciaentidad = m_instanciaentidad;
    }

    public String getVen_cnumero() {
        return ven_cnumero;
    }

    public void setVen_cnumero(String ven_cnumero) {
        this.ven_cnumero = ven_cnumero;
    }
    
}
