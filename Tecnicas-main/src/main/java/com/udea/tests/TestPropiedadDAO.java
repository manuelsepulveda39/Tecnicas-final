package com.udea.tests;

import com.udea.dao.PropiedadDAO;
import com.udea.model.Propiedad;

import java.util.List;

public class TestPropiedadDAO {
    public static void main(String[] args) {
        PropiedadDAO propiedadDAO = new PropiedadDAO();

        // Crear una nueva propiedad
        Propiedad nuevaPropiedad = new Propiedad("Casa", "Calle Falsa 123", "Una casa amplia", "CiudadX", 150000, 123456, true);
        propiedadDAO.insertarPropiedad(nuevaPropiedad);

        // Buscar la propiedad por matricula generada automáticamente
        List<Propiedad> propiedades = propiedadDAO.seleccionarPropiedadesPorPropietario(123456);
        Propiedad propiedadInsertada = propiedades.get(0);
        int matriculaGenerada = propiedadInsertada.getMatricula();
        System.out.println("Propiedad insertada: " + propiedadInsertada.toString());

        // Editar la propiedad
        propiedadInsertada.setValor(200000);
        propiedadDAO.editarPropiedad(propiedadInsertada);

        // Buscar la propiedad nuevamente por matricula para confirmar la edición
        Propiedad propiedadEditada = propiedadDAO.seleccionarPropiedadPorMatricula(matriculaGenerada);
        System.out.println("Propiedad editada: " + propiedadEditada);

        // Eliminar la propiedad
        propiedadDAO.eliminarPropiedadPorMatricula(matriculaGenerada);

        // Verificar que la propiedad fue eliminada
        Propiedad propiedadEliminada = propiedadDAO.seleccionarPropiedadPorMatricula(matriculaGenerada);
        if (propiedadEliminada == null) {
            System.out.println("Propiedad eliminada con éxito.");
        } else {
            System.out.println("Error al eliminar la propiedad.");
        }
    }
}
