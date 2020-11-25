package com.is.trottinette.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is.trottinette.models.Trottinette;
import com.is.trottinette.persistence.TrottinetteRepository;

@Service
public class TrottinetteServiceImpl implements TrottinetteService {
	
	@Autowired
	TrottinetteRepository trottinetteRepository;

	@Override
	public List<Trottinette> findAll() {
		return trottinetteRepository.findAll();
	}

	@Override
	public Trottinette findById(long id) {
		Optional<Trottinette> optional = trottinetteRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public Trottinette ajouterTrottinette() {
		return trottinetteRepository.save(new Trottinette());
	}

	@Override
	public void deleteById(long id) {
		trottinetteRepository.deleteById(id);
	}

}
