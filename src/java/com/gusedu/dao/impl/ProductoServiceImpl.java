// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc 
// Source File Name:   ProductoServiceImpl.java

package com.gusedu.dao.impl;

import com.gusedu.dao.ProductoService;
import com.gusedu.model.Producto;
import com.gusedu.model.ProductoVisita;
import com.gusedu.model.Visita;
import com.gusedu.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductoServiceImpl
    implements ProductoService {

            EntityManager em;


            public List<Producto> getAllProductos() {
        List<Producto> result = new ArrayList();
                 Session sesion = HibernateUtil.getSessionFactory().openSession();
        //Transaction tx = null;
        try {
             //tx = sesion.beginTransaction();
              String sql = "SELECT p FROM Producto p";
            Query q = sesion.createQuery(sql);
            result = q.list();
            for(int i=0;i<result.size();i++)
            {
                System.out.println(result.get(i).getProDescripcionM());
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
            String sql = "SELECT p FROM Producto p";
            Query q = sesion.createQuery(sql);
            result = q.list();
                }
        catch (NoResultException e) {
           System.out.println((new StringBuilder()).append("ERROR : ").append(e.getMessage()).toString());
                }*/
           return result;
            }

            public Producto getProductoById(Integer idProducto) {
                Producto producto;
                Exception exception;
/*  42*/        Session sesion = HibernateUtil.getSessionFactory().openSession();
/*  43*/        producto = null;
/*  44*/        Transaction tx = null;
/*  46*/        try {
/*  46*/            tx = sesion.beginTransaction();
/*  47*/            producto = (Producto)sesion.load(Producto.class, idProducto);
/*  48*/            tx.commit();
/*  49*/            System.out.println((new StringBuilder()).append("VALOR : ").append(producto.getProDescripcionM()).toString());
                }
/*  50*/        catch (Exception e) {
/*  51*/            if (tx != null) {
/*  52*/                tx.rollback();
/*  53*/                System.out.println((new StringBuilder()).append("ERROR . ").append(e.getMessage()).toString());
                    }
/*  55*/            throw new RuntimeException(e);
                }
/*  57*/        finally {
    sesion.flush();
/*  57*/            sesion.close();
                }
 
/*  59*/        return producto;
            }

            public boolean saveProductoVisita(ProductoVisita productoVisita) {
                
                boolean resultado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.save(productoVisita);
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
 
/*  83*/        return resultado;
            }

            public List<ProductoVisita>  getAllProductosByVisita(Visita visita) {
                List<ProductoVisita>  result= new ArrayList<>();
               

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
             String sql = "SELECT p FROM ProductoVisita p WHERE p.visita.visCodigo=:visita";
/*  97*/        Query q = sesion.createQuery(sql);
/*  98*/        q.setParameter("visita", visita.getVisCodigo());
/*  99*/        result = q.list();
/* 100*/        System.out.println((new StringBuilder()).append("LISTA : ").append(result.size()).toString());
/* 101*/        for (int i = 0; i < result.size(); i++) {
/* 103*/            System.out.println((new StringBuilder()).append("PRODUCTO : ").append(((ProductoVisita)result.get(i)).getProducto().getProDescripcionM()).toString());
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
 
/* 121*/        return result;
            }

            public boolean updateProducto(Producto producto) {
                
                
                boolean resultado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            System.out.println("Actualizo Producto....");
/* 133*/        sesion.merge(producto);
/* 134*/        System.out.println(producto.getProExistencias());
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
 
/* 147*/        return resultado;
            }

            public boolean deleteProductoVisita(ProductoVisita productoVisita) {
                boolean resultado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.delete(productoVisita);
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
             
/* 172*/        return resultado;
            }

            public boolean updateProductoVisita(ProductoVisita productoVisita) {
/* 178*/        boolean resultado = false;
/* 186*/        return resultado;
            }

    @Override
    public boolean saveProducto(Producto producto) {
       boolean resultado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.save(producto);
            tx.commit();
            resultado = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("ERROR de saveProducto : " + e.getMessage());
            }
            System.out.println(e.getMessage());
        } finally {
            sesion.flush();
            sesion.close();
        }
        return resultado;
    }

    @Override
    public boolean deleteProducto(Producto producto) {
        boolean resultado = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.delete(producto);
            tx.commit();
            resultado = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("ERROR de saveProducto : " + e.getMessage());
            }
            System.out.println(e.getMessage());
        } finally {
            sesion.flush();
            sesion.close();
        }
        return resultado;
    }
}
