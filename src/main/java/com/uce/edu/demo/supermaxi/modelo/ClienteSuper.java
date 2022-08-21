package com.uce.edu.demo.supermaxi.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_super")
public class ClienteSuper {

	@Id
	@Column(name = "clie_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_id_seque")
	@SequenceGenerator(name = "clie_id_seque", sequenceName = "clie_id_seque", allocationSize = 1)
	private Integer id;

	@Column(name = "clie_nombre")
	private String nombre;

	@Column(name = "clie_cedula")
	private String cedula;

	@OneToMany(mappedBy = "cliente")
	private List<FacturaSuper> facturas;

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<FacturaSuper> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaSuper> facturas) {
		this.facturas = facturas;
	}

}
