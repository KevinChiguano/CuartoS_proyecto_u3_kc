package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{
	
	private static final Logger LOGGER = Logger.getLogger(HotelRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		List<Hotel> hoteles = myQuery.getResultList();
		for(Hotel h: hoteles) {
			h.getHabitaciones().size();
		}
		
		return myQuery.getResultList();
	}
	
	public List<Hotel> buscarHotelInnerJoin2(String tipoHabitacion) {
		// TODO Auto-generated method stub
		
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",Hotel.class);
		
		return myQuery.getResultList();
	}


	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRigth(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h From Hotel h, Habitacion ha WHERE h = ha.hotel AND ha.tipo =:tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	//@Transactional(value = TxType.MANDATORY)
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		
		//LOGGER.info("Transaccion actiba: "+TransactionSynchronizationManager.isActualTransactionActive());
		
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo =: tipoHabitacion",Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		
		return myQuery.getResultList();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Hotel buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public List<Hotel> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myTypedQuery = (TypedQuery<Hotel>) this.entityManager
                .createQuery("SELECT f FROM Hotel f    ", Hotel.class);
        return myTypedQuery.getResultList();
	}

	@Override
	public Hotel insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
        return hotel;
	}

	@Override
	public Hotel actualizar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.merge(hotel);
        return hotel;
	}

	

	
	
	

}
