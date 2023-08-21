package com.carrito.compra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.compra.model.Producto;
import com.carrito.compra.model.Venta;
import com.carrito.compra.service.VentaService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class VentaController {
	
	@Autowired
	//private VentaRepository repository;
	private VentaService ventaservice;
	
//	@GetMapping("/ventas")
//	public List<Venta> ListarVentas(){
//		//return null;
//		return repository.findAll();
//	}@PathVariable String fecha,@PathVariable Long id
	
	@GetMapping("/ventas")
	public List<Venta>listarVenta()
	{
		return ventaservice.listVenta();
	}
	
	@GetMapping("/ventasfecha/{fecha}")
	public List<Venta>listarVentaFecha(@PathVariable String fecha)
	{
		return ventaservice.listVentaFecha(fecha);
	}
	
	@GetMapping("/ventasid/{id}")
	public List<Venta>listarVentaId(@PathVariable Long id)
	{
		return ventaservice.listVentaId(id);
	}
	

}
