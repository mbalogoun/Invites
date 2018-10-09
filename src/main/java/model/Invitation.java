package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Invitation.findAll", query = "FROM Invitation i")
public class Invitation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	private String lieu;
	private String date;

	public Invitation() {
		super();
	}

	public Invitation(String nom, String prenom, String lieu, String date) {
		this.nom = nom;
		this.prenom = prenom;
		this.lieu = lieu;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Invitation [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", lieu=" + lieu + ", date=" + date
				+ "]";
	}

}
