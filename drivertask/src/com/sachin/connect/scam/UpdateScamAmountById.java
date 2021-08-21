package com.sachin.connect.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateScamAmountById {
	public static void main(String[] args) {
		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/transformers";

		try (Connection connect = DriverManager.getConnection(url, username, password)) {

			String updateAmountByID = "update scam set s_amount=178000 where s_id=3";
			Statement st = connect.createStatement();
			st.execute(updateAmountByID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
