package com.is.trottinette.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.is.trottinette.models.Trottinette;
import com.is.trottinette.persistence.TrottinetteRepository;

public class TrottinetteServiceImpl implements TrottinetteService {
	
	@Autowired
	TrottinetteRepository trottinetteRepository;

	@Override
	public List<Trottinette> findAll() {
		return trottinetteRepository.findAll();
	}

	@Override
	public Trottinette findById(long id) {
		return trottinetteRepository.getOne(id);
	}

	@Override
	public Trottinette ajouterTrottinette() {
		return trottinetteRepository.save(new Trottinette());
	}

	@Override
	public void supprimerTrottinette(long id) {
		trottinetteRepository.deleteById(id);
	}

}
