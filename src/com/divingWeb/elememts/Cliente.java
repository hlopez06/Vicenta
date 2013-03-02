package com.divingWeb.elememts;

public class Cliente {
	

	private long id;
	public int guid;
	private String nombre;
	private String apellido;
	private String razonSocial;
	private String tipo;
	private long credito;

	public Cliente(){
		
	}
	
	public Cliente(String sNombre,String sApellido,String sRazonSocial,String sTipo,int sCredito){
		
		nombre = sNombre;
		apellido = sApellido;
		razonSocial = sRazonSocial;
		tipo = sTipo;
		credito = sCredito;
		
	}
	
	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public long getCredito() {
		return credito;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setCredito(long credito) {
		this.credito = credito;
	}
	
}
