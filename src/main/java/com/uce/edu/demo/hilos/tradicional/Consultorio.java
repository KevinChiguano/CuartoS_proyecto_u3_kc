package com.uce.edu.demo.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class Consultorio {
	
	public void proceso(Doctor doctor) {
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		System.out.println("Procesando Doctor: "+doctor.getNombre());
		System.out.println("Especialidad: "+ doctor.especialidad);
		
		for(String pasiente: doctor.pacientes) {
			this.diagnosticar(pasiente);
		}
	}
	
	private void diagnosticar(String pasiente) {
		System.out.println("Diagnosticando a: "+pasiente);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
