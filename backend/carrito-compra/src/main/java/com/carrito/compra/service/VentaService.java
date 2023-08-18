package com.carrito.compra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carrito.compra.model.Venta;

@Service
public interface VentaService {
	
	public List<Venta>listVenta();
	
	public List<Venta>listVentaFecha(String fecha);
	
	public List<Venta>listVentaId(Long id);
	

}
