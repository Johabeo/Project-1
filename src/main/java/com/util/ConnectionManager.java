package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	private static String url = "jdbc:mysql://localhost:3306/expensereimbursementsystem";
	private static String user = "root";
	private static String pass = "Py2Pi6$&9V!o#W"; //figure a way out of this
	
	public static Connection getConnection() throws Exception{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,pass);
			return conn;
		} catch (Exception e){
			throw new Exception(e);
		}
	}
}
