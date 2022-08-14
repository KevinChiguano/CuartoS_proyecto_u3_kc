package com.uce.edu.demo;

import java.math.BigDecimal;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3KcApplication implements CommandLineRunner {

	private static final Logger LOGGER = Logger.getLogger(ProyectoU3KcApplication.class);

	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//LOGGER.info("Relacionamiento Where");
		
		/*List<Factura> lista2 = this.facturaService.buscarFacturaJoinWhere();
		for(Factura item: lista2) {
			LOGGER.info("Factura : "+item.getNumero()+" "+item.getFecha());
			for(DetalleFactura detalles : item.getDetalles()) {
				LOGGER.info("Detalles: "+detalles);
			}
		}*/
		
		/*LOGGER.info("Fetch Join");
		
		List<Factura> lista3 = this.facturaService.buscarFacturaFetchJoin();
		for(Factura item: lista3) {
			LOGGER.info("Factura : "+item.getNumero()+" "+item.getFecha());
			for(DetalleFactura detalles : item.getDetalles()) {
				LOGGER.info("Detalles: "+detalles);
			}
		}*/
		
		//this.transferenciaService.realizarTransferenciaFachada("345345", "12312312", new BigDecimal(1));
		
		
	}

}
