package com.divingWeb.facturador;

import java.util.LinkedList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import com.divingWeb.conexionDAO.ProductDAO;
import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Empleado;
import com.divingWeb.elememts.Producto;
import com.divingWeb.hibernate.HibernateUtil;

public class Factura {
	
	private float iva = 0.21F;
	
	private List<Producto> lProductos;
	private List<Cliente> lClientes;
	private Cliente cliente;
	private Empleado cajero;
	private int nroFactura;
	private float totalBruto;
	private float totalMasIva;
	private String tipo;
	
	public Factura()
	{
		totalBruto = 0;
		totalMasIva = 0;
		lProductos = new LinkedList<Producto>();
		lClientes = new LinkedList<Cliente>();
		cliente = null;
	}
	
	public boolean addProductos(int getGuid, int cantidad)
	{
		boolean encontrado = false;
		Producto nuevoProducto = null;

		for (Producto unProducto : lProductos) {
			if(unProducto.getGuid() == getGuid)
			{
				unProducto.setCantidad(unProducto.getCantidad() + cantidad);
				nuevoProducto = unProducto;
				encontrado = true;
			}
		}
		
		if( !encontrado ){
			nuevoProducto = ProductDAO.buscarProducto(getGuid);
			
			if (nuevoProducto != null) {
				nuevoProducto.setCantidad(cantidad);
			}else{
				return false;
			}
			lProductos.add(nuevoProducto);
		}
		
		totalBruto += nuevoProducto.getPrecio();
		totalMasIva = (totalBruto * iva) + totalBruto;
			
		return true;
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

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getCajero() {
		return cajero;
	}

	public void setCajero(Empleado cajero) {
		this.cajero = cajero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
