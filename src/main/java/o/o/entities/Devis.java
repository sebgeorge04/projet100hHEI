package o.o.entities;

public class Devis {
public Integer id_devis;
public Devis(Integer id_devis, String nom, String prenom, Integer tel, String corps, String sens, String micros,
		Integer frettes, String finition, String dessin, String chevalet, String mecaniques, String commentaires) {
	super();
	this.id_devis = id_devis;
	this.nom = nom;
	this.prenom = prenom;
	this.tel = tel;
	this.corps = corps;
	this.sens = sens;
	this.micros = micros;
	this.frettes = frettes;
	this.finition=finition;
	this.dessin = dessin;
	this.chevalet = chevalet;
	this.mecaniques = mecaniques;
	this.commentaires = commentaires;
}
public String nom;
public Integer getId_devis() {
	return id_devis;
}
public void setId_devis(Integer id_devis) {
	this.id_devis = id_devis;
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
public Integer getTel() {
	return tel;
}
public void setTel(Integer tel) {
	this.tel = tel;
}
public String getCorps() {
	return corps;
}
public void setCorps(String corps) {
	this.corps = corps;
}
public String getSens() {
	return sens;
}
public void setSens(String sens) {
	this.sens = sens;
}
public String getMicros() {
	return micros;
}
public void setMicros(String micros) {
	this.micros = micros;
}
public Integer getFrettes() {
	return frettes;
}
public void setFrettes(Integer frettes) {
	this.frettes = frettes;
}
public String getDessin() {
	return dessin;
}
public void setDessin(String dessin) {
	this.dessin = dessin;
}
public String getChevalet() {
	return chevalet;
}
public void setChevalet(String chevalet) {
	this.chevalet = chevalet;
}
public String getMecaniques() {
	return mecaniques;
}
public void setMecaniques(String mecaniques) {
	this.mecaniques = mecaniques;
}
public String getCommentaires() {
	return commentaires;
}
public void setCommentaires(String commentaires) {
	this.commentaires = commentaires;
}
public String prenom;
public Integer tel;
public String corps;
public String sens;
public String micros;
public Integer frettes;
public String dessin;
public String chevalet;
public String mecaniques;
public String commentaires;
public String finition;
public String getFinition() {
	return finition;
}
public void setFinition(String finition) {
	this.finition = finition;
}
}
