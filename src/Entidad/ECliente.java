
package AccessoDato;

public class ECliente {
    
    private Integer cli_ncodigo;
    private String cli_crazon;
    private String cli_cnumerodoc;
    private String cli_cdireccionfiscal;
    private String coi_ccodigo;
    private String doi_cdescripcion;
    private int cli_ncodubigeo;

    public ECliente(Integer cli_ncodigo, String cli_crazon, String cli_cnumerodoc, String cli_cdireccionfiscal, String coi_ccodigo, String doi_cdescripcion) {
        this.cli_ncodigo = cli_ncodigo;
        this.cli_crazon = cli_crazon;
        this.cli_cnumerodoc = cli_cnumerodoc;
        this.cli_cdireccionfiscal = cli_cdireccionfiscal;
        this.coi_ccodigo = coi_ccodigo;
        this.doi_cdescripcion = doi_cdescripcion;
    }

    public ECliente(Integer cli_ncodigo, String cli_crazon, String cli_cnumerodoc, String cli_cdireccionfiscal, String coi_ccodigo,int x_codubigeo) {
        this.cli_ncodigo = cli_ncodigo;
        this.cli_crazon = cli_crazon;
        this.cli_cnumerodoc = cli_cnumerodoc;
        this.cli_cdireccionfiscal = cli_cdireccionfiscal;
        this.coi_ccodigo = coi_ccodigo;
        this.cli_ncodubigeo=x_codubigeo;
    }

    
    public ECliente()
    {}
    

    public String getCli_crazon() {
        return cli_crazon;
    }

    public void setCli_crazon(String cli_crazon) {
        this.cli_crazon = cli_crazon;
    }

    public String getCli_cnumerodoc() {
        return cli_cnumerodoc;
    }

    public void setCli_cnumerodoc(String cli_cnumerodoc) {
        this.cli_cnumerodoc = cli_cnumerodoc;
    }

    public String getCli_cdireccionfiscal() {
        return cli_cdireccionfiscal;
    }

    public void setCli_cdireccionfiscal(String cli_cdireccionfiscal) {
        this.cli_cdireccionfiscal = cli_cdireccionfiscal;
    }

    public String getCoi_ccodigo() {
        return coi_ccodigo;
    }

    public void setCoi_ccodigo(String coi_ccodigo) {
        this.coi_ccodigo = coi_ccodigo;
    }

    public Integer getCli_ncodigo() {
        return cli_ncodigo;
    }

    public void setCli_ncodigo(Integer cli_ncodigo) {
        this.cli_ncodigo = cli_ncodigo;
    }

    public String getDoi_cdescripcion() {
        return doi_cdescripcion;
    }

    public void setDoi_cdescripcion(String doi_cdescripcion) {
        this.doi_cdescripcion = doi_cdescripcion;
    }

    public int getCli_ncodubigeo() {
        return cli_ncodubigeo;
    }

    public void setCli_ncodubigeo(int cli_ncodubigeo) {
        this.cli_ncodubigeo = cli_ncodubigeo;
    }
    
    

}
