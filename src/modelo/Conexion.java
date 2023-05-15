
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

//Hablar de los métodos, comparar con el metodo de la pagina web y  ver los cambios y saber explicarlos
public class Conexion {

    String url = "C:\\Users\\javie\\NetBeansProjects\\ProyectoCantantes\\BaseDatos\\MiBaseDatos.db";
    private Connection con = null;
  
    public Connection getConexion() {

        try {
            con = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (con != null) {
                System.out.println("Estas conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());

        }

        return con;
    }

}
