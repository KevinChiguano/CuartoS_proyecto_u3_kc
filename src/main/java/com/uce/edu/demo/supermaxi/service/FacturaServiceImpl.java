package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.modelo.ClienteSuper;
import com.uce.edu.demo.supermaxi.modelo.DetalleFacturaSuper;
import com.uce.edu.demo.supermaxi.modelo.FacturaSuper;
import com.uce.edu.demo.supermaxi.modelo.ProductoSuper;
import com.uce.edu.demo.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;

@Service
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(FacturaSuper factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.insertar(factura);
	}

	@Override
	public FacturaSuper buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscar(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(FacturaSuper factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.actualizar(factura);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.facturaRepository.eliminar(id);
	}

	@Override
	public FacturaSuper buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarPorNumero(numero);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal procesarFactura(String cedulaCliente, String numerofactura, List<String> codigoBarra) {
		// TODO Auto-generated method stub
		
		BigDecimal totalPagar = BigDecimal.ZERO;
		ClienteSuper cliente =  this.clienteRepository.buscarPorCedula(cedulaCliente);
		
		FacturaSuper fact = new FacturaSuper();
		fact.setCliente(cliente);
		fact.setFecha(LocalDateTime.now());
		fact.setNumero(numerofactura);
		
		List<DetalleFacturaSuper> detalles = new ArrayList<>();
		
		for(String codigoProd : codigoBarra) {
			DetalleFacturaSuper deta = new DetalleFacturaSuper();
			deta.setCantidad(1);
			deta.setFactura(fact);
			
			ProductoSuper producto = this.productoRepository.buscarPorCodigoBarra(codigoProd);
			deta.setProducto(producto);
			deta.setSubtotal(producto.getPrecio());
			totalPagar.add(deta.getSubtotal());
			producto.setStock(producto.getStock()-deta.getCantidad());
			this.productoRepository.actualizar(producto);
			detalles.add(deta);
			
		}
		
		fact.setDetalles(detalles);
		
		this.facturaRepository.insertar(fact);
		
		return totalPagar;
	}

}
