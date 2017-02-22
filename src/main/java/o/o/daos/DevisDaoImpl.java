package o.o.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import o.o.entities.Devis;

public class DevisDaoImpl implements DevisDao{

	@Override
	public Devis addDevis(Devis devis) {
		// TODO Auto-generated method stub
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO devis (nom,prenom,tel,corps,sens,micros,frettes,finition,dessin,chevalet,mecaniques,commentaires) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1,devis.getNom());
				statement.setString(2,devis.getPrenom());
				statement.setInt(3, devis.getTel());
				statement.setString(4, devis.getCorps());
				statement.setString(5, devis.getSens());
				statement.setString(6, devis.getMicros());
				statement.setInt(7, devis.getFrettes());
				statement.setString(8, devis.getFinition());
				statement.setString(9, devis.getDessin());
				statement.setString(10, devis.getChevalet());
				statement.setString(11, devis.getMecaniques());
				statement.setString(12, devis.getCommentaires());
				
			
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						devis.setId_devis(resultSet.getInt(1));
						return devis;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Devis> listDevis() {
		// TODO Auto-generated method stub
		return null;
	}

}
