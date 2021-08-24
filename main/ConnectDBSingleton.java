package main.java.vr.voter_reg.main;

import java.sql.*;

public class ConnectDBSingleton {
	
	private static ConnectDBSingleton handler = null;
	private static Connection connection = null;
	
	private ConnectDBSingleton() {
	}
	
	public static ConnectDBSingleton getInstance() {
		
		if(handler == null) 
			handler = new ConnectDBSingleton();
		return handler;
	}
	
	public Connection EstablishConnection() {
		
		try {
			
			//Creating string fields to hold database access params
			final String url = "jdbc:postgresql://ec2-108-128-104-50.eu-west-1.compute.amazonaws.com:5432/d31geu5l6qcolq";
			final String user = "hpdxjliatihywu";
			final String password = "c7aed0bc1c2e6b21f03ea76f4510615cd13e36c44766929971940d025619a0ba";
			
			//Connecting to postgresql server
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to PostgreSQL server successfully!");
		}
		catch(SQLException e) {
			
			//Displaying any errors/exceptions caught if anything went wrong
			System.out.println(e.getMessage());
			e.printStackTrace();	
		}
		
		return connection;
		
	}

}
