package Beans;

import java.util.Date;

public class User {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private String url;
	private Date DateCreation;
	private int tailleMax;
	private int etat;
	
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public int getTailleMax() {
		return tailleMax;
	}
	public void setTailleMax(int tailleMax) {
		this.tailleMax = tailleMax;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp + ", url="
				+ url + ", DateCreation=" + DateCreation + ", tailleMax=" + tailleMax + ", etat=" + etat + "]";
	}	
	
}
