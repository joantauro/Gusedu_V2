package com.gusedu.model;
// Generated 15/09/2015 11:54:43 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Mensaje generated by hbm2java
 */
public class Mensaje  implements java.io.Serializable {


     private Integer menCodigo;
     private Usuario usuarioByUsuCodigoReceptor;
     private Usuario usuarioByUsuCodigoEmisor;
     private Boolean menLeido;
     private Date menFecEnviado;
     private String menTexto;
     private String menTitulo;

    public Mensaje() {
    }

	
    public Mensaje(Usuario usuarioByUsuCodigoReceptor, Usuario usuarioByUsuCodigoEmisor) {
        this.usuarioByUsuCodigoReceptor = usuarioByUsuCodigoReceptor;
        this.usuarioByUsuCodigoEmisor = usuarioByUsuCodigoEmisor;
    }
    public Mensaje(Usuario usuarioByUsuCodigoReceptor, Usuario usuarioByUsuCodigoEmisor, Boolean menLeido, Date menFecEnviado, String menTexto, String menTitulo) {
       this.usuarioByUsuCodigoReceptor = usuarioByUsuCodigoReceptor;
       this.usuarioByUsuCodigoEmisor = usuarioByUsuCodigoEmisor;
       this.menLeido = menLeido;
       this.menFecEnviado = menFecEnviado;
       this.menTexto = menTexto;
       this.menTitulo = menTitulo;
    }
   
    public Integer getMenCodigo() {
        return this.menCodigo;
    }
    
    public void setMenCodigo(Integer menCodigo) {
        this.menCodigo = menCodigo;
    }
    public Usuario getUsuarioByUsuCodigoReceptor() {
        return this.usuarioByUsuCodigoReceptor;
    }
    
    public void setUsuarioByUsuCodigoReceptor(Usuario usuarioByUsuCodigoReceptor) {
        this.usuarioByUsuCodigoReceptor = usuarioByUsuCodigoReceptor;
    }
    public Usuario getUsuarioByUsuCodigoEmisor() {
        return this.usuarioByUsuCodigoEmisor;
    }
    
    public void setUsuarioByUsuCodigoEmisor(Usuario usuarioByUsuCodigoEmisor) {
        this.usuarioByUsuCodigoEmisor = usuarioByUsuCodigoEmisor;
    }
    public Boolean getMenLeido() {
        return this.menLeido;
    }
    
    public void setMenLeido(Boolean menLeido) {
        this.menLeido = menLeido;
    }
    public Date getMenFecEnviado() {
        return this.menFecEnviado;
    }
    
    public void setMenFecEnviado(Date menFecEnviado) {
        this.menFecEnviado = menFecEnviado;
    }
    public String getMenTexto() {
        return this.menTexto;
    }
    
    public void setMenTexto(String menTexto) {
        this.menTexto = menTexto;
    }
    public String getMenTitulo() {
        return this.menTitulo;
    }
    
    public void setMenTitulo(String menTitulo) {
        this.menTitulo = menTitulo;
    }




}

