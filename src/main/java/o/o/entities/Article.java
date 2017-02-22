package o.o.entities;

public class Article {
public Article(Categories categorie, Integer id_article, String nom, String description, int prix) {
		super();
		this.categorie = categorie;
		this.id_article = id_article;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
	}
public Categories getCategorie() {
		return categorie;
	}
	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
public Categories categorie;
public Integer id_article;
public String nom;
public String description;
public Integer prix;
 
}
