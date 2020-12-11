package com.is.trottinette.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.is.trottinette.models.Abonne;
import com.is.trottinette.service.AbonneService;

@RestController
@RequestMapping("/abonnes")
public class AbonneController {
		
	@Autowired
	AbonneService abonneService;

	public AbonneController(AbonneService abonneService) {
		super();
		this.abonneService = abonneService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Abonne>> findAll() {
		return new ResponseEntity<List<Abonne>>(abonneService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Abonne> findById(@PathVariable Long id) {
		Abonne abonne = abonneService.findById(id);
		if(abonne != null) {
			return new ResponseEntity<Abonne>(abonne, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Abonne>(abonne, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Abonne> addOne(@RequestBody Abonne abonne) {
		abonne = abonneService.abonnement(abonne);
		return new ResponseEntity<Abonne>(abonne, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAbonne(@PathVariable Long id) {
		abonneService.desabonnement(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
