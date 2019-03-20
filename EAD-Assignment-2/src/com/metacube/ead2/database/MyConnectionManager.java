package com.metacube.ead2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MyConnectionManager {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/ead_2";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "12345";
  
	public static Connection getConnection() {
		
		
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
	          e1.printStackTrace();

		}
		return con;

	}

}
