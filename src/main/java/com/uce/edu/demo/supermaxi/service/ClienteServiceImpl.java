package com.uce.edu.demo.supermaxi.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.modelo.ClienteSuper;
import com.uce.edu.demo.supermaxi.repository.IClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(ClienteSuper cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.insertar(cliente);
	}

	@Override
	public ClienteSuper buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepository.buscar(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(ClienteSuper cliente) {
		// TODO Auto-generated method stub
		this.clienteRepository.actualizar(cliente);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.clienteRepository.eliminar(id);
	}

	@Override
	public ClienteSuper buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepository.buscarPorCedula(cedula);
	}

}
