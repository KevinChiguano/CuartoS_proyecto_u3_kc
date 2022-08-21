package com.uce.edu.demo.supermaxi.service;

import com.uce.edu.demo.supermaxi.modelo.FacturaSuper;

public interface IFacturaService {
	
	public void insertar(FacturaSuper factura);
	public FacturaSuper buscar(Integer id);
	public void actualizar(FacturaSuper factura);
	public void eliminar(Integer id);
	
	public FacturaSuper buscarPorNumero(String numero);

}
