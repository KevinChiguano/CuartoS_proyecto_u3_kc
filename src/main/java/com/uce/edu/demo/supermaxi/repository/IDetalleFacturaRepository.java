package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.modelo.DetalleFacturaSuper;

public interface IDetalleFacturaRepository {
	
	public void insertar(DetalleFacturaSuper detalle);
	public DetalleFacturaSuper buscar(Integer id);
	public void actualizar(DetalleFacturaSuper detalle);
	public void eliminar(Integer id);

}
