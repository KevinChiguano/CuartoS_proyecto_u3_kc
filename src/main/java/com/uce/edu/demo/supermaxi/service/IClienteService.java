package com.uce.edu.demo.supermaxi.service;

import com.uce.edu.demo.supermaxi.modelo.ClienteSuper;

public interface IClienteService {
	
	public void insertar(ClienteSuper cliente);
	public ClienteSuper buscar(Integer id);
	public void actualizar(ClienteSuper cliente);
	public void eliminar(Integer id);
	
	public ClienteSuper buscarPorCedula(String cedula);

}
