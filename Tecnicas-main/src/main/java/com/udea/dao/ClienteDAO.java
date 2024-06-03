package com.udea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.udea.model.Cliente;

public class ClienteDAO {
  private String URL_DB = "jdbc:mariadb://localhost:3306/inmobiliaria";
  private String USER_DB = "root";
  private String PASSWORD_DB = "manuel";

  // Métodos para hacer un CRUD (Create, Read, Update, Delete) de un usuario
  private static final String INSERTAR_USUARIO = "INSERT INTO clientes (Nombre, Cedula, celular, Contraseña, Email) VALUES (?, ?, ?, ?, ?)";
  private static final String SELECCIONAR_USUARIO_CEDULA = "SELECT * FROM clientes WHERE cedula = ?";
  private static final String SELECCIONAR_TODOS = "SELECT * FROM clientes";
  private static final String ELIMINAR_USUARIO = "DELETE FROM clientes WHERE cedula = ?";
  private static final String ACTUALIZAR_USUARIO = "UPDATE clientes SET nombre = ?, celular = ?, email = ?, contraseña = ? WHERE cedula = ?";

  // Conexión a la base de datos
  protected Connection getConnection() {
    Connection conexion = null;
    try {
      //Importante esta línea para que el driver sepa que se va a conectar a una base de datos MariaDB
      Class.forName("org.mariadb.jdbc.Driver");
      System.out.println("Conectando a la base de datos...");
      // Le pasamos la URL de la base de datos, el usuario y la contraseña para
      // conectarnos a la base de datos
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

  // Crear un usuario
  public void insertarUsuario(Cliente nuevoUsuario) {
    try (
        Connection conexion = getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_USUARIO)) {
      preparedStatement.setString(1, nuevoUsuario.getNombre());
      preparedStatement.setInt(2, nuevoUsuario.getCedula());
      preparedStatement.setString(3, nuevoUsuario.getcelular());
      preparedStatement.setString(4, nuevoUsuario.getcontraseña());
      preparedStatement.setString(5, nuevoUsuario.getEmail());
      preparedStatement.executeUpdate();
      System.out.println("Usuario agregado con exito");
    } catch (SQLException e) {
      System.out.println("Error al insertar un usuario: " + e.getMessage());
    }
  }

  // Se retorna un solo usuario por eso Usuario que es el objeto/modelo que se va a retornar
  public Cliente seleccionarUsuarioPorCedula(int cedula) {
    Cliente usuario = null;
    try (Connection conexion = getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_USUARIO_CEDULA)) {
      preparedStatement.setInt(1, cedula);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        usuario = new Cliente();
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setCedula(resultSet.getInt("cedula"));
        usuario.setcelular(resultSet.getString("celular"));
        usuario.setcontraseña(resultSet.getString("contraseña"));
        usuario.setEmail(resultSet.getString("email"));
      }
    } catch (SQLException e) {
      System.out.println("Error al seleccionar un usuario por cédula: " + e.getMessage());
    }
    return usuario;
  }

  // Se va a retornar una lista de clientes por eso List<Usuario>
  public List<Cliente> seleccionarTodosclientes() {
    // Creando una nueva lista de clientes
    List<Cliente> clientes = new ArrayList<>();
    try (Connection conexion = getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_TODOS)) {
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Cliente usuario = new Cliente();
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setCedula(resultSet.getInt("cedula"));
        usuario.setcelular(resultSet.getString("celular"));
        usuario.setcontraseña(resultSet.getString("contraseña"));
        usuario.setEmail(resultSet.getString("email"));
        clientes.add(usuario);
      }
    } catch (SQLException e) {
      System.out.println("Error al seleccionar todos los clientes: " + e.getMessage());
    }
    return clientes;
  }

  public void eliminarClientePorCedula(int cedula) {
    try (Connection conexion = getConnection();
         PreparedStatement preparedStatement = conexion.prepareStatement(ELIMINAR_USUARIO)) {
        preparedStatement.setInt(1, cedula);
        int filasEliminadas = preparedStatement.executeUpdate();
        if (filasEliminadas > 0) {
            System.out.println("Cliente eliminado con éxito");
        } else {
            System.out.println("No se encontró ningún cliente con la cédula especificada");
        }
    } catch (SQLException e) {
        System.out.println("Error al eliminar el cliente: " + e.getMessage());
    }
  }

  public void editarCliente(Cliente cliente) {
    try (Connection conexion = getConnection();
         PreparedStatement preparedStatement = conexion.prepareStatement(ACTUALIZAR_USUARIO)) {
        preparedStatement.setString(1, cliente.getNombre());
        preparedStatement.setString(2, cliente.getcelular());
        preparedStatement.setString(3, cliente.getEmail());
        preparedStatement.setString(4, cliente.getcontraseña());
        preparedStatement.setInt(5, cliente.getCedula());
        int filasActualizadas = preparedStatement.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Cliente actualizado con éxito");
        } else {
            System.out.println("No se encontró ningún cliente con la cédula especificada");
        }
    } catch (SQLException e) {
        System.out.println("Error al editar el cliente: " + e.getMessage());
    }
  }
}
