package com.divingWeb.documents;

import com.divingWeb.elememts.Deposito;
import com.divingWeb.elememts.Usuario;

public class ElementFactory extends Documento{
	
	private long id;
	private String tipo;
	private int idIndentity;
	private Usuario usuario;
	private Deposito deposito;
	private String tipoMovimiento;
	
	public ElementFactory(){
	
	}
	
	public ElementFactory(String tipoIdentity, Usuario us){
		tipo = tipoIdentity;
		usuario = us;
	}
	
}
