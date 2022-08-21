package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.modelo.FacturaSuper;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(FacturaSuper factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public FacturaSuper buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(FacturaSuper.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(FacturaSuper factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public FacturaSuper buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		
		TypedQuery<FacturaSuper> myQuery = this.entityManager.createQuery("SELECT f FROM FacturaSuper f WHERE f.numero =:numero", FacturaSuper.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}
