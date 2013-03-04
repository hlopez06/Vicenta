package com.divingWeb.facturador;

import java.util.LinkedList;

import com.divingWeb.elememts.Proveedor;
import com.divingWeb.elememts.Producto;

public class Remito extends Documento {
	
	public Remito(){
		lProductos = new LinkedList<Producto>();
		cantidadProductos = 0;
		cliente = null;
		proveedor = null;
		tipoDocumento = "factura";
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	private Proveedor proveedor;
}
