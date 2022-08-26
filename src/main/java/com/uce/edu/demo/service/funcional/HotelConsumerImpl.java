package com.uce.edu.demo.service.funcional;

public class HotelConsumerImpl implements IHotelConsumer<Integer>{

	@Override
	public void accept(Integer arg1) {
		// TODO Auto-generated method stub
		System.out.println("Consumer clase: Precio: "+arg1);
	}

}
