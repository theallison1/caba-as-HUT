

package conexion;


public interface DBSentencias {
    //Flag para habilitar Trazas y controles
    public boolean DEBUG =false;
    //Insertar nuevo cliente
   public static final String consulta1 = "INSERT INTO personas (nombre, apellido,  dni, mail, telefono, tipo_usuario,nom_usuario,pass) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
    //Mdificar cliente
    public static final String consulta2 = "UPDATE personas SET nombre = ?, apellido = ?, dni = ?, mail= ?, telefono = ?, tipo_usuario = ?, nom_usuario = ?, pass = ? where id_persona= ?";
    //Eliminar un Cliente
    public static final String consulta3 = "DELETE FROM personas WHERE id_persona= ?";
    //Buscar por dni
    public static final String consulta4 = "select * from personas where dni like ?";
    //Obtener todos los clientes
    public static final String consulta5 = "SELECT * FROM personas";
    //
    public static final String consulta6 = "select * from personas where id_persona = ?";
    
    //consulta login
    public static final String consulta7="SELECT * FROM personas WHERE nom_usuario =? AND pass=?";
    
}
