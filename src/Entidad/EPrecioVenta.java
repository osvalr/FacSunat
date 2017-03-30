
package AccessoDato;

import Utilidad.InstanciaEntidad;
import java.util.Optional;

public class EPrecioVenta {
    private int pve_ncodigo;
    private int art_ncodigo;
    private float pve_fpreciounitario;
    private float pve_fprecioventa;
    private float pve_figv;    
    private String pve_ctipoprecio;
    private InstanciaEntidad m_instancia;
    private int uni_ccodigo;
    private String pve_cmoneda;
    private String pve_ccodbarra;
    private String uni_cdescripcion;
    private String art_cdescripcion;
    private String art_cafectacion;
    private String art_cafecdescripcion;
    //ADD 18-07-2016
    private int pve_ncantidad;
    private int pve_nporcentajedescuento;
    //ADD 20-07-2016
    private String pve_ctipoafectacion;
    private String art_ccodigoArticulo;
    public EPrecioVenta() {
    }

    public EPrecioVenta(int pve_ncodigo, int art_ncodigo, float pve_fpreciounitario, float pve_fprecioventa, float pve_figv, String pve_ctipoprecio, InstanciaEntidad m_instancia, int uni_ccodigo, String pve_cmoneda, String pve_ccodbarra, String uni_cdescripcion,int cantidadxitem,int nporcentaje,String tipoafecta,String art_cafectacion, String art_cafecdescripcion,String art_cdescripcion,String x_codigoArticulo) {
        this.pve_ncodigo = pve_ncodigo;
        this.art_ncodigo = art_ncodigo;
        this.pve_fpreciounitario = pve_fpreciounitario;
        this.pve_fprecioventa = pve_fprecioventa;
        this.pve_figv = pve_figv;
        this.pve_ctipoprecio = pve_ctipoprecio;
        this.m_instancia = m_instancia;
        this.uni_ccodigo = uni_ccodigo;
        this.pve_cmoneda = pve_cmoneda;
        this.pve_ccodbarra = pve_ccodbarra;
        this.uni_cdescripcion = uni_cdescripcion;
        this.pve_ncantidad=cantidadxitem;
        this.pve_nporcentajedescuento=nporcentaje;
        this.pve_ctipoafectacion=tipoafecta;
       this.art_cafectacion = art_cafectacion;
        this.art_cafecdescripcion = art_cafecdescripcion;
        this.art_cdescripcion = art_cdescripcion;
        this.art_ccodigoArticulo=x_codigoArticulo;
    }

//    public EPrecioVenta(int pve_ncodigo, int art_ncodigo, float pve_fpreciounitario, float pve_fprecioventa, float pve_figv, String pve_ctipoprecio, InstancaEntidad m_instancia, int uni_ccodigo, String pve_cmoneda, String pve_ccodbarra, String uni_cdescripcion, String art_cdescripcion) {
//        this.pve_ncodigo = pve_ncodigo;
//        this.art_ncodigo = art_ncodigo;
//        this.pve_fpreciounitario = pve_fpreciounitario;
//        this.pve_fprecioventa = pve_fprecioventa;
//        this.pve_figv = pve_figv;
//        this.pve_ctipoprecio = pve_ctipoprecio;
//        this.m_instancia = m_instancia;
//        this.uni_ccodigo = uni_ccodigo;
//        this.pve_cmoneda = pve_cmoneda;
//        this.pve_ccodbarra = pve_ccodbarra;
//        this.uni_cdescripcion = uni_cdescripcion;
//        this.art_cdescripcion = art_cdescripcion;
//    }

    
//
//    public EPrecioVenta(int pve_ncodigo, int art_ncodigo, float pve_fpreciounitario, float pve_fprecioventa, float pve_figv, String pve_ctipoprecio, InstancaEntidad m_instancia, int uni_ccodigo, String pve_cmoneda, String pve_ccodbarra, String uni_cdescripcion, String art_cdescripcion, String art_cafectacion, String art_cafecdescripcion) {
//        this.pve_ncodigo = pve_ncodigo;
//        this.art_ncodigo = art_ncodigo;
//        this.pve_fpreciounitario = pve_fpreciounitario;
//        this.pve_fprecioventa = pve_fprecioventa;
//        this.pve_figv = pve_figv;
//        this.pve_ctipoprecio = pve_ctipoprecio;
//        this.m_instancia = m_instancia;
//        this.uni_ccodigo = uni_ccodigo;
//        this.pve_cmoneda = pve_cmoneda;
//        this.pve_ccodbarra = pve_ccodbarra;
//        this.uni_cdescripcion = uni_cdescripcion;
//        this.art_cdescripcion = art_cdescripcion;
//        this.art_cafectacion = art_cafectacion;
//        this.art_cafecdescripcion = art_cafecdescripcion;
//    }

    

    
    
    

