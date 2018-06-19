package Beans;

import java.sql.Date;

public class Userspace {
	
	private Long id;
	private Date dateCreation;
	private String url;
	private String shared;
	private float taille;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getShared() {
		return shared;
	}
	public void setShared(String shared) {
		this.shared = shared;
	}
	public float getTaille() {
		return taille;
	}
	public void setTaille(float taille) {
		this.taille = taille;
	}

}
