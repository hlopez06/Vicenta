package com.divingWeb.elememts;

public class Producto {

	private long id;
	private int guid;
	private String nombre;
	private String detalle;
	private int categoria;
	private int precio;
	private int cantidad;

	public Producto() {

	}

	public Producto(int intGuid, String strNombre, String strDetalle, int intCategoria, int intPrecio, int intCantidad) {
		guid = intGuid;
		nombre = strNombre;
		detalle = strDetalle;
		categoria = intCategoria;
		precio = intPrecio;
		cantidad = intCantidad;
		
	}

	public int sumarCant(int cant) {
		cantidad += cant;

		return cantidad;
	}

	public int borrarCant(int cant) {
		cantidad -= cant;

		return cantidad;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public int getGuid() {
		return guid;
	}

	public void setGuid(int guid) {
		this.guid = guid;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
