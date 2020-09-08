package com.is.trottinette.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name="empruntById", query = "select e from Emprunt e where e.id = :id"),
        @NamedQuery(name="allEmprunts", query = "select e from Emprunt e")
})
public class Emprunt implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private Abonne abonne;
    private Trottinette trottinette;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Abonne getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}

	public Trottinette getTrottinette() {
		return trottinette;
	}

	public void setTrottinette(Trottinette trottinette) {
		this.trottinette = trottinette;
	}

	public Emprunt() {
    }

	public Emprunt(Long id) {
		super();
		this.id = id;
	}

	public Emprunt(Date date, Abonne abonne, Trottinette trottinette) {
		super();
		this.date = date;
		this.abonne = abonne;
		this.trottinette = trottinette;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abonne == null) ? 0 : abonne.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((trottinette == null) ? 0 : trottinette.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprunt other = (Emprunt) obj;
		if (abonne == null) {
			if (other.abonne != null)
				return false;
		} else if (!abonne.equals(other.abonne))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (trottinette == null) {
			if (other.trottinette != null)
				return false;
		} else if (!trottinette.equals(other.trottinette))
			return false;
		return true;
	}
	
    
}
