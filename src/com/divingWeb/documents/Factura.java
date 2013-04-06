package com.divingWeb.documents;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.divingWeb.conexionDAO.TransactionDAO;
import com.divingWeb.elememts.Producto;
import com.divingWeb.elememts.Usuario;

public class Factura extends Documento{
	
	private float totalBruto;
	private float totalMasIva;
	
	public Factura()
	{
		lProductos = new LinkedList<Producto>();
		cliente = null;
		totalBruto = 0;
		totalMasIva = 0;
		cantTotalProductos = 0;
		cantElemProductos = 0;
		tipoDocumento = "A";
		claseDocumento = "factura";
	}
	
	public boolean action(long idCliente){
		
		if (cliente.getId() == idCliente){

			setDia(new java.util.Date());
			
			checkCreditoCliente();
			
			TransactionDAO.actionFactura(this);			
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
	
	public long getIdCliente(){
		if (cliente != null){
			return cliente.getId();
		}
		
		return 0;
	}
	
	public void clearProductos(){
		super.clearProductos();
		
		totalBruto = 0;
		totalMasIva = 0;
		cantTotalProductos = 0;
		cantElemProductos = 0;
		
	}
	
	public float getTotalBruto(){
		return this.totalBruto;
	}

	public void setTotalBruto(float totalBruto) {
		this.totalBruto = totalBruto;
	}
	
	public float getTotalMasIva(){
		return this.totalMasIva;
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
	
}
