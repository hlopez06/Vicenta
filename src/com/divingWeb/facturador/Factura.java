package com.divingWeb.facturador;

import java.util.LinkedList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Empleado;
import com.divingWeb.elememts.Producto;
import com.divingWeb.hibernate.HibernateUtil;

public class Factura {
	
	private float iva = 0.21F;
	
	private List<Producto> lProductos;
	private List<Cliente> lClientes;
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
		
	}
	
	public List<Cliente> setCliente(Cliente unCliente)
	{
		if (lClientes.get(unCliente.guid) == null){

			lClientes.add(unCliente.guid, unCliente);
		}
		
		return lClientes;
	}
	public List<Producto> setProducto(int idProducto, int cantidad)
	{
		boolean encontrado = false;
		Producto nuevoProducto = null;

		for (Producto unProducto : lProductos) {
			if(unProducto.getIdProducto() == idProducto)
			{
				unProducto.setCantidad(unProducto.getCantidad() + cantidad);
				nuevoProducto = unProducto;
				encontrado = true;
			}
		}
		
		if( !encontrado ){
			nuevoProducto = new Producto(idProducto, cantidad);
			lProductos.add(nuevoProducto);
			
		}
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(nuevoProducto);
		
		transaction.commit();
		session.close();
		
		
		totalBruto += cantidad;
		totalMasIva = (totalBruto * iva) + totalBruto;
			
		return lProductos;
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
	
}
