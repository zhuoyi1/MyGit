package com.lian3;

import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class LianJieChi2 {
public static void main(String[] args) throws Exception {
	//test01();
	//test02();
	Properties prop = new Properties();
	//prop.load(Test01_05.class.getResourceAsStream("/dbcp.properties"));
	//prop.load();
	// 1.创建连接池
	BasicDataSource ds = (BasicDataSource) BasicDataSourceFactory.createDataSource(prop);
	// 2.获取连接
	for (int i = 1; i<= 10; i++) {
		Connection conn = ds.getConnection();
		System.out.println(conn.hashCode());
	}
}
public static void test01() throws Exception{
	// 获得连接池对象
	ComboPooledDataSource ds = new ComboPooledDataSource();
	// 获得连接对象
	for (int i = 0; i < 10; i++) {
		Connection conn = ds.getConnection();
		System.out.println("第" + (i + 1) + "个:" + conn);
		if(i == 3){
			// 把连接对象放回连接池
			conn.close();
		}
	}
}

// 使用命名配置(named-config)
public static void test02() throws Exception{
	// 获得连接池对象
	ComboPooledDataSource ds = new ComboPooledDataSource("pkxing-config");
	// 获得连接对象
	for (int i = 0; i< 10; i++) {
		Connection conn = ds.getConnection();
		System.out.println("第" + (i + 1) + "个:" + conn);
	}
}
}
