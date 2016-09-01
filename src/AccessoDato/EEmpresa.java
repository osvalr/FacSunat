
package AccessoDato;

public class EEmpresa {
    private int emp_ncodigo;
    private String emp_cruc;
    private String emp_cnombre; 
    private String doi_ccodigo;
    private String emp_cclave;
    private String emp_cusuario;
    //19-07-2016
    private String direccionsucursal;
    private String departamento;
    private String provincia;
    private String distrito;
    private String codigoubigeo;
    
    public EEmpresa() {
    }

    public EEmpresa(int emp_ncodigo, String emp_cruc, String emp_cnombre, String doi_ccodigo, String emp_cclave, String emp_cusuario, String direccionsucursal, String departamento, String provincia, String distrito, String codigoubigeo) {
        this.emp_ncodigo = emp_ncodigo;
        this.emp_cruc = emp_cruc;
        this.emp_cnombre = emp_cnombre;
        this.doi_ccodigo = doi_ccodigo;
        this.emp_cclave = emp_cclave;
        this.emp_cusuario = emp_cusuario;
        this.direccionsucursal = direccionsucursal;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.codigoubigeo = codigoubigeo;
    }

   

    public int getEmp_ncodigo() {
        return emp_ncodigo;
    }

    public void setEmp_ncodigo(int emp_ncodigo) {
        this.emp_ncodigo = emp_ncodigo;
    }

    public String getEmp_cruc() {
        return emp_cruc;
    }

    public void setEmp_cruc(String emp_cruc) {
        this.emp_cruc = emp_cruc;
    }

    public String getEmp_cnombre() {
        return emp_cnombre;
    }

    public void setEmp_cnombre(String emp_cnombre) {
        this.emp_cnombre = emp_cnombre;
    }

    public String getDoi_ccodigo() {
        return doi_ccodigo;
    }

    public void setDoi_ccodigo(String doi_ccodigo) {
        this.doi_ccodigo = doi_ccodigo;
    }

    public String getEmp_cclave() {
        return emp_cclave;
    }

    public void setEmp_cclave(String emp_cclave) {
        this.emp_cclave = emp_cclave;
    }

    public String getEmp_cusuario() {
        return emp_cusuario;
    }

    public void setEmp_cusuario(String emp_cusuario) {
        this.emp_cusuario = emp_cusuario;
    }
    
    //agregado el :19072016

    public String getDireccionsucursal() {
        return direccionsucursal;
    }

    public void setDireccionsucursal(String direccionsucursal) {
        this.direccionsucursal = direccionsucursal;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCodigoubigeo() {
        return codigoubigeo;
    }

    public void setCodigoubigeo(String codigoubigeo) {
        this.codigoubigeo = codigoubigeo;
    }
    
}
