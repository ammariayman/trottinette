package com.is.trottinette.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.is.trottinette.models.Abonne;
import com.is.trottinette.service.AbonneService;
import com.is.trottinette.service.EmpruntService;

@Component("userSecurity")
public class UserSecurity {
	
	@Autowired
	AbonneService abonneService;
	
	@Autowired
	EmpruntService empruntService;
	
	public boolean hasUserId(Authentication authentication, Long userId) {
		String username = authentication.getName();
		Abonne abonne = abonneService.findById(userId);
		if(abonne == null) return false;
		return username.equals(abonne.getName());
    }
}
