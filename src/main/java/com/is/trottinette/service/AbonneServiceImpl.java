package com.is.trottinette.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is.trottinette.models.Abonne;
import com.is.trottinette.models.Trottinette;
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
		Optional<Abonne> optional = abonneRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
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
