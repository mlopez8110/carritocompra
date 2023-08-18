package com.carrito.compra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.compra.model.DetalleVenta;
import com.carrito.compra.service.DetalleVentaService;

@RestController
@RequestMapping("/api/v1/")
public class DetalleVentaController {
	
	@Autowired
	private DetalleVentaService detalleVentaService;
	
	@GetMapping("/detalleventa/{filtro}")
	
	public List<DetalleVenta>listarDetalleId(@PathVariable Integer filtro)
	{
		return detalleVentaService.listDetalleId(filtro);
	}
	

}
