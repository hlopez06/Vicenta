package com.divingWeb.conexionDAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;

import com.divingWeb.elememts.Producto;
import com.divingWeb.facturador.Factura;

public class TransactionDAO extends ConexionDAO {

	public TransactionDAO() {
		
	}
	
	public static int facturarProductos(Factura factura){
		
		int updateEntities = 0;
		String qryUpdate = "";
		
		Iterator<Producto> listIterator = factura.getlProductos().iterator();
		
		while( listIterator.hasNext() ) {
	          Producto pr = (Producto) listIterator.next();
	     
	          qryUpdate += " UPDATE stock stk SET stk.cantidad=cantidad - " + pr.getCantidad() + " WHERE stk.id =" + pr.getId() + ";";
		}
		
		try 
        { 
            iniciaOperacion();

	         updateEntities = sesion.createQuery( qryUpdate ).executeUpdate();
            
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }
		
		return updateEntities;
	}
	
	public static boolean guardarFactura(Factura unaFactura){
		
		try 
        { 
            iniciaOperacion(); 
            
            sesion.save(unaFactura);
            
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }
		
		return true;
	}

}
