package com.divingWeb.conexionDAO;

import java.util.Iterator;
import java.util.List;

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
		
		List<Producto> lProductos = remito.getlProductos();
		
		if (!lProductos.isEmpty() && !(remito.getProveedor() == null && remito.getCliente() == null ) ){
			String accion = remito.signoMovimiento();
			Iterator<Producto> listIterator = lProductos.iterator();
			
			try 
	        { 
				iniciaOperacion();
	            
	            while( listIterator.hasNext() ) {
	            	Producto pr = (Producto) listIterator.next();
	            	
//	            	sesion.getNamedQuery("call_sp_cargaStock").setParameter("stock", new StockProducto(pr, idUsuario) ).executeUpdate();
	            	
	            	sesion.getNamedQuery("call_sp_cargaStock")
		            	.setParameter("idProducto",pr.getId())
		            	.setParameter("codProducto",pr.getCodigo())
		            	.setParameter("cantidad", accion + pr.getCantidad())
		            	.setParameter("precio", pr.getPrecio())
		            	.executeUpdate();
		            		            	
	            	++updateEntities;
	            }
	            tx.commit();
		
	        } catch (HibernateException he) { 
	            manejaExcepcion(he); 
	            throw he; 
	        } finally { 
	            sesion.close(); 
	        }
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
