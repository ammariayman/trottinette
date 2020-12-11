package com.is.trottinette.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.is.trottinette.models.Emprunt;
import com.is.trottinette.persistence.EmpruntRepository;

@Service
public class EmpruntServiceImpl implements EmpruntService {
	
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	EmpruntRepository empruntRepository;

	@Override
	public Emprunt creerEmprunt(Emprunt emprunt) {
		return empruntRepository.save(emprunt);
	}

	@Override
	public Emprunt findById(long id) {
		Optional<Emprunt> optional = empruntRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public List<Emprunt> findAll() {
		return empruntRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emprunt> findByAbonneId(long id) {
		Query query = em.createNamedQuery("empruntsByAbonneId");
		return query.setParameter("id", id).getResultList();
	}

}
