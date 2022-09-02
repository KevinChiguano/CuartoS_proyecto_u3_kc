package com.uce.edu.demo.hilos.tradicional;

import java.util.List;

public class Doctor {

	String nombre;
	String especialidad;
	List<String> pacientes;
	
	

	public Doctor(String nombre, String especialidad, List<String> pacientes) {
		super();
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.pacientes = pacientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public List<String> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<String> pacientes) {
		this.pacientes = pacientes;
	}

}
