
package AccessoDato;

import Utilidad.InstancaEntidad;

public class ESucursal {
    
      private int suc_ncodigo; 
      private String suc_cdireccion; 
      private int pai_ncodigo; 
      private int emp_ncodigo;
      private int ubi_ncodigo; 
      private String suc_sucdescripcion;//-------------------alias sucurxal
      private String suc_coddepa;
      private String suc_codprov;
      private String suc_coddistri;
      private String suc_codpais;
      private String suc_cpais;
      private String suc_cdepartamento;
      private String suc_cprovincia;
      private String suc_cdistrito;
      
      private InstancaEntidad m_instancia;

    public ESucursal() {
    }
      
        
     public ESucursal(int suc_ncodigo, String suc_cdireccion, int pai_ncodigo, int emp_ncodigo, int ubi_ncodigo,String suc_cdescripcion,String x_departamento,String x_provincia,String x_distrito,String x_coddistrito,String x_coddepa,String x_codpro,String x_paisnombre,InstancaEntidad x_instancia) {
        this.suc_ncodigo = suc_ncodigo;
        this.suc_cdireccion = suc_cdireccion;
        this.pai_ncodigo = pai_ncodigo;
        this.emp_ncodigo = emp_ncodigo;
        this.ubi_ncodigo = ubi_ncodigo;
        this.suc_sucdescripcion=suc_cdescripcion;
        this.suc_cdepartamento=x_departamento;
        this.suc_cprovincia=x_provincia;
        this.suc_cdistrito=x_distrito;
        this.suc_coddepa=x_coddepa;
        this.suc_codprov=x_codpro;
        this.suc_coddistri=x_coddistrito;
        this.suc_cpais=x_paisnombre;
        this.m_instancia=x_instancia;
    }

    public int getSuc_ncodigo() {
        return suc_ncodigo;
    }

    public void setSuc_ncodigo(int suc_ncodigo) {
        this.suc_ncodigo = suc_ncodigo;
    }

    public String getSuc_cdireccion() {
        return suc_cdireccion;
    }

    public void setSuc_cdireccion(String suc_cdireccion) {
        this.suc_cdireccion = suc_cdireccion;
    }

    public int getPai_ncodigo() {
        return pai_ncodigo;
    }

    public void setPai_ncodigo(int pai_ncodigo) {
        this.pai_ncodigo = pai_ncodigo;
    }

    public int getEmp_ncodigo() {
        return emp_ncodigo;
    }

    public void setEmp_ncodigo(int emp_ncodigo) {
        this.emp_ncodigo = emp_ncodigo;
    }

    public int getUbi_ncodigo() {
        return ubi_ncodigo;
    }

    public void setUbi_ncodigo(int ubi_ncodigo) {
        this.ubi_ncodigo = ubi_ncodigo;
    }

    public String getSuc_sucdescripcion() {
        return suc_sucdescripcion;
    }

    public void setSuc_sucdescripcion(String suc_sucdescripcion) {
        this.suc_sucdescripcion = suc_sucdescripcion;
    }

    public String getSuc_coddepa() {
        return suc_coddepa;
    }

    public void setSuc_coddepa(String suc_coddepa) {
        this.suc_coddepa = suc_coddepa;
    }

    public String getSuc_codprov() {
        return suc_codprov;
    }

    public void setSuc_codprov(String suc_codprov) {
        this.suc_codprov = suc_codprov;
    }

    public String getSuc_coddistri() {
        return suc_coddistri;
    }

    public void setSuc_coddistri(String suc_coddistri) {
        this.suc_coddistri = suc_coddistri;
    }

    public String getSuc_codpais() {
        return suc_codpais;
    }

    public void setSuc_codpais(String suc_codpais) {
        this.suc_codpais = suc_codpais;
    }

    public String getSuc_cpais() {
        return suc_cpais;
    }

    public void setSuc_cpais(String suc_cpais) {
        this.suc_cpais = suc_cpais;
    }

    public String getSuc_cdepartamento() {
        return suc_cdepartamento;
    }

    public void setSuc_cdepartamento(String suc_cdepartamento) {
        this.suc_cdepartamento = suc_cdepartamento;
    }

    public String getSuc_cprovincia() {
        return suc_cprovincia;
    }

    public void setSuc_cprovincia(String suc_cprovincia) {
        this.suc_cprovincia = suc_cprovincia;
    }

    public String getSuc_cdistrito() {
        return suc_cdistrito;
    }

    public void setSuc_cdistrito(String suc_cdistrito) {
        this.suc_cdistrito = suc_cdistrito;
    }

    public InstancaEntidad getM_instancia() {
        return m_instancia;
    }

    public void setM_instancia(InstancaEntidad m_instancia) {
        this.m_instancia = m_instancia;
    }

      
      
      
}
