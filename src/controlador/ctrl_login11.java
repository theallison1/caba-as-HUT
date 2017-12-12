/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.BaseDeDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Usuario;
import javax.swing.JOptionPane;

import vista.login1;



public class ctrl_login11 implements interfaceValidacion1{

    
    private final login1 validarlogin;
    private final BaseDeDatos conecxion;
    private final Usuario usuario;

    public ctrl_login11() {
       
        conecxion=new BaseDeDatos();
        usuario=new Usuario();
        validarlogin=new login1(this);
        
        
    }
    
    
    
    @Override
    public void recibeusuario(String texto) {
       
        if (texto.length()>1) {
            usuario.setNom_usuario(texto);
            
        }
    }

    @Override
    public void recibeContraseña(String texto) {
      
         if (texto.length()>1) {
            usuario.setPass(texto);
            
        }
    }

    @Override
    public void accionEntrar() {
        
       
       
       String user=validarlogin.txt_usuario.getText();
       String pass=validarlogin.txt_contraseña.getText();
       
        System.out.println(user);
        if (user.equals("")) {
//          JOptionPane.showMessageDialog(null, "no se puede dejar campos vacios");
          
          validarlogin.advertencia1.setText("* obligatorio llenar este campo");
          
          validarlogin.advertencia1.setVisible(true);
         
          
          validarlogin.txt_usuario.setText("");
          
          
                  
        }else if (pass.equals("")) {
            
      
        }else{
            System.out.println("los campos estan llenos");
        
            System.out.println("entre");
           
            if (conecxion.dameDatos(user,pass)) {
                JOptionPane.showMessageDialog(null, "entrando al sistema");
                
              
                  validarlogin.hide();
            }
            else{
                JOptionPane.showMessageDialog(null, "usuario y/o contraseña incorecta");
                
                
                
                validarlogin.txt_usuario.setText("");
                validarlogin.txt_contraseña.setText("");
                 validarlogin.advertencia1.setVisible(false);
                  validarlogin.advertencia2.setVisible(false);
                
                
            }
        
            
        }
{
            
           
        }
        
        
            
         
    }

    @Override
    public void salir() {
        
        JOptionPane.showMessageDialog(null,"saliendo...");
        System.exit(0);
    }

    @Override
    public void olvidecontraseña() {
       
        JOptionPane.showMessageDialog(null, "Lo sentimos!!"+"\n "
                + "contacte con el administrador del sistema");
    }

    
    
 
    
}
