package o.o.daos;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class GenericDaoImpl {

	protected Connection getConnection() throws SQLException {
		return DataSourceProvider.getInstance().getDataSource().getConnection();
	}

}