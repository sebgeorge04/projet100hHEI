package o.o.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import o.o.entities.Comptes;

public class ComptesDaoImpl implements ComptesDao {
	
	
	public List<Comptes> listComptes() {
		String query = "SELECT * FROM connexion ORDER BY nom";
		List<Comptes> compte = new ArrayList<>(); 
		try (Connection connection =  DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						
						Comptes comptes = new Comptes(resultSet.getString("nom"), 
								resultSet.getString("prenom"),resultSet.getString("motdepasse"),resultSet.getString("email"),resultSet.getInt("remise"),resultSet.getInt("accreditation"));
						compte.add(comptes);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}

	@Override
	public Comptes getComptes(String nom) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM connexion WHERE nom = ?")) {
				statement.setString(1, nom);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						
						return  new Comptes(resultSet.getString("nom"),resultSet.getString("prenom"), resultSet.getString("motdepasse"),resultSet.getString("email"),resultSet.getInt("remise"),resultSet.getInt("accreditation"));
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Comptes addComptes(Comptes compte) {
		// TODO Auto-generated method stub
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO connexion(nom,prenom,motdepasse,email,remise,accreditation) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, compte.getNom());
				statement.setString(2, compte.getPrenom());
				statement.setString(3, compte.getMotdepasse());
				statement.setString(4, compte.getEmail());
				statement.setInt(5, compte.getRemise());
				statement.setInt(6, compte.getAccreditation());
				
				
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						compte.setNom(resultSet.getString(1));
						return compte;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
   public Comptes deleteComptes(String nom){
	   try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {

		   String sqlQuery = "DELETE FROM connexion WHERE nom="+nom;

		   try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

		   statement.executeUpdate();

		   }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return null;
   }

public Comptes ModifComptes(String nom) {
	// TODO Auto-generated method stub
	   try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {

		   String sqlQuery = "UPDATE connexion SET motdepasse=? WHERE nom="+nom;

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
