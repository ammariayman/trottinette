package com.is.trottinette.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.is.trottinette.models.Emprunt;
import com.is.trottinette.persistence.EmpruntRepository;

public class EmpruntServiceImpl implements EmpruntService {
	
	@Autowired
	EmpruntRepository empruntRepository;

	@Override
	public Emprunt creerEmprunt(Emprunt emprunt) {
		return empruntRepository.save(emprunt);
	}

	@Override
	public Emprunt findById(long id) {
		return empruntRepository.getOne(id);
	}

	@Override
	public List<Emprunt> findAll() {
		return empruntRepository.findAll();
	}

}
