/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;


import modelo.Usuario;


public class GestorUsuario {
    
      /**
     * Realiza la consulta de personas en la tabla y devuelve el ResultSet
     * correspondiente.
     * @return El resultado de la consulta
     */
    
    Usuario cliente = new Usuario();

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public void cargarCliente(Integer id, String nombre, String apellido, 
                String dni, String mail, String telefono,String tipo_usuario, String nom_usuario,String pass){
        Usuario c = new Usuario();
        c.setId(id);
        c.setNombre(nombre);
        c.setApellido(apellido);
        c.setDni(dni);
        c.setMail(mail);
        c.setTelefono(telefono);
        c.setTipo_usuario(tipo_usuario);
        c.setNom_usuario(nom_usuario);
        c.setPass(pass);
       
        setCliente(c);
        
    }

}
