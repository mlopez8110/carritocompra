package com.carrito.compra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.compra.model.Producto;
import com.carrito.compra.model.Venta;
import com.carrito.compra.repository.VentaRepository;

@Service
public class VentaServiceImp implements VentaService{

	
	@Autowired
	private VentaRepository ventaRepository;
	
	@Override
	public List<Venta> listVenta() {
		List<Venta> venta=ventaRepository.findAllNative();
		return venta;
	}
	
	@Override
	public List<Venta> listVentaFecha(String fecha) {
		List<Venta> venta=ventaRepository.findByFechaNative(fecha);
		return venta;
	}
	
	@Override
	public List<Venta> listVentaId(Long id) {
		List<Venta> venta=ventaRepository.findByIdNative(id);
		return venta;
	}


}
