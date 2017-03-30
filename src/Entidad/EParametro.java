//////
package AccessoDato;

import Utilidad.InstanciaEntidad;
import java.sql.Date;


public class EParametro {
  private int par_ncodigo; 
  private String par_cmoneda; 
  private int par_nsucursal; 
  private String par_cestado; 
  private String par_cserie; 
  private float par_ntipocambio; 
  private int par_nvendedor; 
  private String par_cnumero;
  private int num_ncodigo;
  private Date par_dfecha;
  private InstanciaEntidad m_instancia;  
  private String suc_calias;
  private String ven_cnombre;
  private String suc_cdireccion;
  private String mon_cdescripcion;
    public EParametro() {
    }

    public EParametro(int par_ncodigo, String par_cmoneda, int par_nsucursal, String par_cestado, String par_cserie, float par_ntipocambio, int par_nvendedor,String par_cnumero,int ncodigo,Date x_fecha) {
        this.par_ncodigo = par_ncodigo;
        this.par_cmoneda = par_cmoneda;
        this.par_nsucursal = par_nsucursal;
        this.par_cestado = par_cestado;
        this.par_cserie = par_cserie;
        this.par_ntipocambio = par_ntipocambio;
        this.par_nvendedor = par_nvendedor;
        this.par_cnumero=par_cnumero;
        this.num_ncodigo=ncodigo;
        this.par_dfecha=x_fecha;
    }
    public EParametro(int par_ncodigo, String par_cmoneda, int par_nsucursal, String par_cestado, float par_ntipocambio, int par_nvendedor,String x_alias,String x_nombre,String x_direccion,String x_monedasimbolo) {
        this.par_ncodigo = par_ncodigo;
        this.par_cmoneda = par_cmoneda;
        this.par_nsucursal = par_nsucursal;
        this.par_cestado = par_cestado;
        this.par_ntipocambio = par_ntipocambio;
        this.par_nvendedor = par_nvendedor;
        this.suc_calias=x_alias;
        this.ven_cnombre=x_nombre;
        this.suc_cdireccion=x_direccion;
        this.mon_cdescripcion=x_monedasimbolo;
    }
    

    public int getPar_ncodigo() {
        return par_ncodigo;
    }

    public void setPar_ncodigo(int par_ncodigo) {
        this.par_ncodigo = par_ncodigo;
    }

    public String getPar_cmoneda() {
        return par_cmoneda;
    }

    public void setPar_cmoneda(String par_cmoneda) {
        this.par_cmoneda = par_cmoneda;
    }

    public int getPar_nsucursal() {
        return par_nsucursal;
    }

    public void setPar_nsucursal(int par_nsucursal) {
        this.par_nsucursal = par_nsucursal;
    }

    public String getPar_cestado() {
        return par_cestado;
    }

    public void setPar_cestado(String par_cestado) {
        this.par_cestado = par_cestado;
    }

    public String getPar_cserie() {
        return par_cserie;
    }

    public void setPar_cserie(String par_cserie) {
        this.par_cserie = par_cserie;
    }

    public float getPar_ntipocambio() {
        return par_ntipocambio;
    }

    public void setPar_ntipocambio(float par_ntipocambio) {
        this.par_ntipocambio = par_ntipocambio;
    }

    public int getPar_nvendedor() {
        return par_nvendedor;
    }

    public void setPar_nvendedor(int par_nvendedor) {
        this.par_nvendedor = par_nvendedor;
    }

    public String getPar_cnumero() {
        return par_cnumero;
    }

    public void setPar_cnumero(String par_cnumero) {
        this.par_cnumero = par_cnumero;
    }

    public int getNum_ncodigo() {
        return num_ncodigo;
    }

    public void setNum_ncodigo(int num_ncodigo) {
        this.num_ncodigo = num_ncodigo;
    }

    public InstanciaEntidad getM_instancia() {
        return m_instancia;
    }

    public void setM_instancia(InstanciaEntidad m_instancia) {
        this.m_instancia = m_instancia;
    }

    public Date getPar_dfecha() {
        return par_dfecha;
    }

    public void setPar_dfecha(Date par_dfecha) {
        this.par_dfecha = par_dfecha;
    }

    public String getSuc_calias() {
        return suc_calias;
    }

    public void setSuc_calias(String suc_calias) {
        this.suc_calias = suc_calias;
    }

    public String getVen_cnombre() {
        return ven_cnombre;
    }

    public void setVen_cnombre(String ven_cnombre) {
        this.ven_cnombre = ven_cnombre;
    }

    public String getSuc_cdireccion() {
        return suc_cdireccion;
    }

    public void setSuc_cdireccion(String suc_cdireccion) {
        this.suc_cdireccion = suc_cdireccion;
    }

    public String getMon_cdescripcion() {
        return mon_cdescripcion;
    }

    public void setMon_cdescripcion(String mon_cdescripcion) {
        this.mon_cdescripcion = mon_cdescripcion;
    }
    
  
}
