package com.webproject.api.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webproject.api.entities.Compras;


@RestController
@RequestMapping(value ="/Compras")
public class ComprasController {
	
	private ComprasController ComprasController;
	
	public ComprasController(ComprasController ComprasController) {
		super();
		this.ComprasController = ComprasController;
	}
	@PostMapping
	public ResponseEntity<Compras> save(@RequestBody Compras Compras){
		
		ComprasController.save(Compras);
		return new ResponseEntity<>(Compras, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Compras>> getAll(){
		List<Compras> custumers = new ArrayList<>();
		custumers = ComprasController.findAll();
		Object Comprass;
		return new ResponseEntity<>(Comprass, HttpStatus.OK);
	}
	
	private List<Compras> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@GetMapping (path="/{id}")
	public ResponseEntity<Optional<Compras>> getById(@PathVariable Integer id){
		Optional<Compras> Compras;
		try {
			ResponseEntity<Optional<Compras>> Comprass = ComprasController.getById(id);
			return new ResponseEntity<Optional<Compras>>(Compras, HttpStatus.NOT_FOUND);
		}catch (NoSuchElemetException nsee) {
			return new ResponseEntity<Optional<Compras>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping (path="/{id}")
	public ResponseEntity<Optional<Compras>> update(@PathVariable Integer id, @RequestBody Compras newCompras){
		return ComprasController.getById(id)
			.map(id) (Compras -> {
			Compras.setNome(newCompras.getNome());
			Compras ComprasUpdate = ComprasController.save(Compras);
			return ResponseEntity.ok().body(ComprasUpdate);
			}).orElse(ResponseEntity.notFound().build());
					
		}
	}
	



