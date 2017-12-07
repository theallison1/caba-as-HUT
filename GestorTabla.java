
package controlador;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;


public class GestorTabla {

    
    public static void rellena(ResultSet rs, DefaultTableModel modelo) {
        //configuraColumnas(rs, modelo); //coneste metodo configuro las columnas de forma automatica
        vaciaFilasModelo(modelo);
        anhadeFilasDeDatos(rs, modelo);
    }

   
    public static void anhadeFilasDeDatos(ResultSet rs,
            DefaultTableModel modelo) {
        int numeroFila = 0;
        try {
            // Para cada registro de resultado en la consulta 
            while (rs.next()) {
                // Se crea y rellena la fila para el modelo de la tabla.
                Object[] datosFila = new Object[modelo.getColumnCount()];
                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    datosFila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(datosFila);
                //numeroFila++;
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Borra todas las filas del modelo.
     *
     * @param modelo El modelo para la tabla.
     */
    public static void vaciaFilasModelo(final DefaultTableModel modelo) {

        try {

            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Pone en el modelo para la tabla tantas columnas como tiene el resultado
     * de la consulta a base de datos.
     *
     * @param rs Resultado de consulta a base de datos.
     * @param modelo Modelo de la tabla.
     * @return
     */
    public static void configuraColumnas(ResultSet rs, DefaultTableModel modelo) {

        try {

            // Se obtiene los metadatos de la consulta. Con ellos
            // podemos obtener el número de columnas y el nombre
            // de las mismas.
            ResultSetMetaData metaDatos = rs.getMetaData();

            // Se obtiene el numero de columnas.
            int numeroColumnas = metaDatos.getColumnCount();

            // Se obtienen las etiquetas para cada columna
            Object[] etiquetas = new Object[numeroColumnas];
            for (int i = 0; i < numeroColumnas; i++) {
                etiquetas[i] = metaDatos.getColumnLabel(i + 1);
            }
            // Se meten las etiquetas en el modelo. El numero
            // de columnas se ajusta automáticamente.
            modelo.setColumnIdentifiers(etiquetas);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
