package com.sachin.connect.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDescriptionByName {

	public static void main(String[] args) {
		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/transformers";

		try (Connection cn = DriverManager.getConnection(url, username, password)) {
			String updateDescriptionByName = "update scam set s_description='. It was also reported that the Indian athletes were forced to stay in terrible conditions' where s_name='Commonwealth Games scam'";
			Statement st = cn.createStatement();
			st.execute(updateDescriptionByName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
