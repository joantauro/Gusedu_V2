/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusedu.bean;

import com.gusedu.dao.ClienteService;
import com.gusedu.dao.VisitaService;
import com.gusedu.dao.impl.ClienteServiceImpl;
import com.gusedu.dao.impl.VisitaServiceImpl;
import com.gusedu.model.Cliente;
import com.gusedu.model.Persona;
import com.gusedu.model.Terapia;
import com.gusedu.model.TipoCliente;
import com.gusedu.model.TipoTerapia;
import com.gusedu.model.Visita;
import com.gusedu.util.StaticUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Joel Romero Guillén
 */
@ManagedBean
@SessionScoped
public class ScheduleView {

    /**
     * Creates a new instance of ScheduleView
     */
    
    private ScheduleModel eventModel;   
    private ScheduleModel lazyEventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    
    VisitaService visitaService;
    private List<Visita> listaVisita;
    
    private Cliente cli;
    private String nombre;
    private int codigo;
    
    private Visita visita;
    private Terapia terapia;
    
    ClienteService clienteService;
    
    public ScheduleView() {
        visitaService = new VisitaServiceImpl();
        clienteService= new ClienteServiceImpl();
        cli = new Cliente();
        cli.setPersona(new Persona());
        cli.setTipoCliente(new TipoCliente());
        nombre="";
        
        visita = new Visita();
        visita.setCliente(new Cliente());
        
        terapia = new Terapia();
        terapia.setTipoTerapia(new TipoTerapia());
        terapia.setVisita(new Visita());
   
    }
    
     @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        
        listaVisita=visitaService.getVisitasByEmpresa();   
        
        for ( int i=0;i<listaVisita.size();i++)
        {
             Date fecE= listaVisita.get(i).getVisFecCreacion();
             Date fecF= listaVisita.get(i).getVisFecFin();
             String pac=listaVisita.get(i).getCliente().getPersona().getPerNombres()+" "+
                        listaVisita.get(i).getCliente().getPersona().getPerApellidoP()+" "+
                        listaVisita.get(i).getCliente().getPersona().getPerApellidoM(); 
             eventModel.addEvent(new DefaultScheduleEvent(pac,fecE,fecF,listaVisita.get(i).getCliente()));
             
             /*
             DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     String convertido = fechaHora.format(fecE);
             Date fecI=fecE;
             SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             
                     Date fecha = null;
            try {
                fecha = formatoDelTexto.parse(convertido);
                 Date fecA= fecE;
                 Calendar calendar = Calendar.getInstance();
                calendar.setTime(fecA); 
                calendar.add(Calendar.MINUTE, 30);
                  
                eventModel.addEvent(new DefaultScheduleEvent("Visite", fecE, calendar.getTime()));
            } catch (ParseException ex) {

                ex.printStackTrace();

            }*/
        }
        
 
    }

    public void listado()
    {
        eventModel = new DefaultScheduleModel();
        
        listaVisita=visitaService.getVisitasByEmpresa();   
        
        for ( int i=0;i<listaVisita.size();i++)
        {
             Date fecE= listaVisita.get(i).getVisFecCreacion();
             Date fecF= listaVisita.get(i).getVisFecFin();
             String pac=listaVisita.get(i).getCliente().getPersona().getPerNombres()+" "+
                        listaVisita.get(i).getCliente().getPersona().getPerApellidoP()+" "+
                        listaVisita.get(i).getCliente().getPersona().getPerApellidoM(); 
             eventModel.addEvent(new DefaultScheduleEvent(pac,fecE,fecF,listaVisita.get(i).getCliente()));
        }
    }
    public void paciente()
    { 
        cli = clienteService.getClienteById(codigo);
    }

    
    public void prueba(){
        listaVisita=visitaService.getVisitas(); 
          for ( int i=0;i<listaVisita.size();i++)
        {
             Date fecE= listaVisita.get(i).getVisFecCreacion();
             Date fecA= listaVisita.get(i).getVisFecCreacion();
             fecA.setDate(26);
             System.out.println("VISITA : "+fecE + "-"+fecA);
        }
    }
    
    public List<Visita> getListaVisita() {
        return listaVisita;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Visita getVisita() {
        return visita;
    }

    public void setVisita(Visita visita) {
        this.visita = visita;
    }

    public Terapia getTerapia() {
        return terapia;
    }

    public void setTerapia(Terapia terapia) {
        this.terapia = terapia;
    }

    
    
    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    public void setLazyEventModel(ScheduleModel lazyEventModel) {
        this.lazyEventModel = lazyEventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
    
 
     
    public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null)
        {    
            
            eventModel.addEvent(event);
            // saveVisita();
            saveVisitaSP();
             listado();
        } else{
            eventModel.updateEvent(event);
        }
        event = new DefaultScheduleEvent();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
         cli= ((Cliente)event.getData()); 
     
        visita.setVisFecCreacion(event.getStartDate());
        visita.setVisFecFin(event.getEndDate());
        
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
         visita.setVisFecCreacion(event.getStartDate());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(event.getEndDate()); 
        calendar.add(Calendar.MINUTE, 30);
        visita.setVisFecFin(calendar.getTime());
        System.out.println("FECHA INICIO : "+ visita.getVisFecCreacion() +"|| FECHA FIN : "+visita.getVisFecFin());
    }
     
    
    public void saveVisita()
    {
         visita.setVisPresencial(Boolean.valueOf(true));
        visita.setVisPrioridad(Integer.valueOf(2));
        visita.setVisEstado(Integer.valueOf(1));
        visita.setCliente(cli);
           String usuarioCreacion = StaticUtil.userLogged();
         visita.setVisUsuCreacion(usuarioCreacion);
         visita.setVisCostoTotal(Double.valueOf(0.0D));
        visitaService.saveVisita(visita);
        visita= new Visita();
    }
    
    public void saveVisitaSP()
    {
        visita.setVisPresencial(true);
        visita.setVisPrioridad(2);
        visita.setVisEstado(1);
        visita.setCliente(cli);
        String usuarioCreacion = StaticUtil.userLogged();
        visita.setVisUsuCreacion(usuarioCreacion);
        visita.setVisCostoTotal(0.0);
        System.out.println("vis_fec_creacion : " +visita.getVisFecCreacion()+"\n"+
                "vis_usu_creacion : " +visita.getVisUsuCreacion()+"\n"+
                "cli_codigo : " +visita.getCliente().getCliCodigo()+"\n"+
                "vis_descripcion : " +visita.getVisDescripcion()+"\n"+
                "vis_fec_fin : " +visita.getVisFecFin()+"\n"+
                "USU_CREACION : " +terapia.getTerUsuCreacion()+"\n"+
                "TTE_CODIGO : " +visita.getVisFecCreacion()+"\n"+
                "TER_COSTO : " +visita.getVisFecCreacion()+"\n");
        visitaService.SPsaveVisitaxTerapia(visita, terapia);
    }
            
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
