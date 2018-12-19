package com.wsc.Controls;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnection {
	private static String url="jdbc:mysql://localhost:3306/hotel?useSSL=true";
	private static String user="root";
	private static String password="root";
	
	
	
		public static Connection startConnection() {
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 con=DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
}
