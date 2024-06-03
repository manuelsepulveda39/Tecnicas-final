package com.udea.servlets;

import com.udea.model.Propiedad;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.udea.dao.PropiedadDAO;

@WebServlet("/comprarPropiedad")
public class ComprarPropiedadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear una lista de propiedades
        PropiedadDAO propiedadDAO = new PropiedadDAO();
        List<Propiedad> propiedades = propiedadDAO.seleccionarPropiedadesEnVenta();

        // Pasar la lista de propiedades a la solicitud
        request.setAttribute("propiedades", propiedades);

        // Redirigir a la página JSP
        request.getRequestDispatcher("inio-compra.jsp").forward(request, response);
    }
}
