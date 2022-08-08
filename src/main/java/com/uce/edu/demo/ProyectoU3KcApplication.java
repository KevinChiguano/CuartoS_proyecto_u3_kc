package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3KcApplication implements CommandLineRunner {

	private static final Logger LOGGER = Logger.getLogger(ProyectoU3KcApplication.class);

	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Relacionamiento Where
		
		/*LOGGER.info("Relacionamiento Where");
		List<Hotel> listahoteles = this.hotelService.buscarHotelJoinWhere("Familiar");
		for (Hotel h : listahoteles) {
			LOGGER.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		LOGGER.info("Inner Join EAGER/LAZY");
		List<Hotel> listahoteles2 = this.hotelService.buscarHotelInnerJoin("Familiar");
		for (Hotel h : listahoteles2) {
			LOGGER.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
			
			for(Habitacion ha:h.getHabitaciones()) {
				LOGGER.info("Habitacion2: "+ha);
			}
			
		}
		
		LOGGER.info("Join Fetch");
		List<Hotel> listahoteles3 = this.hotelService.buscarHotelFetchJoin("Familiar");
		for (Hotel h : listahoteles3) {
			LOGGER.info("Hotel3: " + h.getNombre() + " " + h.getDireccion());
			
			for(Habitacion ha:h.getHabitaciones()) {
				LOGGER.info("Habitacion3: "+ha);
			}
			
		}*/
		
		
		LOGGER.info("Relacionamiento Where");
		
		List<Factura> lista2 = this.facturaService.buscarFacturaJoinWhere();
		for(Factura item: lista2) {
			LOGGER.info("Factura : "+item.getNumero()+" "+item.getFecha());
			for(DetalleFactura detalles : item.getDetalles()) {
				LOGGER.info("Detalles: "+detalles);
			}
		}
		
		LOGGER.info("Fetch Join");
		
		List<Factura> lista3 = this.facturaService.buscarFacturaFetchJoin();
		for(Factura item: lista3) {
			LOGGER.info("Factura : "+item.getNumero()+" "+item.getFecha());
			for(DetalleFactura detalles : item.getDetalles()) {
				LOGGER.info("Detalles: "+detalles);
			}
		}
		
	}

}
