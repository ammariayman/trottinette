package com.is.trottinette.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is.trottinette.models.Activation;
import com.is.trottinette.models.Emprunt;
import com.is.trottinette.persistence.ActivationRepository;

@Service
public class ActivationServiceImpl implements ActivationService {
	
	@Autowired
	ActivationRepository activationRepository;

	@Override
	public List<Activation> findAll() {
		return activationRepository.findAll();
	}

	@Override
	public Activation findById(long id) {
		return activationRepository.findById(id).get();
	}

	@Override
	public Activation save(Activation activation) {
		return activationRepository.save(activation);
	}

	@Override
	public boolean activateEmprunt(Long numActivation) {
		Activation activation = activationRepository.getOne(numActivation);
		if(activation == null) {
			return false;
		}
		Emprunt emprunt = activation.getEmprunt();
		if(emprunt == null) {
			return false;
		}
		emprunt.setActivated(true);
		return true;
	}

}
