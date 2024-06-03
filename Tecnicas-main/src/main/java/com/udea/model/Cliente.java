package com.udea.model;

public class Cliente{

  private String nombre;
  private int cedula;
  private String celular;
  private String contraseña;
  private String email;

  public Cliente(String nombre, int cedula, String celular, String contraseña, String email) {
    this.nombre = nombre;
    this.cedula = cedula;
    this.celular = celular;
    this.contraseña = contraseña;
    this.email = email;
  }

  public Cliente(String nombre, String celular, String contraseña, String email) {
    this.nombre = nombre;
    this.celular = celular;
    this.contraseña = contraseña;
    this.email = email;
  }

  public Cliente() {
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCedula() {
    return cedula;
  }

  public void setCedula(int cedula) {
    this.cedula = cedula;
  }

  public String getcelular() {
    return celular;
  }

  public void setcelular(String celular) {
    this.celular = celular;
  }

  public String getcontraseña() {
    return contraseña;
  }

  public void setcontraseña(String contraseña) {
    this.contraseña = contraseña;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
