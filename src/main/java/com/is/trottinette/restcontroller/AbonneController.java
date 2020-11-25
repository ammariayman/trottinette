package com.is.trottinette.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<Abonne> findAll() {
		return abonneService.findAll();
	}
	
	@GetMapping("/{id}")
	public Abonne findById(@PathVariable Long id) {
		return abonneService.findById(id);
	}
	
	@PostMapping("/")
	public Abonne addOne(Abonne abonne) {
		return abonneService.abonnement(abonne);
	}

	@DeleteMapping("/{id}")
	public void deleteAbonne(@PathVariable Long id) {
		abonneService.desabonnement(id);
	}
}
