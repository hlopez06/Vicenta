package com.divingWeb.facturador;

import java.util.LinkedList;
import java.util.List;

import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Usuario;
import com.divingWeb.elememts.Producto;

public class Factura extends EconomicDocument{
	
	private int nroFactura;
	private float totalBruto;
	private float totalMasIva;
	private String tipo;
	
	public Factura()
	{
		lClientes = new LinkedList<Cliente>();
		lProductos = new LinkedList<Producto>();
		totalBruto = 0;
		totalMasIva = 0;
		cantidadProductos = 0;
		cliente = null;
		tipoDocumento = "factura";
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

	public List<Cliente> getlClientes() {
		return lClientes;
	}

	public void setlClientes(List<Cliente> lClientes) {
		this.lClientes = lClientes;
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
