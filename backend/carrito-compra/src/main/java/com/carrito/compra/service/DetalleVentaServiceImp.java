package com.carrito.compra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.compra.model.DetalleVenta;
import com.carrito.compra.repository.DetalleVentaRepository;

@Service
public class DetalleVentaServiceImp implements DetalleVentaService {
	
	@Autowired
	private DetalleVentaRepository detalleVentaRepository;

	@Override
	public List<DetalleVenta> listDetalleId(Integer filtro) {
		// TODO Auto-generated method stub
		//return detalleVentaRepository.findAllById(idventa);
		List<DetalleVenta> detalleventa=detalleVentaRepository.searchNativo(filtro);
		return detalleventa;
	}

}
