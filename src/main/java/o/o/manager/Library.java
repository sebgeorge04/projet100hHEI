package o.o.manager;

import java.util.List;

import o.o.daos.ArticleDao;
import o.o.daos.ArticleDaoImpl;
import o.o.daos.CategoriesDao;
import o.o.daos.CategoriesDaoImpl;
import o.o.daos.ComptesDao;
import o.o.daos.ComptesDaoImpl;
import o.o.daos.ContactDao;
import o.o.daos.ContactDaoImpl;
import o.o.daos.DevisDao;
import o.o.daos.DevisDaoImpl;
import o.o.entities.Article;
import o.o.entities.Categories;
import o.o.entities.Comptes;
import o.o.entities.Contact;
import o.o.entities.Devis;


public class Library {
	
	private static class FilmLibraryHolder {
		private final static Library instance = new Library();
	}
	
	public static Library getInstance() {
		return FilmLibraryHolder.instance;
	}
	
	private ComptesDao comptesDao = new ComptesDaoImpl();
	private ContactDao contactDao = new ContactDaoImpl();
	private ArticleDao articleDao=new ArticleDaoImpl();
	private CategoriesDao categorieDao=new CategoriesDaoImpl();
	private DevisDao devisDao=new DevisDaoImpl();


	private Library() {
	}


	public Comptes getComptes(String nom){
		return comptesDao.getComptes(nom);
	}
	public List<Comptes> listComptes(){
		return comptesDao.listComptes();
	}
	public Comptes addComptes(Comptes compte){
		return comptesDao.addComptes(compte);
	}
    public void deleteComptes(String nom){
    	comptesDao.deleteComptes(nom);
    }
    public void ModifComptes(String nom){
    	comptesDao.ModifComptes(nom);
    }
	public Contact getContact(String nom){
		return contactDao.getContact(nom);
	}
	public List<Contact> listContact(){
		return contactDao.listContact();
	}
	public Contact addContact(Contact contact){
		return contactDao.addContact(contact);
	}
    public void deleteContact(String nom){
    	contactDao.deleteContact(nom);
    }
    public void ModifContact(String nom){
    	contactDao.ModifContact(nom);
    }
	public List<Article> listArticles(){
		return articleDao.listArticles();
	}
	public Article getArticle(int id_article){
		return articleDao.getArticle(id_article);
	}
	public Article addArticle(Article article){
		return articleDao.addArticle(article);
		
	}
	public List<Categories> listCategories(){
		return categorieDao.listCategories();
		
	}
	public Categories getCategories(int id){
		return categorieDao.getCategories(id);
		
	}
	public Categories addCategories(Categories categorie){
		return categorieDao.addCategories(categorie);
	}
	public Categories deleteCategories(int id){
		return categorieDao.deleteCategories(id);
	}
	public Devis addDevis(Devis devis){
		return devisDao.addDevis(devis);
	}
}


