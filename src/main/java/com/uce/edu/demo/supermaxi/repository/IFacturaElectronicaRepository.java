package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.modelo.FacturaElectronica;

public interface IFacturaElectronicaRepository {
	
	public void insertar(FacturaElectronica electronica);
	public FacturaElectronica buscar(Integer id);
	public void actualizar(FacturaElectronica electronica);
	public void eliminar(Integer id);

}
