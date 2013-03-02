package com.divingWeb.facturador;

import java.sql.Date;

import com.divingWeb.conexionDAO.TransactionDAO;

public class Facturador {
	
	public Facturador(){
		
	}
	
	public static boolean facturar(Factura factura){
		factura.setDia(new Date(0));
		
		factura.checkCreditoCliente();
		
		
		
		TransactionDAO.guardarFactura(factura);
		
		return true;
	}

}
