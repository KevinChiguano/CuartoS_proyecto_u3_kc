package com.uce.edu.demo.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionalesHotel {
	
	private static final Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsumoHighOrderHotel higtOrder = new ConsumoHighOrderHotel();
		
		//Supplier
		//Clase
		/*IHotelSupplier<Integer> supplier = new HotelSupplierImpl();
		LOG.info("Supplier clase: "+supplier.getPrecio());
		//Lambda
		IHotelSupplier<Integer> supplierLambda = () -> 40;
		LOG.info("Supplier Lambda: "+supplierLambda.getPrecio());
		//High Order
		LOG.info("Supplier HO: "+higtOrder.consumirSupplier(() -> 90));*/
		//JAVA
		LOG.info("JAVA HO Supplier Stream");
		Stream<Integer> supplierJava = Stream.generate(()-> 3*8).limit(5);
		supplierJava.forEach(valor -> System.out.println(valor));
		
		//Consumer
		//Clase
		/*IHotelConsumer<Integer> consumer = new HotelConsumerImpl();
		consumer.accept(120);
		//Lambda
		IHotelConsumer<Integer> consumerLambda = valor -> System.out.println("Consumer Lambda : Precio: "+valor);
		consumerLambda.accept(140);
		//High Order
		higtOrder.consumirConsumer(valor -> System.out.println("Consumer HO: "+valor), 38);*/
		//JAVA
		LOG.info("JAVA HO Consumer Stream");
		List<String> nombres = Arrays.asList("Kevin","Cristian","Vanessa","Valentina");
		nombres.forEach(nombre -> System.out.println(nombre));
		
		//Predicate
	
		//clase
		/*IHotelPredicate<Integer> predicate = new HotelPredicateImpl();
		LOG.info("Predicate clase : "+predicate.evaluar(50));
		
		//Lambda
		IHotelPredicate<Integer> predicateLambda = valor -> {
			Integer valorComparar = 100;
			return valor>valorComparar;
		};
		LOG.info("Predicate Lambda : "+predicateLambda.evaluar(120));
		//High Order
		LOG.info("Predicate HO: "+higtOrder.consumirPredicate(valor -> valor>400, 800));*/
		
		//JAVA
		LOG.info("JAVA HO Predicate Stream");
		Stream<String> nombresLista = nombres.stream().filter(nombre -> nombre.length() > 5);
		nombresLista.forEach(nombre -> System.out.println(nombre));
		
		//Function
		//Clase
		/*IHotelFunction<String, Integer> function = new HotelFunctionImpl();
		LOG.info("Function clase : "+function.apply(54));
		//Lambda
		IHotelFunction<String, Integer> functionLambda = valor -> {
			return "Valor: "+String.valueOf(valor);
		};
		LOG.info("Function Lambda : "+functionLambda.apply(50));
		//High Order
		
		LOG.info("Function HO: "+higtOrder.consumirFunction(valor -> String.valueOf(valor), 180));*/
		
		//JAVA
		LOG.info("JAVA HO Function Stream");
		//Conversiones / cast de un objeto a un objeto sencillo
		Stream<Integer> cambiarLista = nombres.stream().map(nombre ->{
			Integer tam = nombre.length();
			return tam;
		});
				
		System.out.println("longitud de la cadena");
		cambiarLista.forEach(valor-> System.out.println(valor));
		
		//UnaryOperator
		//Clase
		/*IHotelUnaryOperator<Integer> unaryOperator = new HotelUnaryOperatorImpl();
		LOG.info("Unary Operator clase : "+unaryOperator.apply(50));
 		//Lambda
		IHotelUnaryOperator<Integer> unaryOperatorLambda = valor ->{
			return valor+10;
		};
		LOG.info("Unary Operator Lambda : "+unaryOperatorLambda.apply(50));
		//High Order
		LOG.info("Unary Operator HO: "+higtOrder.consumirUnaryOperator(valor -> valor, 150));
		*/
	}

}
