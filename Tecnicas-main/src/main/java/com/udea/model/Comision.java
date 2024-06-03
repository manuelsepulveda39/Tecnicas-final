package com.udea.model;

import java.sql.Date;

public class Comision {
    private int numeroComision;
    private int propiedad;
    private double valor;
    private Date fecha;

    public Comision(int propiedad, double valor){
        this.propiedad = propiedad;
        this.valor = valor;
        this.fecha = new Date(System.currentTimeMillis());
    }

    public Comision(int numeroComision, int propiedad, double valor, Date fecha){
        this.numeroComision = numeroComision;
        this.propiedad = propiedad;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Comision(){
        
    }

    public void setNumeroComision(int numeroComision){
        this.numeroComision = numeroComision;
    }

    public int getNumeroComision(){
        return numeroComision;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(int propiedad) {
        this.propiedad = propiedad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
