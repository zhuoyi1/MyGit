package com.lian1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class zsgc {
	public static void main(String[] args) {
		//zengjia();
		//shanchu();
		//gai();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = Juts.getConn();
			st = conn.createStatement();
			rs = st.executeQuery("select * from product");
			while (rs.next()) {
				rs.getObject("pid");
				rs.getObject("pname");
				rs.getObject("price");
				rs.getObject("flag");
				System.out.println(rs.getObject("pid")+"-"+rs.getObject("pname")+"-"+rs.getObject("price")+"-"+rs.getObject("flag"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Juts.guan(conn, st, rs);
		}
	}

	private static void gai() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = Juts.getConn();
			st = conn.createStatement();
			int executeUpdate = st.executeUpdate("update product set pname ='花花公子' where pid='9';");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Juts.guan(conn, st, rs);
		}
	}

	private static void shanchu() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = Juts.getConn();
			 st = conn.createStatement();
			 int executeUpdate = st.executeUpdate("delete from product where pname='森马';");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Juts.guan(conn, st, rs);
		}
	}

	private static void zengjia() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = Juts.getConn();
			st = conn.createStatement();
			int executeUpdate = st.executeUpdate("insert into product(pname,price,flag) values('森马',1300,'2');");
			System.out.println(executeUpdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Juts.guan(conn, st, rs);
		}
	}
	
}
