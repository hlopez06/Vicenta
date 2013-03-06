package com.divingWeb.elememts;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private long id;
	private String usuario;
	private String pass;
	private String nombre;
	private String apellido;
	private String categoria;
	private String sucursal;
	private Usuario objSupervisor;
	private String supervisor;
	private boolean administrador;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public Usuario getObjSupervisor() {
		return objSupervisor;
	}

	public void setObjSupervisor(Usuario objSupervisor) {
		this.objSupervisor = objSupervisor;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public List<Cliente> getlClFavoritos() {
		return lClFavoritos;
	}

	public void setlClFavoritos(List<Cliente> lClFavoritos) {
		this.lClFavoritos = lClFavoritos;
	}

	public List<Cliente> getlClHistorico() {
		return lClHistorico;
	}

	public void setlClHistorico(List<Cliente> lClHistorico) {
		this.lClHistorico = lClHistorico;
	}
	
}
