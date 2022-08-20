package com.uce.edu.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(true)
@Transactional
class Impl2Test {
	
	private static Logger LOG =  LogManager.getLogger(Impl2Test.class);

	@Autowired
    private IHotelRepository hotelRepo;

    @Mock
    private IHotelRepository hotelRepo2;

    @Autowired
    private IHotelService hotelService;

    @Test
    @Order(1)
    public void testGuardarHotel() {
        LOG.info("Test guardar hotel 1");
        Hotel hotel= new Hotel();
        hotel.setNombre("angel7");
        hotel.setDireccion("san luis7");

        Hotel hotelGuardado =  this.hotelRepo.insertar(hotel);

        assertNotNull(hotelGuardado);//me va a confirmar la prueba simpre y cuando no sea nulo
    }

    @Test
    @Order(3)
    public void testBuscarHotel() {
        LOG.info("Test buscar hotel 3");
        Integer id = 2;
        Hotel hotel = this.hotelRepo.buscar(id);

        assertThat(hotel.getId()).isEqualTo(id);
    }


    @Test
    @Order(2)
    public void buscarHotelLeftOuterJoinTest() {//**
        LOG.info("Test buscarHotelLeftOuterJoinTest hotel 2");

        Hotel hotel= new Hotel();
        hotel.setNombre("Gran Colon");
        hotel.setDireccion("Patria");
        hotel.setId(1);

        when(this.hotelRepo2.buscarHotelOuterJoinLeft("Familiar")).thenReturn(Arrays.asList(hotel));
        assertNotNull(hotelService.buscarHotelOuterJoinLeft());

    }

    @Test
    @Order(5)
    public void actualizarHotelTest() {
        LOG.info("Test actualizar hotel 5");
        Integer id = 3;

        Hotel hotel= new Hotel();
        hotel.setNombre("marco1");
        hotel.setDireccion("calle 21 A1");
        hotel.setId(id);

        Hotel hotelActualizado =  this.hotelRepo.actualizar(hotel);

        assertThat(hotelActualizado.getId()).isEqualTo(id);//confirmo si el proidcuto actulizado
    }


}
