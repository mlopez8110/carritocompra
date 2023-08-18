package com.carrito.compra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.compra.model.VentaModel;
import com.carrito.compra.repository.VentaModelRepository;

@Service
public class VentaModelServiceImp implements VentaModelService{
	
	@Autowired
	private VentaModelRepository ventaModelRepository;

	@Override
	public VentaModel guardar(VentaModel vm) {
		// TODO Auto-generated method stub
		
		VentaModel ventamodel=ventaModelRepository.save(vm);
		return ventamodel;

	}


	
}
