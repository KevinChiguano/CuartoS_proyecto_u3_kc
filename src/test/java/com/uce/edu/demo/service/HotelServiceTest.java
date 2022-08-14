package com.uce.edu.demo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.HotelRepositoryImpl;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.HotelServiceImpl;

@SpringBootTest
@Rollback(true)
@Transactional
class HotelServiceTest {

	private static Logger LOG =  LogManager.getLogger(HotelServiceTest.class);

	List<Hotel> listaHoteles;

	@MockBean
	private HotelRepositoryImpl hotelRepoImpl;

	@Autowired()
	private HotelServiceImpl hotelServiceImpl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		LOG.info("INICIO DE LAS TODAS PRUEBAS");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		LOG.info("FIN DE TODAS LAS PRUEBAS");
	}

	@BeforeEach
	void setUp() throws Exception {
		LOG.info("Iniciando prueba unitaria");
		Hotel hotel = new Hotel();

		listaHoteles = new ArrayList<>();
		listaHoteles.add(hotel);

	}

	@AfterEach
	void tearDown() throws Exception {
		LOG.info("Termina la prueba unitaria");

	}

	@Test
	void test() {

		when(hotelRepoImpl.buscarHotelInnerJoin("Familiar")).thenReturn(listaHoteles);
		assertEquals(listaHoteles, hotelServiceImpl.buscarHotelInnerJoin("Familiar"));

	}

}