package com.webproject.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "td_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_product;
	private String descricao;
	private Long valor;
	
	
	
	public Long getId_product() {
		return id_product;
	}



	public void setId_product(Long id_product) {
		this.id_product = id_product;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Long getValor() {
		return valor;
	}



	public void setValor(Long valor) {
		this.valor = valor;
	}



	public Product() {
		
	}
}
