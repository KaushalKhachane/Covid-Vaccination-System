package com.internship;

import java.sql.*;

public class DbConnection{
	public static Connection Connectiontodatabase() throws Exception{

		String url="jdbc:mysql://localhost:3306/management?autoReconnect=true&useSSL=false&allowPublicKeyRetrival=true";
		String user="root";
		String password = "Tiger@123";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection(url,user,password);
		
		return connect;
		
	}
}