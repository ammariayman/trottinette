package com.is.trottinette.restcontroller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.is.trottinette.dto.TokenDTO;
import com.is.trottinette.dto.UserAuthenticator;

@RestController
@RequestMapping("/auth")
public class Authentication {
	
	@Autowired
	private Environment env;
	
	private final RestTemplate restTemplate;
	
	public Authentication(Environment env, RestTemplateBuilder restTemplateBuilder) {
		super();
		this.env = env;
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenDTO> login(@RequestBody UserAuthenticator userAuthenticator) {
		String realm = env.getProperty("keycloak.realm");
		String clientID = env.getProperty("keycloak.resource");
		String baseUrl = env.getProperty("keycloak.auth-server-url");
		String authUrl = baseUrl + "/realms/{realm}/protocol/openid-connect/token";
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	    
	    MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
	    map.add("client_id", clientID);
	    map.add("username", userAuthenticator.getUsername());
	    map.add("password", userAuthenticator.getPassword());
	    map.add("grant_type", "password");
	    HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);
	    
	    // send POST request
	    ResponseEntity<TokenDTO> response = restTemplate.postForEntity(authUrl, entity, TokenDTO.class, realm);
	    TokenDTO token = response.getBody();
	    if(response.getStatusCode() == HttpStatus.OK) {
	    	return new ResponseEntity<TokenDTO>(token, HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<TokenDTO> refresh(@RequestHeader("refresh_token") String refreshToken) {
		String realm = env.getProperty("keycloak.realm");
		String clientID = env.getProperty("keycloak.resource");
		String baseUrl = env.getProperty("keycloak.auth-server-url");
		String authUrl = baseUrl + "/realms/{realm}/protocol/openid-connect/token";
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	    
	    MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
	    map.add("client_id", clientID);
	    map.add("refresh_token", refreshToken);
	    map.add("grant_type", "refresh_token");
	    HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);
	    
	    // send POST request
	    ResponseEntity<TokenDTO> response = restTemplate.postForEntity(authUrl, entity, TokenDTO.class, realm);
	    TokenDTO token = response.getBody();
	    if(response.getStatusCode() == HttpStatus.OK) {
	    	return new ResponseEntity<TokenDTO>(token, HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
