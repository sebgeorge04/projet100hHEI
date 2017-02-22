package o.o.entities;

public class Categories {
public Categories(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
public int id;
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
public String nom;
}
