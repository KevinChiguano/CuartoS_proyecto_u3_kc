package com.uce.edu.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.modelo.Hotel;

@SpringBootTest
@Rollback(true)
@Transactional
class HotelRepositoryImplTest {

	@Autowired
	private HotelRepositoryImpl hotelRepositoryImpl;
	
	
	@Test
	void testEliminar() {
		Integer id = 2;
		Hotel hotelInicio = hotelRepositoryImpl.buscar(id);
		hotelRepositoryImpl.eliminar(id);
		Hotel hotelFin = hotelRepositoryImpl.buscar(id);
		assertNotNull(hotelInicio);
		assertNull(hotelFin);
	}

}
