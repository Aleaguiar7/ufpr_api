package com.webproject.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "td_compras")

public class Compras {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_compras;
	private Long qtde;
	
	
public Compras() {
		
	}
	
	public  Compras(Long id_compras, Long qtde, Pedido pedido, Customer customer) {
		
	this.id_compras = id_compras;
	this.qtde = qtde;
}


	public Long getId_compras() {
		return id_compras;
	}


	public void setId_compras(Long id_compras) {
		this.id_compras = id_compras;
	}


	public Long getQtde() {
		return qtde;
	}


	public void setQtde(Long qtde) {
		this.qtde = qtde;
	}
	
	}


