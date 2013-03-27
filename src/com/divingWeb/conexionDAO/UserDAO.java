package com.divingWeb.conexionDAO;

import java.math.BigInteger;
import java.sql.Types;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.divingWeb.elememts.Usuario;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

public class UserDAO extends ConexionDAO{
	
	public static Object[] getIdUsuario(String usuario, String pass){
		
		BigInteger id;
		
		Object[] lResp;
		
		String qry = "SELECT idUsuario,estado FROM pws WHERE pws.usuario='" + usuario + "' AND pws.password='" + pass + "'";
		
		try 
        { 
            iniciaOperacion();

            lResp = (Object[]) sesion.createSQLQuery(qry).uniqueResult();
            
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he;

        } finally 
        { 
            sesion.close(); 
        }  
		
		
		return lResp;
//		if (id == null)
//			return 0;
//			
//		return id.longValue();
	}
	
	public static long nuevoUsuario(Usuario usuario){
		Long id = null;
		
		try 
        { 
            iniciaOperacion(); 
            id = (Long) sesion.save(usuario); 
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
	public static Usuario buscarCliente(long idUsuario){
		
		Usuario us = null;
		
		try 
        { 
            iniciaOperacion(); 
            us = (Usuario)sesion.get(Usuario.class, (long)idUsuario);
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
		
		return us;
	}
	
	public static List<Usuario> obtenerListaClientes(String termino){
		
		List<Usuario> lResultados = null;

		try 
        { 
            iniciaOperacion(); 

    		Criteria criterio = sesion.createCriteria(Usuario.class);
    		criterio.add(Restrictions.like("nombre",termino + "%"));

    		lResultados = (List<Usuario>) criterio.list();
            
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
