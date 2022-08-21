package com.uce.edu.demo.supermaxi.service;

import com.uce.edu.demo.supermaxi.modelo.ProductoSuper;

public interface IProductoService {
	
	public void insertar(ProductoSuper producto);
	public ProductoSuper buscar(Integer id);
	public void actualizar(ProductoSuper producto);
	public void eliminar(Integer id);
	
	public ProductoSuper buscarPorCodigoBarra(String codigo);

}
