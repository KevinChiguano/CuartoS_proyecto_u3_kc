package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {
	
	public List<Factura> buscarFacturaInnerJoin();
	public List<Factura> buscarFacturaOuterLeftJoin();
	public List<Factura> buscarFacturaOuterRightJoin();
	public List<Factura> buscarFacturaJoinWhere();
	public List<Factura> buscarFacturaFetchJoin();

}