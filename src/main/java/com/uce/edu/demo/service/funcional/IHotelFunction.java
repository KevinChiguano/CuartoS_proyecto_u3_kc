package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IHotelFunction <R,T>{

	public R apply(T arg);
}
