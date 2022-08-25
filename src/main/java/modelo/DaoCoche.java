package modelo;

import utils.MysqlConnection;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCoche {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    public List<BeanCoche> findAll() {
        List<BeanCoche> coches = new LinkedList<>();
        BeanCoche coche = null;
        try {
            conn = new MysqlConnection().getConnection();
            String query = "SELECT * FROM coche;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                coche = new BeanCoche();
                coche.setId(rs.getLong("id"));
                coche.setModelo(rs.getString("modelo"));
                coche.setMatricula(rs.getString("matricula"));
                coche.setId_persona(rs.getLong("id_persona"));
                coches.add(coche);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return coches;
    }

    public boolean save(BeanCoche coche) { //Guardar los datos del coche cuando se registro
        try {
            conn = new MysqlConnection().getConnection();
            String query = "INSERT INTO coche" +
                    "(modelo, matricula, id_persona" +
                    " VALUES (?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, coche.getModelo());
            pstm.setString(2, coche.getMatricula());
            pstm.setLong(3, coche.getId_persona());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoCoche.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public BeanCoche findOne(Long id) { //devuelve los datos ingresados del auto cuando se registro para la edicion
        try {
            conn = new MysqlConnection().getConnection();
            String query = "SELECT * FROM coche WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                BeanCoche coche = new BeanCoche();
                coche.setId(rs.getLong("id"));
                coche.setModelo(rs.getString("modelo"));
                coche.setMatricula(rs.getString("matricula"));
                coche.setId_persona(rs.getLong("id_persona"));
                return coche;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error findOne", e);
        } finally {
            closeConnections();
        }
        return null;
    }

    public boolean update(BeanCoche coche) { //Modifica los datos del coche que se registro
        try {
            conn = new MysqlConnection().getConnection();
            String query = "UPDATE coche SET modelo = ?, matricula = ?, id_persona= ?," +
                    "  WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, coche.getModelo());
            pstm.setString(2, coche.getMatricula());
            pstm.setLong(3, coche.getId_persona());
            pstm.setLong(4, coche.getId());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error update", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean delete(Long id) { //Eliminar el coche por medio de su id
        try {
            conn = new MysqlConnection().getConnection();
            String query = "DELETE FROM coche WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error delete method");
            return false;
        } finally {
            closeConnections();
        }
    }

    public void closeConnections() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (cstm != null) {
                cstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
        }
    }

}
