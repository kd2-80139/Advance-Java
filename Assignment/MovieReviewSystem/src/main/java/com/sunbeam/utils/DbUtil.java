package com.sunbeam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static String dbName="com.mysql.cj.jdbc.Driver";
	public static String dbURL="jdbc:mysql://localhost:3306/movies";
	public static String userName="root";
	public static String userPasswrd="manager";
	static {
		try {
			Class.forName(dbName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	public static Connection getCon() throws SQLException {
		Connection con=DriverManager.getConnection(dbURL, userName, userPasswrd);
		return con;
	}
}

