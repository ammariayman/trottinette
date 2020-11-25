package com.is.trottinette.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Trottinette> findAll() {
		return trottinetteService.findAll();
	}
	
	@GetMapping("/{id}")
	public Trottinette findById(@PathVariable Long id) {
		return trottinetteService.findById(id);
	}
	
	@PostMapping("/")
	public Trottinette addOne() {
		return trottinetteService.ajouterTrottinette();
	}

	@DeleteMapping("/{id}")
	public void deleteTrottinette(@PathVariable Long id) {
		trottinetteService.deleteById(id);
	}
}
