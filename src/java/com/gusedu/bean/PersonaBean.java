// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc 
// Source File Name:   PersonaBean.java

package com.gusedu.bean;

import com.gusedu.dao.impl.PersonaServiceImpl;
import com.gusedu.model.Persona;
import com.gusedu.dao.PersonaService;
import com.gusedu.util.StaticUtil;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.primefaces.context.RequestContext;

// Referenced classes of package com.gusedu.bean:
//            PacienteBean
@ManagedBean
@SessionScoped
public class PersonaBean {

            PersonaService personaService;
            private List listaTerapeutas;
            private Persona persona;

            public PersonaBean() {
/*  36*/        persona = new Persona();
               
            }

            @PostConstruct
            public void init() {
/*  43*/        personaService = new PersonaServiceImpl();
/*  44*/        listaTerapeutas = personaService.getTerapeutas();
            }

            public List getListaTerapeutas() {
/*  48*/        return listaTerapeutas;
            }

            public Persona getPersona() {
/*  52*/        return persona;
            }

            public void setPersona(Persona persona) {
/*  56*/        this.persona = persona;
            }

     public void registroPacienteV2() {
         String empresa = StaticUtil.userLogged();
         RequestContext context = RequestContext.getCurrentInstance();
         FacesContext fc = FacesContext.getCurrentInstance();
         PacienteBean objetoBean = (PacienteBean)fc.getExternalContext().getSessionMap().get("pacienteBean");
         
         UbigoBean ubigeoBean  = (UbigoBean)fc.getExternalContext().getSessionMap().get("ubigoBean");
         persona.setPerDepartamento(ubigeoBean.getIdDepartamento());
         persona.setPerProvincia(ubigeoBean.getIdProvincia());
         persona.setPerDistrito(ubigeoBean.getIdDistrito());
         
        if( personaService.validarDni(persona.getPerDni())==false)
        {
            StaticUtil.errorMessage("Advertencia", "Ya existe una persona registrada con este DNI");
            StaticUtil.keepMessages();
            return ;
        }
         
         if (personaService.registroPaciente(persona, empresa)) {
             persona = new Persona();
             StaticUtil.correctMesage("Éxito", "Se ha registrado correctamente al paciente");
            StaticUtil.keepMessages();
            context.execute("PF('dlg1').hide();");
                } else {
           System.out.println("Error Fatal");
            persona = new Persona();

                }
         objetoBean.listado();
       
  
          
            }

            public void cancel() {
/*  83*/        RequestContext context = RequestContext.getCurrentInstance();
/*  84*/        context.execute("PF('dlg1').hide();");
/*  85*/        persona = new Persona();
            }

            public void valida() {
/*  90*/        FacesContext fc = FacesContext.getCurrentInstance();
/*  92*/       
                //query= fc.getExternalContext().getSessionMap().get("query").toString();
                if(fc.getExternalContext().getSessionMap().get("query")!=null)
                {
                     String query = fc.getExternalContext().getSessionMap().get("query").toString();
                  if (StaticUtil.esSoloNumero(query)) {
/*  95*/            persona.setPerDni(query);
/*  96*/            persona.setPerNombres("");
                } else {
/*  99*/            persona.setPerNombres((new StringBuilder()).append(query.substring(0, 1).toUpperCase()).append(query.substring(1).toLowerCase()).toString());
/* 100*/            persona.setPerDni("");
                }
                }
                
            }
            
     
            public void validaDni(String dni)                    
            {
              
                System.out.println("Hola ^_^");
              boolean valor=  personaService.validarDni(dni);
              if(valor)
              {
                  System.out.println("It's true");
              }else
              {
                  System.out.println("It's false");
              }
                
            }
            
}
