package com.carrito.compra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.compra.model.VentaModel;
import com.carrito.compra.service.VentaModelService;

@RestController
@RequestMapping("/api/v1/")
public class VentaModelController {
	
	@Autowired
	private VentaModelService ventamodelservice;
	
	@PostMapping("/ventas")
	public VentaModel guardarVenta(@RequestBody VentaModel ventamodel)
	{
		return ventamodelservice.guardar(ventamodel);
	}
	

}
