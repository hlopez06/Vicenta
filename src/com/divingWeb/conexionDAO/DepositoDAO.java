package com.divingWeb.conexionDAO;

import java.util.List;

import org.hibernate.HibernateException;

import com.divingWeb.elememts.StockProducto;

public class DepositoDAO extends ConexionDAO {
	
	public static List<StockProducto> SelectStock(int lineMax ){
		
		List<StockProducto> stock = null;
		
		try 
        { 
			iniciaOperacion();
            
            stock = (List<StockProducto>) sesion.createCriteria(StockProducto.class).list();
        
            tx.commit();
	
        } catch (HibernateException he) { 
            manejaExcepcion(he); 
            throw he; 
        } finally { 
            sesion.close(); 
        }
		
		return stock;
	}

}
