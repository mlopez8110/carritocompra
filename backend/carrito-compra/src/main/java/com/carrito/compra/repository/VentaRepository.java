package com.carrito.compra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carrito.compra.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

	/*@Query(
			value = "SELECT * from view_ventas where fecha like %:fecha% or id like %:id%",
			nativeQuery = true
			)
	
	List<Venta> searchNativo(@Param("fecha") String fecha, @Param("id") Long id);	*/
	
	@Query(value = "SELECT * from view_ventas", nativeQuery = true)
	List<Venta> findAllNative();

	@Query(value = "SELECT * from view_ventas where fecha=:fecha", nativeQuery = true)
	List<Venta> findByFechaNative(@Param("fecha") String fecha);
	
	@Query(value = "SELECT * from view_ventas where id=:id", nativeQuery = true)
	List<Venta> findByIdNative(@Param("id") Long id);
	
}
