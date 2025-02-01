package org.dnyanyog.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
	private static String url;
	private static String username = "root";
	private static String password = "Shree@123";

	private static Connection connection;
	private static Statement statement;

	// Getter Setter for url variable
	public static String getUrl() {
		return url;
	}

	// "jdbc:mysql://127.0.0.1:3306/user_management"
	// "jdbc:mysql://127.0.0.1:3306/product_management"
	public static void setUrl(String tempurl) {
		url = tempurl;
	}

	// Getter Setter for Statement
	public static Statement getStatement() {
		return statement;
	}

	public static void setStatement(Statement statement) {
		DatabaseUtil.statement = statement;
	}

	// Here the complexity gets in
	// Created a 2 different connection for user as well as product
	// Just set the url changed, inside the box everything is same
	public static Connection userConnection() {
		setUrl("jdbc:mysql://127.0.0.1:3306/user_management");
		try {
			return DriverManager.getConnection(getUrl(), username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return connection;
		}
	}

	public static Connection productConnection() {
		setUrl("jdbc:mysql://127.0.0.1:3306/product_management");
		try {
			return DriverManager.getConnection(getUrl(), username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return connection;
		}
	}

	// Same 2 block for user and product
	public static ResultSet executeUser(String query) throws SQLException {
		setStatement(userConnection().createStatement());

		ResultSet result = getStatement().executeQuery(query);

		return result;
	}

	public static ResultSet executeProduct(String query) throws SQLException {
		setStatement(productConnection().createStatement());

		ResultSet result = getStatement().executeQuery(query);

		return result;
	}

}
