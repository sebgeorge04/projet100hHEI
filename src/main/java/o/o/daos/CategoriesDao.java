package o.o.daos;

import java.util.List;

import o.o.entities.Categories;

public interface CategoriesDao {
	public List<Categories> listCategories();
	public Categories getCategories(int id);
	public Categories addCategories(Categories categorie);
	public Categories deleteCategories(int id);
	public Categories modifCategories(int id);

}
