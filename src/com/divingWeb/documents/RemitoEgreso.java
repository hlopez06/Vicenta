package com.divingWeb.documents;

import java.util.List;

import com.divingWeb.conexionDAO.ClientDAO;
import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Producto;


public class RemitoEgreso extends Remito {
		
	public RemitoEgreso () {
		super();
		tipoMovimiento = "egreso";
		signo = "+";
		cliente = null;
	}
	
	public Boolean existsRemitente (){
		if (cliente == null)
			return false;
		return true;
	}
	
	public Boolean setRemitentePorID (long idCliente){
		Cliente cliente = ClientDAO.buscarCliente(idCliente);
		
		setRemitente(cliente);

		return true;
	}
	
	public void setRemitente(Cliente cliente){
		this.cliente = cliente;		
	}
	
	public String getSigno(){
		return signo;
	}

	public List<Producto> getlProductos() {
		return lProductos;
	}

	public void setlProductos(List<Producto> lProductos) {
		this.lProductos = lProductos;
	}
}

