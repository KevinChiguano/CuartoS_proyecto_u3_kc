package com.uce.edu.demo.service.funcional;

public class ConsumoHighOrderHotel {
	
	public String consumirSupplier(IHotelSupplier<Integer> funcion) {
		
		return "El precio es: "+funcion.getPrecio();
		
	}
	
	public void consumirConsumer(IHotelConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
	}
	
	public String consumirPredicate(IHotelPredicate<Integer> funcion, Integer valor) {
		
		String cadena = "";
		
		if(funcion.evaluar(valor) == true) {
			cadena = "El valor es verdadero";
		}else {
			cadena = "El valor es falso";
		}
		return cadena;
	}
	
	public Integer consumirFunction(IHotelFunction<String, Integer> funcion, Integer valor) {
		
		String cadena = funcion.apply(valor)+"00";
		
		return Integer.parseInt(cadena);
	}
	
	public String consumirUnaryOperator(IHotelUnaryOperator<Integer> funcion, Integer valor) {
		
		String cadena = String.valueOf(funcion.apply(valor));
		
		return "Valor: "+cadena;
	}

}
