
package AccessoDato;

import Utilidad.InstancaEntidad;
import Utilidad.InstanciaForm;

public class EFacturaDetalle {
  private int dfa_ncodigo;
  private int fac_ncodigo;
  private int art_ncodigo; 
  private int dfa_ccantidad;
  private double dfa_fvalorunitario;
  private double dfa_fvalortotal; 
  private double dfa_fvaloritemigv; 
  private double dfa_foexonerada; 
  private double dfa_fogravada; 
  private double dfa_foinafecta; 
  private InstancaEntidad m_instancia;
  private String art_cafectacion;
  private String dfa_cnumeroitem;
  private String art_cdescripcion;
  private String art_ncodarticulo;
  //add 21-07-2016
  private int pve_ctipoafectacion;
  private double dfa_fdescuento;
  private double dfa_fvalorsubtotal;
  private double dfa_fvalorventa;
  //add 04-08-2016
  //private String art_cdescripcion;
  private String categoria;
  private String afe_cdescripcion;
  private int uni_ncodigo;
  private String uni_cdescripcion;
  private String dfa_cDescripcionDetalleiIem;
  
    public EFacturaDetalle() {
    }

    public EFacturaDetalle(int dfa_ncodigo, int fac_ncodigo, int art_ncodigo, int dfa_ccantidad, double dfa_fvalorunitario, double dfa_fvalortotal, double dfa_fvaloritemigv, double dfa_foexonerada, double dfa_fogravada, double dfa_foinafecta, String art_cafectacion,double descuento,double subtotal,double valorventa,int x_pvectipoafectacion,String x_artdescripcion,String x_categoria,String x_afecdescripcion,int x_unincodigo,String x_unidescripcion,InstancaEntidad x_instancia) {
        this.dfa_ncodigo = dfa_ncodigo;
        this.fac_ncodigo = fac_ncodigo;
        this.art_ncodigo = art_ncodigo;
        this.dfa_ccantidad = dfa_ccantidad;
        this.dfa_fvalorunitario = dfa_fvalorunitario;
        this.dfa_fvalortotal = dfa_fvalortotal;
        this.dfa_fvaloritemigv = dfa_fvaloritemigv;
        this.dfa_foexonerada = dfa_foexonerada;
        this.dfa_fogravada = dfa_fogravada;
        this.dfa_foinafecta = dfa_foinafecta;
        this.art_cafectacion = art_cafectacion;
        this.dfa_fdescuento=descuento;
        this.dfa_fvalorsubtotal=subtotal;
        this.dfa_fvalorventa=valorventa;
        this.art_cdescripcion= x_artdescripcion;
        this.pve_ctipoafectacion= x_pvectipoafectacion;
        this.categoria=x_categoria;
        this.afe_cdescripcion=x_afecdescripcion;
        this.uni_ncodigo=x_unincodigo;
        this.uni_cdescripcion=x_unidescripcion;
        this.m_instancia=x_instancia;
    }
    public int getDfa_ncodigo() {
        return dfa_ncodigo;
    }
    public void setDfa_ncodigo(int dfa_ncodigo) {
        this.dfa_ncodigo = dfa_ncodigo;
    }
    public int getFac_ncodigo() {
        return fac_ncodigo;
    }
    public void setFac_ncodigo(int fac_ncodigo) {
        this.fac_ncodigo = fac_ncodigo;
    }
    public int getArt_ncodigo() {
        return art_ncodigo;
    }
    public void setArt_ncodigo(int art_ncodigo) {
        this.art_ncodigo = art_ncodigo;
    }
    public int getDfa_ccantidad() {
        return dfa_ccantidad;
    }
    public void setDfa_ccantidad(int dfa_ccantidad) {
        this.dfa_ccantidad = dfa_ccantidad;
    }
    public double getDfa_fvalorunitario() {
        return dfa_fvalorunitario;
    }
    public void setDfa_fvalorunitario(double dfa_fvalorunitario) {
        this.dfa_fvalorunitario = dfa_fvalorunitario;
    }
    public double getDfa_fvalortotal() {
        return dfa_fvalortotal;
    }
    public void setDfa_fvalortotal(double dfa_fvalortotal) {
        this.dfa_fvalortotal = dfa_fvalortotal;
    }
    public double getDfa_fvaloritemigv() {
        return dfa_fvaloritemigv;
    }
    public void setDfa_fvaloritemigv(double dfa_fvaloritemigv) {
        this.dfa_fvaloritemigv = dfa_fvaloritemigv;
    }
    public double getDfa_foexonerada() {
        return dfa_foexonerada;
    }
    public void setDfa_foexonerada(double dfa_foexonerada) {
        this.dfa_foexonerada = dfa_foexonerada;
    }
    public double getDfa_fogravada() {
        return dfa_fogravada;
    }
    public void setDfa_fogravada(double dfa_fogravada) {
        this.dfa_fogravada = dfa_fogravada;
    }
    public double getDfa_foinafecta() {
        return dfa_foinafecta;
    }
    public void setDfa_foinafecta(double dfa_foinafecta) {
        this.dfa_foinafecta = dfa_foinafecta;
    }
    public InstancaEntidad getM_instancia() {
        return m_instancia;
    }
    public void setM_instancia(InstancaEntidad m_instancia) {
        this.m_instancia = m_instancia;
    }
    public String getArt_cafectacion() {
        return art_cafectacion;
    }
    public void setArt_cafectacion(String art_cafectacion) {
        this.art_cafectacion = art_cafectacion;
    }
    public String getDfa_cnumeroitem() {
        return dfa_cnumeroitem;
    }
    public void setDfa_cnumeroitem(String dfa_cnumeroitem) {
        this.dfa_cnumeroitem = dfa_cnumeroitem;
    }
    public String getArt_cdescripcion() {
        return art_cdescripcion;
    }
    public void setArt_cdescripcion(String art_cdescripcion) {
        this.art_cdescripcion = art_cdescripcion;
    }
    public String getArt_ncodarticulo() {
        return art_ncodarticulo;
    }
    public void setArt_ncodarticulo(String art_ncodarticulo) {
        this.art_ncodarticulo = art_ncodarticulo;
    }
    public int getPve_ctipoafectacion() {
        return pve_ctipoafectacion;
    }
    public void setPve_ctipoafectacion(int pve_ctipoafectacion) {
        this.pve_ctipoafectacion = pve_ctipoafectacion;
    }
    public double getDfa_fdescuento() {
        return dfa_fdescuento;
    }
    public void setDfa_fdescuento(double dfa_fdescuento) {
        this.dfa_fdescuento = dfa_fdescuento;
    }
    public double getDfa_fvalorsubtotal() {
        return dfa_fvalorsubtotal;
    }
    public void setDfa_fvalorsubtotal(double dfa_fvalorsubtotal) {
        this.dfa_fvalorsubtotal = dfa_fvalorsubtotal;
    }
    public double getDfa_fvalorventa() {
        return dfa_fvalorventa;
    }
    public void setDfa_fvalorventa(double dfa_fvalorventa) {
        this.dfa_fvalorventa = dfa_fvalorventa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAfe_cdescripcion() {
        return afe_cdescripcion;
    }

    public void setAfe_cdescripcion(String afe_cdescripcion) {
        this.afe_cdescripcion = afe_cdescripcion;
    }

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

    public String getDfa_cDescripcionDetalleItem() {
        return dfa_cDescripcionDetalleiIem;
    }

    public void setDfa_cDescripcionDetalleItem(String dfa_cDescripcionDetalle) {
        this.dfa_cDescripcionDetalleiIem = dfa_cDescripcionDetalle;
    }

    
}
