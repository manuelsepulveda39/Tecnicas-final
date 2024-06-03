package com.udea.model;

public class Propiedad {
    
    private int matricula;
    private String tipo;
    private String direccion;
    private String descripcion;
    private String ciudad;
    private int valor;
    private int propietario;
    private boolean enVenta;

    public Propiedad(int matricula, String tipo, String direccion, String descripcion, String ciudad, int valor, int propietario, boolean enVenta){
        this.matricula = matricula;
        this.tipo = tipo;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.valor = valor;
        this.propietario = propietario;
        this.enVenta = enVenta;
    }

    public Propiedad(String tipo, String direccion, String descripcion, String ciudad, int valor, int propietario, boolean enVenta){
        this.tipo = tipo;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.valor = valor;
        this.propietario = propietario;
        this.enVenta = enVenta;
    }

    public Propiedad(){
        
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public int getMatricula(){
        return matricula;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    public String getCiudad(){
        return ciudad;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }

    public void setPropietario(int propietario){
        this.propietario = propietario;
    }

    public int getPropietario(){
        return propietario;
    }

    public boolean isEnVenta() {
        return enVenta;
    }

    public void setEnVenta(boolean enVenta) {
        this.enVenta = enVenta;
    }
}
