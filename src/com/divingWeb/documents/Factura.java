package com.divingWeb.documents;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import com.divingWeb.conexionDAO.TransactionDAO;
import com.divingWeb.elememts.Usuario;
import com.divingWeb.elememts.Producto;

public class Factura extends Documento{
	
	private int nroFactura;
	private float totalBruto;
	private float totalMasIva;
	private String tipo;
	
	public Factura()
	{
		lProductos = new LinkedList<Producto>();
		cliente = null;
		totalBruto = 0;
		totalMasIva = 0;
		cantidadProductos = 0;
		tipoDocumento = "factura";
	}
	
	public boolean ejecutate(long idCliente){
		
		if (cliente.getId() == idCliente){
			setDia(new Date(0));
			
			checkCreditoCliente();
			
			TransactionDAO.guardarFactura(this);			
		}
		
		return true;
	}
	
	public boolean checkCreditoCliente(){
		
		if (totalMasIva == cliente.getCredito() )
			return true;
		
		return false;
	}
	
	public Producto addProducto(int getGuid, int cantidad)
	{
		Producto nuevoProducto = super.addProducto(getGuid, cantidad);
		
		if (nuevoProducto == null)
			return null;
		
		totalBruto += nuevoProducto.getPrecio();
		totalMasIva = (totalBruto * IVA) + totalBruto;
			
		return nuevoProducto;
	}
	
	public List<Producto> listProductos()
	{	
		return lProductos;
	}
	
	public float getTotalBruto(){
		return this.totalBruto;
	}
	
	public float getTotalMasIva(){
		return this.totalMasIva;
	}

	public int getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}

	public void setTotalBruto(float totalBruto) {
		this.totalBruto = totalBruto;
	}

	public void setTotalMasIva(float totalMasIva) {
		this.totalMasIva = totalMasIva;
	}

	public List<Producto> getlProductos() {
		return lProductos;
	}

	public void setlProductos(List<Producto> lProductos) {
		this.lProductos = lProductos;
	}

	public Usuario getCajero() {
		return cajero;
	}

	public void setCajero(Usuario cajero) {
		this.cajero = cajero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
