package com.sachin.connect.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateScamYearAmountLocationTypeByNameAndId {

	public static void main(String[] args) {

		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/transformers";

		try (Connection cn = DriverManager.getConnection(url, username, password)) {
			String updateScamByMultipleFields = "update scam set s_year=2009,s_amount=17900,s_location='india',s_type='2G network' where s_name='2G Spectrum scam' and s_id=3";
			Statement st = cn.createStatement();
			st.execute(updateScamByMultipleFields);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
