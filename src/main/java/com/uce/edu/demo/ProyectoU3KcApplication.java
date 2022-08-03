package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3KcApplication implements CommandLineRunner {

	private static final Logger LOGGER = Logger.getLogger(ProyectoU3KcApplication.class);

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOGGER.info("Inner Join");
		List<Hotel> listahoteles = this.hotelService.buscarHotelInnerJoin("Familiar");
		for (Hotel h : listahoteles) {
			LOGGER.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		List<Hotel> listahoteles2 = this.hotelService.buscarHotelInnerJoin();
		for (Hotel h : listahoteles2) {
			LOGGER.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
		}
		

		// Left
		LOGGER.info("Left Join");
		List<Hotel> listahotelesLeft = this.hotelService.buscarHotelOuterJoinLeft("Familiar");
		for (Hotel h : listahotelesLeft) {
			LOGGER.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}

		List<Hotel> listahotelesLeft2 = this.hotelService.buscarHotelOuterJoinLeft();
		for (Hotel h : listahotelesLeft2) {
			LOGGER.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
		}
		
		// Right
		LOGGER.info("Right Join");
		List<Hotel> listahotelesRight = this.hotelService.buscarHotelOuterJoinRigth("Familiar");
		for (Hotel h : listahotelesRight) {
			LOGGER.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}

	}

}
