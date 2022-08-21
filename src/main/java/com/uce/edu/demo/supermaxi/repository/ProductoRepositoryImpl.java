package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.modelo.ProductoSuper;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(ProductoSuper producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public ProductoSuper buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(ProductoSuper.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(ProductoSuper producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public ProductoSuper buscarPorCodigoBarra(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<ProductoSuper> myQuery = this.entityManager.createQuery("SELECT p FROM ProductoSuper p WHERE p.codigoBarra =: codigo", ProductoSuper.class);
		myQuery.setParameter("codigo", codigo);
		return myQuery.getSingleResult();
	}

}
