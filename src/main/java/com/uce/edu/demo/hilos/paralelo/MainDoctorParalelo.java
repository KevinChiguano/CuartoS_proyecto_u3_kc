package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainDoctorParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		DoctorParalelo doctor1 = new DoctorParalelo("Kevin","Dentista" ,Arrays.asList("Maria","Patricio"));
		DoctorParalelo doctor2 = new DoctorParalelo("Paul","Cardiologo" ,Arrays.asList("Saul","Cesar"));
		DoctorParalelo doctor3 = new DoctorParalelo("Cristian","Clinico" ,Arrays.asList("Vero","Ximena"));
		DoctorParalelo doctor4 = new DoctorParalelo("Vanessa","Optometrista" ,Arrays.asList("Alonso","Alexis"));
		DoctorParalelo doctor5 = new DoctorParalelo("Valentina","Pediatra" ,Arrays.asList("Nicol","Paola"));
		
		ConsultorioParalelo consultorio1 = new ConsultorioParalelo(doctor1);
		consultorio1.start();
		
		ConsultorioParalelo consultorio2 = new ConsultorioParalelo(doctor2);
		consultorio2.start();
		
		ConsultorioParalelo consultorio3 = new ConsultorioParalelo(doctor3);
		consultorio3.start();
		
		ConsultorioParalelo consultorio4 = new ConsultorioParalelo(doctor4);
		consultorio4.start();
		
		ConsultorioParalelo consultorio5 = new ConsultorioParalelo(doctor5);
		consultorio5.start();
		

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Tiempo total: "+tiempoTranscurrido + " seg");

	}

}
