package com.divingWeb.elememts;

public class Producto {

	private long id;
	private long codigo;
	private String nombre;
	private String detalle;
	private String categoria;
	private int precio;
	private int cantidad;

	public Producto() {}

	public Producto(long codigo ,String nombre, String detalle, String categoria, int precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.detalle = detalle;
		this.categoria = categoria;
		this.precio = precio;
		
	}
	
	public int sumarCantidad(int cantidad){
		if(cantidad < 0)
			cantidad = (cantidad * -1);
		
		return this.cantidad += cantidad;
	}
	
	public int restarCantidad(int cantidad){
		if(cantidad < 0)
			cantidad = (cantidad * -1);
		
		return this.cantidad -= cantidad;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
