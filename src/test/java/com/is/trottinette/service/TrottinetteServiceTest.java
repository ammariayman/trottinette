package com.is.trottinette.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.is.trottinette.PersistenceJPAConfig;
import com.is.trottinette.models.Trottinette;


@ContextConfiguration(classes = {PersistenceJPAConfig.class})
@WebAppConfiguration
public class TrottinetteServiceTest {
	
	@Autowired
	TrottinetteService trottinetteService;

	@Test
	public void trottinetteTest() {
		
		Trottinette trottinette = trottinetteService.ajouterTrottinette();
		assertNotEquals(0, trottinette.getId());
		
		Trottinette trottinette2 = trottinetteService.findById(trottinette.getId());
		assertEquals(trottinette, trottinette2);
		
		Trottinette trottinette3 = trottinetteService.ajouterTrottinette();
		assertNotEquals(trottinette, trottinette3);
		
		List<Trottinette> trottinettes = trottinetteService.findAll();
		assertNotEquals(0, trottinettes.size());
		
		trottinetteService.supprimerTrottinette(trottinette.getId());
		Trottinette trottinette4 = trottinetteService.findById(trottinette.getId());
		assertNull(trottinette4);
	}
}
