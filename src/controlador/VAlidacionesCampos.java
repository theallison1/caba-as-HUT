/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 
 */
public class VAlidacionesCampos {

    
    private JTextField campo;
    
    public VAlidacionesCampos() {
    }
    
     public void validarCampoSoloNumerico(KeyEvent evt, int tamanioLimitar){
        char caracter = evt.getKeyChar();

        if((caracter < '0') || (caracter > '9')){
            evt.consume();
        }
     limitarCampo(evt,tamanioLimitar);
    }


    public void validarCampoDosDigitosNumericoyLuegoTexto(KeyEvent evt, int tamanioLimitar){
        char caracter = evt.getKeyChar();

        if((caracter < '0') || (caracter > '9')){
            evt.consume();
        }

     limitarCampo(evt,tamanioLimitar);
     tamanioLimitar=10 ;

  validarCampoSoloTexto(evt,tamanioLimitar);

    }


    public void validarCampoSoloTexto(KeyEvent evt, int tamanioLimitar){
        Character caracter = new Character(evt.getKeyChar());
        if (!(Character.isLetter(caracter)|| caracter == ' ' || caracter == 8 )){
            evt.consume();

        }
    this.validarCampoVacio(evt, tamanioLimitar);
    }



    public void validarCampoVacio(KeyEvent evt, int tamanioLimitar){
        Character caracter = new Character(evt.getKeyChar());
        campo =(JTextField)evt.getSource();
        // Validar solo el espacio
        if (caracter == ' '&& campo.getText().length()==0){
            evt.consume();
        }
        limitarCampo(evt,tamanioLimitar);
    }

    public void limitarCampo(KeyEvent evt, int tamanioLimitar){
        campo =(JTextField)evt.getSource();
        if(campo.getText().length()>=tamanioLimitar){
            evt.consume();
        }
    }

    // Valida que el combo sea cargado en la bùsqueda
        public void validarCampoBusquedaCombo(String txt,String combo){

        if(txt.isEmpty() && combo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione un valor en el combo y un valor en el campo de texto ");
        }else{
            if(txt.isEmpty()){
                  
                  JOptionPane.showMessageDialog(null, "Introduzca el contenido a  buscar :");
            }else{
                if(combo.isEmpty()){
                      JOptionPane.showMessageDialog(null, "Seleccione un valor en el criterio de bùsqueda");
                }
            }
        }
    }
    
    
}
