package com.divingWeb.documents;

import java.sql.Date;
import java.util.List;

import com.divingWeb.conexionDAO.ProductDAO;
import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Deposito;
import com.divingWeb.elememts.Producto;
import com.divingWeb.elememts.StockProducto;
import com.divingWeb.elememts.Usuario;

public abstract class Documento {
	
	static float IVA = 0.21F;
	
	protected long id;
	protected List<Producto> lProductos;
	protected Usuario usuario;
	protected int nroDocumento;
	protected int cantidadProductos;
	protected Date dia;
	protected String tipoDocumento;
	protected Cliente cliente;
	protected Usuario cajero;
	protected Deposito deposito;

	public Producto addProducto(int getId, int cantidad)
	{
		boolean encontrado = false;
		Producto nuevoProducto = null;

		for (Producto unProducto : lProductos) {
			if(unProducto.getId() == getId)
			{
				unProducto.setCantidad(unProducto.getCantidad() + cantidad);
				nuevoProducto = unProducto;
				encontrado = true;
				
				break;
			}
		}
		
		if( !encontrado ){
			nuevoProducto = ProductDAO.buscarProducto(getId);
			
			if (nuevoProducto == null)
					return null;
			
			nuevoProducto.setCantidad(cantidad);
			lProductos.add(nuevoProducto);
		}
		
		cantidadProductos += cantidad;
			
		return nuevoProducto;
	}
	
	protected void clearProductos(){
		lProductos.clear();
	}
	
	protected float getIva() {
		return IVA;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	protected List<Producto> getlProductos() {
		return lProductos;
	}
	protected void setlProductos(List<Producto> lProductos) {
		this.lProductos = lProductos;
	}
	protected Usuario getUsuario() {
		return usuario;
	}
	protected void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	protected int getNroDocumento() {
		return nroDocumento;
	}
	protected void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	protected int getCantidadProductos() {
		return cantidadProductos;
	}
	protected void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}
	protected Date getDia() {
		return dia;
	}
	protected void setDia(Date dia) {
		this.dia = dia;
	}	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public Usuario getCajero() {
		return cajero;
	}

	public void setCajero(Usuario cajero) {
		this.cajero = cajero;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

}
