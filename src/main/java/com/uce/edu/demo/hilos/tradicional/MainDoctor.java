package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class MainDoctor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		Doctor doctor1 = new Doctor("Kevin","Dentista" ,Arrays.asList("Maria","Patricio"));
		Doctor doctor2 = new Doctor("Paul","Cardiologo" ,Arrays.asList("Saul","Cesar"));
		Doctor doctor3 = new Doctor("Cristian","Clinico" ,Arrays.asList("Vero","Ximena"));
		Doctor doctor4 = new Doctor("Vanessa","Optometrista" ,Arrays.asList("Alonso","Alexis"));
		Doctor doctor5 = new Doctor("Valentina","Pediatra" ,Arrays.asList("Nicol","Paola"));
		
		Consultorio consultorio1 = new Consultorio();
		consultorio1.proceso(doctor1);
		
		Consultorio consultorio2 = new Consultorio();
		consultorio2.proceso(doctor2);
		
		Consultorio consultorio3 = new Consultorio();
		consultorio3.proceso(doctor3);
		
		Consultorio consultorio4 = new Consultorio();
		consultorio4.proceso(doctor4);
		
		Consultorio consultorio5 = new Consultorio();
		consultorio5.proceso(doctor5);
		

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Tiempo total: "+tiempoTranscurrido + " seg");

	}

}
