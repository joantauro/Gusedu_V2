package com.gusedu.model;
// Generated 05/01/2016 05:20:55 PM by Hibernate Tools 4.3.1



/**
 * SintomaTerapia generated by hbm2java
 */
public class SintomaTerapia  implements java.io.Serializable {


     private Integer sxtCodigo;
     private Sintoma sintoma;
     private Terapia terapia;
     private String sxtDescripcion;
     private Integer sxtDolor;

    public SintomaTerapia() {
    }

	
    public SintomaTerapia(Sintoma sintoma, Terapia terapia) {
        this.sintoma = sintoma;
        this.terapia = terapia;
    }
    public SintomaTerapia(Sintoma sintoma, Terapia terapia, String sxtDescripcion, Integer sxtDolor) {
       this.sintoma = sintoma;
       this.terapia = terapia;
       this.sxtDescripcion = sxtDescripcion;
       this.sxtDolor = sxtDolor;
    }
   
    public Integer getSxtCodigo() {
        return this.sxtCodigo;
    }
    
    public void setSxtCodigo(Integer sxtCodigo) {
        this.sxtCodigo = sxtCodigo;
    }
    public Sintoma getSintoma() {
        return this.sintoma;
    }
    
    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }
    public Terapia getTerapia() {
        return this.terapia;
    }
    
    public void setTerapia(Terapia terapia) {
        this.terapia = terapia;
    }
    public String getSxtDescripcion() {
        return this.sxtDescripcion;
    }
    
    public void setSxtDescripcion(String sxtDescripcion) {
        this.sxtDescripcion = sxtDescripcion;
    }
    public Integer getSxtDolor() {
        return this.sxtDolor;
    }
    
    public void setSxtDolor(Integer sxtDolor) {
        this.sxtDolor = sxtDolor;
    }




}


