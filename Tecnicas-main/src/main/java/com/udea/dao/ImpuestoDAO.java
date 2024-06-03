package com.udea.dao;

import com.udea.model.Impuesto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpuestoDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/inmobiliaria";
    private String USER_DB = "root";
    private String PASSWORD_DB = "manuel";

    // Sentencias SQL para el CRUD
    private static final String INSERTAR_IMPUESTO = "INSERT INTO impuestos (Cliente, Valor, Fecha) VALUES (?, ?, ?)";
    private static final String SELECCIONAR_IMPUESTO_NUMERO = "SELECT * FROM impuestos WHERE NumeroImpuesto = ?";
    private static final String SELECCIONAR_TODOS = "SELECT * FROM impuestos";
    private static final String ELIMINAR_IMPUESTO = "DELETE FROM impuestos WHERE NumeroImpuesto = ?";

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

    // Crear un impuesto
    public void insertarImpuesto(Impuesto nuevoImpuesto) {
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_IMPUESTO)) {
            preparedStatement.setInt(1, nuevoImpuesto.getCliente());
            preparedStatement.setInt(2, nuevoImpuesto.getValor());
            preparedStatement.setDate(3, nuevoImpuesto.getFecha());
            preparedStatement.executeUpdate();
            System.out.println("Impuesto agregado con éxito");
        } catch (SQLException e) {
            System.out.println("Error al insertar un impuesto: " + e.getMessage());
        }
    }

    // Seleccionar un impuesto por número
    public Impuesto seleccionarImpuestoPorNumero(int numeroImpuesto) {
        Impuesto impuesto = null;
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_IMPUESTO_NUMERO)) {
            preparedStatement.setInt(1, numeroImpuesto);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                impuesto = new Impuesto();
                impuesto.setNumeroImpuesto(resultSet.getInt("NumeroImpuesto"));
                impuesto.setCliente(resultSet.getInt("Cliente"));
                impuesto.setValor(resultSet.getInt("Valor"));
                impuesto.setFecha(resultSet.getDate("Fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar un impuesto por número: " + e.getMessage());
        }
        return impuesto;
    }

    // Seleccionar todos los impuestos
    public List<Impuesto> seleccionarTodosImpuestos() {
        List<Impuesto> impuestos = new ArrayList<>();
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_TODOS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Impuesto impuesto = new Impuesto();
                impuesto.setNumeroImpuesto(resultSet.getInt("NumeroImpuesto"));
                impuesto.setCliente(resultSet.getInt("Cliente"));
                impuesto.setValor(resultSet.getInt("Valor"));
                impuesto.setFecha(resultSet.getDate("Fecha"));
                impuestos.add(impuesto);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar todos los impuestos: " + e.getMessage());
        }
        return impuestos;
    }

    // Eliminar un impuesto por número
    public void eliminarImpuestoPorNumero(int numeroImpuesto) {
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(ELIMINAR_IMPUESTO)) {
            preparedStatement.setInt(1, numeroImpuesto);
            int filasEliminadas = preparedStatement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Impuesto eliminado con éxito");
            } else {
                System.out.println("No se encontró ningún impuesto con el número especificado");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el impuesto: " + e.getMessage());
        }
    }
}
