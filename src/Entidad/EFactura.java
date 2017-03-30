
package AccessoDato;

import java.sql.Date;

public class EFactura {
    private int fac_ncodigo;
    private int cli_ncodigo;
    private int ley_ncodigo;
    //private int emp_ncodigo;
    private Date fac_dfechaemision;
    private String fac_cdescripcion;
    private String fac_cestado;
    private String fac_cclasepago;
    private String fac_cserie;
    private String fac_cnumero;
    private String fac_firmadigital;
    private double fac_fimportesubtotal;
    private double fac_ftotal;
    private double fac_igv;
    private String fac_nnumeroguia;
    private String doc_ccodigo;
    private String mon_ccodigo;
    private int suc_ncodigo;
    private int ve_ncodigo;
    //add 21072016
    private double fac_ftotalisc;
    private double fac_ftotalotrostributos;
    private double fac_ftotalexonerado;
    private double fac_ftotalinafecto;
    
    //add adicional
    private String fac_cnombrecliente;
    private String fac_estadodocumento;
    private String fac_ctipodocumento;
    private String fac_cclasedepagodocumento;
    private String fac_cmondocumento;
    private String fac_cnombrevendedor;
    private String fac_cnumerodocumento;
    private String Rel_codigo;
//    private int pla_nodigo;
    private  int dir_ncodigo;
    private  int pla_ncodigo;
    //fecha:2016-12-28
    //autor:yasmani
    //descripcion:seagrego un atributo para usar en la descripcion de documentos de baja.
    private String desAlternativo;
    public EFactura() {
    }

    public EFactura(int fac_ncodigo, int cli_ncodigo, int ley_ncodigo, Date fac_dfechaemision, String x_descripcionfact, String fac_cestado, String fac_cclasepago, String fac_cserie, String fac_cnumero, String fac_firmadigital, double fac_fimportesubtotal, double fac_ftotal, double fac_igv, String fac_nnumeroguia, String doc_ccodigo, String mon_ccodigo, int suc_ncodigo, int ve_ncodigo,double impuestoisc,double impuestootros,double totalexonerado,double totalinafecto) {
        this.fac_ncodigo = fac_ncodigo;
        this.cli_ncodigo = cli_ncodigo;
        this.ley_ncodigo = ley_ncodigo;
        this.fac_dfechaemision = fac_dfechaemision;
        this.fac_cdescripcion=x_descripcionfact;
        this.fac_cestado = fac_cestado;
        this.fac_cclasepago = fac_cclasepago;
        this.fac_cserie = fac_cserie;
        this.fac_cnumero = fac_cnumero;
        this.fac_firmadigital = fac_firmadigital;
        this.fac_fimportesubtotal = fac_fimportesubtotal;
        this.fac_ftotal = fac_ftotal;
        this.fac_igv = fac_igv;
        this.fac_nnumeroguia = fac_nnumeroguia;
        this.doc_ccodigo = doc_ccodigo;
        this.mon_ccodigo = mon_ccodigo;
        this.suc_ncodigo = suc_ncodigo;
        this.ve_ncodigo = ve_ncodigo;
        this.fac_ftotalisc=impuestoisc;
        this.fac_ftotalotrostributos=impuestootros;
        this.fac_ftotalexonerado=totalexonerado;
        this.fac_ftotalinafecto=totalinafecto;
    }
    
