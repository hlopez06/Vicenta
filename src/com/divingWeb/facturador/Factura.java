package com.divingWeb.facturador;

import java.util.LinkedList;
import java.util.List;

import com.divingWeb.elememts.Producto;
import com.google.gson.Gson;

public class Factura {
	
	private float iva = 0.21F;
	
	public List<Producto> lProductos;
	public Integer total = 0;
	public Integer totalMasIva = 0;
	
	public Factura()
	{
		lProductos = new LinkedList<Producto>();
	}
	
	public List<Producto> setProduct(int idProducto, int cantidad)
	{
		boolean encontrado = false;
		
		for (Producto unProducto : lProductos) {
			if(unProducto.idProducto == idProducto)
			{
				unProducto.cantidad += cantidad;
				encontrado = true;
			}
		}
		
		if( !encontrado ){
			lProductos.add(new Producto(idProducto, cantidad));
		}
		
		return lProductos;
	}
	
	public List<Producto> listProductosJson()
	{	
		return lProductos;
	}
	
	
	public float totalSinIva(){
		float total = 0;
		
		for (Producto unProducto : lProductos) {
			total += unProducto.cantidad;
		};
		
		return total;
	}
	
	public float totalConIva(){
		
		return this.totalSinIva()+( this.totalSinIva() * iva );
	}

}
