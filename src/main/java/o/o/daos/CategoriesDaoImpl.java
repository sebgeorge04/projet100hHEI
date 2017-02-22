package o.o.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import o.o.entities.Categories;
import o.o.entities.Comptes;


public class CategoriesDaoImpl implements CategoriesDao {

	@Override
	public List<Categories> listCategories() {
		String query = "SELECT * FROM categories ORDER BY id";
		List<Categories> categories = new ArrayList<>(); 
		try (Connection connection =  DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						
						Categories categorie = new Categories(resultSet.getInt("id"), 
								resultSet.getString("nom"));
						categories.add(categorie);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public Categories getCategories(int id) {
		// TODO Auto-generated method stub
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM categories WHERE id = ?")) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						
						return  new Categories(resultSet.getInt("id"), 
								resultSet.getString("nom"));
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Categories addCategories(Categories categorie) {
		// TODO Auto-generated method stub
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO categories(id,nom) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setInt(1, categorie.getId());
				statement.setString(2, categorie.getNom());
			
				
				
				
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						categorie.setId(resultSet.getInt(1));
						return categorie;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Categories deleteCategories(int id) {
		   try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {

			   String sqlQuery = "DELETE FROM categorie WHERE id="+id;

			   try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

			   statement.executeUpdate();

			   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;

}

	@Override
	public Categories modifCategories(int id) {
		 try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {

			   String sqlQuery = "UPDATE categories SET id=?,nom=? WHERE id="+id;

			   try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
				   

				   int rowsAffected    = statement.executeUpdate(sqlQuery);
				  

			   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	   }
}


