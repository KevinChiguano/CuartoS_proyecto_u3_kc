package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {
	
	private static final Logger LOGGER = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		
		//SUPPLIER
		
		//clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOGGER.info("Supplier Clase: "+supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		LOGGER.info("Supplier Clase: "+supplierTE.getNombre());
		
		//lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Kevin2";
		LOGGER.info("Supplier Lambda: "+supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel TE2";
		LOGGER.info("Supplier Lambda: "+supplierLambda.getNombre());
		
		//Metodos High Order
		String valorHO = metodosHO.consumirSupplier(()->"Hola mundo");
		LOGGER.info("HO Supplier "+ valorHO);
		
		String valorHO1 = metodosHO.consumirSupplier(()->{
			String valorConsultado = "17128383";
			return valorConsultado;
			});
		LOGGER.info("HO Supplier "+ valorHO1);
		
		//CONSUMER
		
		//clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		//lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);
		
		
		//PREDICATE
		
		//clases
		//lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOGGER.info("Predicate Lambdas: "+predicateLambda.evaluar("Kevin con Z"));
		
		//Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("A"), "Kevin con Z");
		LOGGER.info("HO Predicate "+respuesta);
		
		//FUNCTION
		
		//clases
		//lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor-2;
			return valorFinal;
			};
		
		LOGGER.info("Function Lambdas: "+ functionLambda.aplicar("7"));
		
		//Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorn = valor.toString()+"A";
			return retorn;
		}, 1);
		
		LOGGER.info("HO Function: "+valorFinalHO);
		
		//UNARY OPERATOR (FUNCTION)
		
		//clases
		//lambdas
		
		IPersonaUnaryOperator<String> unaryLambda = cade -> {
			String valorFinal = cade.concat(" sufijo");
			return valorFinal;
		};
		
		LOGGER.info("Unari Operator Lamda: "+ unaryLambda.apply("Daniel"));
	}

}