    public int getPve_ncodigo() {
        return pve_ncodigo;
    }

    public void setPve_ncodigo(int pve_ncodigo) {
        this.pve_ncodigo = pve_ncodigo;
    }

    public int getArt_ncodigo() {
        return art_ncodigo;
    }

    public void setArt_ncodigo(int art_ncodigo) {
        this.art_ncodigo = art_ncodigo;
    }

    public float getPve_fpreciounitario() {
        return pve_fpreciounitario;
    }

    public void setPve_fpreciounitario(float pve_fpreciounitario) {
        this.pve_fpreciounitario = pve_fpreciounitario;
    }

    public float getPve_fprecioventa() {
        return pve_fprecioventa;
    }

    public void setPve_fprecioventa(float pve_fprecioventa) {
        this.pve_fprecioventa = pve_fprecioventa;
    }

    public float getPve_figv() {
        return pve_figv;
    }

    public void setPve_figv(float pve_figv) {
        this.pve_figv = pve_figv;
    }

    

    public InstanciaEntidad getM_instancia() {
        return m_instancia;
    }

    public void setM_instancia(InstanciaEntidad m_instancia) {
        this.m_instancia = m_instancia;
    }

    public String getPve_ctipoprecio() {
        return pve_ctipoprecio;
    }

    public void setPve_ctipoprecio(String pve_ctipoprecio) {
        this.pve_ctipoprecio = pve_ctipoprecio;
    }

    public int getUni_ccodigo() {
        return uni_ccodigo;
    }

    public void setUni_ccodigo(int uni_ccodigo) {
        this.uni_ccodigo = uni_ccodigo;
    }

    public String getPve_cmoneda() {
        return pve_cmoneda;
    }

    public void setPve_cmoneda(String pve_cmoneda) {
        this.pve_cmoneda = pve_cmoneda;
    }

    public String getUni_cdescripcion() {
        return uni_cdescripcion;
    }

    public void setUni_cdescripcion(String uni_cdescripcion) {
        this.uni_cdescripcion = uni_cdescripcion;
    }

    public String getPve_ccodbarra() {
        return pve_ccodbarra;
    }

    public void setPve_ccodbarra(String pve_ccodbarra) {
        this.pve_ccodbarra = pve_ccodbarra;
    }

    public String getArt_cdescripcion() {
        return art_cdescripcion;
    }

    public void setArt_cdescripcion(String art_cdescripcion) {
        this.art_cdescripcion = art_cdescripcion;
    }

    
    
    public String getArt_cafecdescripcion() {
        return art_cafecdescripcion;
    }

    public void setArt_cafecdescripcion(String art_cafecdescripcion) {
        this.art_cafecdescripcion = art_cafecdescripcion;
    }

    public String getArt_cafectacion() {
        return art_cafectacion;
    }

    public void setArt_cafectacion(String art_cafectacion) {
        this.art_cafectacion = art_cafectacion;
    }

    public int getPve_ncantidad() {
        return pve_ncantidad;
    }

    public void setPve_ncantidad(int pve_ncantidad) {
        this.pve_ncantidad = pve_ncantidad;
    }

    public int getPve_nporcentajedescuento() {
        return pve_nporcentajedescuento;
    }

    public void setPve_nporcentajedescuento(int pve_nporcentajedescuento) {
        this.pve_nporcentajedescuento = pve_nporcentajedescuento;
    }

    public String getPve_ctipoafectacion() {
        return pve_ctipoafectacion;
    }

    public void setPve_ctipoafectacion(String pve_ctipoafectacion) {
        this.pve_ctipoafectacion = pve_ctipoafectacion;
    }

    public String getArt_ccodigoArticulo() {
        return art_ccodigoArticulo;
    }

    public void setArt_ccodigoArticulo(String art_ccodigoArticulo) {
        this.art_ccodigoArticulo = art_ccodigoArticulo;
    }
    
    
    
}
