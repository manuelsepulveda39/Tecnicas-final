package com.udea.dao;

import com.udea.model.Comision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComisionDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/inmobiliaria";
    private String USER_DB = "root";
    private String PASSWORD_DB = "manuel";

    // Sentencias SQL para el CRUD
    private static final String INSERTAR_COMISION = "INSERT INTO comisiones (Propiedad, Valor, Fecha) VALUES (?, ?, ?)";
    private static final String SELECCIONAR_COMISION_NUMERO = "SELECT * FROM comisiones WHERE NumeroComision = ?";
    private static final String SELECCIONAR_TODAS = "SELECT * FROM comisiones";
    private static final String ELIMINAR_COMISION = "DELETE FROM comisiones WHERE NumeroComision = ?";

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

    // Crear una comisión
    public void insertarComision(Comision nuevaComision) {
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_COMISION)) {
            preparedStatement.setInt(1, nuevaComision.getPropiedad());
            preparedStatement.setDouble(2, nuevaComision.getValor());
            preparedStatement.setDate(3, nuevaComision.getFecha());
            preparedStatement.executeUpdate();
            System.out.println("Comisión agregada con éxito");
        } catch (SQLException e) {
            System.out.println("Error al insertar una comisión: " + e.getMessage());
        }
    }

    // Seleccionar una comisión por número
    public Comision seleccionarComisionPorNumero(int numeroComision) {
        Comision comision = null;
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_COMISION_NUMERO)) {
            preparedStatement.setInt(1, numeroComision);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                comision = new Comision();
                comision.setNumeroComision(resultSet.getInt("NumeroComision"));
                comision.setPropiedad(resultSet.getInt("Propiedad"));
                comision.setValor(resultSet.getDouble("Valor"));
                comision.setFecha(resultSet.getDate("Fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar una comisión por número: " + e.getMessage());
        }
        return comision;
    }

    // Seleccionar todas las comisiones
    public List<Comision> seleccionarTodasComisiones() {
        List<Comision> comisiones = new ArrayList<>();
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_TODAS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Comision comision = new Comision();
                comision.setNumeroComision(resultSet.getInt("NumeroComision"));
                comision.setPropiedad(resultSet.getInt("Propiedad"));
                comision.setValor(resultSet.getDouble("Valor"));
                comision.setFecha(resultSet.getDate("Fecha"));
                comisiones.add(comision);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar todas las comisiones: " + e.getMessage());
        }
        return comisiones;
    }

    // Eliminar una comisión por número
    public void eliminarComisionPorNumero(int numeroComision) {
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(ELIMINAR_COMISION)) {
            preparedStatement.setInt(1, numeroComision);
            int filasEliminadas = preparedStatement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Comisión eliminada con éxito");
            } else {
                System.out.println("No se encontró ninguna comisión con el número especificado");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la comisión: " + e.getMessage());
        }
    }
}

