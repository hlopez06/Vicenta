package com.divingWeb.elememts;

public class Producto {

	private long id;
	public int guid;
	private int idProducto;
	private int cantidad;

	public Producto() {

	}

	public Producto(int idPro, int cant) {
		idProducto = idPro;
		cantidad = cant;
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

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

}
