package com.sachin.connect.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateScamYearByName {

	public static void main(String[] args) {

		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/transformers";

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String updateYearByName = "select count(s_name) from scam;";
			Statement st = conn.createStatement();
			st.execute(updateYearByName);
			ResultSet result = st.getResultSet();
			System.out.println(result.getFetchSize());
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
