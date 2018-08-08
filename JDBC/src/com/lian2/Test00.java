package com.lian2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lian1.Juts;

public class Test00 {
public static void main(String[] args) {
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	//cha(conn, st, rs);
	//gai(conn, st, rs);
	try {
		conn = Juts.getConn();
		st = conn.prepareStatement("update product set pname='森马' where pid=?");
		st.setObject(1, 10);
		st.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		Juts.guan(conn, st, rs);
	}
}

private static void gai(Connection conn, PreparedStatement st, ResultSet rs) {
	try {
		conn = Juts.getConn();
		st = conn.prepareStatement("insert into product(pname,price,flag) values(?,?,?);");
		st.setObject(1, "hahah");
		st.setObject(2, 5000);
		st.setObject(3, "2");
		int executeUpdate = st.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		Juts.guan(conn, st, rs);
	}
}

private static void cha(Connection conn, PreparedStatement st, ResultSet rs) {
	try {
		conn = Juts.getConn();
		st = conn.prepareStatement("select * from product;");
		//st.setLong(1, 2);
		rs = st.executeQuery();
		while (rs.next()) {
			rs.getObject("pname");
			System.out.println(rs.getObject("pname"));
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		Juts.guan(conn, st, rs);
	}
}
}
