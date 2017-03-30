
package AccessoDato;

import Utilidad.InstanciaEntidad;

public class EPlaca {
   private  int pla_ncodigo; 
   private String pla_cnombre; 
   private InstanciaEntidad m_instancia;
   private int cli_ncodigo;
    public EPlaca() {
    }

    public EPlaca(int pla_ncodigo, String pla_cnombre) {
        this.pla_ncodigo = pla_ncodigo;
        this.pla_cnombre = pla_cnombre;
    }
    public EPlaca(int pla_ncodigo, String pla_cnombre,InstanciaEntidad x_instancia) {
        this.pla_ncodigo = pla_ncodigo;
        this.pla_cnombre = pla_cnombre;
        this.m_instancia=x_instancia;
    }

    public int getPla_ncodigo() {
        return pla_ncodigo;
    }

    public void setPla_ncodigo(int pla_ncodigo) {
        this.pla_ncodigo = pla_ncodigo;
    }

    public String getPla_cnombre() {
        return pla_cnombre;
    }

    public void setPla_cnombre(String pla_cnombre) {
        this.pla_cnombre = pla_cnombre;
    }

    public InstanciaEntidad getM_instancia() {
        return m_instancia;
    }

    public void setM_instancia(InstanciaEntidad m_instancia) {
        this.m_instancia = m_instancia;
    }

    public int getCli_ncodigo() {
        return cli_ncodigo;
    }

    public void setCli_ncodigo(int cli_ncodigo) {
        this.cli_ncodigo = cli_ncodigo;
    }
   
}
