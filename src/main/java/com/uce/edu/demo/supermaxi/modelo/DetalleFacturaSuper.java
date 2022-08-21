package com.uce.edu.demo.supermaxi.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_super")
public class DetalleFacturaSuper {

	@Id
	@Column(name = "deta_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deta_id_seque")
	@SequenceGenerator(name = "deta_id_seque", sequenceName = "deta_id_seque", allocationSize = 1)
	private Integer id;

	@Column(name = "deta_cantidad")
	private Integer cantidad;
	
	@Column(name = "deta_subtotal")
	private BigDecimal subtotal;

	@ManyToOne
	@JoinColumn(name = "deta_fact_id")
	private FacturaSuper factura;

	@ManyToOne
	@JoinColumn(name = "deta_prod_id")
	private ProductoSuper producto;
	
	

	@Override
	public String toString() {
		return "DetalleFacturaSuper [id=" + id + ", cantidad=" + cantidad + ", subtotal=" + subtotal + "]";
	}

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public FacturaSuper getFactura() {
		return factura;
	}

	public void setFactura(FacturaSuper factura) {
		this.factura = factura;
	}

	public ProductoSuper getProducto() {
		return producto;
	}

	public void setProducto(ProductoSuper producto) {
		this.producto = producto;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	
	

}
