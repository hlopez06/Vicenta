package com.divingWeb.elememts;

public class StockProducto {
	private long id;
	private long idProducto;
	private long codProducto;
	private long idUsuario;
	private int cantidad;
	private int precio;

	public StockProducto(){}
	
	public StockProducto(Producto producto,long idUsuario){
		this.idProducto = producto.getId();
		this.codProducto = producto.getCodigo();
		this.cantidad = producto.getCantidad();
		this.precio = producto.getPrecio();
		this.idUsuario = idUsuario;
		
	}
	
	public int getTotal(){
		return cantidad * precio; 
	}

	public long getId() {
		return id;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public long getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(long idProducto) {
		this.codProducto = idProducto;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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
