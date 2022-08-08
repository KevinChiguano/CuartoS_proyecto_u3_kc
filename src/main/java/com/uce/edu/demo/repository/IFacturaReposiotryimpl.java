package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;

@Repository
@Transactional
public class IFacturaReposiotryimpl implements IFacturaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		
		TypedQuery<Factura> myQuery = entityManager.createQuery("SELECT f FROM Factura f Join f.detalles", Factura.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		// TODO Auto-generated method stub
		
		TypedQuery<Factura> myQuery = entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles", Factura.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin() {
		// TODO Auto-generated method stub
		
		TypedQuery<Factura> myQuery = entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalles", Factura.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin() {
		// TODO Auto-generated method stub
		return null;
	}

}
