package com.carrito.compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrito.compra.model.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Long>{

}
