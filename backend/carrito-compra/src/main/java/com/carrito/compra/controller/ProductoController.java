package com.carrito.compra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.compra.model.Producto;
import com.carrito.compra.service.ProductoService;


@RestController
@RequestMapping("/api/v1/")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto>listarProducto()
	{
		return productoService.listar();
	}
	
	@PostMapping("/productos")
	public Producto guardarProducto(@RequestBody Producto producto)
	{
		return productoService.guardar(producto);
	}
	
	@PutMapping("/updateproductos/{id}")
	public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto)
	{
		return productoService.actualizar(id,producto);
	}
	
	@DeleteMapping("/eliminarproductos/{id}")
	public String eliminarProducto(@PathVariable Long id)
	{
		productoService.eliminar(id);
		return "Eliminado";
	}
	
	
	

}
