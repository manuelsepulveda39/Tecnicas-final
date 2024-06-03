package com.udea.servlets;

import com.udea.dao.ClienteDAO;
import com.udea.model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private ClienteDAO usuarioDAO;

    public RegistroServlet() {
        this.usuarioDAO = new ClienteDAO();
    }

    //GET , UPDATE, POST, DELETE son métodos HTTP
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String celular = request.getParameter("celular");
        String contraseña = request.getParameter("contraseña");
        String email = request.getParameter("email");

        Cliente nuevoUsuario = new Cliente(nombre, cedula, celular, contraseña, email);
        usuarioDAO.insertarUsuario(nuevoUsuario);

        // Redireccionamos a la página de registro exitoso
        response.sendRedirect("registro-exitoso.jsp");
    }
}
