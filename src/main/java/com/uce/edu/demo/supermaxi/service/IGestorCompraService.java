package com.uce.edu.demo.supermaxi.service;

import java.util.List;

public interface IGestorCompraService {
	
	public void compraProductos(String cedulaCliente, String numerofactura, List<String> codigoBarra);

}
