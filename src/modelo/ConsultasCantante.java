package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
//heredamos la conexion para evitar hacer objetos e instancias de la calse

public class ConsultasCantante extends Conexion {

    //aqui trabajamos con todas consultas que se van a realizar
    //hacemos todos los metodos que tiene el formulario
    public boolean registrar(Cantante cant) {//recibe el modelo

        PreparedStatement ps = null;
        Connection con = getConexion();//lo heredamos

        String sql = "INSERT INTO cantantes(id, nombre, apellido, estilo) VALUES(?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, cant.getId());
            ps.setString(2, cant.getNombre());
            ps.setString(3, cant.getApellido());
            ps.setString(4, cant.getEstilo());
            ps.execute();
            return true;//en caso de que se realice todo esto no habrá problema ni lanzara excepcion por lo que nos retorna true

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();//cerramos conexion
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean modificar(Cantante cant) {//recibe el modelo

        PreparedStatement ps = null;
        Connection con = getConexion();//lo heredamos

        String sql = "UPDATE cantantes SET id=?, nombre=?, apellido=?, estilo=? WHERE id=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, cant.getId());
            ps.setString(2, cant.getNombre());
            ps.setString(3, cant.getApellido());
            ps.setString(4, cant.getEstilo());
            ps.setInt(5, cant.getId());
            ps.executeUpdate();
            return true;//en caso de que se realice todo esto no habrá problema ni lanzara excepcion por lo que nos retorna true

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();//cerramos conexion
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean eliminar(Cantante cant) {//recibe el modelo

        PreparedStatement ps = null;
        Connection con = getConexion();//lo heredamos

        String sql = "DELETE FROM cantantes WHERE id=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, cant.getId());
            ps.execute();
            return true;//en caso de que se realice todo esto no habrá problema ni lanzara excepcion por lo que nos retorna true

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();//cerramos conexion
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean buscar(Cantante cant) {//recibe el modelo

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();//lo heredamos

        String sql = "SELECT * FROM cantantes WHERE id=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, cant.getId());
            rs = ps.executeQuery();//El resultado va a ser igual a la ejecucion de mi consulta

            //nos trae toda la informacion que tiene mi consulta y con un if pasamos todos los resultados
            if (rs.next()) {
                cant.setId(Integer.parseInt(rs.getString("id")));
                cant.setNombre(rs.getString("nombre"));
                cant.setApellido(rs.getString("apellido"));
                cant.setEstilo(rs.getString("estilo"));
                return true;
            }

            //en caso de no encontrar ningun resultado nos retorna falso
            return false;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();//cerramos conexion
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

}
