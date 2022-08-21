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
import com.uce.edu.demo.supermaxi.modelo.FacturaElectronica;
import com.uce.edu.demo.supermaxi.modelo.ProductoSuper;
import com.uce.edu.demo.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.supermaxi.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;

@Service
public class GestorCompraServiceImpl implements IGestorCompraService {
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepository;
	
	@Autowired
	private IDetalleFacturaRepository detalleFacturaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void compraProductos(String cedulaCliente, String numerofactura, List<String> codigoBarra) {
		// TODO Auto-generated method stub
		
		ClienteSuper cliente = this.clienteRepository.buscarPorCedula(cedulaCliente);
		
		FacturaSuper factura = new FacturaSuper();
		
		factura = this.facturaRepository.buscarPorNumero(numerofactura);
		
		ProductoSuper producto = new ProductoSuper();
		List<DetalleFacturaSuper> detalles = new ArrayList<>();
		
		
		for(String codigos: codigoBarra) {
			DetalleFacturaSuper detalle = new DetalleFacturaSuper();
			producto = this.productoRepository.buscarPorCodigoBarra(codigos);
			detalle.setCantidad(1);
			detalle.setFactura(factura);
			detalle.setProducto(producto);
			detalle.setSubtotal(producto.getPrecio());
			detalles.add(detalle);
			this.detalleFacturaRepository.insertar(detalle);
			
			this.productoRepository.actualizar(producto);
			if(producto.getStock() < 1) {
				throw new RuntimeException();
			}
			
		}
		
		BigDecimal monto = new BigDecimal(0);
		Integer numeroItems = 0;
		for(DetalleFacturaSuper deta: detalles) {
			
			monto = monto.add(deta.getSubtotal());
			numeroItems += deta.getCantidad();
		}
		
		FacturaElectronica electronica = new FacturaElectronica();
		electronica.setFechaCreacion(LocalDateTime.now());
		electronica.setMonto(monto);
		electronica.setNumero(numerofactura);
		electronica.setNumeroItems(numeroItems);
		
		this.facturaElectronicaRepository.insertar(electronica);
			
	}

}
