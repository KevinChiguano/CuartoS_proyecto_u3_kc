package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IHotelUnaryOperator <T>{
	
	public T apply(T arg1);

}
