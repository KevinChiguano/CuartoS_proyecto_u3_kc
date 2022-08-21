package com.uce.edu.demo.supermaxi.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura_super")
public class FacturaSuper {

	@Id
	@Column(name = "fact_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fact_id_seque")
	@SequenceGenerator(name = "fact_id_seque", sequenceName = "fact_id_seque", allocationSize = 1)
	private Integer id;

	@Column(name = "fact_fecha")
	private LocalDateTime fecha;

	@Column(name = "fact_numero")
	private String numero;

	@ManyToOne
	@JoinColumn(name = "fact_clie_id")
	private ClienteSuper cliente;

	@OneToMany(mappedBy = "factura")
	private List<DetalleFacturaSuper> detalles;

	//GET y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ClienteSuper getCliente() {
		return cliente;
	}

	public void setCliente(ClienteSuper cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFacturaSuper> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFacturaSuper> detalles) {
		this.detalles = detalles;
	}

}
