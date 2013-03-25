package com.divingWeb.conexionDAO;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

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
	
	public static List<Producto> buscarProductos(String termino, String nombre, String detalle, String categoria){
		
		List<Producto> lproductos = null;
		String query = " FROM com.divingWeb.elememts.Producto ";
		
		if (termino.length() > 0 ){
			query = query.concat("WHERE");
		
			if(nombre.length() > 0){
				query = query.concat(" nombre like '%" + nombre + "%'");
			} else {
				query = query.concat(" nombre like '%" + termino + "%'");
			}
			if(detalle.length() > 0){
				query = query.concat(" OR detalle like '%" + detalle + "%'");
			} else {
				query = query.concat(" OR detalle like '%" + termino + "%'");
			}
			if(categoria.length() > 0){
				query = query.concat(" OR categoria like '%" + categoria + "%'");
			} else {
				query = query.concat(" OR categoria like '%" + termino + "%'");
			}
		} else {
			query = query.concat("WHERE nombre like '%" + nombre + "%' AND detalle like '%" + detalle + "%' AND categoria like '%" + categoria + "%'");
		}
		
		try 
        { 
            iniciaOperacion(); 
            
            lproductos  = (List<Producto>) sesion.createQuery(query).list();
            
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
		
		return lproductos;
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

//test
//Criteria criterio = sesion.createCriteria(Producto.class);
//
//if (termino.length() > 0 ){
//
//	if(nombre.length() > 0){
//		criterio.add(Restrictions.like("nombre","%" + nombre + "%"));
//	} else {
//		criterio.add(Restrictions.like("nombre","%" + termino + "%"));
//	}
//	if(detalle.length() > 0){
//		criterio.add(Restrictions.like("detalle","%" + detalle + "%"));
//	} else {
//		criterio.add(Restrictions.like("detalle","%" + detalle + "%"));
//	}
//	if(categoria.length() > 0){
//		criterio.add(Restrictions.like("categoria","%" + categoria + "%"));
//	} else {
//		criterio.add(Restrictions.like("categoria","%" + categoria + "%"));
//	}
//} else {
//	criterio.add(Restrictions.like("nombre","%" + nombre + "%"))
//			.add(Restrictions.like("detalle","%" + detalle + "%"))
//			.add(Restrictions.like("categoria","%" + categoria + "%"));
//}
//
//lproductos = (List<Producto>) criterio.list();
