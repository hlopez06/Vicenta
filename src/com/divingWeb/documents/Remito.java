package com.divingWeb.documents;

import java.util.LinkedList;
import java.util.List;

import com.divingWeb.conexionDAO.TransactionDAO;
import com.divingWeb.elememts.Proveedor;
import com.divingWeb.elememts.Producto;

public class Remito extends Documento {
	
	private Proveedor proveedor;
	private String tipoMovimiento;
	
	public Remito(){
		lProductos = new LinkedList<Producto>();
		cantidadProductos = 0;
		cliente = null;
		proveedor = null;
		tipoDocumento = "remito";
		tipoMovimiento = "ingreso";
	}
	
	public boolean action(){
		
		TransactionDAO.remitoAction(this);
		
		return true;
	}
	
	public String signoMovimiento(){
		String signo;
		
		if (tipoMovimiento.contains("ingreso"))
		{
			signo = "+";
		} else if (tipoMovimiento.contains("egreso")){
			signo = "-";
		} else {
			signo = "error";
		}
		
		return signo;
	}
	
	public void clearProductos(){
		super.clearProductos();
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public List<Producto> getlProductos() {
		return lProductos;
	}
	
	public void setlProductos(List<Producto> lProductos) {
		this.lProductos = lProductos;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	
}
