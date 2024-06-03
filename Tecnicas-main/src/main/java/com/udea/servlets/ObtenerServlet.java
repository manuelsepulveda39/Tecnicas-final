package com.udea.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.udea.dao.ClienteDAO;
import com.udea.model.Cliente;

@WebServlet("/lista-clientes")
public class ObtenerServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ClienteDAO usuarioDAO = new ClienteDAO();
    String cedulaParametro = request.getParameter("cedula");

    if (cedulaParametro != null && !cedulaParametro.isEmpty()) {
      // Si se proporcionó, mostrar solo el usuario con esa cédula
      int cedula = Integer.parseInt(cedulaParametro);
      Cliente usuario = usuarioDAO.seleccionarUsuarioPorCedula(cedula);

      // Pasar el usuario al archivo JSP
      request.setAttribute("clientes", Collections.singletonList(usuario));
    } else {
      List<Cliente> clientes = usuarioDAO.seleccionarTodosclientes();
      // Pasar la lista de clientes al archivo JSP
      request.setAttribute("clientes", clientes);
    }

    request.getRequestDispatcher("/lista-clientes.jsp").forward(request, response);
  }
}
