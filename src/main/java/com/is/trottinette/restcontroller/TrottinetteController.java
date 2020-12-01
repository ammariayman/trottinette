package com.is.trottinette.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.is.trottinette.models.Trottinette;
import com.is.trottinette.service.TrottinetteService;

@RestController
@RequestMapping("/trottinettes")
public class TrottinetteController {
	
	@Autowired
	TrottinetteService trottinetteService;

	public TrottinetteController(TrottinetteService trottinetteService) {
		super();
		this.trottinetteService = trottinetteService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Trottinette>> findAll() {
		return new ResponseEntity<List<Trottinette>>(trottinetteService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Trottinette> findById(@PathVariable Long id) {
		Trottinette trottinette = trottinetteService.findById(id);
		if(trottinette != null) {
			return new ResponseEntity<Trottinette>(trottinette, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Trottinette>(trottinette, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Trottinette> addOne() {
		Trottinette trottinette = trottinetteService.ajouterTrottinette();
		return new ResponseEntity<Trottinette>(trottinette, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTrottinette(@PathVariable Long id) {
		trottinetteService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
