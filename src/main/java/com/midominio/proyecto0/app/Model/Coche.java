package com.midominio.proyecto0.app.Model;

import java.util.Objects;

public class Coche {
	
	private String matricula;
	private String marca;
	private String modelo;
	
	public Coche() {
	}
	
	public Coche(String matricula) {
		this.matricula = matricula;
	}
	
	public Coche(String matricula, String marca, String modelo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		return this.matricula.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Coche c= (Coche)obj;
		return c.getMatricula().equalsIgnoreCase(matricula);
	}

	
	

	
	
}
