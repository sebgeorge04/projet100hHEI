package o.o.daos;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceProvider {
	private static MysqlDataSource dataSource;
	private static class DataSourceProviderHolder {
		private final static DataSourceProvider instance = new DataSourceProvider();
	}
	
	public static DataSourceProvider getInstance() {
		return DataSourceProviderHolder.instance;
	}

	public static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("projetiti");
			dataSource.setUser("root");
			dataSource.setPassword("root");
		}
		return dataSource;
	}
}

