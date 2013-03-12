package com.divingWeb.elememts;

public class StockProducto {
	private long id;
	private int cantidad;
	private int precio;

	public StockProducto(){}
	
	public int getTotal(){
		return cantidad * precio; 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
