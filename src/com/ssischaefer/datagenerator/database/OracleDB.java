package com.ssischaefer.datagenerator.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class that manages the local database connection
public class OracleDB {

	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String USERNAME = "Diplomarbeit";
	private final static String PASSWORD = "diplomarbeit";

	private static Connection connection;

	public OracleDB() {
		connect();
	}

	public static void connect() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			if (connection != null) {
				System.out.println("[OracleDB] The connection to the database has been established.");
			} else {
				System.out.println("[OracleDB] The connection to the database was not established.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void disconnect() {
		try {
			connection.close();
			
			System.out.println("[OracleDB] The connection to the database has been closed.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		OracleDB.connection = connection;
	}

}
