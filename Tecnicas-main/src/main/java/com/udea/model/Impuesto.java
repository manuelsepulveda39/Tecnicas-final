package com.udea.model;

import java.sql.Date;

public class Impuesto {
    private int numeroImpuesto;
    private int cliente;
    private int valor;
    private Date fecha;

    public Impuesto(int cliente, int valor){
        this.cliente = cliente;
        this.valor = valor;
        this.fecha = new Date(System.currentTimeMillis());
    }

    public Impuesto(int numeroImpuesto, int cliente, int valor, Date fecha){
        this.numeroImpuesto = numeroImpuesto;
        this.cliente = cliente;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Impuesto(){
        
    }

    public int getNumeroImpuesto() {
        return numeroImpuesto;
    }
    
    public void setNumeroImpuesto(int numeroImpuesto) {
        this.numeroImpuesto = numeroImpuesto;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
