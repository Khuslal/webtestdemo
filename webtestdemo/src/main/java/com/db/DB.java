package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private static final String url = "jdbc:mysql://localhost:3306/jspwebtestdemo";
	private static final String username = "root";
	private static final String password = "password";
	
	public static Connection getDBCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return  DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}