package com.divingWeb.elememts;

public class Producto {
	
	public int idProducto;
	public int cantidad;
	
	public Producto(int idPro, int cant)
	{
		idProducto = idPro;
		cantidad = cant;
	}
	
	public int sumarCant(int cant)
	{
		cantidad += cant;
		
		return cantidad;
	}
	
	public int borrarCant(int cant)
	{
		cantidad -= cant;
		
		return cantidad;
	}
		
	public int getIdProducto()
	{
		return idProducto;
	}
	
	public int getCantidad()
	{
		return cantidad;
	}

}
