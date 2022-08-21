package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.modelo.FacturaSuper;

public interface IFacturaRepository {

	public void insertar(FacturaSuper factura);
	public FacturaSuper buscar(Integer id);
	public void actualizar(FacturaSuper factura);
	public void eliminar(Integer id);
	
	public FacturaSuper buscarPorNumero(String numero);
	
}
