package com.webproject.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "td_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pedido;
	private String date;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;	
	
	public Pedido() {
		
	}


	public  Pedido (Long id_pedido, String date, Customer customer ) {
	this.id_pedido = id_pedido;
	this.date = date;
	this.customer = customer;
	}

	
	public Long getId_pedido() {
		return id_pedido;
	}


	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Customer getCostumer() {
		return customer;
	}


	public void setCostumer(Customer customer) {
		this.customer = customer;	
}
}