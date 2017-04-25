package o.o.entities;

public class Comptes {

private String motdepasse;
public String getMotdepasse() {
	return motdepasse;
}
public void setMotdepasse(String motdepasse) {
	this.motdepasse = motdepasse;
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
private String nom;
public Comptes(String nom, String prenom, String motdepasse, String email,Integer remise,Integer accreditation) {
	super();
	this.motdepasse = motdepasse;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.remise=remise;
	this.accreditation=accreditation;
}
private String prenom;
private String email;
private Integer remise;
public Integer getRemise() {
	return remise;
}
public void setRemise(Integer remise) {
	this.remise = remise;
}
public Integer getAccreditation() {
	return accreditation;
}
public void setAccreditation(Integer accreditation) {
	this.accreditation = accreditation;
}
private Integer accreditation;
}
