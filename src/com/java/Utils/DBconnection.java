package com.java.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	public static Connection getDBconnection() {
		Connection connection = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");  
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/officetoolsdb","root","root");  
		}
		catch(Exception exception){
			connection= null;
		}
		return connection;
	}
}
