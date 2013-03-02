package com.divingWeb.conexionDAO;


import org.hibernate.HibernateException;

import com.divingWeb.elememts.Producto;


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
	
	public static Producto buscarProducto(int idProducto){
		
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