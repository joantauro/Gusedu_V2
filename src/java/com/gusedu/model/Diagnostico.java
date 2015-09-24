package com.gusedu.model;
// Generated 15/09/2015 11:54:43 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Diagnostico generated by hbm2java
 */
public class Diagnostico  implements java.io.Serializable {


     private Integer diaCodigo;
     private Terapia terapia;
     private String diaDescripcion;
     private Date diaFecRealizado;
     private String diaResultado;
     private String diaUsuCreacion;

    public Diagnostico() {
    }

    public Diagnostico(Terapia terapia, String diaDescripcion, Date diaFecRealizado, String diaResultado, String diaUsuCreacion) {
       this.terapia = terapia;
       this.diaDescripcion = diaDescripcion;
       this.diaFecRealizado = diaFecRealizado;
       this.diaResultado = diaResultado;
       this.diaUsuCreacion = diaUsuCreacion;
    }
   
    public Integer getDiaCodigo() {
        return this.diaCodigo;
    }
    
    public void setDiaCodigo(Integer diaCodigo) {
        this.diaCodigo = diaCodigo;
    }
    public Terapia getTerapia() {
        return this.terapia;
    }
    
    public void setTerapia(Terapia terapia) {
        this.terapia = terapia;
    }
    public String getDiaDescripcion() {
        return this.diaDescripcion;
    }
    
    public void setDiaDescripcion(String diaDescripcion) {
        this.diaDescripcion = diaDescripcion;
    }
    public Date getDiaFecRealizado() {
        return this.diaFecRealizado;
    }
    
    public void setDiaFecRealizado(Date diaFecRealizado) {
        this.diaFecRealizado = diaFecRealizado;
    }
    public String getDiaResultado() {
        return this.diaResultado;
    }
    
    public void setDiaResultado(String diaResultado) {
        this.diaResultado = diaResultado;
    }
    public String getDiaUsuCreacion() {
        return this.diaUsuCreacion;
    }
    
    public void setDiaUsuCreacion(String diaUsuCreacion) {
        this.diaUsuCreacion = diaUsuCreacion;
    }




}


