package com.divingWeb.conexionDAO;


import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.divingWeb.elememts.Producto;
import com.divingWeb.elememts.StockProducto;

public class ProductDAO extends ConexionDAO{
	
	public static long nuevoProducto(Producto unProducto){
		Long id = null;
		
		try 
        { 
            iniciaOperacion(); 
            id = (Long) sesion.save(unProducto); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  
		
		return id;	
	}	
	
	public static Producto buscarProdXId(int idProducto){
		
		Producto pr = null;
		
		try 
        { 
            iniciaOperacion(); 
            
            pr = (Producto) sesion.get(Producto.class, (long)idProducto);
//            Query query = sesion.createQuery("FROM com.divingWeb.elememts.Producto WHERE guid=" + idProducto);
//            pr = (Producto)query.uniqueResult();
            
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
		
		return pr;
	}
	
	public static Producto buscarProducto(Integer codProducto){
		
		Producto pr = null;
		
		try 
        { 
            iniciaOperacion(); 
            
//            pr = (Producto) sesion.get(Producto.class, (long)codProducto);
            Query query = sesion.createQuery("FROM com.divingWeb.elememts.Producto WHERE codigo=" + codProducto.toString());
            pr = (Producto)query.uniqueResult();
            
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
		
		return pr;
	}
	
	public static StockProducto buscarProductoStock(int idProducto){
		
		StockProducto pr = null;
		
		try 
        { 
            iniciaOperacion(); 
            
            pr = (StockProducto) sesion.get(StockProducto.class, (long)idProducto);
//            Query query = sesion.createQuery("FROM com.divingWeb.elememts.Producto WHERE guid=" + idProducto);
//            pr = (Producto)query.uniqueResult();
            
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
		
		return pr;
	}
	
	public static boolean addProdutoToTest(Producto unProducto){
		
		try 
        { 
            iniciaOperacion(); 
            
            sesion.saveOrUpdate(unProducto);
            
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
