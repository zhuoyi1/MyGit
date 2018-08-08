package com.lian1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class abc {
public static void main(String[] args) throws Exception {
	//chaxun();
	//zengjia();
	//xiugai();
	//shanchu();
}

private static void shanchu() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zxc","root","root");
	Statement createStatement = connection.createStatement();
	int executeUpdate = createStatement.executeUpdate("delete from product where pid='10';");
	System.out.println(executeUpdate);
	createStatement.close();
	connection.close();
}

private static void xiugai() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zxc","root","root");
	Statement createStatement = connection.createStatement();
	int executeUpdate = createStatement.executeUpdate("update product set pname='特步' where pid='1';");
	System.out.println(executeUpdate);
	createStatement.close();
	connection.close();
}

private static void zengjia() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zxc","root","root");
	Statement createStatement = connection.createStatement();
	int executeUpdate = createStatement.executeUpdate("insert into product(pname,price,flag) values('阿迪',5000,'1');");
	System.out.println(executeUpdate);
	createStatement.close();
	connection.close();
}

private static void chaxun() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zxc","root","root");
	Statement st = conn.createStatement();
	ResultSet exe = st.executeQuery("select * from product;");
	while (exe.next()) {
		Object object = exe.getObject("pid");
		Object object2 = exe.getObject("pname");
		Object object3 = exe.getObject("price");
		Object object4 = exe.getObject("flag");
		System.out.println(object+"-"+object2+"-"+object3+"-"+object4);
	}
	exe.close();
	st.close();
	conn.close();
}
}
