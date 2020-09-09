package com.is.trottinette.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is.trottinette.models.Abonne;
import com.is.trottinette.persistence.AbonneRepository;

@Service
public class AbonneServiceImpl implements AbonneService {
	
	@Autowired
	AbonneRepository abonneRepository;

	@Override
	public List<Abonne> findAll() {
		return abonneRepository.findAll();
	}

	@Override
	public Abonne findById(long id) {
		return abonneRepository.getOne(id);
	}

	@Override
	public Abonne abonnement(Abonne abonne) {
		return abonneRepository.save(abonne);
	}

	@Override
	public void desabonnement(long id) {
		abonneRepository.deleteById(id);
	}

}
