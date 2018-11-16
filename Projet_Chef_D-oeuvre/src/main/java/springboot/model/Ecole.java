package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Logan LANFUMEY
 * version 00
 */

@Entity
@Table (name = "ecole")
public class Ecole {
	
	

	/**
	 * Création du modèle Ecole
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name ="id")
	private Long id;

	@NotBlank
	@Column (name = "nom")
	private String nom;
	
	@Column (name = "url")
	private String url;
	
	@NotBlank
	@Column (name = "localisation")
	private String localisation;
	
	@Column (name = "avis")
	private String avis;
	
	@Column (name = "note")
	private double note;
	
	
	//génération des getters/setters
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}
	
	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public Ecole(Long id, String nom, String url, String localisation, String avis, double note) {
		super();
		this.id = id;
		this.nom = nom;
		this.url = url;
		this.localisation = localisation;
		this.avis = avis;
		this.note = note;
	}
	@Override
	public String toString() {
		return "Ecole [id=" + id + ", nom=" + nom + ", url=" + url + ", localisation=" + localisation + ", avis=" + avis
				+ ", note=" + note + "]";
	}
}
