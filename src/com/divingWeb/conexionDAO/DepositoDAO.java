package com.divingWeb.conexionDAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;

import com.divingWeb.documents.Remito;
import com.divingWeb.elememts.Producto;
import com.divingWeb.elememts.StockProducto;

public class DepositoDAO extends ConexionDAO {
	
	private static String nombreDeposito = "stock";
	
	public static List<StockProducto> SelectStock(int lineMax ){
		
		List<StockProducto> stock = null;
		
		try 
        { 
			iniciaOperacion();
            
            stock = sesion.createCriteria(StockProducto.class).list();
        
            tx.commit();
	
        } catch (HibernateException he) { 
            manejaExcepcion(he); 
            throw he; 
        } finally { 
            sesion.close(); 
        }
		
		return stock;
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
}