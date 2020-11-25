package com.is.trottinette.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Emprunt> findAll() {
		return empruntService.findAll();
	}
	
	@GetMapping("/{id}")
	public Emprunt findById(@PathVariable Long id) {
		return empruntService.findById(id);
	}
	
	@PostMapping("/")
	public Emprunt addOne(@RequestBody Emprunt emprunt) {
		return empruntService.creerEmprunt(emprunt);
	}
}
