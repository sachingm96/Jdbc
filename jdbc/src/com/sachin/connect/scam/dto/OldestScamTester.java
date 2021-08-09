package com.sachin.connect.scam.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sachin.connect.scam.dto.constant.JdbcConnection;

public class OldestScamTester {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(JdbcConnection.url, JdbcConnection.username,
				JdbcConnection.password)) {

			String query = "SELECT * FROM scam ORDER BY s_year 	LIMIT 3;";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet result = statement.getResultSet();
			while (result.next()) {
				int year = result.getInt("s_year");
				System.out.println(year);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}

}
