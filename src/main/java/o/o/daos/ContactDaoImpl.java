package o.o.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import o.o.entities.Contact;

public class ContactDaoImpl implements ContactDao {
	
	
	public List<Contact> listContact() {
		String query = "SELECT * FROM contact ORDER BY nom";
		List<Contact> compte = new ArrayList<>(); 
		try (Connection connection =  DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						
						Contact contact = new Contact(resultSet.getString("nom"), 
								resultSet.getString("email"),resultSet.getString("sujet"),resultSet.getString("message"));
						compte.add(contact);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}
@Override
	public Contact getContact(String nom) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM contact WHERE nom = ?")) {
				statement.setString(1, nom);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						
						return  new Contact(resultSet.getString("nom"),resultSet.getString("email"), resultSet.getString("sujet"),resultSet.getString("message"));
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Contact addContact(Contact contact) {
		// TODO Auto-generated method stub
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO contact(nom,email,sujet,message) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, contact.getNom());
				statement.setString(2, contact.getEmail());
				statement.setString(3, contact.getSujet());
				statement.setString(4, contact.getMessage());
				
				
				
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						contact.setNom(resultSet.getString(1));
						return contact;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
   public Contact deleteContact(String nom){
	   try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {

		   String sqlQuery = "DELETE FROM contact WHERE nom="+nom;

		   try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

		   statement.executeUpdate();

		   }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return null;
   }

public Contact ModifContact(String nom) {
	// TODO Auto-generated method stub
	   try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {

		   String sqlQuery = "UPDATE contact SET message=? WHERE nom="+nom;

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

