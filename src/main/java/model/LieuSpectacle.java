package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "LieuSpectacle.findAll", query = "SELECT i FROM LieuSpectacle i")
public class LieuSpectacle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String adresse;
	@OneToMany(mappedBy = "lieuspectacle", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	Set<Invitation> invitations = new HashSet<>();

	public LieuSpectacle() {
		super();
	}

	public LieuSpectacle(String name, String adresse) {
		super();
		this.name = name;
		this.adresse = adresse;
	}
	
	public void addStudent(Invitation inv) {
		this.getInvitations().add(inv);
		inv.setLieuspectacle(this);
	}

	@Override
	public String toString() {
		return "LieuSpectacle [id=" + id + ", name=" + name + ", adresse=" + adresse + ", invitations=" + invitations
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Set<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(Set<Invitation> invitations) {
		this.invitations = invitations;
	}

}
