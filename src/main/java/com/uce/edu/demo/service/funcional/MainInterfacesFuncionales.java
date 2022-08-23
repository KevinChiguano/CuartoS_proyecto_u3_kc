package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {
	
	private static final Logger LOGGER = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		//CONSUMER
		
		//clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//lambdas
		
		//PREDICATE
		
		//clases
		//lambdas
		
		//FUNCTION
		
		//clases
		//lambdas
		
		//UNARY OPERATOR (FUNCTION)
		
		//clases
		//lambdas
	}

}
