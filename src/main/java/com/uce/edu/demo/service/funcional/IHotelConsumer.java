package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IHotelConsumer <T>{
	
	public void accept(T arg1);

}
