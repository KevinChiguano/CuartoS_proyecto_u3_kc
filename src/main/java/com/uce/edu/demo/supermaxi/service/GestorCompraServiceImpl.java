package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorCompraServiceImpl implements IGestorCompraService {
	
	@Autowired 
	private IFacturaElectronicaService electronicaService;
	
	@Autowired
	private IFacturaService facturaService;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void compraProductos(String cedulaCliente, String numerofactura, List<String> codigoBarra) {
		// TODO Auto-generated method stub
		
		BigDecimal totalPagar = this.facturaService.procesarFactura(cedulaCliente, numerofactura, codigoBarra);
		
		this.electronicaService.procesarElectronica(numerofactura, codigoBarra.size(), totalPagar);
		
	}

}
