package com.gusedu.model;
// Generated 18/02/2016 11:27:55 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Modelo generated by hbm2java
 */
public class Modelo  implements java.io.Serializable {


     private Integer modCodigo;
     private Marca marca;
     private String modYearFab;
     private String modColor;
     private String modNombre;
     private String modSize;
     private Set productos = new HashSet(0);
     private Set productos_1 = new HashSet(0);

    public Modelo() {
    }

	
    public Modelo(Marca marca) {
        this.marca = marca;
    }
    public Modelo(Marca marca, String modYearFab, String modColor, String modNombre, String modSize, Set productos, Set productos_1) {
       this.marca = marca;
       this.modYearFab = modYearFab;
       this.modColor = modColor;
       this.modNombre = modNombre;
       this.modSize = modSize;
       this.productos = productos;
       this.productos_1 = productos_1;
    }
   
    public Integer getModCodigo() {
        return this.modCodigo;
    }
    
    public void setModCodigo(Integer modCodigo) {
        this.modCodigo = modCodigo;
    }
    public Marca getMarca() {
        return this.marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public String getModYearFab() {
        return this.modYearFab;
    }
    
    public void setModYearFab(String modYearFab) {
        this.modYearFab = modYearFab;
    }
    public String getModColor() {
        return this.modColor;
    }
    
    public void setModColor(String modColor) {
        this.modColor = modColor;
    }
    public String getModNombre() {
        return this.modNombre;
    }
    
    public void setModNombre(String modNombre) {
        this.modNombre = modNombre;
    }
    public String getModSize() {
        return this.modSize;
    }
    
    public void setModSize(String modSize) {
        this.modSize = modSize;
    }
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }
    public Set getProductos_1() {
        return this.productos_1;
    }
    
    public void setProductos_1(Set productos_1) {
        this.productos_1 = productos_1;
    }




}


