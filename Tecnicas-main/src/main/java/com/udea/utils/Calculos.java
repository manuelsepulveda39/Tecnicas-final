package com.udea.utils;

public class Calculos {
    private static final Double valorComision = 0.05;
    private static final Double valorImpuestos = 0.02;
    
    public static Double calcularComision(Double valor){
        return valor * valorComision;
    }

    public static Double calcularImpuestos(Double valor){
        return valor * valorImpuestos;
    }
}
