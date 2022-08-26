package com.uce.edu.demo.service.funcional;

public class HotelFunctionImpl implements IHotelFunction<String, Integer>{

	@Override
	public String apply(Integer arg) {
		// TODO Auto-generated method stub
		return String.valueOf("Valor: "+arg);
	}

}
