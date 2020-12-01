package com.is.trottinette.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.is.trottinette.models.Emprunt;
import com.is.trottinette.service.EmpruntService;

@RestController
@RequestMapping("/emprunts")
public class EmpruntController {
	
	@Autowired
	EmpruntService empruntService;

	public EmpruntController(EmpruntService empruntService) {
		super();
		this.empruntService = empruntService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Emprunt>> findAll() {
		return new ResponseEntity<List<Emprunt>>(empruntService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emprunt> findById(@PathVariable Long id) {
		Emprunt emprunt = empruntService.findById(id);
		if(emprunt != null) {
			return new ResponseEntity<Emprunt>(emprunt, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Emprunt>(emprunt, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Emprunt> addOne(@RequestBody Emprunt emprunt) {
		emprunt = empruntService.creerEmprunt(emprunt);
		return new ResponseEntity<Emprunt>(emprunt, HttpStatus.CREATED);
	}
}
