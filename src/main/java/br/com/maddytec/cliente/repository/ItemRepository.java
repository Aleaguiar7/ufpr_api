package br.com.maddytec.cliente.repository;

import br.com.maddytec.cliente.entity.Item;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

	

	
}
