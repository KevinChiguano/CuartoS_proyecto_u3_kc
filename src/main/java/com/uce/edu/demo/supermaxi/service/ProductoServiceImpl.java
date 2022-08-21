package com.uce.edu.demo.supermaxi.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.modelo.ProductoSuper;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(ProductoSuper producto) {
		// TODO Auto-generated method stub
		this.productoRepository.insertar(producto);
	}

	@Override
	public ProductoSuper buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.productoRepository.buscar(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(ProductoSuper producto) {
		// TODO Auto-generated method stub
		this.productoRepository.actualizar(producto);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.productoRepository.eliminar(id);
	}

	@Override
	public ProductoSuper buscarPorCodigoBarra(String codigo) {
		// TODO Auto-generated method stub
		return this.productoRepository.buscarPorCodigoBarra(codigo);
	}

}
