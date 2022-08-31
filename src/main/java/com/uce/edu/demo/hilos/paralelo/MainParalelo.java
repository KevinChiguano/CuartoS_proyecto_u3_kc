package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

import com.uce.edu.demo.hilos.tradicional.Cajero;
import com.uce.edu.demo.hilos.tradicional.PCCajero;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		CajeroParalelo cajero1 = new CajeroParalelo("Kevin", Arrays.asList("Pepito"));
		CajeroParalelo cajero2 = new CajeroParalelo("Luis", Arrays.asList("Pepito2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Paul", Arrays.asList("Pepito3"));

		CajeroParalelo cajero4 = new CajeroParalelo("Kevin", Arrays.asList("Juan"));
		CajeroParalelo cajero5 = new CajeroParalelo("Luis", Arrays.asList("Juan2"));
		CajeroParalelo cajero6 = new CajeroParalelo("Paul", Arrays.asList("Juan3"));

		// Kevin
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start(); // procesar

		// Luis
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start(); // procesar

		// Paul
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start(); // procesar

		// Kevin
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start(); // procesar

		// Luis
		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start(); // procesar

		// Paul
		for (int i = 1; i < 1000; i++) {
			PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
			gestorAtencion6.start(); // procesar
		}
		
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + " seg");

	}

}
