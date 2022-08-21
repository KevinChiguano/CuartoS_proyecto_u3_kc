package com.uce.edu.demo.supermaxi.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uce.edu.demo.supermaxi.modelo.FacturaSuper;
import com.uce.edu.demo.supermaxi.repository.IFacturaRepository;

@Service
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired
	private IFacturaRepository facturaRepository;

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

}
