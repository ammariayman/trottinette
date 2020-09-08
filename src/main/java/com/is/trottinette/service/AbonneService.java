package com.is.trottinette.service;

import java.util.List;

import com.is.trottinette.models.Abonne;

public interface AbonneService {
	
	public List<Abonne> findAll();
	
	public Abonne findById(long id);
	
	public Abonne abonnement(Abonne abonne);
	
	public void desabonnement(long id);

}
