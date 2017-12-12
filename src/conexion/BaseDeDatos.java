package conexion;

/**
 *
 * @author 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Usuario;
import vista.login1;

/**
 * Clase encargada de conexión y consultas a base de datos.

 */
public class BaseDeDatos
{
    /** La conexion con la base de datos */
    private Connection conexion = null;
    private String user = "root";
    private String password = "";
    private String puerto = "3306";
    private String catalogo = "login1";
    private String host = "localhost";
      
    private ResultSet rs;
    private Statement st;
    
    private login1 log =new login1(null);

  
    
    public Connection estableceConexion()
    {  
        if (conexion != null)
            return conexion;

        try
        {
            // Se registra el Driver de MySQL
            Class.forName("com.mysql.jdbc.Driver");
            
            String urlConexion = "jdbc:mysql://" + host + "/"+catalogo;
           
            conexion = DriverManager.getConnection(urlConexion,user,password);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return conexion;
    }

 
  
    
    public boolean dameDatos(String nom_user, String pass) {

        estableceConexion();
        String sql = "SELECT * FROM personas WHERE nom_usuario ='" + nom_user + "' AND pass='" + pass + "'";

        try {

            st = conexion.createStatement();

            rs = st.executeQuery(sql);

            System.out.println("se ejecuto");

            return rs.first();

        } catch (Exception e) {

        }
        return false;
    }


    
    
    
    
    
    
    
    
    
//      public boolean  getUsuario(Usuario usuario){
//          
//         
//         
//            estableceConexion();
//      
//   String sql="SELECT * FROM personas WHERE nom_usuario ='"+log.txt_usuario.getText()+"' AND pass='"+log.txt_contraseña.getText()+"'";
//   
//   
//        try {
//  
//     
//            st = conexion.createStatement();
//            
//            rs = st.executeQuery(sql);
//   
//           System.out.println("se ejecuto");
//           
//            return rs.first();
//
//        } catch (Exception e) {
//
//        }
//       
//        return false;
//         
//       
//    }
//  
    /** Cierra la conexión con la base de datos */
    public void cierraConexion()
    {
        try
        {
            conexion.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
 
   
}
