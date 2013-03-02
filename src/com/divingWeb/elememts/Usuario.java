package com.divingWeb.elememts;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private long id;
	private String nombre;
	private String apellido;
	private String categoria;
	private String sucursal;
	private Usuario objSupervisor;
	private String supervisor;
	List<Cliente> lClFavoritos;
	List<Cliente> lClHistorico;
	
	private Usuario(){

	}
	
	public void newUsuario(String strNombre, String strApellido, String strCategoria, String strSucursal,String strSupervisor){
		
		newUsuario(strNombre, strApellido, strCategoria, strSucursal);
		
		supervisor = strSupervisor;
		objSupervisor = null;
	}

	public void newUsuario(String strNombre, String strApellido, String strCategoria, String strSucursal,Usuario oSupervisor){
		
		newUsuario(strNombre, strApellido, strCategoria, strSucursal);
			
		supervisor = null;
		objSupervisor = oSupervisor;
	}
		
	private void newUsuario(String strNombre, String strApellido, String strCategoria, String strSucursal){
		
		nombre = strNombre;
		apellido = strApellido;
		categoria = strCategoria;
		sucursal = strSucursal;
		
		lClFavoritos = new LinkedList<Cliente>();
		lClHistorico = new LinkedList<Cliente>();
	}
	
}
