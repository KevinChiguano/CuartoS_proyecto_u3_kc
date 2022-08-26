package com.uce.edu.demo.service.funcional;

public class HotelUnaryOperatorImpl implements IHotelUnaryOperator<Integer> {

	@Override
	public Integer apply(Integer arg1) {
		// TODO Auto-generated method stub
		Integer valor = arg1+5;
		return valor;
	}

}
