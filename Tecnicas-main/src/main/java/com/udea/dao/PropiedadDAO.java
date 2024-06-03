package com.udea.dao;

import com.udea.model.Propiedad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropiedadDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/inmobiliaria";
    private String USER_DB = "root";
    private String PASSWORD_DB = "manuel";

    // Codigos SQL
    private static final String INSERTAR_PROPIEDAD = "INSERT INTO propiedades (Tipo, Direccion, Descripcion, Ciudad, Valor, Propietario, EnVenta) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECCIONAR_PROPIEDAD_MATRICULA = "SELECT * FROM propiedades WHERE Matricula = ?";
    private static final String SELECCIONAR_PROPIEDADES_PROPIETARIO = "SELECT * FROM propiedades WHERE Propietario = ?";
    private static final String SELECCIONAR_TODAS = "SELECT * FROM propiedades";
    private static final String ELIMINAR_PROPIEDAD = "DELETE FROM propiedades WHERE Matricula = ?";
    private static final String ACTUALIZAR_PROPIEDAD = "UPDATE propiedades SET Tipo = ?, Direccion = ?, Descripcion = ?, Ciudad = ?, Valor = ?, Propietario = ?, EnVenta = ? WHERE Matricula = ?";
    private static final String SELECCIONAR_PROPIEDADES_EN_VENTA = "SELECT * FROM propiedades WHERE EnVenta = ?";
    private static final String SELECCIONAR_PROPIEDADES_NO_EN_VENTA = "SELECT * FROM propiedades WHERE EnVenta = ?";


    // Metodo para conectarse con la base de datos
    protected Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Conectando a la base de datos...");
            conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            System.out.println(conexion);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MariaDB JDBC Driver no encontrado.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }

    // Insertar propiedad
    public void insertarPropiedad(Propiedad nuevaPropiedad) {
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_PROPIEDAD)) {
            preparedStatement.setString(1, nuevaPropiedad.getTipo());
            preparedStatement.setString(2, nuevaPropiedad.getDireccion());
            preparedStatement.setString(3, nuevaPropiedad.getDescripcion());
            preparedStatement.setString(4, nuevaPropiedad.getCiudad());
            preparedStatement.setInt(5, nuevaPropiedad.getValor());
            preparedStatement.setInt(6, nuevaPropiedad.getPropietario());
            preparedStatement.setBoolean(7, nuevaPropiedad.isEnVenta());
            preparedStatement.executeUpdate();
            System.out.println("Propiedad agregada con éxito");
        } catch (SQLException e) {
            System.out.println("Error al insertar una propiedad: " + e.getMessage());
        }
    }

    // Seleccionar propiedad por matrícula
    public Propiedad seleccionarPropiedadPorMatricula(int matricula) {
        Propiedad propiedad = null;
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_PROPIEDAD_MATRICULA)) {
            preparedStatement.setInt(1, matricula);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                propiedad = new Propiedad();
                propiedad.setMatricula(resultSet.getInt("Matricula"));
                propiedad.setTipo(resultSet.getString("Tipo"));
                propiedad.setDireccion(resultSet.getString("Direccion"));
                propiedad.setDescripcion(resultSet.getString("Descripcion"));
                propiedad.setCiudad(resultSet.getString("Ciudad"));
                propiedad.setValor(resultSet.getInt("Valor"));
                propiedad.setPropietario(resultSet.getInt("Propietario"));
                propiedad.setEnVenta(resultSet.getBoolean("EnVenta"));
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar una propiedad por matrícula: " + e.getMessage());
        }
        return propiedad;
    }

    // Seleccionar todas las propiedades de un propietario
    public List<Propiedad> seleccionarPropiedadesPorPropietario(int propietario) {
        List<Propiedad> propiedades = new ArrayList<>();
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_PROPIEDADES_PROPIETARIO)) {
            preparedStatement.setInt(1, propietario);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Propiedad propiedad = new Propiedad();
                propiedad.setMatricula(resultSet.getInt("Matricula"));
                propiedad.setTipo(resultSet.getString("Tipo"));
                propiedad.setDireccion(resultSet.getString("Direccion"));
                propiedad.setDescripcion(resultSet.getString("Descripcion"));
                propiedad.setCiudad(resultSet.getString("Ciudad"));
                propiedad.setValor(resultSet.getInt("Valor"));
                propiedad.setPropietario(resultSet.getInt("Propietario"));
                propiedad.setEnVenta(resultSet.getBoolean("EnVenta"));
                propiedades.add(propiedad);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar las propiedades por propietario: " + e.getMessage());
        }
        return propiedades;
    }

    // Seleccionar todas las propiedades
    public List<Propiedad> seleccionarTodasPropiedades() {
        List<Propiedad> propiedades = new ArrayList<>();
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_TODAS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Propiedad propiedad = new Propiedad();
                propiedad.setMatricula(resultSet.getInt("Matricula"));
                propiedad.setTipo(resultSet.getString("Tipo"));
                propiedad.setDireccion(resultSet.getString("Direccion"));
                propiedad.setDescripcion(resultSet.getString("Descripcion"));
                propiedad.setCiudad(resultSet.getString("Ciudad"));
                propiedad.setValor(resultSet.getInt("Valor"));
                propiedad.setPropietario(resultSet.getInt("Propietario"));
                propiedad.setEnVenta(resultSet.getBoolean("EnVenta"));
                propiedades.add(propiedad);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar todas las propiedades: " + e.getMessage());
        }
        return propiedades;
    }

    // Seleccionar propiedades en venta
    public List<Propiedad> seleccionarPropiedadesEnVenta() {
        List<Propiedad> propiedades = new ArrayList<>();
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_PROPIEDADES_EN_VENTA)) {
            preparedStatement.setBoolean(1, true);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Propiedad propiedad = new Propiedad();
                propiedad.setMatricula(resultSet.getInt("Matricula"));
                propiedad.setTipo(resultSet.getString("Tipo"));
                propiedad.setDireccion(resultSet.getString("Direccion"));
                propiedad.setDescripcion(resultSet.getString("Descripcion"));
                propiedad.setCiudad(resultSet.getString("Ciudad"));
                propiedad.setValor(resultSet.getInt("Valor"));
                propiedad.setPropietario(resultSet.getInt("Propietario"));
                propiedad.setEnVenta(resultSet.getBoolean("EnVenta"));
                propiedades.add(propiedad);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar propiedades en venta: " + e.getMessage());
        }
        return propiedades;
    }

    // Seleccionar propiedades no en venta
    public List<Propiedad> seleccionarPropiedadesNoEnVenta() {
        List<Propiedad> propiedades = new ArrayList<>();
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_PROPIEDADES_NO_EN_VENTA)) {
            preparedStatement.setBoolean(1, false);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Propiedad propiedad = new Propiedad();
                propiedad.setMatricula(resultSet.getInt("Matricula"));
                propiedad.setTipo(resultSet.getString("Tipo"));
                propiedad.setDireccion(resultSet.getString("Direccion"));
                propiedad.setDescripcion(resultSet.getString("Descripcion"));
                propiedad.setCiudad(resultSet.getString("Ciudad"));
                propiedad.setValor(resultSet.getInt("Valor"));
                propiedad.setPropietario(resultSet.getInt("Propietario"));
                propiedad.setEnVenta(resultSet.getBoolean("EnVenta"));
                propiedades.add(propiedad);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar propiedades no en venta: " + e.getMessage());
        }
        return propiedades;
    }

    // Eliminar propiedad por matrícula
    public void eliminarPropiedadPorMatricula(int matricula) {
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(ELIMINAR_PROPIEDAD)) {
            preparedStatement.setInt(1, matricula);
            int filasEliminadas = preparedStatement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Propiedad eliminada con éxito");
            } else {
                System.out.println("No se encontró ninguna propiedad con la matrícula especificada");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la propiedad: " + e.getMessage());
        }
    }

    // Editar propiedad
    public void editarPropiedad(Propiedad propiedad) {
        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(ACTUALIZAR_PROPIEDAD)) {
            preparedStatement.setString(1, propiedad.getTipo());
            preparedStatement.setString(2, propiedad.getDireccion());
            preparedStatement.setString(3, propiedad.getDescripcion());
            preparedStatement.setString(4, propiedad.getCiudad());
            preparedStatement.setInt(5, propiedad.getValor());
            preparedStatement.setInt(6, propiedad.getPropietario());
            preparedStatement.setBoolean(7, propiedad.isEnVenta());
            preparedStatement.setInt(8, propiedad.getMatricula());
            int filasActualizadas = preparedStatement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Propiedad actualizada con éxito");
            } else {
                System.out.println("No se encontró ninguna propiedad con la matrícula especificada");
            }
        } catch (SQLException e) {
            System.out.println("Error al editar la propiedad: " + e.getMessage());
        }
    }
}
