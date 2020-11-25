package com.is.trottinette.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Trottinette implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private boolean disponible = true;

	@OneToMany
	private List<Intervention> interventions;

	public Trottinette() {
	}

	public Trottinette(long id) {
		this.id = id;
	}

	public Trottinette(Long id, boolean disponible) {
		this.id = id;
		this.disponible = disponible;
	}

	public Trottinette(boolean disponible, List<Intervention> interventions) {
		super();
		this.disponible = disponible;
		this.interventions = interventions;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@JsonProperty
	public List<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	@JsonProperty
	public boolean isDisponible() {
		return disponible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trottinette other = (Trottinette) obj;
		return Objects.equals(getId(), other.getId());
	}

}
