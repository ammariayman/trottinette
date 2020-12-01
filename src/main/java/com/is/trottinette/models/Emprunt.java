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
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @ManyToOne
    private Abonne abonne;
    
    @ManyToOne
    private Trottinette trottinette;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Emprunt(Date dateDebut, Date dateFin, Abonne abonne, Trottinette trottinette) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.abonne = abonne;
		this.trottinette = trottinette;
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
		Emprunt other = (Emprunt) obj;
		return Objects.equals(getId(), other.getId());
	}
	
    
}
