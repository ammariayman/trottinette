package com.is.trottinette.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Abonne implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private String name;
    

    public Abonne() {
    }

    public Abonne(Long id, String name, Date dateDebut, Date dateFin) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.name = name;
    }

    public Abonne(Date dateDebut, Date dateFin, String name) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.name = name;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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
		Abonne other = (Abonne) obj;
		return Objects.equals(getId(), other.getId());
	}
    
	
}