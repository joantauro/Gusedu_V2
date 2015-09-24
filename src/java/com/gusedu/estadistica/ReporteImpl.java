package com.gusedu.estadistica;

import com.gusedu.util.HibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 

import com.gusedu.util.StaticUtil;
import org.hibernate.Query;
import org.hibernate.Session;

 
public class ReporteImpl implements ReporteService{

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
 
	public List<Reporte> listarTerapiaByterapeutas() {
		List<Reporte> lista= new ArrayList<>();
                
                
                Session session = HibernateUtil.getSessionFactory().openSession();
                 try {
             //tx = sesion.beginTransaction();
          String empresa = StaticUtil.userLogged();
             Query q = session.createSQLQuery("{ CALL Reporte_TerapiasbyTerapeutas(:empresa) }");
                    q.setParameter("empresa",empresa);
			
			List<Object[]> d=q.list();
			for (Object[] result : d) {
				
				String CANTIDAD = ((BigInteger) result[0]).toString();
				String NOMBRE = (String) result[1];
				double COSTO = (double) result[2];
				lista.add(new Reporte(CANTIDAD, NOMBRE, COSTO));
			}
        } catch (Exception e) {
            /*if (tx != null) {
                tx.rollback();
            }   */
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
                
                /* try {
                     String empresa = StaticUtil.userLogged();
             Query q = session.createSQLQuery("{ CALL Reporte_TerapiasbyTerapeutas(:empresa) }");
                    q.setParameter("empresa",empresa);
			
			List<Object[]> d=q.list();
			for (Object[] result : d) {
				
				String CANTIDAD = ((BigInteger) result[0]).toString();
				String NOMBRE = (String) result[1];
				double COSTO = (double) result[2];
				lista.add(new Reporte(CANTIDAD, NOMBRE, COSTO));
			}

                }
                
                
		 
		catch(Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}*/
		
		return lista;
	}

	@Override
	public Reporte AcumuladoTerapias() {
		Reporte rep =  new Reporte();
                
                
                 Session session = HibernateUtil.getSessionFactory().openSession();
                 
                  try {
             //tx = sesion.beginTransaction();
           String empresa = StaticUtil.userLogged();
             Query q = session.createSQLQuery("{ CALL Reporte_Acumulado_Terapias(:empresa) }");
                    q.setParameter("empresa",empresa);
			
			Object[] result=  (Object[]) q.uniqueResult()   ;
			rep.setCantidad(((BigInteger) result[0]).toString());
			rep.setNombre(result[1].toString());
			rep.setCosto((double) result[2]);
        } catch (Exception e) {
            /*if (tx != null) {
                tx.rollback();
            }   */
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
                 
               /*  try {
                     String empresa = StaticUtil.userLogged();
             Query q = session.createSQLQuery("{ CALL Reporte_Acumulado_Terapias(:empresa) }");
                    q.setParameter("empresa",empresa);
			
			Object[] result=  (Object[]) q.uniqueResult()   ;
			rep.setCantidad(((BigInteger) result[0]).toString());
			rep.setNombre(result[1].toString());
			rep.setCosto((double) result[2]);

                }
                
	 
		catch(Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}*/
		
		return rep;
	}

	@Override
	public List<Reporte> listarProductos() {
		List<Reporte> lista= new ArrayList<>();
                
                Session session = HibernateUtil.getSessionFactory().openSession();
                
                 try {
             //tx = sesion.beginTransaction();
          String empresa = StaticUtil.userLogged();
             Query q = session.createSQLQuery("{ CALL Reporte_Cant_Prod(:empresa) }");
                    q.setParameter("empresa",empresa);
			
			List<Object[]> d=q.list();
			for (Object[] result : d) {
				
				double cant = (double) result[0] ;
				int a=(int)cant;
				String CANTIDAD = a+"";
				String NOMBRE = (String) result[1];
				String val=((double) result[2])+"";
				double COSTO = Double.parseDouble(val);
				lista.add(new Reporte(CANTIDAD, NOMBRE, COSTO));
			}
        } catch (Exception e) {
            /*if (tx != null) {
                tx.rollback();
            }   */
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
                
            /*     try {
                     String empresa = StaticUtil.userLogged();
             Query q = session.createSQLQuery("{ CALL Reporte_Cant_Prod(:empresa) }");
                    q.setParameter("empresa",empresa);
			
			List<Object[]> d=q.list();
			for (Object[] result : d) {
				
				double cant = (double) result[0] ;
				int a=(int)cant;
				String CANTIDAD = a+"";
				String NOMBRE = (String) result[1];
				String val=((double) result[2])+"";
				double COSTO = Double.parseDouble(val);
				lista.add(new Reporte(CANTIDAD, NOMBRE, COSTO));
			}

                }
                 catch(Exception e)
                 {
                     
                 }
 */
		
		return lista;
	}

}
