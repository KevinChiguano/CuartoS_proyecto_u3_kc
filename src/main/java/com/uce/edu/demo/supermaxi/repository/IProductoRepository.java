package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.modelo.ProductoSuper;

public interface IProductoRepository {
	
	public void insertar(ProductoSuper producto);
	public ProductoSuper buscar(Integer id);
	public void actualizar(ProductoSuper producto);
	public void eliminar(Integer id);
	
	public ProductoSuper buscarPorCodigoBarra(String codigo);

}
