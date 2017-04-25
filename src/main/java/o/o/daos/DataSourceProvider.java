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
			dataSource.setServerName("zwgaqwfn759tj79r.chr7pe7iynqr.eu-west-1.rds.amazonaws.com");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("zexptj97xtqt398a");
			dataSource.setUser("x2vd5aq4deoxeur2");
			dataSource.setPassword("sl1t5lniabf4jl4e");
		}
		return dataSource;
	}
}

