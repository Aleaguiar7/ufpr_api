package com.webproject.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "td_venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_venda;
	private Long valorfinal;
	
	public Long getId_venda() {
		return id_venda;
	}
	public void setId_venda(Long id_venda) {
		this.id_venda = id_venda;
	}
	public Long getValorfinal() {
		return valorfinal;
	}
	public void setValorfinal(Long valorfinal) {
		this.valorfinal = valorfinal;
	}
	
}


