package o.o.entities;

public class Contact {
String nom;

public Contact(String nom, String email, String sujet, String message) {
	super();
	this.nom = nom;
	this.email = email;
	this.sujet = sujet;
	this.message = message;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSujet() {
	return sujet;
}
public void setSujet(String sujet) {
	this.sujet = sujet;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
String email;
String sujet;
String message;
}
