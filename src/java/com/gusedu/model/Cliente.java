package com.gusedu.model;
// Generated 18/02/2016 11:27:55 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer cliCodigo;
     private Persona persona;
     private TipoCliente tipoCliente;
     private String cliAlergia;
     private String cliCanRegular;
     private String cliCirugiaEstetica;
     private String cliDolcabRegular;
     private Boolean cliActivo;
     private Date cliFecCreacion;
     private String cliProGastrico;
     private String cliMedicamentos;
     private String cliOperacion;
     private String cliResRegular;
     private String cliUsuCreacion;
     private String cliAlcohol;
     private String cliEjercicio;
     private String cliHabitos;
     private String cliHijos;
     private String cliOcupacion;
     private Set visitas = new HashSet(0);
     private Set visitas_1 = new HashSet(0);

    public Cliente() {
    }

	
    public Cliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public Cliente(Persona persona, TipoCliente tipoCliente, String cliAlergia, String cliCanRegular, String cliCirugiaEstetica, String cliDolcabRegular, Boolean cliActivo, Date cliFecCreacion, String cliProGastrico, String cliMedicamentos, String cliOperacion, String cliResRegular, String cliUsuCreacion, String cliAlcohol, String cliEjercicio, String cliHabitos, String cliHijos, String cliOcupacion, Set visitas, Set visitas_1) {
       this.persona = persona;
       this.tipoCliente = tipoCliente;
       this.cliAlergia = cliAlergia;
       this.cliCanRegular = cliCanRegular;
       this.cliCirugiaEstetica = cliCirugiaEstetica;
       this.cliDolcabRegular = cliDolcabRegular;
       this.cliActivo = cliActivo;
       this.cliFecCreacion = cliFecCreacion;
       this.cliProGastrico = cliProGastrico;
       this.cliMedicamentos = cliMedicamentos;
       this.cliOperacion = cliOperacion;
       this.cliResRegular = cliResRegular;
       this.cliUsuCreacion = cliUsuCreacion;
       this.cliAlcohol = cliAlcohol;
       this.cliEjercicio = cliEjercicio;
       this.cliHabitos = cliHabitos;
       this.cliHijos = cliHijos;
       this.cliOcupacion = cliOcupacion;
       this.visitas = visitas;
       this.visitas_1 = visitas_1;
    }
   
    public Integer getCliCodigo() {
        return this.cliCodigo;
    }
    
    public void setCliCodigo(Integer cliCodigo) {
        this.cliCodigo = cliCodigo;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public TipoCliente getTipoCliente() {
        return this.tipoCliente;
    }
    
    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public String getCliAlergia() {
        return this.cliAlergia;
    }
    
    public void setCliAlergia(String cliAlergia) {
        this.cliAlergia = cliAlergia;
    }
    public String getCliCanRegular() {
        return this.cliCanRegular;
    }
    
    public void setCliCanRegular(String cliCanRegular) {
        this.cliCanRegular = cliCanRegular;
    }
    public String getCliCirugiaEstetica() {
        return this.cliCirugiaEstetica;
    }
    
    public void setCliCirugiaEstetica(String cliCirugiaEstetica) {
        this.cliCirugiaEstetica = cliCirugiaEstetica;
    }
    public String getCliDolcabRegular() {
        return this.cliDolcabRegular;
    }
    
    public void setCliDolcabRegular(String cliDolcabRegular) {
        this.cliDolcabRegular = cliDolcabRegular;
    }
    public Boolean getCliActivo() {
        return this.cliActivo;
    }
    
    public void setCliActivo(Boolean cliActivo) {
        this.cliActivo = cliActivo;
    }
    public Date getCliFecCreacion() {
        return this.cliFecCreacion;
    }
    
    public void setCliFecCreacion(Date cliFecCreacion) {
        this.cliFecCreacion = cliFecCreacion;
    }
    public String getCliProGastrico() {
        return this.cliProGastrico;
    }
    
    public void setCliProGastrico(String cliProGastrico) {
        this.cliProGastrico = cliProGastrico;
    }
    public String getCliMedicamentos() {
        return this.cliMedicamentos;
    }
    
    public void setCliMedicamentos(String cliMedicamentos) {
        this.cliMedicamentos = cliMedicamentos;
    }
    public String getCliOperacion() {
        return this.cliOperacion;
    }
    
    public void setCliOperacion(String cliOperacion) {
        this.cliOperacion = cliOperacion;
    }
    public String getCliResRegular() {
        return this.cliResRegular;
    }
    
    public void setCliResRegular(String cliResRegular) {
        this.cliResRegular = cliResRegular;
    }
    public String getCliUsuCreacion() {
        return this.cliUsuCreacion;
    }
    
    public void setCliUsuCreacion(String cliUsuCreacion) {
        this.cliUsuCreacion = cliUsuCreacion;
    }
    public String getCliAlcohol() {
        return this.cliAlcohol;
    }
    
    public void setCliAlcohol(String cliAlcohol) {
        this.cliAlcohol = cliAlcohol;
    }
    public String getCliEjercicio() {
        return this.cliEjercicio;
    }
    
    public void setCliEjercicio(String cliEjercicio) {
        this.cliEjercicio = cliEjercicio;
    }
    public String getCliHabitos() {
        return this.cliHabitos;
    }
    
    public void setCliHabitos(String cliHabitos) {
        this.cliHabitos = cliHabitos;
    }
    public String getCliHijos() {
        return this.cliHijos;
    }
    
    public void setCliHijos(String cliHijos) {
        this.cliHijos = cliHijos;
    }
    public String getCliOcupacion() {
        return this.cliOcupacion;
    }
    
    public void setCliOcupacion(String cliOcupacion) {
        this.cliOcupacion = cliOcupacion;
    }
    public Set getVisitas() {
        return this.visitas;
    }
    
    public void setVisitas(Set visitas) {
        this.visitas = visitas;
    }
    public Set getVisitas_1() {
        return this.visitas_1;
    }
    
    public void setVisitas_1(Set visitas_1) {
        this.visitas_1 = visitas_1;
    }




}


