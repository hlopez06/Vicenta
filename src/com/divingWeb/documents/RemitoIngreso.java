package com.divingWeb.documents;

import java.util.List;

import com.divingWeb.conexionDAO.ProviderDAO;
import com.divingWeb.elememts.Producto;
import com.divingWeb.elememts.Proveedor;

public class RemitoIngreso extends Remito {
	
	private Proveedor proveedor;
	
	public RemitoIngreso () {
		super();
		tipoMovimiento = "ingreso";
		signo = "-";
		proveedor = null;
	}
	
	public Boolean existsRemitente (){
		if (proveedor == null)
			return false;
		return true;
	}
	
	public Boolean setRemitentePorID (long idProveedor){
		Proveedor proveedor = ProviderDAO.buscarProveedor(idProveedor);
		
		setRemitente(proveedor);

		return true;
	}
	
	public void setRemitente(Proveedor proveedor){
		this.proveedor = (Proveedor) proveedor;		
	}
	
	public String getSigno(){
		return signo;
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
}
