package com.sachin.connect.scam.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sachin.connect.scam.dto.constant.JdbcConnection;

public class ScamOrderByIdDescTester {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(JdbcConnection.url, JdbcConnection.username,
				JdbcConnection.password)) {

			String query = "SELECT * FROM scam  order by s_name desc;";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet result = statement.getResultSet();
			while (result.next()) {
				String name = result.getString("s_name");
				System.out.println(name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
