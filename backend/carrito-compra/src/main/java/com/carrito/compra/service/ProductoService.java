package com.carrito.compra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carrito.compra.model.Producto;

@Service
public interface ProductoService {
	
	public List<Producto>listar();
	public Optional<Producto>listarId(Long id);
	public Producto guardar(Producto p);
	public Producto actualizar(Long id,Producto p);
	public void eliminar(Long id);
	

}
