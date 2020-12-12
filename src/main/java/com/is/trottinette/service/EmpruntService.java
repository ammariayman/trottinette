package com.is.trottinette.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.is.trottinette.models.Emprunt;

public interface EmpruntService {
	
	@PreAuthorize("hasRole('user') and #emprunt.abonne.name.equals(authentication.name)")
	public Emprunt creerEmprunt(Emprunt emprunt);
	
	public Emprunt findById(long id);
	
	public List<Emprunt> findAll();
	
	public List<Emprunt> findByAbonneId(long id);

}
