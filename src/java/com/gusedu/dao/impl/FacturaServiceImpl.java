/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusedu.dao.impl;

import com.gusedu.dao.FacturaService;
import com.gusedu.entidad.cabecera_factura;
import com.gusedu.entidad.detalle_factura;
import com.gusedu.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author NV55C
 */
public class FacturaServiceImpl implements FacturaService{

    @Override
    public cabecera_factura SP_ObtenerCabecera(int cli_codigo) {
        cabecera_factura obj = null;
                Session session = HibernateUtil.getSessionFactory().openSession();
                 try {
         
             Query q = session.createSQLQuery("{ CALL SP_SaveFactura(:cod_cli) }");
               q.setParameter("cod_cli",cli_codigo);
			Object[] d =   (Object[]) q.uniqueResult();
                         int cod_factura=(int) d[0];
                         String cliente=(String) d[1];
                         double montod=(double) d[2];
                         Date fecha=(Date) d[3];
                         String factura_real=(String) d[4];
                         int cod_cliente=(int) d[5];
                         obj = new cabecera_factura(cod_factura, cliente, montod, fecha, factura_real, cod_cliente);
                       /* Object 
                        
			for (Object[] result : d) {
				
				    int cod_det_factura = (int) result[0];
                                    String item=(String) result[1];
                                    double precio_unitario=(double) result[2];
                                    int cantidad = (int) result[3];
                                    double monto=(double) result[4];
                                    int cod_factura=(int) result[5];
                                    lista.add(new detalle_factura(cod_det_factura, item, precio_unitario,cantidad, monto, cod_factura));
			}*/
        } catch (Exception e) {
            System.out.println("Error en SP_ObtenerCabecera : "+e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
          return obj;  
    }

    @Override
    public boolean SP_UpdateCabecera(int cli_codigo, String fac_real) {
              boolean resultado = false;
         Session session = HibernateUtil.getSessionFactory().openSession();
         try {
             Query q = session.createSQLQuery("{ CALL SP_UpdateFactura(:cli_codigo,:fact_real) }");
             q.setParameter("cli_codigo", cli_codigo);
             q.setParameter("fact_real", fac_real);
             q.executeUpdate();
             resultado = true;
         }
         catch(Exception e)
         {
             System.out.println("ERROR de SP_UpdateCabecera : "+e.getMessage());
             resultado=false;
         }
         return resultado;
    }

    @Override
    public List<detalle_factura> SP_ListaDetalle(int pk_cabecera) {
         List<detalle_factura> lista= new ArrayList<>();
                Session session = HibernateUtil.getSessionFactory().openSession();
                 try {
         
             Query q = session.createSQLQuery("{ CALL SP_ListarDetalleFactura(:fact) }");
               q.setParameter("fact",pk_cabecera);
			List<Object[]> d=q.list();
			for (Object[] result : d) {
				
				    int cod_det_factura = (int) result[0];
                                    String item=(String) result[1];
                                    double precio_unitario=(double) result[2];
                                    int cantidad = (int) result[3];
                                    double monto=(double) result[4];
                                    int cod_factura=(int) result[5];
                                    lista.add(new detalle_factura(cod_det_factura, item, precio_unitario,cantidad, monto, cod_factura));
			}
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
          return lista;  
    }
    
}
