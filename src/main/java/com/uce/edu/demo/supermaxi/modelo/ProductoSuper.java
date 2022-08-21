package com.uce.edu.demo.supermaxi.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity()
@Table(name = "producto_super")
public class ProductoSuper {

	@Id
	@Column(name = "prod_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "prod_id_seque")
	@SequenceGenerator(name = "prod_id_seque", sequenceName = "prod_id_seque", allocationSize = 1)
	private Integer id;

	@Column(name = "prod_nombre")
	private String nombre;

	@Column(name = "prod_codigo_barra")
	private String codigoBarra;

	@Column(name = "prod_precio")
	private BigDecimal precio;

	@Column(name = "prod_stock")
	private Integer stock;

	@OneToMany(mappedBy = "producto")
	private List<DetalleFacturaSuper> detalles;


	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", codigoBarra=" + codigoBarra + ", precio=" + precio
				+ ", stock=" + stock + "]";
	}

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

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<DetalleFacturaSuper> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFacturaSuper> detalles) {
		this.detalles = detalles;
	}

}
