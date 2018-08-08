package com.lian2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0 {
	private static ComboPooledDataSource cds = new ComboPooledDataSource();//创建连接池对象

	public static Connection getconnection(){
		try {
			return cds.getConnection();
			//return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
