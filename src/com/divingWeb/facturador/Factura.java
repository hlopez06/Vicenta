package com.divingWeb.facturador;

import java.util.LinkedList;
import java.util.List;

import com.divingWeb.elememts.Producto;

public class Factura {
	
	private static Double iva = 0.21;
	
	public List<Producto> lProductos;
	public Integer total = 0;
	public Integer totalMasIva = 0;
	
	public Factura()
	{
		lProductos = new LinkedList<Producto>();
	}
	
	public List<Producto> setProduct(Integer idProduto, Integer cantidad)
	{
		lProductos.add(new Producto(idProduto, cantidad));
		
		return lProductos;
	}

}
