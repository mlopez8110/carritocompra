package com.carrito.compra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carrito.compra.model.DetalleVenta;

@Service
public interface DetalleVentaService {
	
	public List<DetalleVenta>listDetalleId(Integer filtro);

}
