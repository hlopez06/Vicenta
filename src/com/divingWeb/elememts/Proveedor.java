package com.divingWeb.elememts;

public class Proveedor {
	
	private long id;
	private String nombre;
	private String razonSocial;
	private String direccion;
	private String tipo;
	
	public Proveedor(){
		
	}
	
	public Proveedor(String nombre,String direccion,String razonSocial,String tipo){
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.razonSocial = razonSocial;
		this.tipo = tipo;
		
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

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
