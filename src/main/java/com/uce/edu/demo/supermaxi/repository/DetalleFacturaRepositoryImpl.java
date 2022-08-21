package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.modelo.DetalleFacturaSuper;

@Repository
@Transactional
public class DetalleFacturaRepositoryImpl implements IDetalleFacturaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(DetalleFacturaSuper detalle) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalle);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public DetalleFacturaSuper buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(DetalleFacturaSuper.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(DetalleFacturaSuper detalle) {
		// TODO Auto-generated method stub
		this.entityManager.merge(detalle);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

}
