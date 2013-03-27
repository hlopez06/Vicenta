package com.divingWeb.documents;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.divingWeb.conexionDAO.ProductDAO;
import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Deposito;
import com.divingWeb.elememts.Producto;
import com.divingWeb.elememts.Usuario;

public abstract class Documento {
	
	static float IVA = 0.21F;
	
	protected long id;
	protected List<Producto> lProductos;
	protected Usuario usuario;
	protected int nroDocumento;
	protected int cantTotalProductos;
	protected int cantElemProductos;
	protected Date dia;
	protected String tipoDocumento;
	protected String claseDocumento;
	protected Cliente cliente;
	protected Usuario cajero;
	protected Deposito deposito;

	private Producto searchProducto(int codigo)
	{
		for (Producto unProducto : lProductos) {
			if(unProducto.getCodigo() ==  codigo)
			{
				return unProducto;
			}
		}
		return null;
	}	
	public Producto addProducto (int codigo, int cantidad){ 	
		
		Producto producto = searchProducto(codigo);
		
		if( producto == null ){
			producto = ProductDAO.buscarProducto(codigo);
			
			if (producto == null)
					return null;
			
			++cantElemProductos;
			producto.setCantidad(cantidad);
			lProductos.add(producto);
		} else {
			producto.sumarCantidad(cantidad);
		}
		cantTotalProductos += cantidad;
		
		return producto;
	}
	
	public Producto extractProducto (int codigo, int cantidad){ 	
		
		if(cantidad > 0)
			cantidad = (cantidad * -1);
		
		Producto producto = searchProducto(codigo);
		
		if( producto != null ){
			producto.restarCantidad(cantidad);
			
			if(producto.getCantidad() == 0){
				lProductos.remove(producto);
				--cantElemProductos;				
			}

		} else {
			return null;
		}
		cantTotalProductos -= cantidad;
		
		return producto;
	}

	public boolean removeProducto (int codigo){ 	
	
		Producto producto = searchProducto(codigo);
		
		if( producto != null ){
			cantTotalProductos -= producto.getCantidad();
			lProductos.remove(producto);
			--cantElemProductos;
			
			return true;
		}
		
		return false;
	}
	
	
	public void clearProductos(){
		lProductos.clear();
	}
	
	public float getIva() {
		return IVA;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Producto> getlProductos() {
		return lProductos;
	}
	public void setlProductos(List<Producto> lProductos) {
		this.lProductos = lProductos;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public int getCantTotalProductos() {
		return cantTotalProductos;
	}
	public void setCantTotalProductos(int cantTotalProductos) {
		this.cantTotalProductos = cantTotalProductos;
	}
	public int getCantElemProductos() {
		return cantElemProductos;
	}
	public void setCantElemProductos(int cantElemProductos) {
		this.cantElemProductos = cantElemProductos;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getClaseDocumento() {
		return claseDocumento;
	}
	public void setClaseDocumento(String claseDocumento) {
		this.claseDocumento = claseDocumento;
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
