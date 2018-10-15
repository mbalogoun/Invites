package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Invitation.findAll", query = "SELECT i FROM Invitation i")
public class Invitation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String date;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "spectacle_id")
	private LieuSpectacle lieuspectacle;

	public void addLieuSpectacle(LieuSpectacle lieu) {
		this.setLieuspectacle(lieu);
		lieu.getInvitations().add(this);
	}
	
	public Invitation() {
		super();
	}
	
	public Invitation(String nom, String prenom, String date) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
	}

	public Invitation(String nom, String prenom, String date, LieuSpectacle lieuspectacle) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.lieuspectacle = lieuspectacle;
	}
	
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LieuSpectacle getLieuspectacle() {
		return lieuspectacle;
	}

	public void setLieuspectacle(LieuSpectacle lieuspectacle) {
		this.lieuspectacle = lieuspectacle;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Invitation [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date=" + date + "]";
	}

}
