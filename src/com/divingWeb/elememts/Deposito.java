package com.divingWeb.elememts;

public class Deposito {
	private long id;
	private String nombre;
	private String ubicacion;
	private int tamanioMaximo;
	
	public Deposito(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getTamanioMaximo() {
		return tamanioMaximo;
	}

	public void setTamanioMaximo(int tamanioMaximo) {
		this.tamanioMaximo = tamanioMaximo;
	}
}
