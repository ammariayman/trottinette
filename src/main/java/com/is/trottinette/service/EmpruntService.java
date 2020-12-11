package com.is.trottinette.service;

import java.util.List;

import com.is.trottinette.models.Emprunt;

public interface EmpruntService {
	
	public Emprunt creerEmprunt(Emprunt emprunt);
	
	public Emprunt findById(long id);
	
	public List<Emprunt> findAll();
	
	public List<Emprunt> findByAbonneId(long id);

}
