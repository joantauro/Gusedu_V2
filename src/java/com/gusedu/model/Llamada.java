package com.gusedu.model;
// Generated 29/01/2016 10:00:22 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Llamada generated by hbm2java
 */
public class Llamada  implements java.io.Serializable {


     private Integer llaCodigo;
     private Persona persona;
     private String llaDetalle;
     private Boolean llaContestada;
     private Date llaFecRealizada;
     private String llaUsuCreacion;

    public Llamada() {
    }

	
    public Llamada(Persona persona) {
        this.persona = persona;
    }
    public Llamada(Persona persona, String llaDetalle, Boolean llaContestada, Date llaFecRealizada, String llaUsuCreacion) {
       this.persona = persona;
       this.llaDetalle = llaDetalle;
       this.llaContestada = llaContestada;
       this.llaFecRealizada = llaFecRealizada;
       this.llaUsuCreacion = llaUsuCreacion;
    }
   
    public Integer getLlaCodigo() {
        return this.llaCodigo;
    }
    
    public void setLlaCodigo(Integer llaCodigo) {
        this.llaCodigo = llaCodigo;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getLlaDetalle() {
        return this.llaDetalle;
    }
    
    public void setLlaDetalle(String llaDetalle) {
        this.llaDetalle = llaDetalle;
    }
    public Boolean getLlaContestada() {
        return this.llaContestada;
    }
    
    public void setLlaContestada(Boolean llaContestada) {
        this.llaContestada = llaContestada;
    }
    public Date getLlaFecRealizada() {
        return this.llaFecRealizada;
    }
    
    public void setLlaFecRealizada(Date llaFecRealizada) {
        this.llaFecRealizada = llaFecRealizada;
    }
    public String getLlaUsuCreacion() {
        return this.llaUsuCreacion;
    }
    
    public void setLlaUsuCreacion(String llaUsuCreacion) {
        this.llaUsuCreacion = llaUsuCreacion;
    }




}


