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
	private long idDepositoDefault;
	private Deposito objDepositoDefault;
	private boolean administrador;
	private int estado;
	List<Cliente> lClFavoritos;
	List<Cliente> lClHistorico;
	
	public Usuario(){}
	
	public void newUsuario(String nombre, String apellido, String categoria, String sucursal,String supervisor){
		
		newUsuario(nombre, apellido, categoria, sucursal);
		
		this.supervisor = supervisor;
		objSupervisor = null;
		administrador = false;
		idDepositoDefault = 0;
	}

	public void newUsuario(String strNombre, String strApellido, String strCategoria, String strSucursal,Usuario oSupervisor){
		
		newUsuario(strNombre, strApellido, strCategoria, strSucursal);
			
		supervisor = null;
		objSupervisor = oSupervisor;
	}
		
	private void newUsuario(String nombre, String apellido, String categoria, String sucursal){
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.categoria = categoria;
		this.sucursal = sucursal;
		
		lClFavoritos = new LinkedList<Cliente>();
		lClHistorico = new LinkedList<Cliente>();
	}

	public long caragarObjDeposito(){
		// se debe usan el idDepositoDefault para traer el un deposito a "objDepositoDefault" y (return id de deposito).
		return 1;
	}
	
	public String getNombreDepositoDefault(){
		String nombreDeposito = null;
		
		if (objDepositoDefault != null){
			nombreDeposito = objDepositoDefault.getNombre();
		}
		// sacar esta linea para multiples depositos.
		nombreDeposito = "Deposito principal";

		return nombreDeposito;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getIdDepositoDefault() {
		return idDepositoDefault;
	}

	public void setIdDepositoDefault(long idDepositoDefault) {
		this.idDepositoDefault = idDepositoDefault;
	}

	public Deposito getObjDepositoDefault() {
		return objDepositoDefault;
	}

	public void setObjDepositoDefault(Deposito objDepositoDefault) {
		this.objDepositoDefault = objDepositoDefault;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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
