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

			/*String query1 = "insert into scam values(1,'PNB scam','Bank',2016,'King of good times Vijay Mallya',9000,'Karnataka','rs 9000cr which he had taken as a loan to keep his now defunct Kingfisher airlines from failing.')";
			String query2="insert into scam values(2,' Coalgate Scam ',' Coalgate',2012,'UPA government',186000,'UP',' is a political scandal that surfaced in 2012 when the UPA government was in power')";
			String query3="insert into scam values(3,'2G Spectrum scam','2G',2008,' Raja',176000,'india',' Supreme Court and led to the cancellation of over 120 licenses.')";
			String query4="insert into scam values(4,'Commonwealth Games scam','game',2010,'Suresh Kalmadi',70000,'india','the Commonwealth Games held in India made more headlines for the controversies')";
			String query5="insert into scam values(5,'BOFORS scandal','weapon',1986,'Rajiv Gandhi',64,'india','This is a major weapons contract scandal that took place between India and Sweden')";
			String query6="insert into scam values(6,'Nirav Modi PNB Bank fraud','bank', 2018 ,'Nirav Gandhi',11400  ,'India' ,'Diamonds are a man or womans best friend, but diamantaires like Nirav Modi are not.')";
			String query7="insert into scam values(7,'AgustaWestland chopper scam','AgustaWestland chopper',2010  ,'UPA government ', 3600 ,'UP' ,'some politicians and defence officials received bribes')";
			String query8="insert into scam values(8,'Satyam scam','corporate',2009  ,'B Ramalinga Raju ',14000  ,'india' ,'in front of its board, stock exchanges, investors and other stakeholders. ')";
			String query9="insert into scam values(9,'Hawala scam ','black money', 1990 ,'Hawala brothers',18  ,'india' ,'black money were done by these politicians through the brothers.  ')";
			String query10 = "insert into scam values(10,'Jet Airways','misappropriation', 2010,'jetairwayscompany',25000000,'mumbai',' top industrialists and CEOs of the country. Its service standards were its USP.') ";
			
			
			String query12 = "insert into scam values(12,'IPL Scam','BCCI',2013,'Arun Jaitley and Jyotiraditya Scindia','Pune',3.75,'IPL Scam')";
			String query15 = "insert into scam values(15,'Railgate Scam','Indian Railway Board',2012,' Pawan Kumar Bansal','India',7,'with the help of  telephonic conversations ')";
			String query16 = "insert into scam values(16,'Tatra truck scam','Bharat Earth Movers Ltd (BEML)',2011,'VK Singh','India',14,' purchase of components for Tatra trucks')";
			String query17 = "insert into scam values(17,'Stock market scam','Trading',2010,'Ketan Parekh','India',8,'involved in circular trading ')";
			String query18 = "insert into scam values(18,'cash-for-votes scandal','Election',2008,'Soniya Gandhi','India',2,'to pursue the Indo-US nuclear deal ')";
			String query19 = "insert into scam values(19,'Bellary mining scam','Mining leases',2006,'Reddy brothers','Bellary',16.0,'xchange for issuing mining leases ')";
			String query20 = "insert into scam values(20,'Saradha Group chit fund scam','Financial',2013,' Debjani Mukhopadhdhay ','West Bengal.',15.3,'variety of collective investment schemes')";
			String query11 = "insert into scam values(11,'Coal scam','corruption',2000,' Abhishek Banerjee ','Bengal.',40,'imprisonment in a coal block ')";
			String query13 = "insert into scam values(13,'Antrix Devas scam','Scientific',2011,'G Madhavan Nair','Bengal',148,'build the satellites without disclosing fact')";
			String query14 = "insert into scam values(14,' Fodder scam','fictitious livestock',1996,'Jagannath Mishra','India',950,'medicines and animal husbandry equipment')";
			*/
			
			
			
			
			Statement statement = connect.createStatement();
			/*statement.execute(query1);
			statement.execute(query2);
			statement.execute(query3);
			statement.execute(query4);
			statement.execute(query5);
			statement.execute(query6);
			statement.execute(query7);
			statement.execute(query8);
			statement.execute(query9);
			statement.execute(query10);
			statement.execute(query11);
			statement.execute(query12);
			statement.execute(query13);
			statement.execute(query14);
			statement.execute(query15);
			statement.execute(query16);
			statement.execute(query17);
			statement.execute(query18);
			statement.execute(query19);
			statement.execute(query20);
			*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
