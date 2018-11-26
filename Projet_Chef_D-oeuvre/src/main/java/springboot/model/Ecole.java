package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	private Long idEcole;

	@JsonIgnore
	@NotBlank
	@Column (name = "nom")
	private String nom;
	
	@JsonIgnore
	@Column (name = "url")
	private String url;
	
	@JsonIgnore
	@NotBlank
	@Column (name = "localisation")
	private String localisation;
	
	@JsonIgnore
	@Column (name = "avis")
	private String avis;
	
	@JsonIgnore
	@Column (name = "note")
	private double note;
	
	
	//génération des getters/setters
	

	public Long getId() {
		return idEcole;
	}

	public void setId(Long id) {
		this.idEcole = id;
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

}
