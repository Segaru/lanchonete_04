package com.example.lanchonete.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.lanchonete.model.Lanche;
import com.example.lanchonete.repository.Lanches;

@RestController
@RequestMapping("/api/lanches")
public class ApiLancheController {

	@Autowired
	private Lanches lanches;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Collection<Lanche> listaLanches() {
		return lanches.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Lanche> getLanche(@PathVariable("id") Long id) {
		return this.lanches.findById(id);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Lanche>> listar() {
		return new ResponseEntity<List<Lanche>>(new ArrayList<Lanche>(lanches.findAll()), 
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeLanche(@PathVariable("id") Long id) {
		Optional<Lanche> p = lanches.findById(id);
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		lanches.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public  ResponseEntity<?> saveLanche(@RequestBody Lanche lanche) {
		return new ResponseEntity<Lanche> (lanches.save(lanche), HttpStatus.OK);
	}

}