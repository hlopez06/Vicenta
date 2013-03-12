package com.divingWeb.conexionDAO;

import java.util.Iterator;

import org.hibernate.HibernateException;

import com.divingWeb.documents.Factura;
import com.divingWeb.documents.Remito;
import com.divingWeb.elememts.Producto;
import com.divingWeb.elememts.StockProducto;

public class TransactionDAO extends ConexionDAO {

	public TransactionDAO() {
		
	}
	
public static int remitoAction(Remito remito){
		
		int updateEntities = 0;
		String qryUpdate = "";
		
		String accion = remito.signoMovimiento();
		Iterator<Producto> listIterator = remito.getlProductos().iterator();
		
		while( listIterator.hasNext() ) {
			Producto pr = (Producto) listIterator.next();
	     
	          qryUpdate += " UPDATE stock stk SET stk.id=" + pr.getId() + " AND stk.cantidad=cantidad " + accion + " " + pr.getCantidad() + " AND stk.precio=" + pr.getPrecio() +
	        		  " WHERE stk.id=" + pr.getId() + ";";
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
