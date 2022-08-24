package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.modelo.FacturaElectronica;
import com.uce.edu.demo.supermaxi.repository.IFacturaElectronicaRepository;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService {

	@Autowired
	private IFacturaElectronicaRepository electronicaRepository;
	
	@Override
	@Transactional(value =  TxType.REQUIRES_NEW)
	public void procesarElectronica(String numero, Integer cantidadItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronica electronica = new FacturaElectronica();
		electronica.setNumero(numero);
		electronica.setFechaCreacion(LocalDateTime.now());
		electronica.setNumeroItems(cantidadItems);
		electronica.setMonto(monto);
		
		this.electronicaRepository.insertar(electronica);
		
		throw new RuntimeException();
	}

}
