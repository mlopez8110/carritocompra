package com.carrito.compra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.compra.model.Cliente;
import com.carrito.compra.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente guardar(Cliente c) {
		// TODO Auto-generated method stub
		Cliente cliente=clienteRepository.save(c);
		return cliente;
	}

}
