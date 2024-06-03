package com.udea.dao;

import com.udea.model.Traspaso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraspasoDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/inmobiliaria";
    private String USER_DB = "root";
    private String PASSWORD_DB = "manuel";

    // Sentencias SQL para el CRUD
    private static final String INSERTAR_TRASPASO = "INSERT INTO traspasos (PropietarioAnterior, PropietarioNuevo, Propiedad, Fecha) VALUES (?, ?, ?, ?)";
    private static final String SELECCIONAR_TRASPASO_NUMERO = "SELECT * FROM traspasos WHERE NumeroTraspaso = ?";
    private static final String SELECCIONAR_TODOS = "SELECT * FROM traspasos";
    private static final String ELIMINAR_TRASPASO = "DELETE FROM traspasos WHERE NumeroTraspaso = ?";

    // Conexión a la base de datos
    protected Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MariaDB JDBC Driver no encontrado.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    // Crear un traspaso
    public void insertarTraspaso(Traspaso nuevoTraspaso) {
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_TRASPASO)) {
            preparedStatement.setInt(1, nuevoTraspaso.getPropietarioAnterior());
            preparedStatement.setInt(2, nuevoTraspaso.getPropietarioNuevo());
            preparedStatement.setInt(3, nuevoTraspaso.getPropiedad());
            preparedStatement.setDate(4, nuevoTraspaso.getFecha());
            preparedStatement.executeUpdate();
            System.out.println("Traspaso agregado con éxito");
        } catch (SQLException e) {
            System.out.println("Error al insertar un traspaso: " + e.getMessage());
        }
    }

    // Seleccionar un traspaso por número
    public Traspaso seleccionarTraspasoPorNumero(int numeroTraspaso) {
        Traspaso traspaso = null;
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_TRASPASO_NUMERO)) {
            preparedStatement.setInt(1, numeroTraspaso);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                traspaso = new Traspaso();
                traspaso.setNumeroTraspaso(resultSet.getInt("NumeroTraspaso"));
                traspaso.setPropietarioAnterior(resultSet.getInt("PropietarioAnterior"));
                traspaso.setPropietarioNuevo(resultSet.getInt("PropietarioNuevo"));
                traspaso.setPropiedad(resultSet.getInt("Propiedad"));
                traspaso.setFecha(resultSet.getDate("Fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar un traspaso por número: " + e.getMessage());
        }
        return traspaso;
    }

    // Seleccionar todos los traspasos
    public List<Traspaso> seleccionarTodosTraspasos() {
        List<Traspaso> traspasos = new ArrayList<>();
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_TODOS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Traspaso traspaso = new Traspaso();
                traspaso.setNumeroTraspaso(resultSet.getInt("NumeroTraspaso"));
                traspaso.setPropietarioAnterior(resultSet.getInt("PropietarioAnterior"));
                traspaso.setPropietarioNuevo(resultSet.getInt("PropietarioNuevo"));
                traspaso.setPropiedad(resultSet.getInt("Propiedad"));
                traspaso.setFecha(resultSet.getDate("Fecha"));
                traspasos.add(traspaso);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar todos los traspasos: " + e.getMessage());
        }
        return traspasos;
    }

    // Eliminar un traspaso por número
    public void eliminarTraspasoPorNumero(int numeroTraspaso) {
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(ELIMINAR_TRASPASO)) {
            preparedStatement.setInt(1, numeroTraspaso);
            int filasEliminadas = preparedStatement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Traspaso eliminado con éxito");
            } else {
                System.out.println("No se encontró ningún traspaso con el número especificado");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el traspaso: " + e.getMessage());
        }
    }
}
