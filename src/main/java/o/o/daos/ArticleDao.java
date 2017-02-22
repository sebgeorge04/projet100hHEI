package o.o.daos;

import java.util.List;

import o.o.entities.Article;

public interface ArticleDao {
	public List<Article> listArticles();
	public Article getArticle(Integer id_article);
	public Article addArticle(Article article);
	public Article deleteArticle(Integer id_article);
}
