package com.divingWeb.conexionDAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.divingWeb.elememts.Proveedor;

public abstract class ProviderDAO extends ConexionDAO{
public static long getIdProveedor(String proveedor, String pass){
		
		long id = 1;
		
		try 
        { 
            iniciaOperacion(); 

            Criteria criterio = sesion.createCriteria(Proveedor.class);
    		criterio.add(Restrictions.like("proveedor",proveedor));
    		criterio.add(Restrictions.like("pass",pass));
    		
    		Proveedor objUsuario = (Proveedor) criterio.uniqueResult();
    		id = objUsuario.getId();
            
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
	
	public static long nuevoProveedor(Proveedor proveedor){
		Long id = null;
		
		try 
        { 
            iniciaOperacion(); 
            id = (Long) sesion.save(proveedor); 
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
	public static Proveedor buscarProveedor(long idProveedor){
		
		Proveedor pv = null;
		
		try 
        { 
            iniciaOperacion(); 
            pv = (Proveedor)sesion.get(Proveedor.class, (long)idProveedor);
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
		
		return pv;
	}
	
	public static List<Proveedor> obtenerListaidProveedores(String termino){
		
		List<Proveedor> lResultados = null;

		try 
        { 
            iniciaOperacion(); 

    		Criteria criterio = sesion.createCriteria(Proveedor.class);
    		criterio.add(Restrictions.like("nombre",termino + "%"));

    		lResultados = (List<Proveedor>) criterio.list();
            
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
		
		return lResultados;
	}
}
