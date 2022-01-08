package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DATABASE_URL = "jdbc:mysql://localhost/%s?user=%s&password=%s";

	private static ConnectionFactory connectionFactory;

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			return new ConnectionFactory();
		}

		return connectionFactory;
	}

	private Connection getConnection(String dbName, String username, String password) throws SQLException {
		String url = String.format(DATABASE_URL, dbName, username, password);
		return DriverManager.getConnection(url);
	}

	public Connection getConnection() throws SQLException {
		return getConnection("emprestou", "junior", "jun@");
	}

}
