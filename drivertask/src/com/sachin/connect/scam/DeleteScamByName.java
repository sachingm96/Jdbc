package com.sachin.connect.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteScamByName {

	public static void main(String[] args) {
		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/transformers";

		try (Connection connect = DriverManager.getConnection(url, username, password)) {

			String deleteScamByname = "delete from scam where s_name=' Coalgate Scam '";
			Statement st = connect.createStatement();
			st.execute(deleteScamByname);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
