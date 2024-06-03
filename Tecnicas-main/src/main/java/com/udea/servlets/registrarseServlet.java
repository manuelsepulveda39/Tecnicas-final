package com.udea.servlets;

import com.udea.dao.ClienteDAO;
import com.udea.model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registrarse")
public class registrarseServlet extends HttpServlet {
    private ClienteDAO usuarioDAO;

    public registrarseServlet() {
        this.usuarioDAO = new ClienteDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nombre = request.getParameter("nombre");
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            String celular = request.getParameter("celular");
            String email = request.getParameter("email");
            String contraseña = request.getParameter("contraseña");

            Cliente nuevoUsuario = new Cliente(nombre, cedula, celular, contraseña, email);
            usuarioDAO.insertarUsuario(nuevoUsuario);

            // Redireccionamos a la página de registro exitoso
            response.sendRedirect("index.jsp");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Formato de cédula incorrecto.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al registrar usuario: " + e.getMessage());
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}
