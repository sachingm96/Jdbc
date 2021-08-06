package com.sachin.connect.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateScamYearByName {

	public static void main(String[] args) {

		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/transformers";

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String updateYearByName = "update scam set s_year=2009 where s_name='Commonwealth Games scam'";
			Statement st = conn.createStatement();
			st.execute(updateYearByName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
