package com.carrito.compra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="venta")
public class VentaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_cliente")
	private String id_cliente;
	
	@Column(name = "fecha")
	private String fecha;
	
	
public VentaModel() {
	// TODO Auto-generated constructor stub
}


public VentaModel(Long id, String id_cliente, String fecha) {
	super();
	this.id = id;
	this.id_cliente = id_cliente;
	this.fecha = fecha;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getId_cliente() {
	return id_cliente;
}


public void setId_cliente(String id_cliente) {
	this.id_cliente = id_cliente;
}


public String getFecha() {
	return fecha;
}


public void setFecha(String fecha) {
	this.fecha = fecha;
}


}
