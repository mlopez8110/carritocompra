package com.carrito.compra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carrito.compra.model.Cliente;

@Service
public interface ClienteService {
	
	public List<Cliente>listar();
	public Cliente guardar(Cliente c);

}
