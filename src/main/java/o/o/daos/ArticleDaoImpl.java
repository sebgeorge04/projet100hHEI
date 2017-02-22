package o.o.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import o.o.entities.Article;
import o.o.entities.Categories;




public class ArticleDaoImpl implements ArticleDao {

	@Override
	public List<Article> listArticles() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM articles JOIN categories ON articles.id=categories.id ORDER BY id_article";
		List<Article> articles = new ArrayList<>(); 
		try (Connection connection =  DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						
						Categories categorie = new Categories(resultSet.getInt("id"), resultSet.getString("nom"));
						Article article = new Article(categorie,resultSet.getInt("id_article"), 
								resultSet.getString("nom"),resultSet.getString("description"),resultSet.getInt("prix"));
						articles.add(article);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public Article getArticle(Integer id_article) {
		// TODO Auto-generated method stub
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM articles JOIN categories ON articles.id=categories.id ORDER BY id_article")) {
				statement.setInt(1, id_article);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						Categories categorie = new Categories(resultSet.getInt("id"), resultSet.getString("nom"));
						
						return  new Article(categorie,resultSet.getInt("id_article"), 
								resultSet.getString("nom"),resultSet.getString("description"),resultSet.getInt("prix"));
						
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public Article addArticle(Article article) {
		// TODO Auto-generated method stub
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO articles (id_article,nom,prix,description,id) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setInt(1, article.getId_article());
				statement.setString(2, article.getNom());
				statement.setInt(3, article.getPrix());
				statement.setString(4, article.getDescription());
				
				statement.setInt(5, article.getCategorie().getId());
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						article.setId_article(resultSet.getInt(1));
						return article;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



	   public Article deleteArticle(Integer id_article){
		   try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {

			   String sqlQuery = "DELETE FROM articles WHERE id_article="+id_article;

			   try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

			   statement.executeUpdate();

			   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	   }



}
