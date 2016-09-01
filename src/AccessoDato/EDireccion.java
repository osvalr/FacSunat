
package AccessoDato;

import Utilidad.InstancaEntidad;

public class EDireccion {
    
    private Integer dir_ncodigo;
    private String dir_cdescripcion;
    private Integer cli_ncodigo;
    private InstancaEntidad m_Instancia;

    public InstancaEntidad getM_Instancia() {
        return m_Instancia;
    }

    public void setM_Instancia(InstancaEntidad m_Instancia) {
        this.m_Instancia = m_Instancia;
    }
    public EDireccion(Integer dir_ncodigo, String dir_cdescripcion, Integer cli_ncodigo,InstancaEntidad x_instacia) {
        this.dir_ncodigo = dir_ncodigo;
        this.dir_cdescripcion = dir_cdescripcion;
        this.cli_ncodigo = cli_ncodigo;
        this.m_Instancia=x_instacia;
    }
    public EDireccion()
    {}
    public Integer getDir_ncodigo() {
        return dir_ncodigo;
    }

    public void setDir_ncodigo(Integer dir_ncodigo) {
        this.dir_ncodigo = dir_ncodigo;
    }

    public String getDir_cdescripcion() {
        return dir_cdescripcion;
    }

    public void setDir_cdescripcion(String dir_cdescripcion) {
        this.dir_cdescripcion = dir_cdescripcion;
    }

    public Integer getCli_ncodigo() {
        return cli_ncodigo;
    }

    public void setCli_ncodigo(Integer cli_ncodigo) {
        this.cli_ncodigo = cli_ncodigo;
    }
    
}