    public EFactura(int x_fac_ncodigo,String x_fac_dfechaemision,String x_seriefac,String x_numerofac,String x_fac_tipodocumento,String x_estadodocumento,String x_fac_estadopago,String x_mon_cdescripcion,String x_clirazonsocial,double x_facsubtotal,double x_total,double x_exonerado,double x_inafecto,String x_facvendedor,int x_clincodigo,int x_leyncodigo,String x_facclasepago,String x_docccodigo,String x_monncodigo,int x_venncodigo,int x_sucursalcodigo,String x_estado,String x_descripcion,double x_igv)//---------------------------------------------Solo se usa para cargar la vista de busqueda 
    {
        this.fac_ncodigo=x_fac_ncodigo;
        this.fac_dfechaemision=Date.valueOf(x_fac_dfechaemision);
        this.fac_ctipodocumento=x_fac_tipodocumento;
        this.fac_estadodocumento=x_estadodocumento;
        this.fac_cclasedepagodocumento=x_fac_estadopago;
        this.fac_cmondocumento=x_mon_cdescripcion;
        this.fac_cnombrecliente =x_clirazonsocial;
        this.fac_fimportesubtotal=x_facsubtotal;
        this.fac_ftotal=x_total;
        this.fac_ftotalexonerado=x_exonerado;
        this.fac_ftotalinafecto=x_inafecto;
        this.fac_cnombrevendedor=x_facvendedor;
        this.cli_ncodigo=x_clincodigo;
        this.ley_ncodigo=x_leyncodigo;
        this.fac_cclasepago=x_facclasepago;
        this.doc_ccodigo=x_docccodigo;
        this.mon_ccodigo=x_monncodigo;
        this.ve_ncodigo=x_venncodigo;
        this.fac_cserie=x_seriefac;
        this.fac_cnumero=x_numerofac;
        this.suc_ncodigo=x_sucursalcodigo;
        this.fac_cestado=x_estado;
        this.fac_cdescripcion=x_descripcion;
        this.fac_igv=x_igv;
    }

    public int getFac_ncodigo() {
        return fac_ncodigo;
    }

    public void setFac_ncodigo(int fac_ncodigo) {
        this.fac_ncodigo = fac_ncodigo;
    }

    public int getCli_ncodigo() {
        return cli_ncodigo;
    }

    public void setCli_ncodigo(int cli_ncodigo) {
        this.cli_ncodigo = cli_ncodigo;
    }

    public int getLey_ncodigo() {
        return ley_ncodigo;
    }

    public void setLey_ncodigo(int ley_ncodigo) {
        this.ley_ncodigo = ley_ncodigo;
    }


    public Date getFac_dfechaemision() {
        return fac_dfechaemision;
    }

    public void setFac_dfechaemision(Date fac_dfechaemision) {
        this.fac_dfechaemision = fac_dfechaemision;
    }

    public String getFac_cdescripcion() {
        return fac_cdescripcion;
    }

    public void setFac_cdescripcion(String fac_cdescripcion) {
        this.fac_cdescripcion = fac_cdescripcion;
    }

    public String getFac_cestado() {
        return fac_cestado;
    }

    public void setFac_cestado(String fac_cestado) {
        this.fac_cestado = fac_cestado;
    }

    public String getFac_cclasepago() {
        return fac_cclasepago;
    }

    public void setFac_cclasepago(String fac_cclasepago) {
        this.fac_cclasepago = fac_cclasepago;
    }

    public String getFac_cserie() {
        return fac_cserie;
    }

    public void setFac_cserie(String fac_cserie) {
        this.fac_cserie = fac_cserie;
    }

    public String getFac_cnumero() {
        return fac_cnumero;
    }

    public void setFac_cnumero(String fac_cnumero) {
        this.fac_cnumero = fac_cnumero;
    }

    public String getFac_firmadigital() {
        return fac_firmadigital;
    }

    public void setFac_firmadigital(String fac_firmadigital) {
        this.fac_firmadigital = fac_firmadigital;
    }

    public double getFac_fimportesubtotal() {
        return fac_fimportesubtotal;
    }

    public void setFac_fimportesubtotal(double fac_fimportesubtotal) {
        this.fac_fimportesubtotal = fac_fimportesubtotal;
    }

    public double getFac_ftotal() {
        return fac_ftotal;
    }

    public void setFac_ftotal(double fac_ftotal) {
        this.fac_ftotal = fac_ftotal;
    }

    public double getFac_igv() {
        return fac_igv;
    }

    public void setFac_igv(double fac_igv) {
        this.fac_igv = fac_igv;
    }

    public String getFac_nnumeroguia() {
        return fac_nnumeroguia;
    }

    public void setFac_nnumeroguia(String fac_nnumeroguia) {
        this.fac_nnumeroguia = fac_nnumeroguia;
    }

    public String getDoc_ccodigo() {
        return doc_ccodigo;
    }

    public void setDoc_ccodigo(String doc_ccodigo) {
        this.doc_ccodigo = doc_ccodigo;
    }

    public String getMon_ccodigo() {
        return mon_ccodigo;
    }

