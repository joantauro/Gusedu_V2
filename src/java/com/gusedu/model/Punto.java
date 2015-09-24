package com.gusedu.model;
// Generated 15/09/2015 11:54:43 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Punto generated by hbm2java
 */
public class Punto  implements java.io.Serializable {


     private Integer punCodigo;
     private String punNombre;
     private Integer punOrdenFisico;
     private String punUbicacionC;
     private String punUbicacionM;
     private Set parsForPunCodigoP2 = new HashSet(0);
     private Set parsForPunCodigoP1 = new HashSet(0);

    public Punto() {
    }

    public Punto(String punNombre, Integer punOrdenFisico, String punUbicacionC, String punUbicacionM, Set parsForPunCodigoP2, Set parsForPunCodigoP1) {
       this.punNombre = punNombre;
       this.punOrdenFisico = punOrdenFisico;
       this.punUbicacionC = punUbicacionC;
       this.punUbicacionM = punUbicacionM;
       this.parsForPunCodigoP2 = parsForPunCodigoP2;
       this.parsForPunCodigoP1 = parsForPunCodigoP1;
    }
   
    public Integer getPunCodigo() {
        return this.punCodigo;
    }
    
    public void setPunCodigo(Integer punCodigo) {
        this.punCodigo = punCodigo;
    }
    public String getPunNombre() {
        return this.punNombre;
    }
    
    public void setPunNombre(String punNombre) {
        this.punNombre = punNombre;
    }
    public Integer getPunOrdenFisico() {
        return this.punOrdenFisico;
    }
    
    public void setPunOrdenFisico(Integer punOrdenFisico) {
        this.punOrdenFisico = punOrdenFisico;
    }
    public String getPunUbicacionC() {
        return this.punUbicacionC;
    }
    
    public void setPunUbicacionC(String punUbicacionC) {
        this.punUbicacionC = punUbicacionC;
    }
    public String getPunUbicacionM() {
        return this.punUbicacionM;
    }
    
    public void setPunUbicacionM(String punUbicacionM) {
        this.punUbicacionM = punUbicacionM;
    }
    public Set getParsForPunCodigoP2() {
        return this.parsForPunCodigoP2;
    }
    
    public void setParsForPunCodigoP2(Set parsForPunCodigoP2) {
        this.parsForPunCodigoP2 = parsForPunCodigoP2;
    }
    public Set getParsForPunCodigoP1() {
        return this.parsForPunCodigoP1;
    }
    
    public void setParsForPunCodigoP1(Set parsForPunCodigoP1) {
        this.parsForPunCodigoP1 = parsForPunCodigoP1;
    }




}


