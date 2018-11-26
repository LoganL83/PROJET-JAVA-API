package springboot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Logan LANFUMEY version 00
 */

@Entity
@Table (name = "formation")
public class Formation {
	/**
	 * Création du modèle Formation
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name ="id")
	private Long idFormation;

	@JsonIgnore
	@NotBlank
	@Column (name ="nom", length = 100)
	private String nom; 

	@JsonIgnore
	@Column (name ="url", length = 100)
	@OneToOne (mappedBy = "ecole")
	private String url; // url de la formation

	@JsonIgnore
	@Column (name ="type_de_formation")
	private String type; // alternance? cours du soir? etc...

	@JsonIgnore
	@NotBlank
	@Column (name ="localisation")
	private String localisation; // où?

	@JsonIgnore
	@Column (name ="metier")
	private String metier; // quel métier?

	@JsonIgnore
	@Column (name ="certification")
	private String certification; // si oui laquelle (hésite avec un boolean)

	@JsonIgnore
	@Column (name ="date_de_formation")
	private LocalDate date; // date de formation

	@JsonIgnore
	@Column (name ="avis")
	private String avis; // commentaires et note

	@JsonIgnore
	@Column (name = "note")
	private double note; // note de la formation

	// génération des getters/setters

	public Long getId() {
		return idFormation;
	}

	public void setId(Long id) {
		this.idFormation = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
