package com.gusedu.model;
// Generated 15/09/2015 11:54:43 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Sintoma generated by hbm2java
 */
public class Sintoma  implements java.io.Serializable {


     private Integer sinCodigo;
     private String sinDescripcion;
     private Set sintomaTerapias = new HashSet(0);
     private Set sintomaVisitas = new HashSet(0);
     private Set sintomaPars = new HashSet(0);

    public Sintoma() {
    }

    public Sintoma(String sinDescripcion, Set sintomaTerapias, Set sintomaVisitas, Set sintomaPars) {
       this.sinDescripcion = sinDescripcion;
       this.sintomaTerapias = sintomaTerapias;
       this.sintomaVisitas = sintomaVisitas;
       this.sintomaPars = sintomaPars;
    }
   
    public Integer getSinCodigo() {
        return this.sinCodigo;
    }
    
    public void setSinCodigo(Integer sinCodigo) {
        this.sinCodigo = sinCodigo;
    }
    public String getSinDescripcion() {
        return this.sinDescripcion;
    }
    
    public void setSinDescripcion(String sinDescripcion) {
        this.sinDescripcion = sinDescripcion;
    }
    public Set getSintomaTerapias() {
        return this.sintomaTerapias;
    }
    
    public void setSintomaTerapias(Set sintomaTerapias) {
        this.sintomaTerapias = sintomaTerapias;
    }
    public Set getSintomaVisitas() {
        return this.sintomaVisitas;
    }
    
    public void setSintomaVisitas(Set sintomaVisitas) {
        this.sintomaVisitas = sintomaVisitas;
    }
    public Set getSintomaPars() {
        return this.sintomaPars;
    }
    
    public void setSintomaPars(Set sintomaPars) {
        this.sintomaPars = sintomaPars;
    }




}


