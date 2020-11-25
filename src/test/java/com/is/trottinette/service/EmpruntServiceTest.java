package com.is.trottinette.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.is.trottinette.models.Abonne;
import com.is.trottinette.models.Emprunt;
import com.is.trottinette.models.Trottinette;

@SpringBootTest
public class EmpruntServiceTest {
	
	@Autowired
	EmpruntService empruntService;
	
	@Autowired
	AbonneService abonneService;
	
	@Autowired
	TrottinetteService trottinetteService;

	@Test
	public void empruntTest() {
		GregorianCalendar gc = new GregorianCalendar(2020, 12, 25);
		Abonne abonne = new Abonne(new Date(), gc.getTime(), "Ayman");
		abonne = abonneService.abonnement(abonne);
		Trottinette trottinette = trottinetteService.ajouterTrottinette();
		Emprunt emprunt = new Emprunt(gc.getTime(), abonne, trottinette);
		emprunt = empruntService.creerEmprunt(emprunt);
		assertNotEquals(0, emprunt.getId());
		
		Emprunt emprunt2 = empruntService.findById(emprunt.getId());
		assertEquals(emprunt, emprunt2);
		
		Emprunt emprunt3 = new Emprunt(gc.getTime(), abonne, trottinette);
		emprunt3 = empruntService.creerEmprunt(emprunt3);
		assertNotEquals(emprunt, emprunt3);
		
				
		List<Emprunt> emprunts = empruntService.findAll();
		assertNotEquals(0, emprunts.size());
	}
}
