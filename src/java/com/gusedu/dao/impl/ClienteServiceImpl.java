// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc 
// Source File Name:   ClienteServiceImpl.java

package com.gusedu.dao.impl;

import com.gusedu.model.Cliente;
import com.gusedu.dao.ClienteService;
import com.gusedu.util.HibernateUtil;
import com.gusedu.util.StaticUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteServiceImpl
    implements ClienteService {

            EntityManager em;


            public boolean saveCliente(Cliente cliente) {
/*  35*/        boolean resultado = false;
/*  37*/        try {
/*  37*/            em.persist(cliente);
/*  38*/            resultado = true;
                }
/*  39*/        catch (Exception e) {
/*  40*/            System.out.println((new StringBuilder()).append("ERROR: ").append(e.getMessage()).toString());
/*  41*/            resultado = false;
                }
/*  43*/        return resultado;
            }

            @Override
    public boolean updateCliente(Cliente cliente) {
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            if (cliente.getPersona().getPerFecNacimiento() != null) {
                cliente.getPersona().setPerSignoZodiacal(StaticUtil.signoZodiacal(cliente.getPersona().getPerFecNacimiento().getMonth(), cliente.getPersona().getPerFecNacimiento().getDate()));
            }
             sesion.merge(cliente);
             tx.commit();
            resultado = true;
 
        } catch (Exception e) {
             System.out.println("Error : "+e.getMessage());
            if (tx != null) {
                tx.rollback();
               
            }
            System.out.println("Error : "+e.getMessage());
        } finally {
            sesion.flush();
            sesion.close();
        }
       return resultado;
    }

            public boolean deleteCliente(Cliente cliente) {
/*  76*/        boolean resultado = false;
/*  78*/        try {
/*  78*/            em.remove(em.getReference(Cliente.class, cliente.getCliCodigo()));
/*  79*/            resultado = true;
                }
/*  80*/        catch (Exception e) {
/*  81*/            System.out.println((new StringBuilder()).append("ERROR: ").append(e.getMessage()).toString());
/*  82*/            resultado = false;
                }
/*  84*/        return resultado;
            }

            public List<Cliente>  getClientes() {
/*  90*/        List<Cliente>  result = new ArrayList();
/*  97*/        return result;
            }

            public List<Cliente>  getClientesPacientes() {
/* 103*/        List<Cliente>  result = new ArrayList();
/* 112*/        return result;
            }

    @Override
    public List<Cliente> getClientesPacientesByUsuario(String usuario) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> result = new ArrayList<>();
        
               
        //Transaction tx = null;
        try {
             //tx = sesion.beginTransaction();
             String sql = "SELECT c FROM Cliente c WHERE c.tipoCliente.tclDescripcion =:paciente AND c.cliUsuCreacion=:usuario order by c.persona.perFecCreacion desc";
             Query q = sesion.createQuery(sql);
            // q.setEntity("cliente", Cliente.class);
             q.setParameter("paciente", "Paciente");
             q.setParameter("usuario", usuario);
             result =  q.list();
       
          for(int j=0;j<result.size();j++)
             {
                 System.out.println(result.get(j).getPersona().getPerDni());
             }
             // tx.commit();
         
        } catch (Exception e) {
            /*if (tx != null) {
                tx.rollback();
            }  */
            System.out.println(e.getMessage());
        } finally {
            sesion.flush();
            sesion.close();
        }      
  
        
       /* try {
            String sql = "SELECT c FROM Cliente c WHERE c.tipoCliente.tclDescripcion =:paciente AND c.cliUsuCreacion=:usuario order by c.persona.perFecCreacion desc";
            Query q = sesion.createQuery(sql);
            q.setParameter("paciente", "Paciente");
            q.setParameter("usuario", usuario);
            result = q.list();
            System.out.println("TAMAÑO : "+result.size());
        } catch (NoResultException e) {
            System.out.println((new StringBuilder()).append("ERROR de getClientesPacientesByUsuario: ").append(e.getMessage()).toString());
        }*/
        return result;
    }

            public Cliente getClienteById(Integer idCliente) {
                Cliente cliente=null;
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                //Transaction tx = null;
                try {
                    //tx = sesion.beginTransaction();
                    cliente = (Cliente) sesion.load(Cliente.class, idCliente);
                    if(cliente!=null)
                    {
                        cliente.getPersona().getPerNombres();
                        cliente.getTipoCliente().getTclCodigo();
                    }
                    //System.out.println(cliente.getPersona().getPerNombres());
                    //tx.commit();
                 } catch (Exception e) {
                   /* if (tx != null) {
                        tx.rollback();
                    }*/
                    throw new RuntimeException(e);
                } finally {
                    sesion.flush();
                    sesion.close();
                }
                return cliente;
            }

            public Cliente getClienteByIdPersona(Integer idPersona) {
/* 141*/        Cliente result = null;
/* 149*/        return result;
            }

            public List<Cliente>  ordenar() {
/* 155*/        List<Cliente>  result = new ArrayList();
/* 162*/        return result;
            }

            public Cliente lastClient() {
/* 167*/        Cliente result = null;
/* 175*/        return result;
            }
}
