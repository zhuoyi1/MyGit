package com.lian3;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class LianJieChi1 {
	public static void main(String[] args) throws Exception {
		ComboPooledDataSource cds = new ComboPooledDataSource();
		cds.setUser("root");
		cds.setPassword("root");
		cds.setJdbcUrl("jdbc:mysql://localhost:3306/zxc");
		cds.setDriverClass("com.mysql.jdbc.Driver");
		cds.setInitialPoolSize(5);
		cds.setMaxPoolSize(10);
		cds.setMaxIdleTime(2000);
		cds.setCheckoutTimeout(1000);
		for (int i = 0; i < 10; i++) {
			Connection conn = cds.getConnection();
			System.out.println(conn+"-");
		}
	}
	
}
