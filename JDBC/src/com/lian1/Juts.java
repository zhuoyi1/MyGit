package com.lian1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Juts {
	private static String Driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/zxc";
	private static String name = "root";
	private static String pass = "root";
	static{
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws Exception{
		Connection conn =  DriverManager.getConnection(url,name,pass);
		return conn;
	}
	public static void guan(Connection conn,Statement st, ResultSet rs){
		if (rs != null) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
