package com.divingWeb.facturador;

import java.util.LinkedList;
import java.util.List;

import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Usuario;

public abstract class EconomicDocument extends Documento {
	
	protected List<Cliente> lClientes;
	protected Cliente cliente;
	protected Usuario cajero;
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
