package com.gusedu.model;
// Generated 18/02/2016 11:27:55 AM by Hibernate Tools 4.3.1



/**
 * EnfermedadPar generated by hbm2java
 */
public class EnfermedadPar  implements java.io.Serializable {


     private Integer expCodigo;
     private Enfermedad enfermedad;
     private Par par;

    public EnfermedadPar() {
    }

    public EnfermedadPar(Enfermedad enfermedad, Par par) {
       this.enfermedad = enfermedad;
       this.par = par;
    }
   
    public Integer getExpCodigo() {
        return this.expCodigo;
    }
    
    public void setExpCodigo(Integer expCodigo) {
        this.expCodigo = expCodigo;
    }
    public Enfermedad getEnfermedad() {
        return this.enfermedad;
    }
    
    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }
    public Par getPar() {
        return this.par;
    }
    
    public void setPar(Par par) {
        this.par = par;
    }




}


