package springboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Logan LANFUMEY 
 * version 00
 */

@Entity
@Table(name = "user")
public class User {

	
	/**
	 * Création du modèle utilisateur.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name ="id")
	private Long id;

	@Email
	@NotBlank
	@Column (name ="email")
	private String email;

	@NotBlank
	@Column (name ="mot_de_passe")
	private String mot_de_passe;

	@Column (name ="age")
	private int age;

	@Column (name ="lieu")
	private String lieu;

	@Column (name ="niveau_etude")
	private String niveau_etude;

	/**
	 * situation : en recherche d'emploi, salarié, intermittent du spectacle,
	 * travailleur indépendant,
	 * 
	 */
	
	@Column (name ="situation")
	private String situation; //pourquoi pas utiliser une classe enum????

	// requête par type de formation ou par école
/*
	@OneToMany(mappedBy = "user")
	private List<Formation> formation;

	@OneToMany(mappedBy = "user")
	private List<Ecole> ecole;
	*/
	
	// génération des getters/setters

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getNiveau_etude() {
		return niveau_etude;
	}

	public void setNiveau_etude(String niveau_etude) {
		this.niveau_etude = niveau_etude;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}
/*
	public List<Formation> getFormation() {
		return formation;
	}

	public void setFormation(List<Formation> formation) {
		this.formation = formation;
	}

	public List<Ecole> getEcole() {
		return ecole;
	}

	public void setEcole(List<Ecole> ecole) {
		this.ecole = ecole;
	}
	*/
	public User(Long id, String email, String mot_de_passe, int age, String lieu, String niveau_etude, String situation/*,
			List<Formation> formation, List<Ecole> ecole*/) {
		super();
		this.id = id;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
		this.age = age;
		this.lieu = lieu;
		this.niveau_etude = niveau_etude;
		this.situation = situation;/*
		this.formation = formation;
		this.ecole = ecole;*/
	}/*
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", mot_de_passe=" + mot_de_passe + ", age=" + age + ", lieu="
				+ lieu + ", niveau_etude=" + niveau_etude + ", situation=" + situation + ", formation=" + formation
				+ ", ecole=" + ecole + "]";
	}*/

}
