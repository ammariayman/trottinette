package com.is.trottinette.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.is.trottinette.models.Abonne;

@SpringBootTest
public class AbonneServiceTest {
	
	@Autowired
	AbonneService abonneService;

	@Test
	public void abonneTest() {
		Abonne abonne = new Abonne(new Date(), "Ayman");
		abonne = abonneService.abonnement(abonne);
		assertNotEquals(0, abonne.getId());
		assertEquals("Ayman", abonne.getName());
		
		Abonne abonne2 = abonneService.findById(abonne.getId());
		assertEquals(abonne, abonne2);
		
		Abonne abonne3 = new Abonne(new Date(), "Ayman");
		abonne3 = abonneService.abonnement(abonne3);
		assertNotEquals(abonne, abonne3);
		
				
		List<Abonne> abonnes = abonneService.findAll();
		assertNotEquals(0, abonnes.size());
		
		abonneService.desabonnement(abonne.getId());
		Abonne abonne4 = abonneService.findById(abonne.getId());
		assertNull(abonne4);
	}
}
