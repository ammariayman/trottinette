package com.is.trottinette.security;

import java.util.List;
import java.util.Map;

import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialModel;
import org.keycloak.models.GroupModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserCredentialModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.credential.PasswordCredentialModel;
import org.keycloak.storage.StorageId;
import org.springframework.beans.factory.annotation.Autowired;

import com.is.trottinette.models.Abonne;
import com.is.trottinette.service.AbonneService;

public class CustomUserStorageProvider implements ILocalCustomUserStorageProvider{
	
	protected ComponentModel model;

	protected KeycloakSession kcSession;
	
	@Autowired
	AbonneService abonneService;

	public KeycloakSession getKcSession() {
		return kcSession;
	}

	public void setKcSession(KeycloakSession kcSession) {
		this.kcSession = kcSession;
	}

	public ComponentModel getModel() {
		return model;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel getUserById(String id, RealmModel realm) {
		
		Abonne abonne = abonneService.findById(Long.valueOf(id));

		if (abonne == null) {
			return null;
		}
		return new UserAdapter(kcSession, realm, model, abonne);
	}

	@Override
	public UserModel getUserByUsername(String username, RealmModel realm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getUserByEmail(String email, RealmModel realm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUsersCount(RealmModel realm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserModel> getUsers(RealmModel realm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getUsers(RealmModel realm, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> searchForUser(String search, RealmModel realm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> searchForUser(String search, RealmModel realm, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> searchForUser(Map<String, String> params, RealmModel realm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> searchForUser(Map<String, String> params, RealmModel realm, int firstResult,
			int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getGroupMembers(RealmModel realm, GroupModel group, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getGroupMembers(RealmModel realm, GroupModel group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> searchForUserByUserAttribute(String attrName, String attrValue, RealmModel realm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportsCredentialType(String credentialType) {
		return PasswordCredentialModel.TYPE.equals(credentialType);
	}

	@Override
	public boolean isConfiguredFor(RealmModel realm, UserModel user, String credentialType) {
		return supportsCredentialType(credentialType);
	}

	@Override
	public boolean isValid(RealmModel realm, UserModel user, CredentialInput credentialInput) {
		if (!supportsCredentialType(credentialInput.getType()) || !(credentialInput instanceof UserCredentialModel))
			return false;
		UserCredentialModel cred = (UserCredentialModel) credentialInput;
		
	}

	@Override
	public void setModel(ComponentModel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSession(KeycloakSession session) {
		// TODO Auto-generated method stub
		
	}

}
