/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusedu.bean;

import com.gusedu.dao.PagoService;
import com.gusedu.dao.impl.PagoServiceImpl;
import com.gusedu.estadistica.EPago;
import com.gusedu.model.Pago;
import com.gusedu.model.TipoPago;
import com.gusedu.model.Visita;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author NV55C
 */
@ManagedBean
@SessionScoped
public class PagoBean {

    /**
     * Creates a new instance of PagoBean
     */
    private List<TipoPago> listapagos;
    private List<Pago> listaPagoByVisita;
    PagoService pagoservice;
    private Pago pago;
    private int id_visita;
    
    private List<EPago> listaepago;
    private Date fechaini;
    private Date fechafin;
    
    public PagoBean() {
        pagoservice = new PagoServiceImpl();
        pago = new Pago();
        pago.setTipoPago(new TipoPago());
        pago.setVisita(new Visita());
        id_visita=0;
        Date currentDateTime=new Date();
        fechaini=new Date(currentDateTime.getYear(),currentDateTime.getMonth(),currentDateTime.getDate());
        fechafin=new Date(currentDateTime.getYear(),currentDateTime.getMonth(),currentDateTime.getDate());
    }

    public void inicializar()
    {
        pago = new Pago();
        pago.setTipoPago(new TipoPago());
        pago.setVisita(new Visita());
    }
    
    public void  insertarPago()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        Visita a =  (Visita) fc.getExternalContext().getSessionMap().get("visitaPago");
        int b=a.getVisCodigo();
        pago.setVisita(a);
        pagoservice.InsertPago(pago);
        inicializar();
        VisitaBean visBean = new VisitaBean();
        visBean.llenarlista(b);
    }
    
    public void updatePagos()
    {
        pagoservice.UpdatePago(pago) ;
    }
    
    public void llenarlista(int id)
    {
       id_visita=id;
       getListaPagoByVisita();
       //listaPagoByVisita= pagoservice.allPagosByVisita(id);
        System.out.println("Cantidad de Pagos : "+listaPagoByVisita.size());
        for (int i = 0; i < listaPagoByVisita.size(); i++) {
            System.out.println("MODALIDAD : "+ listaPagoByVisita.get(i).getTipoPago().getNombre() +
                               "\n MONTO :  "+ listaPagoByVisita.get(i).getMonto());
        }
    }
    
    
    public void onRowEdit(RowEditEvent event) {
        Pago p = new Pago();
        p = (Pago) event.getObject();
        pago = p;
        updatePagos();
        inicializar();
    }
    
    public void cambioFecha()
    {
        if(fechafin.before(fechaini))
        {
           // System.out.println("FECHA FIN ES ANTES QUE LA FECHA INICIAL");
            fechaini=fechafin;
        }/*else
        {
            System.out.println("FECHA INICIO ES ANTES QUE LA FECHA FIN");
        }*/
        LLENARListaPago();
    }
    
    public void LLENARListaPago()
    {
        listaepago=pagoservice.allReport(fechaini, fechafin);
    }
    
    public List<TipoPago> getListapagos() {
        listapagos=pagoservice.allTipoPagos();
        return listapagos;
    }

    public List<Pago> getListaPagoByVisita() {
        listaPagoByVisita= pagoservice.allPagosByVisita(id_visita);
        return listaPagoByVisita;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public List<EPago> getListaepago() {
        listaepago=pagoservice.allReport(fechaini, fechafin);
        return listaepago;
    }

    public void setListaepago(List<EPago> listaepago) {
        this.listaepago = listaepago;
    }

    public Date getFechaini() {
        return fechaini;
    }

    public void setFechaini(Date fechaini) {
        this.fechaini = fechaini;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }
    
    
}
