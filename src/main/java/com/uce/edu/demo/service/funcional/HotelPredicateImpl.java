package com.uce.edu.demo.service.funcional;

public class HotelPredicateImpl implements IHotelPredicate<Integer> {


	@Override
	public boolean evaluar(Integer arg1) {
		// TODO Auto-generated method stub
		return arg1 >= 150;
	}

}
