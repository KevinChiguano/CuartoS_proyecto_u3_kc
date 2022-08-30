package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.jboss.logging.Logger;

public class MainInterfacesFuncionales {
	
	private static final Logger LOGGER = Logger.getLogger(MainInterfacesFuncionales.class);

	public static boolean prueba(Integer numero) {
		return numero >=3;
	}
	
	public static void imprimir(String cadena) {
		LOGGER.info("Impresion: "+cadena);
	}
	
	public static void guardar(String elementoAInsertar) {
		//Consumo el metodo 
	}
	
	
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
		
		//JAVA
		LOGGER.info("JAVA Supplier ");
		Stream<String> test = Stream.generate(() -> "Edison 3").limit(7);
		test.forEach(cadena -> System.out.println(cadena));
		
		//CONSUMER
		
		//clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		//lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);
		
		//JAVA
		LOGGER.info("JAVA Consumer");
		List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach(numero -> System.out.println(numero));
		
		//PREDICATE
		
		//clases
		//lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOGGER.info("Predicate Lambdas: "+predicateLambda.evaluar("Kevin con Z"));
		
		//Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("A"), "Kevin con Z");
		LOGGER.info("HO Predicate "+respuesta);
		
		//JAVA
		LOGGER.info("JAVA Predicate");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(valor -> prueba(valor));
		nuevaLista.forEach(numero -> System.out.println(numero));
		
		//FUNCTION
		
		//clases
		//lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor-2;
			return valorFinal;
			};
		
		LOGGER.info("Function Lambdas: "+ functionLambda.aplicar("7"));
		
		//JAVA
		
		
		//Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorn = valor.toString()+"A";
			return retorn;
		}, 1);
		
		LOGGER.info("HO Function: "+valorFinalHO);
		
		LOGGER.info("JAVA Function");
		//Conversiones/cast Empleado EmpleadoDTO (Ligero)
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista+1;
			String cadena = "Num: "+valor.toString();
			return cadena;
		});
		
		//Declarativa: ideas/inteciones
		listaCambiada.forEach(valor -> imprimir(valor));
		
		List<String> lista1 = new ArrayList<>();
		Map<String, String> mp1 = new HashMap<String, String>();
		
		//Imperativa: paso a paso
		//for(Integer valor:) {
		//	
		//}
		
		//UNARY OPERATOR (FUNCTION)
		
		//clases
		//lambdas
		
		IPersonaUnaryOperator<String> unaryLambda = cade -> {
			String valorFinal = cade.concat(" sufijo");
			return valorFinal;
		};
		
		LOGGER.info("Unari Operator Lamda: "+ unaryLambda.apply("Daniel"));
		
		//JAVA
		
	}

}
