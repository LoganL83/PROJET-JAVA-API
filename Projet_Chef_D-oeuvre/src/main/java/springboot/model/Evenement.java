package springboot.model;

import java.util.Date;

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
 * @author Logan LANFUMEY version 00
 */

@Entity
@Table(name = "evenement")
public class Evenement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "evenementId")
	private Long idEvenement;

	@JsonIgnore
	@NotBlank
	@Column(name = "date")
	private Date date;

	@JsonIgnore
	@NotBlank
	@Column(name = "nom")
	private String nom;

	@JsonIgnore
	@NotBlank
	@Column(name = "lieu")
	private String lieu;

	@JsonIgnore
	@NotBlank
	@Column(name = "descriptif")
	private String descriptif;

	public Long getId() {
		return idEvenement;
	}

	public void setId(Long id) {
		this.idEvenement = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
}
