package com.gusedu.model;
// Generated 15/09/2015 11:54:43 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Visita generated by hbm2java
 */
public class Visita  implements java.io.Serializable {


     private Integer visCodigo;
     private Cliente cliente;
     private Double visCostoTotal;
     private Boolean visPresencial;
     private Integer visEstado;
     private Date visFecCreacion;
     private Integer visPrioridad;
     private String visUsuCreacion;
     private String visDescripcion;
     private Set enfermedadVisitas = new HashSet(0);
     private Set terapias = new HashSet(0);
     private Set productoVisitas = new HashSet(0);
     private Set sintomaVisitas = new HashSet(0);
     private Set historiaClinicas = new HashSet(0);

    public Visita() {
    }

	
    public Visita(Cliente cliente) {
        this.cliente = cliente;
    }
    public Visita(Cliente cliente, Double visCostoTotal, Boolean visPresencial, Integer visEstado, Date visFecCreacion, Integer visPrioridad, String visUsuCreacion, String visDescripcion, Set enfermedadVisitas, Set terapias, Set productoVisitas, Set sintomaVisitas, Set historiaClinicas) {
       this.cliente = cliente;
       this.visCostoTotal = visCostoTotal;
       this.visPresencial = visPresencial;
       this.visEstado = visEstado;
       this.visFecCreacion = visFecCreacion;
       this.visPrioridad = visPrioridad;
       this.visUsuCreacion = visUsuCreacion;
       this.visDescripcion = visDescripcion;
       this.enfermedadVisitas = enfermedadVisitas;
       this.terapias = terapias;
       this.productoVisitas = productoVisitas;
       this.sintomaVisitas = sintomaVisitas;
       this.historiaClinicas = historiaClinicas;
    }
   
    public Integer getVisCodigo() {
        return this.visCodigo;
    }
    
    public void setVisCodigo(Integer visCodigo) {
        this.visCodigo = visCodigo;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Double getVisCostoTotal() {
        return this.visCostoTotal;
    }
    
    public void setVisCostoTotal(Double visCostoTotal) {
        this.visCostoTotal = visCostoTotal;
    }
    public Boolean getVisPresencial() {
        return this.visPresencial;
    }
    
    public void setVisPresencial(Boolean visPresencial) {
        this.visPresencial = visPresencial;
    }
    public Integer getVisEstado() {
        return this.visEstado;
    }
    
    public void setVisEstado(Integer visEstado) {
        this.visEstado = visEstado;
    }
    public Date getVisFecCreacion() {
        return this.visFecCreacion;
    }
    
    public void setVisFecCreacion(Date visFecCreacion) {
        this.visFecCreacion = visFecCreacion;
    }
    public Integer getVisPrioridad() {
        return this.visPrioridad;
    }
    
    public void setVisPrioridad(Integer visPrioridad) {
        this.visPrioridad = visPrioridad;
    }
    public String getVisUsuCreacion() {
        return this.visUsuCreacion;
    }
    
    public void setVisUsuCreacion(String visUsuCreacion) {
        this.visUsuCreacion = visUsuCreacion;
    }
    public String getVisDescripcion() {
        return this.visDescripcion;
    }
    
    public void setVisDescripcion(String visDescripcion) {
        this.visDescripcion = visDescripcion;
    }
    public Set getEnfermedadVisitas() {
        return this.enfermedadVisitas;
    }
    
    public void setEnfermedadVisitas(Set enfermedadVisitas) {
        this.enfermedadVisitas = enfermedadVisitas;
    }
    public Set getTerapias() {
        return this.terapias;
    }
    
    public void setTerapias(Set terapias) {
        this.terapias = terapias;
    }
    public Set getProductoVisitas() {
        return this.productoVisitas;
    }
    
    public void setProductoVisitas(Set productoVisitas) {
        this.productoVisitas = productoVisitas;
    }
    public Set getSintomaVisitas() {
        return this.sintomaVisitas;
    }
    
    public void setSintomaVisitas(Set sintomaVisitas) {
        this.sintomaVisitas = sintomaVisitas;
    }
    public Set getHistoriaClinicas() {
        return this.historiaClinicas;
    }
    
    public void setHistoriaClinicas(Set historiaClinicas) {
        this.historiaClinicas = historiaClinicas;
    }




}


