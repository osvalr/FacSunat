
package Utilidad;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

 public  class   Conector {

    public Conector() {
        
    }
    
    String driver ="org.postgresql.Driver";
    String connectStirng ="jdbc:postgresql://localhost:5432/DBFactura";
    String user="postgres";
    String pwd="postgres";
    public Connection con=null;
    private Statement  stm=null;
    private PreparedStatement pst=null;
    public boolean  m_tipo;

    public Conector(boolean _estado) {
        Abrir();
    }

    
    public final void Abrir()
    {
        try
        {
            m_tipo=false;
            Class.forName(driver);
            con =DriverManager.getConnection(connectStirng,user,pwd);
        }
        catch(Exception e)
        {    }
      }
       public void Cerrar()
       {
           try
           {
               con.close();
               stm.close();
               pst.close();
           }
           catch(Exception e)
           {}
       }
       
       public PreparedStatement RecibirQuer(String x_query)
       {
                try
                {
                pst  = con.prepareStatement(x_query);
               
                }
                catch(Exception  e)
                {
                    
                }
                return pst;
       }
       public ResultSet EjecutarQuery(PreparedStatement x_spt)
       {
           ResultSet _rs=null;
           int _rpta=0;
           try
           {   
                _rs= x_spt.executeQuery();
//                if(!m_tipo)
//                    _rs= x_spt.executeQuery();
//                else
//                {   _rpta=x_spt.executeUpdate();
//                    _rs = 
//                }
           }
           catch(Exception  e)
           {
           JOptionPane.showMessageDialog(null, "error :"+  e.getMessage());
           Cerrar();
           }
           return _rs;
       }
       public Integer EjecutarQueryUpdate(PreparedStatement x_spt)
       {
          
           int _rpta=0;
           try
           {   
                 _rpta=x_spt.executeUpdate();

           }
           catch(Exception  e)
           {
            JOptionPane.showMessageDialog(null, "error :"+  e.getMessage());
            Cerrar();
           }
           return _rpta;
       }
    
    
}
