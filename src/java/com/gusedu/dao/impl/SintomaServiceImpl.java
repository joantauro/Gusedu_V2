// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc 
// Source File Name:   SintomaServiceImpl.java

package com.gusedu.dao.impl;

import com.gusedu.dao.SintomaService;
import com.gusedu.model.Sintoma;
import com.gusedu.model.SintomaTerapia;
import com.gusedu.util.HibernateUtil;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SintomaServiceImpl
    implements SintomaService, Serializable {

            private static final long serialVersionUID = 1L;
            EntityManager em;


            public List<Sintoma> getAll() {
                List<Sintoma> result= new ArrayList();
                
                boolean resultado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
             String sql = "SELECT s FROM Sintoma s";
/*  40*/        Query q = sesion.createQuery(sql);
/*  41*/        result = q.list();
            //tx.commit();
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
                
                 
/*  50*/        return result;
            }

            public boolean saveSintoma(Sintoma sintoma) {
                boolean resultado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.save(sintoma);
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
    
/*  73*/        return resultado;
            }

            public boolean updateSintoma(Sintoma sintoma) {
/*  78*/        boolean resultado = false;
/*  86*/        return resultado;
            }

            public boolean deleteSintoma(Sintoma sintoma) {
/*  91*/        boolean resultado = false;
/*  99*/        return resultado;
            }

            public Sintoma getById(Integer id) {
/* 104*/        return (Sintoma)em.find(Sintoma.class, id);
            }

            public Sintoma getByNombre(String nombre) {
                Sintoma result=null;
                
              

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
             String sql = "SELECT s FROM Sintoma s WHERE s.sinDescripcion=:nombre";
/* 120*/        Query q = sesion.createQuery(sql);
/* 121*/        q.setParameter("nombre", nombre);
/* 123*/        result = (Sintoma)q.uniqueResult();
            //tx.commit();
           
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
 
/* 132*/        return result;
            }

            public boolean saveSintomaTerapia(SintomaTerapia sintomaTerapia) {
/* 137*/        boolean resultado = false;
/* 145*/        return resultado;
            }

            public Sintoma lastSintoma() {
/* 150*/        Sintoma result = null;
/* 161*/        return result;
            }
}
