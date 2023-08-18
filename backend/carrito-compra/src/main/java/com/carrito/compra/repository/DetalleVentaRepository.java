package com.carrito.compra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carrito.compra.model.DetalleVenta;
import com.carrito.compra.model.Venta;

@Repository
public interface DetalleVentaRepository extends JpaRepository <DetalleVenta, Long>{
	
	@Query(
			value = "SELECT * from view_detalle where id_venta=:filtro",
			nativeQuery = true
			)
	
	List<DetalleVenta> searchNativo(@Param("filtro") Integer filtro);	

}
