package com.modelo;

public class Calcular {
    private Integer gitY = 0;
	private boolean cargado = false;
	private String nombre , direccion;
	private int diasTrabajados;
	private Double valor , salario;
	private Integer idSrl = 0;
	
	
	public Calcular() {
		this.cargado = false;
		this.nombre = "";
		this.direccion = "";
		this.diasTrabajados = 0;
		this.valor = 0.0;
		this.idSrl = 0;
 	}
	
	public void setidSrl(Integer id){
		this.idSrl = id;
	}
	
	public Integer getidSrl(){
		return this.idSrl;
	}
	
	public Boolean EstaCargado(){
		return cargado;
	}
	
	public void CalcularSalario(){
		this.cargado = true;
		this.salario = this.diasTrabajados * this.valor;
	}
	
	
	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(int diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
