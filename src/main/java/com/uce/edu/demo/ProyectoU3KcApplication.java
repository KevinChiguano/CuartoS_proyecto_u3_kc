package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;
import com.uce.edu.demo.supermaxi.modelo.ClienteSuper;
import com.uce.edu.demo.supermaxi.modelo.FacturaSuper;
import com.uce.edu.demo.supermaxi.modelo.ProductoSuper;
import com.uce.edu.demo.supermaxi.repository.IFacturaRepository;
import com.uce.edu.demo.supermaxi.service.IClienteService;
import com.uce.edu.demo.supermaxi.service.IFacturaService;
import com.uce.edu.demo.supermaxi.service.IGestorCompraService;
import com.uce.edu.demo.supermaxi.service.IProductoService;

@SpringBootApplication
public class ProyectoU3KcApplication implements CommandLineRunner {

	private static final Logger LOGGER = Logger.getLogger(ProyectoU3KcApplication.class);

	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IGestorCompraService compraService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*ClienteSuper cliente = new ClienteSuper();
		cliente.setCedula("123456");
		cliente.setNombre("Juan");
		this.clienteService.insertar(cliente);
		
		ClienteSuper cliente2 = new ClienteSuper();
		cliente2.setCedula("789456");
		cliente2.setNombre("Arturo");
		this.clienteService.insertar(cliente2);
		
		ProductoSuper producto = new ProductoSuper();
		producto.setCodigoBarra("0123456");
		producto.setNombre("Pan");
		producto.setPrecio(new BigDecimal(1.50));
		producto.setStock(30);
		this.productoService.insertar(producto);
		
		ProductoSuper producto1 = new ProductoSuper();
		producto1.setCodigoBarra("0789456");
		producto1.setNombre("Leche");
		producto1.setPrecio(new BigDecimal(0.85));
		producto1.setStock(20);
		this.productoService.insertar(producto1);
		
		ProductoSuper producto2 = new ProductoSuper();
		producto2.setCodigoBarra("0789123");
		producto2.setNombre("atun");
		producto2.setPrecio(new BigDecimal(1.45));
		producto2.setStock(20);
		this.productoService.insertar(producto2);

		cliente.setId(1);
		FacturaSuper factura = new FacturaSuper();
		factura.setNumero("00001");
		factura.setFecha(LocalDateTime.now());
		factura.setCliente(cliente);
		this.facturaService.insertar(factura);
		
		cliente2.setId(2);
		FacturaSuper factura2 = new FacturaSuper();
		factura2.setNumero("00002");
		factura2.setFecha(LocalDateTime.now());
		factura2.setCliente(cliente2);
		this.facturaService.insertar(factura2);*/
		
		List<String> codigos = new ArrayList<>();
		codigos.add("0123456");
		codigos.add("0789456");
		codigos.add("0789123");
		this.compraService.compraProductos("123456", "00001", codigos);
		
	}

}
