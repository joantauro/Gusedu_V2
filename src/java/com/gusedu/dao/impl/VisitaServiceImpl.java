// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc 
// Source File Name:   VisitaServiceImpl.java

package com.gusedu.dao.impl;

import com.gusedu.dao.VisitaService;
import com.gusedu.model.Cliente;
import com.gusedu.model.Visita;
import com.gusedu.util.HibernateUtil;
import com.gusedu.util.StaticUtil;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class VisitaServiceImpl
    implements VisitaService {

            EntityManager em;


            public boolean saveVisita(Visita visita) {
                boolean resultado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.save(visita);
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
 
/*  42*/        return resultado;
            }

            public boolean updateVisita(Visita visita) {
               boolean resultado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.merge(visita);
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
 
/*  63*/        return resultado;
            }

            public boolean deleteVisita(Visita visita) {
/*  67*/        boolean resultado = false;
/*  75*/        return resultado;
            }

            public List<Visita> getVisitasCliente(Cliente cliente) {
                List<Visita> result= new ArrayList<>();
                
                

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
             String sql = "SELECT v FROM Visita v WHERE v.cliente.cliCodigo=:cliente order by v.visFecCreacion desc";
/*  88*/        Query q = sesion.createQuery(sql);
/*  89*/        q.setParameter("cliente", cliente.getCliCodigo());
/*  90*/        result = q.list();
           // tx.commit();
            
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
 
/* 105*/        return result;
            }

            public Visita getVisitaById(Integer idVisita) {
/* 110*/        return (Visita)em.find(Visita.class, idVisita);
            }

           public Visita getLastVisitaCliente(Cliente cliente) {
       
        Visita result = null;
        
                 Session sesion = HibernateUtil.getSessionFactory().openSession();
        //Transaction tx = null;
        try {
             //tx = sesion.beginTransaction();
             Query q = sesion.createQuery("SELECT v FROM Visita v WHERE v.cliente.cliCodigo=:cliente ORDER BY v.visFecCreacion DESC");
            q.setParameter("cliente", cliente.getCliCodigo());
            q.setMaxResults(1);
            result = (Visita) q.uniqueResult();
            System.out.println(result.getVisCodigo());
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
            Query q = sesion.createQuery("SELECT v FROM Visita v WHERE v.cliente.cliCodigo=:cliente ORDER BY v.visFecCreacion DESC");
            q.setParameter("cliente", cliente.getCliCodigo());
            q.setMaxResults(1);
            result = (Visita) q.uniqueResult();
        } catch (NoResultException e) {
            System.out.println((new StringBuilder()).append("ERROR de buscaVisita: ").append(e.getMessage()).toString());
        }*/
        return result;
    }

            public Visita buscarVisita(Cliente cliente) {
                Visita result = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Date fecha = new Date();
        int mes = fecha.getMonth() + 1;
       int aF1o = fecha.getYear() + 1900;
        int dia = fecha.getDate();
       String mesM = "";
        String diaD = "";
         if (mes < 10) {
             mesM = "0";
                }
         if (dia < 10) {
             diaD = "0";
                }
         String cadena = (new StringBuilder()).append(aF1o).append("-").append(mesM).append(mes).append("-").append(diaD).append(dia).toString();
        
          try {
             //tx = sesion.beginTransaction();
            Query q = sesion.createQuery("SELECT v  FROM Visita v WHERE SUBSTRING(v.visFecCreacion,1,10) =:fecha AND v.cliente.cliCodigo=:cliente");
             q.setParameter("fecha", cadena);
             q.setParameter("cliente", cliente.getCliCodigo());
            Cliente cli = cliente;
             result = (Visita)q.uniqueResult();
              System.out.println(result.getVisCodigo());

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
             Query q = sesion.createQuery("SELECT v  FROM Visita v WHERE SUBSTRING(v.visFecCreacion,1,10) =:fecha AND v.cliente.cliCodigo=:cliente");
             q.setParameter("fecha", cadena);
             q.setParameter("cliente", cliente.getCliCodigo());
            Cliente cli = cliente;
             result = (Visita)q.uniqueResult();
                }
         catch (NoResultException e) {
            System.out.println((new StringBuilder()).append("ERROR de buscaVisita: ").append(e.getMessage()).toString());
                }*/
         return result;
            }

            public Visita getLastVisitaCliente2(Cliente cliente) {
         List resultlist = new ArrayList();
         Visita result = null;
         return result;
            }

            public double costodeVisita(Date fec_inicial, Date fec_final) {
/* 185*/        double result = 0.0D;
/* 195*/        return result;
            }

            public List<Visita> getVisitabyFechas(String username, Date fec_inicial, Date fec_final) {
/* 201*/        List<Visita> result = new ArrayList();
Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
           // tx = sesion.beginTransaction();
             String sql = "select v from Visita v where v.visUsuCreacion=:usuario and :fec_inicial <= v.visFecCreacion and v.visFecCreacion<=:fec_final order by v.visFecCreacion desc";
       Query q = sesion.createQuery(sql);
                q.setParameter("fec_inicial",fec_inicial);
			q.setParameter("fec_final", fec_final);
			q.setParameter("usuario", username);
                     

        result = q.list();
        for(int i=0;i<result.size();i++)
        {
           System.out.println(result.get(i).getCliente().getPersona().getPerNombres());
        }
           // tx.commit();
            
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
 
              
/* 211*/        return result;
            }

            public List<Visita> getVisitas() {
         List<Visita> result = new ArrayList();
         Session sesion = HibernateUtil.getSessionFactory().openSession();
 
        try {
 
             String sql = "SELECT v FROM Visita v ORDER BY v.visFecCreacion DESC";
             Query q = sesion.createQuery(sql);
             result = q.list();          
        } catch (Exception e) {
         
                System.out.println("ERROR   : " + e.getMessage());

        } finally {
            sesion.flush();
            sesion.close();
        }
         return result;
            }

    @Transactional
    @Override
    public List<Visita> getVisitasByEmpresa() {
       List<Visita> result = new ArrayList();
         Session sesion = HibernateUtil.getSessionFactory().openSession();
 
        try {
            String username =StaticUtil.userLogged();
             String sql = "SELECT v FROM Visita v where v.visUsuCreacion=:usuario and v.visFecCreacion >= CURDATE() ORDER BY v.visFecCreacion DESC";
             Query q = sesion.createQuery(sql);
             q.setParameter("usuario", username);
             result = q.list(); 
            
for(int i=0;i<result.size();i++){
                     System.out.println("PROBANDO:::"+result.get(i).getCliente().getPersona().getPerNombres()+" "
                                                 +result.get(i).getCliente().getPersona().getPerApellidoP()+" "
                                                 +result.get(i).getCliente().getPersona().getPerApellidoM());
}
          
        } catch (Exception e) {
         
                System.out.println("ERROR   : " + e.getMessage());

        } finally {
            sesion.flush();
            sesion.close();
        }
         return result;
    }
}
