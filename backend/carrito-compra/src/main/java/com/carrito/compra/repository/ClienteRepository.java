package com.carrito.compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrito.compra.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository< Cliente, Long> {

}
