package springboot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

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
	private Long id;

	@NotBlank
	@Column (name ="nom")
	private String nom; 

	@Column (name ="url")
	private String url; // url de la formation

	@Column (name ="type_de_formation")
	private String type; // alternance? cours du soir? etc...

	@NotBlank
	@Column (name ="localisation")
	private String localisation; // où?

	@NotBlank
	@Column (name ="metier")
	private String metier; // quel métier?

	@Column (name ="certification")
	private String certification; // si oui laquelle (hésite avec un boolean)

	@Column (name ="date_de_formation")
	private LocalDate date; // date de formation

	@Column (name ="avis")
	private String avis; // commentaires et note

	@Column (name = "note")
	private double note; // note de la formation

	// génération des getters/setters

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
	
	public Formation(Long id, String nom, String url, String type, String localisation, String metier,
			String certification, LocalDate date, String avis, double note) {
		super();
		this.id = id;
		this.nom = nom;
		this.url = url;
		this.type = type;
		this.localisation = localisation;
		this.metier = metier;
		this.certification = certification;
		this.date = date;
		this.avis = avis;
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "Formation [id=" + id + ", nom=" + nom + ", url=" + url + ", type=" + type + ", localisation="
				+ localisation + ", metier=" + metier + ", certification=" + certification + ", date=" + date
				+ ", avis=" + avis + ", note=" + note + "]";
	}
}
