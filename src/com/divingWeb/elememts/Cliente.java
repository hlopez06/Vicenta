package com.divingWeb.elememts;

public class Cliente {
	
	private long id;
	private String nombre;
	private String apellido;
	private String razonSocial;
	private String direccion;
	private String tipo;
	private long credito;

	public Cliente(){
		
	}
	
	public Cliente(String nombre,String apellido,String razonSocial,String direccion, String tipo,int credito){
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.tipo = tipo;
		this.credito = credito;
		
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
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
