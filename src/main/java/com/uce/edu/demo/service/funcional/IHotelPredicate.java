package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IHotelPredicate <T>{
	
	public boolean evaluar(T arg1);

}
