package com.carrito.compra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.compra.model.Producto;
import com.carrito.compra.repository.ProductoRepository;

@Service
public class ProductoServiceImp implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> listarId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Producto guardar(Producto p) {
		// TODO Auto-generated method stub
		
		Producto producto=productoRepository.save(p);
		return producto;
	}
	
	@Override
	public Producto actualizar(Long id,Producto p) {
		Optional<Producto> productobuscado = productoRepository.findById(id);
		
		if (productobuscado.get()!=null)
		{
			productobuscado.get().setNombre(p.getNombre());
			productobuscado.get().setPrecio(p.getPrecio());
			return this.guardar(productobuscado.get());
		}
		
		return null;
	}	

	@Override
	public void eliminar(Long id) {
		
		productoRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

}
