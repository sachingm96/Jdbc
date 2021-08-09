package com.sachin.connect.scam.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sachin.connect.scam.dto.constant.JdbcConnection;

public class TotalScamTester {

	public static void main(String[] args) {


		try (Connection connection = DriverManager.getConnection(JdbcConnection.url, JdbcConnection.username,
				JdbcConnection.password)) {

			String query = "select count(s_id) from scam;";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet result = statement.getResultSet();
			while (result.next()) {
				int count = result.getInt(1);
				System.out.println("total number pf Scams " + count);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		
		}

	}

}
