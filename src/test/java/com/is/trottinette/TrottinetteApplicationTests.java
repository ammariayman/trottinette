package com.is.trottinette;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.is.trottinette.loader.TrottinetteLoader;

@SpringBootTest
class TrottinetteApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void loadTrottinettes() {
		try {
			TrottinetteLoader.load();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(0, TrottinetteLoader.getTrottinettes().size());
	}

}
