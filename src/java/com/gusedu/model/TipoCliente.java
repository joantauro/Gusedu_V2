package com.gusedu.model;
// Generated 15/09/2015 11:54:43 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TipoCliente generated by hbm2java
 */
public class TipoCliente  implements java.io.Serializable {


     private Integer tclCodigo;
     private String tclDescripcion;
     private Set clientes = new HashSet(0);

    public TipoCliente() {
    }

    public TipoCliente(String tclDescripcion, Set clientes) {
       this.tclDescripcion = tclDescripcion;
       this.clientes = clientes;
    }
   
    public Integer getTclCodigo() {
        return this.tclCodigo;
    }
    
    public void setTclCodigo(Integer tclCodigo) {
        this.tclCodigo = tclCodigo;
    }
    public String getTclDescripcion() {
        return this.tclDescripcion;
    }
    
    public void setTclDescripcion(String tclDescripcion) {
        this.tclDescripcion = tclDescripcion;
    }
    public Set getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Set clientes) {
        this.clientes = clientes;
    }




}

