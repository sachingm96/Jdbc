package com.sachin.connect.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamTester {

	public static void main(String[] args) throws Exception {


		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/transformers";

		
		try (Connection connect = DriverManager.getConnection(url, username, password)) {
			System.out.println(connect.getAutoCommit());
			connect.setAutoCommit(false);
			String query1 = "insert into scam values(4355551,'PNB scam','Bank',2016,'King of good times Vijay Mallya',9000,'Karnataka','rs 9000cr which he had taken as a loan to keep his now defunct Kingfisher airlines from failing.')";
			String query2="insert into scam values(454552,' Coalgate Scam ', 'Coalgate',2012,'UPA government',186000,'UP',' is a political scandal that surfaced in 2012 when the UPA government was in power')";
			

			Statement statement = connect.createStatement();
			statement.execute(query1);
			statement.execute(query2);
			
			
			connect.commit();
			
			System.out.println(connect);
			
		} catch (SQLException e) {
			e.printStackTrace();
			Connection connect = null;
			connect.rollback();
		}

	}

}
