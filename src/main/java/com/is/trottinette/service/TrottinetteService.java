package com.is.trottinette.service;

import java.util.List;

import com.is.trottinette.models.Trottinette;

public interface TrottinetteService {
	
	public List<Trottinette> findAll();
	
	public Trottinette findById(long id);
	
	public Trottinette ajouterTrottinette();
	
	public void deleteById(long id);

}
