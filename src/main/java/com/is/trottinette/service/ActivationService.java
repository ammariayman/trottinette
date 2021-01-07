package com.is.trottinette.service;

import java.util.List;

import com.is.trottinette.models.Activation;

public interface ActivationService {
	
public List<Activation> findAll();
	
	public Activation findById(long id);
	
	public Activation save(Activation activation);
	
	public boolean activateEmprunt(Long numActivation);
	
}
