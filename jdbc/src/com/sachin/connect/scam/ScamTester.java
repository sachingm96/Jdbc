package com.sachin.connect.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamTester {

	public static void main(String[] args) {


		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/transformers";

		try (Connection connect = DriverManager.getConnection(url, username, password)) {

			String query1 = "insert into scam values(1,'PNB scam','Bank',2016,'King of good times Vijay Mallya',9000,'Karnataka','rs 9000cr which he had taken as a loan to keep his now defunct Kingfisher airlines from failing.')";
			String query2="insert into scam values(2,' Coalgate Scam ',' Coalgate',2012,'UPA government',186000,'UP',' is a political scandal that surfaced in 2012 when the UPA government was in power')";
			String query3="insert into scam values(3,'2G Spectrum scam','2G',2008,' Raja',176000,'india',' Supreme Court and led to the cancellation of over 120 licenses.')";
			String query4="insert into scam values(4,'Commonwealth Games scam','game',2010,'Suresh Kalmadi',70000,'india','the Commonwealth Games held in India made more headlines for the controversies')";
			
			Statement statement = connect.createStatement();
			statement.execute(query1);
			statement.execute(query2);
			statement.execute(query3);
			statement.execute(query4);
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
