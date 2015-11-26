// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc 
// Source File Name:   PersonaServiceImpl.java
package com.gusedu.dao.impl;

import com.gusedu.model.*;
import com.gusedu.dao.PersonaService;
import com.gusedu.util.HibernateUtil;
import com.gusedu.util.StaticUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonaServiceImpl
        implements PersonaService, Serializable {

    EntityManager em;

    public boolean savePersona(Persona persona) {
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();

            sesion.save(persona);
            tx.commit();
            resultado = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("ERROR de saveHistoriaClinica : " + e.getMessage());
            }
            System.out.println(e.getMessage());
        } finally {
            sesion.flush();
            sesion.close();
        }
        return resultado;
    }

    public boolean updatePersona(Persona persona) {
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            if (persona.getPerFecNacimiento() != null) {
                persona.setPerSignoZodiacal(StaticUtil.signoZodiacal(persona.getPerFecNacimiento().getMonth(), persona.getPerFecNacimiento().getDate()));
            }
            sesion.merge(persona);
            tx.commit();
            resultado = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("ERROR de saveHistoriaClinica : " + e.getMessage());
            }
            System.out.println(e.getMessage());
        } finally {
            sesion.flush();
            sesion.close();
        }
        return resultado;
    }

    public boolean deletePersona(Persona persona) {
        /*  66*/ boolean resultado = false;
        /*  74*/ return resultado;
    }

    public List<Persona> getPersonas() {
        /*  80*/ List<Persona> result = new ArrayList();
        /*  87*/ return result;
    }

    @Transactional
    @Override
    public Persona getPersonaById(Integer id) {
        Persona persona = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            persona = (Persona) sesion.load(Persona.class, id);
            System.out.println("DNI : " + persona.getPerDni());
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            sesion.flush();
            sesion.close();
        }
        return persona;
    }

    @Override
    public boolean registroPaciente(Persona persona, String usernameSession) {
        boolean resultado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {

            persona.setPerFecCreacion(new Date());
            /* 102*/ tx = sesion.beginTransaction();
            /* 103*/ if (persona.getPerFecNacimiento() != null) {
                /* 104*/ persona.setPerSignoZodiacal(StaticUtil.signoZodiacal(persona.getPerFecNacimiento().getMonth(), persona.getPerFecNacimiento().getDate()));
            }
            sesion.save(persona);
            /* 108*/ Cliente cliente = new Cliente();
            /* 109*/ TipoCliente tipoCliente = new TipoCliente();
            /* 110*/ Usuario usuario = new Usuario();
            /* 111*/ String username = persona.getPerNombres().trim().substring(0, 1);
            /* 112*/ username = (new StringBuilder()).append(username).append(persona.getPerApellidoP().trim().replaceAll(" ", "")).toString();
            /* 114*/ username = username.toLowerCase();
            /* 133*/ usuario.setUsuUsuario(username);
            /* 134*/ usuario.setUsuPassword("1234");
            /* 135*/ TipoUsuario tipoUsuario = new TipoUsuario();
            /* 136*/ tipoUsuario.setTusCodigo(1);
            /* 137*/ usuario.setTipoUsuario(tipoUsuario);
            /* 138*/ tipoCliente.setTclCodigo(1);
            /* 139*/ cliente.setTipoCliente(tipoCliente);
            /* 140*/ cliente.setCliUsuCreacion(usernameSession);
            /* 141*/ persona.setPerUsuCreacion(usernameSession);
            /* 142*/ cliente.setPersona(persona);
            /* 144*/ sesion.save(cliente);
            tx.commit();
            resultado = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("ERROR de registroPaciente : " + e.getMessage());
            }
            System.out.println(e.getMessage());
        } finally {
            sesion.flush();
            sesion.close();
        }

        /* 160*/ return resultado;
    }

    public List<Terapia> terapiasPorPersona(Persona persona) {
        /* 166*/ List<Terapia> result = new ArrayList();
        /* 175*/ return result;
    }

    public Cliente buscarPorDni(String dni) {
        /* 180*/ Cliente result = null;
        /* 192*/ return result;
    }

    public List<Persona> getTerapeutas() {

        List<Persona> result = new ArrayList();
        /* 199*/ String empresa = StaticUtil.userLogged();

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        //Transaction tx = null;
        try {
            //tx = sesion.beginTransaction();
            String sql = "select p from Usuario u ,Persona  p where u.persona.perCodigo=p.perCodigo and u.tipoUsuario.tusCodigo=:terapeuta and u.usuEmpresa=:empresa";
            Query q = sesion.createQuery(sql);
            /* 205*/ if (empresa.equals("Gusedu")) {
                /* 207*/ q.setParameter("terapeuta", Integer.valueOf(2));
            } else {
                /* 210*/ q.setParameter("terapeuta", Integer.valueOf(4));
            }
            /* 212*/ q.setParameter("empresa", empresa);
            /* 213*/ result = q.list();
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).getPerNombres());
            }
            // tx.commit();

        } catch (Exception e) {
            /*if (tx != null) {
             tx.rollback();
             }   */
            System.out.println(e.getMessage());
        } finally {
            sesion.flush();
            sesion.close();
        }

        /* try {
         Query q = sesion.createQuery("select p from Usuario u ,Persona  p where u.persona.perCodigo=p.perCodigo and u.tipoUsuario.tusCodigo=:terapeuta and u.usuEmpresa=:empresa");
         if (empresa.equals("Gusedu")) {
         q.setParameter("terapeuta", Integer.valueOf(2));
         } else {
         q.setParameter("terapeuta", Integer.valueOf(4));
         }
         q.setParameter("empresa", empresa);
         result = q.list();
         }
         catch (NoResultException e) {
         System.out.println((new StringBuilder()).append("ERROR: ").append(e.getMessage()).toString());
         }*/
        return result;
    }

    @Override
    public boolean validarDni(String dni) {
        boolean result = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String sql = "select count  (perDni)  FROM Persona  WHERE perDni= :Dni ";
            Query query = sesion.createQuery(sql);
            query.setString("Dni", dni);

            int val = Integer.parseInt(query.uniqueResult().toString());
            System.out.println("Valor de val : "+val);
            System.out.println("Valor de DNI : "+dni);
            if (val == 0) {
                result = true;

            } else {
                result = false;
            }
        } catch (Exception e) {

            System.out.println("Error : "+e.getMessage());
        } finally {
            sesion.flush();
            sesion.close();
        }
        return result;
    }
}
