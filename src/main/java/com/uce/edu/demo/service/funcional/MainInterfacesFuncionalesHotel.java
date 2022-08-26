package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionalesHotel {
	
	private static final Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsumoHighOrderHotel higtOrder = new ConsumoHighOrderHotel();
		
		//Supplier
		//Clase
		IHotelSupplier<Integer> supplier = new HotelSupplierImpl();
		LOG.info("Supplier clase: "+supplier.getPrecio());
		//Lambda
		IHotelSupplier<Integer> supplierLambda = () -> 40;
		LOG.info("Supplier Lambda: "+supplierLambda.getPrecio());
		//High Order
		LOG.info("Supplier HO: "+higtOrder.consumirSupplier(() -> 90));
		
		//Consumer
		//Clase
		IHotelConsumer<Integer> consumer = new HotelConsumerImpl();
		consumer.accept(120);
		//Lambda
		IHotelConsumer<Integer> consumerLambda = valor -> System.out.println("Consumer Lambda : Precio: "+valor);
		consumerLambda.accept(140);
		//High Order
		higtOrder.consumirConsumer(valor -> System.out.println("Consumer HO: "+valor), 38);
		
		//Predicate
		
		//clase
		IHotelPredicate<Integer> predicate = new HotelPredicateImpl();
		LOG.info("Predicate clase : "+predicate.evaluar(50));
		
		//Lambda
		IHotelPredicate<Integer> predicateLambda = valor -> {
			Integer valorComparar = 100;
			return valor>valorComparar;
		};
		LOG.info("Predicate Lambda : "+predicateLambda.evaluar(120));
		//High Order
		LOG.info("Predicate HO: "+higtOrder.consumirPredicate(valor -> valor>400, 800));
		
		//Function
		//Clase
		IHotelFunction<String, Integer> function = new HotelFunctionImpl();
		LOG.info("Function clase : "+function.apply(54));
		//Lambda
		IHotelFunction<String, Integer> functionLambda = valor -> {
			return "Valor: "+String.valueOf(valor);
		};
		LOG.info("Function Lambda : "+functionLambda.apply(50));
		//High Order
		
		LOG.info("Function HO: "+higtOrder.consumirFunction(valor -> String.valueOf(valor), 180));
		
		
		//UnaryOperator
		//Clase
		IHotelUnaryOperator<Integer> unaryOperator = new HotelUnaryOperatorImpl();
		LOG.info("Unary Operator clase : "+unaryOperator.apply(50));
 		//Lambda
		IHotelUnaryOperator<Integer> unaryOperatorLambda = valor ->{
			return valor+10;
		};
		LOG.info("Unary Operator Lambda : "+unaryOperatorLambda.apply(50));
		//High Order
		LOG.info("Unary Operator HO: "+higtOrder.consumirUnaryOperator(valor -> valor, 150));
		
	}

}
