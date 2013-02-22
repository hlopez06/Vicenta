package com.divingWeb.facturador;

import java.util.LinkedList;
import java.util.List;

import com.divingWeb.elememts.Producto;

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
		if (lProductos.contains(idProducto)){
			
			Producto prodGuardado = lProductos.get(idProducto);
			prodGuardado.sumarCant(cantidad);
			
		} else {
		
			lProductos.add(new Producto(idProducto, cantidad));
		}
		
		return lProductos;
	}
	
	public float totalSinIva(){
		float total = 0;
		
		for (Producto miProducto : lProductos) {
			total += miProducto.cantidad;
		};
		
		return total;
	}
	
	public float totalConIva(){
		
		return this.totalSinIva()+( this.totalSinIva() * iva );
	}

}
