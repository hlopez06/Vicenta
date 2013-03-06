package com.divingWeb.documents;

import com.divingWeb.elememts.Deposito;
import com.divingWeb.elememts.Usuario;

public class ElementHistory extends Documento{
	
	private final String FACTORY = "factory";
	
	private String tipo;
	private Deposito deposito;
	private String tipoMovimiento;
	
	public ElementHistory(){
	
	}
	
	public ElementHistory(String tipoIdentity, Usuario us){
		tipoDocumento = FACTORY;
		tipo = tipoIdentity;
		usuario = us;
	}

	public String getTipo() {
		return tipo;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	
}
