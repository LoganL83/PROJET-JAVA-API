package springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Logan LANFUMEY
 * version 00
 */

@Entity
public class Ecole {
	
	/**
	 * Création du modèle Ecole
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String nom;
	
	private String url;
	
	@NotBlank
	private String localisation;
	
	private String avis;
	
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
}
