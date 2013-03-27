package com.divingWeb.documents;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.divingWeb.conexionDAO.TransactionDAO;
import com.divingWeb.elememts.Cliente;
import com.divingWeb.elememts.Deposito;
import com.divingWeb.elememts.Proveedor;
import com.divingWeb.elememts.Producto;
import com.divingWeb.elememts.Usuario;

public class Remito extends Documento {
	
	private Proveedor proveedor;
	private String tipoMovimiento;
	
	public Remito(){
		lProductos = new LinkedList<Producto>();
		cliente = null;
		proveedor = null;
		cantTotalProductos = 0;
		cantElemProductos = 0;
		tipoDocumento = "remito";
		tipoMovimiento = "ingreso";
	}
	
	public boolean action(){
		
		TransactionDAO.remitoAction(this);
		
		return true;
	}
	
	public Producto addProducto (int codigo, int cantidad){ 
		return super.addProducto (codigo, cantidad);
		
	}
	
	public String signoMovimiento(){
		String signo;
		
		if (tipoMovimiento.contains("ingreso"))
		{
			signo = "+";
		} else if (tipoMovimiento.contains("egreso")){
			signo = "-";
		} else {
			signo = "error";
		}
		
		return signo;
	}
	
	public void clearProductos(){
		super.clearProductos();
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
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
	public void setlProductos(LinkedList<Producto> lProductos) {
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
