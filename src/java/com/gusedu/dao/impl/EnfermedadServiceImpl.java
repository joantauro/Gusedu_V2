// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc 
// Source File Name:   EnfermedadServiceImpl.java

package com.gusedu.dao.impl;

import com.gusedu.dao.EnfermedadService;
import com.gusedu.model.*;
import com.gusedu.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EnfermedadServiceImpl
    implements EnfermedadService, Serializable {

            private static final long serialVersionUID = 1L;
            EntityManager em;


    @Override
    public List<Enfermedad> getAll() {
        List<Enfermedad> result = new ArrayList<>();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            String sql = "SELECT e FROM Enfermedad e";
            Query q = sesion.createQuery(sql);
            result = q.list();
            //tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                System.out.println(e.getMessage());
            }
            System.out.println(e.getMessage());
        } finally {
            sesion.flush();
            sesion.close();
        }
                
                
 
/*  52*/        return result;
            }

            public boolean saveEnfermedad(Enfermedad enfermedad) {
                boolean resultado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.save(enfermedad);
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

            public boolean saveEnfermedadPar(EnfermedadPar enfermedadPar) {
/*  81*/        boolean resultado = false;
/*  89*/        return resultado;
            }

            public boolean deleteEnfermedadPar(EnfermedadPar enfermedadPar) {
/*  94*/        boolean resultado = false;
/* 103*/        return resultado;
            }

            public Enfermedad getById(Integer idEnfermedad) {
/* 108*/        return (Enfermedad)em.find(Enfermedad.class, idEnfermedad);
            }

            public EnfermedadPar getByIdPar(Integer idEnfermedadPar) {
/* 113*/        return (EnfermedadPar)em.find(EnfermedadPar.class, idEnfermedadPar);
            }

            public EnfermedadPar getByParameters(Enfermedad enfermedad, Par par) {
/* 118*/        EnfermedadPar result = null;
/* 129*/        return result;
            }

            public boolean updateEnfermedad(Enfermedad enfermedad) {
/* 134*/        boolean resultado = false;
/* 142*/        return resultado;
            }

            public boolean deleteEnfermedad(Enfermedad enfermedad) {
/* 148*/        boolean resultado = false;
/* 157*/        return resultado;
            }

            public boolean saveSintomaPar(SintomaPar sintomaPar) {
/* 162*/        boolean resultado = false;
/* 170*/        return resultado;
            }

            public boolean deleteSintomaPar(SintomaPar sintomaPar) {
/* 175*/        boolean resultado = false;
/* 184*/        return resultado;
            }

            public SintomaPar getByParameters(Sintoma sintoma, Par par) {
/* 189*/        SintomaPar result = null;
/* 200*/        return result;
            }

            public Enfermedad getByNombre(String nombre) {
                Enfermedad result=null;
               

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            String sql = "SELECT e FROM Enfermedad e WHERE e.enfNombre=:nombre";
/* 212*/        Query q = sesion.createQuery(sql);
/* 213*/        q.setParameter("nombre", nombre);
/* 214*/        result = (Enfermedad)q.uniqueResult();
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
/* 224*/        return result;
            }

            public boolean saveEnfermedadTerapia(EnfermedadTerapia enfermedadTerapia) {
/* 229*/        boolean resultado = false;
/* 237*/        return resultado;
            }

            public boolean deleteEnfermedadTerapia(EnfermedadTerapia enfermedadTerapia) {
/* 242*/        boolean resultado = false;
/* 250*/        return resultado;
            }
}
