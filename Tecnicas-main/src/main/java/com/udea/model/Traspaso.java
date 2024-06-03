package com.udea.model;

import java.sql.Date;

public class Traspaso {
    private int numeroTraspaso;
    private int propietarioAnterior;
    private int propietarioNuevo;
    private int propiedad;
    private Date fecha;

    public Traspaso(int propietarioAnterior, int propietarioNuevo, int propiedad){
        this.propietarioAnterior = propietarioAnterior;
        this.propietarioNuevo = propietarioNuevo;
        this.propiedad = propiedad;
        this.fecha = new Date(System.currentTimeMillis());
    }

    public Traspaso(int numeroTraspaso, int propietarioAnterior, int propietarioNuevo, int propiedad, Date fecha){
        this.numeroTraspaso = numeroTraspaso;
        this.propietarioAnterior = propietarioAnterior;
        this.propietarioNuevo = propietarioNuevo;
        this.propiedad = propiedad;
        this.fecha = fecha;
    }

    public Traspaso(){
        
    }

    public int getNumeroTraspaso() {
        return numeroTraspaso;
    }

    public void setNumeroTraspaso(int numeroTraspaso) {
        this.numeroTraspaso = numeroTraspaso;
    }

    public int getPropietarioAnterior() {
        return propietarioAnterior;
    }

    public void setPropietarioAnterior(int propietarioAnterior) {
        this.propietarioAnterior = propietarioAnterior;
    }

    public int getPropietarioNuevo() {
        return propietarioNuevo;
    }

    public void setPropietarioNuevo(int propietarioNuevo) {
        this.propietarioNuevo = propietarioNuevo;
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
