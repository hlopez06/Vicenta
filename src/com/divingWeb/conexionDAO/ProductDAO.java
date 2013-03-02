package com.divingWeb.conexionDAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Producto;
import com.divingWeb.hibernate.HibernateUtil;

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

//    		Producto pr = (Producto)session.get(Producto.class, idProducto);
            Query query = sesion.createQuery("FROM com.divingWeb.elememts.Producto WHERE guid=" + idProducto);
    		
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
