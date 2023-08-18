package com.carrito.compra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.compra.model.Cliente;
import com.carrito.compra.model.Producto;
import com.carrito.compra.repository.ClienteRepository;
import com.carrito.compra.service.ClienteService;
import com.carrito.compra.service.ProductoService;

@RestController
@RequestMapping("/api/v1/")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> ListarClientes(){
		return clienteService.listar();
	}
	
	@PostMapping("/clientes")
	public Cliente guardarProducto(@RequestBody Cliente cliente)
	{
		return clienteService.guardar(cliente);
	}
	

}
