package com.sachin.connect.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateScamAmountByName {

	public static void main(String[] args) {

		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/transformers";

		try (Connection connect = DriverManager.getConnection(url, username, password)) {

			String updateAmountByName = "update scam set s_amount=8000 where s_name='Commonwealth Games scam'";
			Statement st = connect.createStatement();
			st.execute(updateAmountByName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
