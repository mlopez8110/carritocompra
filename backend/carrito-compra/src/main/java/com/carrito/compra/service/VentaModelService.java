package com.carrito.compra.service;

import org.springframework.stereotype.Service;

import com.carrito.compra.model.VentaModel;

@Service
public interface VentaModelService {
	
	public VentaModel guardar(VentaModel vm);

}
