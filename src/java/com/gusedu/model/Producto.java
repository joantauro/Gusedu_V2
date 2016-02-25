package com.gusedu.model;
// Generated 18/02/2016 11:27:55 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private Integer proCodigo;
     private Modelo modelo;
     private TipoProducto tipoProducto;
     private UnidadMedida unidadMedida;
     private Double proCostoUnitario;
     private String proCurrencySymbol;
     private String proDescripcionC;
     private String proDescripcionL;
     private String proDescripcionM;
     private Double proExistencias;
     private String proSku;
     private String proUrlImagen;
     private Set productoVisitas = new HashSet(0);
     private Set productoVisitas_1 = new HashSet(0);

    public Producto() {
    }

	
    public Producto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    public Producto(Modelo modelo, TipoProducto tipoProducto, UnidadMedida unidadMedida, Double proCostoUnitario, String proCurrencySymbol, String proDescripcionC, String proDescripcionL, String proDescripcionM, Double proExistencias, String proSku, String proUrlImagen, Set productoVisitas, Set productoVisitas_1) {
       this.modelo = modelo;
       this.tipoProducto = tipoProducto;
       this.unidadMedida = unidadMedida;
       this.proCostoUnitario = proCostoUnitario;
       this.proCurrencySymbol = proCurrencySymbol;
       this.proDescripcionC = proDescripcionC;
       this.proDescripcionL = proDescripcionL;
       this.proDescripcionM = proDescripcionM;
       this.proExistencias = proExistencias;
       this.proSku = proSku;
       this.proUrlImagen = proUrlImagen;
       this.productoVisitas = productoVisitas;
       this.productoVisitas_1 = productoVisitas_1;
    }
   
    public Integer getProCodigo() {
        return this.proCodigo;
    }
    
    public void setProCodigo(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }
    public Modelo getModelo() {
        return this.modelo;
    }
    
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    public TipoProducto getTipoProducto() {
        return this.tipoProducto;
    }
    
    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    public UnidadMedida getUnidadMedida() {
        return this.unidadMedida;
    }
    
    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    public Double getProCostoUnitario() {
        return this.proCostoUnitario;
    }
    
    public void setProCostoUnitario(Double proCostoUnitario) {
        this.proCostoUnitario = proCostoUnitario;
    }
    public String getProCurrencySymbol() {
        return this.proCurrencySymbol;
    }
    
    public void setProCurrencySymbol(String proCurrencySymbol) {
        this.proCurrencySymbol = proCurrencySymbol;
    }
    public String getProDescripcionC() {
        return this.proDescripcionC;
    }
    
    public void setProDescripcionC(String proDescripcionC) {
        this.proDescripcionC = proDescripcionC;
    }
    public String getProDescripcionL() {
        return this.proDescripcionL;
    }
    
    public void setProDescripcionL(String proDescripcionL) {
        this.proDescripcionL = proDescripcionL;
    }
    public String getProDescripcionM() {
        return this.proDescripcionM;
    }
    
    public void setProDescripcionM(String proDescripcionM) {
        this.proDescripcionM = proDescripcionM;
    }
    public Double getProExistencias() {
        return this.proExistencias;
    }
    
    public void setProExistencias(Double proExistencias) {
        this.proExistencias = proExistencias;
    }
    public String getProSku() {
        return this.proSku;
    }
    
    public void setProSku(String proSku) {
        this.proSku = proSku;
    }
    public String getProUrlImagen() {
        return this.proUrlImagen;
    }
    
    public void setProUrlImagen(String proUrlImagen) {
        this.proUrlImagen = proUrlImagen;
    }
    public Set getProductoVisitas() {
        return this.productoVisitas;
    }
    
    public void setProductoVisitas(Set productoVisitas) {
        this.productoVisitas = productoVisitas;
    }
    public Set getProductoVisitas_1() {
        return this.productoVisitas_1;
    }
    
    public void setProductoVisitas_1(Set productoVisitas_1) {
        this.productoVisitas_1 = productoVisitas_1;
    }




}


