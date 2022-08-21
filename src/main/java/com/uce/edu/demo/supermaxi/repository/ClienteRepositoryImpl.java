package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.modelo.ClienteSuper;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(ClienteSuper cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public ClienteSuper buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(ClienteSuper.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(ClienteSuper cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public ClienteSuper buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<ClienteSuper> myQuery = this.entityManager.createQuery("SELECT c FROM ClienteSuper c WHERE c.cedula =: cedula", ClienteSuper.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

}
