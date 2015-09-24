// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc 
// Source File Name:   PuntoServiceImpl.java

package com.gusedu.dao.impl;

import com.gusedu.dao.PuntoService;
import com.gusedu.model.Punto;
import com.gusedu.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.Query;
import org.hibernate.Session;

public class PuntoServiceImpl
    implements PuntoService, Serializable {

            private static final long serialVersionUID = 1L;
            EntityManager em;


            public List<Punto> getAllPuntos() {
         List<Punto> result = new ArrayList();
                Session sesion = HibernateUtil.getSessionFactory().openSession();
        //Transaction tx = null;
        try {
             //tx = sesion.beginTransaction();
              String sql = "SELECT p FROM Punto p";
           Query q = sesion.createQuery(sql);
            result = q.list();
            for(int i=0;i<result.size();i++)
            {
                System.out.println(result.get(i).getPunCodigo());
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
           String sql = "SELECT p FROM Punto p";
           Query q = sesion.createQuery(sql);
            result = q.list();
                }
        catch (NoResultException e) {
            System.out.println((new StringBuilder()).append("ERROR de paresByPunto: ").append(e.getMessage()).toString());
                }*/
           return result;
            }

            public Punto puntoById(Integer id) {
/*  47*/        return (Punto)em.find(Punto.class, id);
            }

            public Boolean savePunto(Punto punto) {
/*  52*/        boolean resultado = false;
/*  60*/        return Boolean.valueOf(resultado);
            }

            public Boolean updatePunto(Punto punto) {
/*  65*/        boolean resultado = false;
/*  73*/        return Boolean.valueOf(resultado);
            }

            public Boolean deletePunto(Punto punto) {
/*  78*/        boolean resultado = false;
/*  86*/        return Boolean.valueOf(resultado);
            }

            public Punto puntoByNombre(String nombrePunto) {
         Punto result = null;
         Session sesion = HibernateUtil.getSessionFactory().openSession();
        //Transaction tx = null;
        try {
             //tx = sesion.beginTransaction();
             String sql = "SELECT p FROM Punto p WHERE p.punNombre=:nombre";
             Query q = sesion.createQuery(sql);
             q.setParameter("nombre", nombrePunto);
            result = (Punto)q.uniqueResult();
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
            String sql = "SELECT p FROM Punto p WHERE p.punNombre=:nombre";
             Query q = sesion.createQuery(sql);
             q.setParameter("nombre", nombrePunto);
            result = (Punto)q.uniqueResult();
                }
         catch (NoResultException e) {
             System.out.println((new StringBuilder()).append("ERROR de paresByPunto: ").append(e.getMessage()).toString());
             result = null;
                }*/
         return result;
            }

            public List<Punto> getAllOrdenAlfabeticoAsc() {
/* 109*/        List<Punto> result = new ArrayList();

                Session sesion = HibernateUtil.getSessionFactory().openSession();
        //Transaction tx = null;
        try {
             //tx = sesion.beginTransaction();
              String sql = "SELECT p FROM Punto p  order by p.punNombre asc";
           Query q = sesion.createQuery(sql);
           result = q.list();
            for(int i=0;i<result.size();i++)
            {
                System.out.println(result.get(i).getPunCodigo());
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



       /*try {
            String sql = "SELECT p FROM Punto p  order by p.punNombre asc";
           Query q = sesion.createQuery(sql);
           result = q.list();
                }
       catch (NoResultException e) {
            System.out.println((new StringBuilder()).append("ERROR de paresByPunto: ").append(e.getMessage()).toString());
                }*/
        return result;
            }

            public List<Punto> getAllOrdenAlfabeticoDesc() {
/* 125*/        List<Punto> result = new ArrayList();
/* 132*/        return result;
            }

            public List<Punto> getAllOrdenGoiz() {
/* 138*/        List<Punto> result = new ArrayList();
/* 145*/        return result;
            }

            public List<Punto> getAllPuntosRastreables() {
/* 151*/        List<Punto> result = new ArrayList();
/* 158*/        return result;
            }
}
