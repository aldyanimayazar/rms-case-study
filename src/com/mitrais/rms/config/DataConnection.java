package com.mitrais.rms.config;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;


public class DataConnection {
	private final DataSource  dataSource;
	
	public DataConnection() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setServerName("localhost");
		dataSource.setDatabaseName("db_rms");
		dataSource.setPort(3306);
		dataSource.setUser("root");
		dataSource.setPassword("");
		this.dataSource = dataSource;
	}
	
	public static Connection getConnection() throws SQLException
	{
		// Ambil Class DataConnection dari Private Class diBawah
		return SingletonHelper.CONNECTION_INSTANCE.dataSource.getConnection();
	}
	
	private static class SingletonHelper 
	{
		private static final DataConnection CONNECTION_INSTANCE = new DataConnection();
	}
}
