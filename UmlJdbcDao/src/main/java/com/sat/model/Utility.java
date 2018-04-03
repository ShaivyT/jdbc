package com.sat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {
	
	public static Connection getDMConnection() {
		Connection conn = null;
		try {
			//												 hw2-tiwari-shaivy-spring-2018.chcdakd3wsv8.us-east-2.rds.amazonaws.com
			//												 cs5200-spring2018-tiwari.chcdakd3wsv8.us-east-2.rds.amazonaws.com
			conn = DriverManager.getConnection("jdbc:mysql://hw2-tiwari-shaivy-spring-2018.chcdakd3wsv8.us-east-2.rds.amazonaws.com/hw2_tiwari_shaivy_spring_2018","shaivysh","shaivytiger");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:","shaivysh","shaivytiger");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
