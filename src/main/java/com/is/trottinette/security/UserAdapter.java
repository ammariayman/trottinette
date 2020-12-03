package com.is.trottinette.security;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.adapter.AbstractUserAdapterFederatedStorage;

import com.is.trottinette.models.Abonne;

public class UserAdapter extends AbstractUserAdapterFederatedStorage {
	
	protected Abonne abonne;
	protected String keycloakId;

	public UserAdapter(KeycloakSession session, RealmModel realm, ComponentModel storageProviderModel, Abonne abonne) {
		super(session, realm, storageProviderModel);
		this.abonne = abonne;
		keycloakId = StorageId.keycloakId(storageProviderModel, abonne.getId().toString());
	}

	@Override
	public String getUsername() {
		return abonne.getName();
	}

	@Override
	public void setUsername(String username) {
		abonne.setName(username);
	}

}