    public void setMon_ccodigo(String mon_ccodigo) {
        this.mon_ccodigo = mon_ccodigo;
    }

    public int getSuc_ncodigo() {
        return suc_ncodigo;
    }

    public void setSuc_ncodigo(int suc_ncodigo) {
        this.suc_ncodigo = suc_ncodigo;
    }

    public int getVe_ncodigo() {
        return ve_ncodigo;
    }

    public void setVe_ncodigo(int ve_ncodigo) {
        this.ve_ncodigo = ve_ncodigo;
    }

    public double getFac_ftotalisc() {
        return fac_ftotalisc;
    }

    public void setFac_ftotalisc(double fac_ftotalisc) {
        this.fac_ftotalisc = fac_ftotalisc;
    }

    public double getFac_ftotalotrostributos() {
        return fac_ftotalotrostributos;
    }

    public void setFac_ftotalotrostributos(double fac_ftotalotrostributos) {
        this.fac_ftotalotrostributos = fac_ftotalotrostributos;
    }

    public double getFac_ftotalexonerado() {
        return fac_ftotalexonerado;
    }

    public void setFac_ftotalexonerado(double fac_ftotalexonerado) {
        this.fac_ftotalexonerado = fac_ftotalexonerado;
    }

    public double getFac_ftotalinafecto() {
        return fac_ftotalinafecto;
    }

    public void setFac_ftotalinafecto(double fac_ftotalinafecto) {
        this.fac_ftotalinafecto = fac_ftotalinafecto;
    }

    public String getFac_cnombrecliente() {
        return fac_cnombrecliente;
    }

    public void setFac_cnombrecliente(String fac_cnombrecliente) {
        this.fac_cnombrecliente = fac_cnombrecliente;
    }

    public String getFac_estado() {
        return fac_estadodocumento;
    }

    public void setFac_estado(String fac_estado) {
        this.fac_estadodocumento = fac_estado;
    }

    public String getFac_ctipodocumento() {
        return fac_ctipodocumento;
    }

    public void setFac_ctipodocumento(String fac_ctipodocumento) {
        this.fac_ctipodocumento = fac_ctipodocumento;
    }

    public String getFac_cclasedepagodocumento() {
        return fac_cclasedepagodocumento;
    }

    public void setFac_cclasedepagodocumento(String fac_cclasedepagodocumento) {
        this.fac_cclasedepagodocumento = fac_cclasedepagodocumento;
    }

    public String getFac_cmondocumento() {
        return fac_cmondocumento;
    }

    public void setFac_cmondocumento(String fac_cmondocumento) {
        this.fac_cmondocumento = fac_cmondocumento;
    }

    public String getFac_nombrevendedor() {
        return fac_cnombrevendedor;
    }

    public void setFac_nombrevendedor(String fac_nombrevendedor) {
        this.fac_cnombrevendedor = fac_nombrevendedor;
    }

    public String getFac_numerodocumento() {
        return fac_cnumerodocumento;
    }

    public void setFac_numerodocumento(String fac_numerodocumento) {
        this.fac_cnumerodocumento = fac_numerodocumento;
    }

    public String getFac_estadodocumento() {
        return fac_estadodocumento;
    }

    public void setFac_estadodocumento(String fac_estadodocumento) {
        this.fac_estadodocumento = fac_estadodocumento;
    }

    public String getRel_codigo() {
        return Rel_codigo;
    }

    public void setRel_codigo(String Rel_codigo) {
        this.Rel_codigo = Rel_codigo;
    }

//    public int getPla_nodigo() {
//        return pla_nodigo;
//    }
//
//    public void setPla_nodigo(int pla_nodigo) {
//        this.pla_nodigo = pla_nodigo;
//    }

    public int getDir_ncodigo() {
        return dir_ncodigo;
    }

    public void setDir_ncodigo(int dir_ncodigo) {
        this.dir_ncodigo = dir_ncodigo;
    }

    public int getPla_ncodigo() {
        return pla_ncodigo;
    }

    public void setPla_ncodigo(int pla_ncodigo) {
        this.pla_ncodigo = pla_ncodigo;
    }

    public String getDesAlternativo() {
        return desAlternativo;
    }

    public void setDesAlternativo(String desAlternativo) {
        this.desAlternativo = desAlternativo;
    }
    
            
}
