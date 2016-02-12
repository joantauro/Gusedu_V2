/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusedu.estadistica;

import java.util.Date;

/**
 *
 * @author user
 */
public class EUltimaVisita {
    
    private int codCliente;
    private String dni;
    private String apellidoPPersona;
    private String apellidoMPersona;
    private String nombresPersona;
    private String telmovilPersona;
    private Date fechafinVisita;
    
    public EUltimaVisita()
    {
        
    }

    public EUltimaVisita(int codCliente, String dni, String apellidoPPersona, String apellidoMPersona, String nombresPersona, String telmovilPersona, Date fechafinVisita) {
        this.codCliente = codCliente;
        this.dni = dni;
        this.apellidoPPersona = apellidoPPersona;
        this.apellidoMPersona = apellidoMPersona;
        this.nombresPersona = nombresPersona;
        this.telmovilPersona = telmovilPersona;
        this.fechafinVisita = fechafinVisita;
    }

    
    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getApellidoPPersona() {
        return apellidoPPersona;
    }

    public void setApellidoPPersona(String apellidoPPersona) {
        this.apellidoPPersona = apellidoPPersona;
    }

    public String getApellidoMPersona() {
        return apellidoMPersona;
    }

    public void setApellidoMPersona(String apellidoMPersona) {
        this.apellidoMPersona = apellidoMPersona;
    }

    public String getNombresPersona() {
        return nombresPersona;
    }

    public void setNombresPersona(String nombresPersona) {
        this.nombresPersona = nombresPersona;
    }

    public String getTelmovilPersona() {
        return telmovilPersona;
    }

    public void setTelmovilPersona(String telmovilPersona) {
        this.telmovilPersona = telmovilPersona;
    }

    public Date getFechafinVisita() {
        return fechafinVisita;
    }

    public void setFechafinVisita(Date fechafinVisita) {
        this.fechafinVisita = fechafinVisita;
    }        

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
}