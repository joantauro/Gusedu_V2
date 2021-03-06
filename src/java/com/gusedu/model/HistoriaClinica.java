package com.gusedu.model;
// Generated 18/02/2016 11:27:55 AM by Hibernate Tools 4.3.1



/**
 * HistoriaClinica generated by hbm2java
 */
public class HistoriaClinica  implements java.io.Serializable {


     private Integer hclCodigo;
     private Visita visita;
     private Integer cliAgua;
     private String cliHabAlmuerzo;
     private Boolean cliAzucar;
     private String cliHabCena;
     private String hclDatosAdicionales;
     private String hclDepRegular;
     private String cliHabDesayuno;
     private Boolean cliEsVegetariano;
     private Boolean hclEmbarazo;
     private Double hclGlucosa;
     private Boolean hclQuimioterapia;
     private Double hclImc;
     private String hclMesEmbarazo;
     private Double hclPeso;
     private Boolean cliSalYodada;
     private Double hclTalla;
     private Double hclTemperatura;
     private String hclTensionArterial;
     private Boolean hclDispElectronico;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Visita visita, Integer cliAgua, String cliHabAlmuerzo, Boolean cliAzucar, String cliHabCena, String hclDatosAdicionales, String hclDepRegular, String cliHabDesayuno, Boolean cliEsVegetariano, Boolean hclEmbarazo, Double hclGlucosa, Boolean hclQuimioterapia, Double hclImc, String hclMesEmbarazo, Double hclPeso, Boolean cliSalYodada, Double hclTalla, Double hclTemperatura, String hclTensionArterial, Boolean hclDispElectronico) {
       this.visita = visita;
       this.cliAgua = cliAgua;
       this.cliHabAlmuerzo = cliHabAlmuerzo;
       this.cliAzucar = cliAzucar;
       this.cliHabCena = cliHabCena;
       this.hclDatosAdicionales = hclDatosAdicionales;
       this.hclDepRegular = hclDepRegular;
       this.cliHabDesayuno = cliHabDesayuno;
       this.cliEsVegetariano = cliEsVegetariano;
       this.hclEmbarazo = hclEmbarazo;
       this.hclGlucosa = hclGlucosa;
       this.hclQuimioterapia = hclQuimioterapia;
       this.hclImc = hclImc;
       this.hclMesEmbarazo = hclMesEmbarazo;
       this.hclPeso = hclPeso;
       this.cliSalYodada = cliSalYodada;
       this.hclTalla = hclTalla;
       this.hclTemperatura = hclTemperatura;
       this.hclTensionArterial = hclTensionArterial;
       this.hclDispElectronico = hclDispElectronico;
    }
   
    public Integer getHclCodigo() {
        return this.hclCodigo;
    }
    
    public void setHclCodigo(Integer hclCodigo) {
        this.hclCodigo = hclCodigo;
    }
    public Visita getVisita() {
        return this.visita;
    }
    
    public void setVisita(Visita visita) {
        this.visita = visita;
    }
    public Integer getCliAgua() {
        return this.cliAgua;
    }
    
    public void setCliAgua(Integer cliAgua) {
        this.cliAgua = cliAgua;
    }
    public String getCliHabAlmuerzo() {
        return this.cliHabAlmuerzo;
    }
    
    public void setCliHabAlmuerzo(String cliHabAlmuerzo) {
        this.cliHabAlmuerzo = cliHabAlmuerzo;
    }
    public Boolean getCliAzucar() {
        return this.cliAzucar;
    }
    
    public void setCliAzucar(Boolean cliAzucar) {
        this.cliAzucar = cliAzucar;
    }
    public String getCliHabCena() {
        return this.cliHabCena;
    }
    
    public void setCliHabCena(String cliHabCena) {
        this.cliHabCena = cliHabCena;
    }
    public String getHclDatosAdicionales() {
        return this.hclDatosAdicionales;
    }
    
    public void setHclDatosAdicionales(String hclDatosAdicionales) {
        this.hclDatosAdicionales = hclDatosAdicionales;
    }
    public String getHclDepRegular() {
        return this.hclDepRegular;
    }
    
    public void setHclDepRegular(String hclDepRegular) {
        this.hclDepRegular = hclDepRegular;
    }
    public String getCliHabDesayuno() {
        return this.cliHabDesayuno;
    }
    
    public void setCliHabDesayuno(String cliHabDesayuno) {
        this.cliHabDesayuno = cliHabDesayuno;
    }
    public Boolean getCliEsVegetariano() {
        return this.cliEsVegetariano;
    }
    
    public void setCliEsVegetariano(Boolean cliEsVegetariano) {
        this.cliEsVegetariano = cliEsVegetariano;
    }
    public Boolean getHclEmbarazo() {
        return this.hclEmbarazo;
    }
    
    public void setHclEmbarazo(Boolean hclEmbarazo) {
        this.hclEmbarazo = hclEmbarazo;
    }
    public Double getHclGlucosa() {
        return this.hclGlucosa;
    }
    
    public void setHclGlucosa(Double hclGlucosa) {
        this.hclGlucosa = hclGlucosa;
    }
    public Boolean getHclQuimioterapia() {
        return this.hclQuimioterapia;
    }
    
    public void setHclQuimioterapia(Boolean hclQuimioterapia) {
        this.hclQuimioterapia = hclQuimioterapia;
    }
    public Double getHclImc() {
        return this.hclImc;
    }
    
    public void setHclImc(Double hclImc) {
        this.hclImc = hclImc;
    }
    public String getHclMesEmbarazo() {
        return this.hclMesEmbarazo;
    }
    
    public void setHclMesEmbarazo(String hclMesEmbarazo) {
        this.hclMesEmbarazo = hclMesEmbarazo;
    }
    public Double getHclPeso() {
        return this.hclPeso;
    }
    
    public void setHclPeso(Double hclPeso) {
        this.hclPeso = hclPeso;
    }
    public Boolean getCliSalYodada() {
        return this.cliSalYodada;
    }
    
    public void setCliSalYodada(Boolean cliSalYodada) {
        this.cliSalYodada = cliSalYodada;
    }
    public Double getHclTalla() {
        return this.hclTalla;
    }
    
    public void setHclTalla(Double hclTalla) {
        this.hclTalla = hclTalla;
    }
    public Double getHclTemperatura() {
        return this.hclTemperatura;
    }
    
    public void setHclTemperatura(Double hclTemperatura) {
        this.hclTemperatura = hclTemperatura;
    }
    public String getHclTensionArterial() {
        return this.hclTensionArterial;
    }
    
    public void setHclTensionArterial(String hclTensionArterial) {
        this.hclTensionArterial = hclTensionArterial;
    }
    public Boolean getHclDispElectronico() {
        return this.hclDispElectronico;
    }
    
    public void setHclDispElectronico(Boolean hclDispElectronico) {
        this.hclDispElectronico = hclDispElectronico;
    }




}


