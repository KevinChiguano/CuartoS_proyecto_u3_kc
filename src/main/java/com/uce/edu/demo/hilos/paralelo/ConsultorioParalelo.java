package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class ConsultorioParalelo extends Thread{
	
	private DoctorParalelo doctor;
	
	
	public ConsultorioParalelo(DoctorParalelo doctor) {
		this.doctor = doctor;
	}

	@Override
	public void run() {
		this.proceso(this.doctor);
	}
	
	public void proceso(DoctorParalelo doctor) {
		
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		System.out.println("Procesando Doctor: "+doctor.getNombre());
		System.out.println("Especialidad: "+ doctor.especialidad);
		
		for(String pasiente: doctor.pacientes) {
			this.diagnosticar(pasiente);
		}
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		
		System.out.println("Termino: "+doctor.getNombre()+ " en: "+tiempoTranscurrido + " seg");
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
