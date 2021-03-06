// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc 
// Source File Name:   PacienteBean.java

package com.gusedu.bean;

import com.gusedu.dao.ClienteService;
import com.gusedu.dao.PersonaService;
import com.gusedu.dao.impl.ClienteServiceImpl;
import com.gusedu.dao.impl.PersonaServiceImpl;
import com.gusedu.estadistica.EUltimaVisita;
import com.gusedu.model.Cliente;
import com.gusedu.model.Persona;
import com.gusedu.model.TipoCliente;
 
import com.gusedu.util.StaticUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

// Referenced classes of package com.gusedu.bean:
//            VisitaBean

@ManagedBean
@SessionScoped
public class PacienteBean {

            ClienteService clienteService;
            PersonaService personaservice;
            private Cliente cliente;
            //private List<Cliente> clientes;
            private List<EUltimaVisita> clientesxfecha;
            
            private String query;
            

            public PacienteBean() {
                clienteService= new ClienteServiceImpl();
                personaservice = new PersonaServiceImpl();
/*  42*/        cliente = new Cliente();
/*  43*/        cliente.setPersona(new Persona());
/*  44*/        cliente.setTipoCliente(new TipoCliente());
/*  46*/        query = "";
     
            }
            
            @PostConstruct
            public void init() {
/*  56*/        listado();
            }

            public void prueba(Cliente cli) {
/*  61*/        cliente=cli;
                System.out.println(cli.getPersona().getPerNombres());
/*  62*/        FacesContext fc = FacesContext.getCurrentInstance();
/*  63*/        fc.getExternalContext().getSessionMap().put("cliente", getCliente());
/*  65*/        VisitaBean objetoBean = (VisitaBean)fc.getExternalContext().getSessionMap().get("visitaBean");
/*  66*/        objetoBean.lastvisita(getCliente());
            }

            public void cargaCliente(int codcliente)
            {
                System.out.println("COD_CLIENTE : "+codcliente);
                cliente=clienteService.getClienteById(codcliente);
                
/*  62*/        FacesContext fc = FacesContext.getCurrentInstance();
/*  63*/        fc.getExternalContext().getSessionMap().put("cliente", getCliente());
/*  65*/        VisitaBean objetoBean = (VisitaBean)fc.getExternalContext().getSessionMap().get("visitaBean");
/*  66*/        objetoBean.lastvisita(getCliente());
            }
            
            public void listado() {
/*  71*/        clienteService = new ClienteServiceImpl();
/*  72*/        String username = StaticUtil.userLogged();
/*  73*/     //   clientes = clienteService.getClientesPacientesByUsuario(username);
                clientesxfecha = clienteService.getListaUltimaVisita(username);
            }

            
         /*   public List<Cliente> getClientes() {
                 return clientes;
            }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }*/
            
            
            
            public String getQuery() {
/*  77*/        return query;
            }

            public void setQuery(String query) {
/*  81*/        this.query = query;
            }

            public Cliente getCliente() {
/*  89*/        return cliente;
            }

            public void setCliente(Cliente cliente) {
/*  96*/        this.cliente = cliente;
            }

            public void editar2() {
                
        if (personaservice.updatePersona(cliente.getPersona())) {
            FacesContext fc = FacesContext.getCurrentInstance();
            VisitaBean objetoBean = (VisitaBean)fc.getExternalContext().getSessionMap().get("visitaBean");
                    ScheduleView oscheduleBean =new ScheduleView();
            objetoBean.probando();
                    oscheduleBean.listado();
            StaticUtil.correctMesage("Éxito", "Se ha actualizado correctamente");
            StaticUtil.keepMessages();
            cliente = new Cliente();
                    cliente.setPersona(new Persona());
                } else {
            StaticUtil.errorMessage("Error", "No se pudo actualizar");
                    StaticUtil.keepMessages();
                }
            }

            public void filtrarBusqueda() {
/* 117*/        String username = StaticUtil.userLogged();
/* 118*/        System.out.println("Entro a filtrar Busqueda :O");
/* 119*/        clientesxfecha = clienteService.getListaUltimaVisita(username);
/* 120*/        List filtrados = new ArrayList();
/* 121*/        Iterator iterator = clientesxfecha.iterator();
/* 121*/        do {
/* 121*/            if (!iterator.hasNext()) {
/* 121*/                break;
                    }
/* 121*/            EUltimaVisita c = (EUltimaVisita)iterator.next();
/* 122*/            if (c.getApellidoPPersona().toLowerCase().contains(query.toLowerCase()) || c.getApellidoMPersona().toLowerCase().contains(query.toLowerCase()) || c.getNombresPersona().toLowerCase().contains(query.toLowerCase())) {
/* 128*/                filtrados.add(c);
                    }
                } while (true);
/* 131*/        clientesxfecha = filtrados;
/* 132*/        enviarQuery();
            }

            public void enviarQuery() {
/* 136*/        FacesContext fc = FacesContext.getCurrentInstance();
/* 137*/        fc.getExternalContext().getSessionMap().put("query", query);
/* 138*/        System.out.println("Enviando query....");
            }

    public List<EUltimaVisita> getClientesxfecha() {
        return clientesxfecha;
    }

    public void setClientesxfecha(List<EUltimaVisita> clientesxfecha) {
        this.clientesxfecha = clientesxfecha;
    }
            
  public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }       
}
