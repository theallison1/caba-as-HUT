
package controlador;

import conexion.BaseDeDatos;
import vista.login1;



public class main1 {
    
    
        private ctrl_login11 usuario;
       
    
        public main1() {
        
        usuario=new ctrl_login11();
    }
    public static void main(String[] args) {
        
         BaseDeDatos con=new BaseDeDatos ();
         
        new main1();
    
        
        
       

    }
   
    
}
