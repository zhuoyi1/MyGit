package com.lian2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lian1.Juts;

public class Test01 {
public static void main(String[] args) {
	List<Product> tt = tt();
	for (Product product : tt) {
		System.out.println(product);
	}
}
public static List<Product> tt(){
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	List<Product> list = new ArrayList<>();
	try {
		conn = Juts.getConn();
		st = conn.prepareStatement("select pid,pname,price,flag from Product");
		rs = st.executeQuery();
		while (rs.next()) {
			Product p = new Product();
			p.setPid(rs.getInt("pid"));
			p.setPname(rs.getString("pname"));
			p.setPrice(rs.getInt("price"));
			p.setFlag(rs.getString("flag"));
			list.add(p);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		Juts.guan(conn, st, rs);
	}
	return list;
}
public static int shan(int h){
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	int s = 0;
	try {
		conn = Juts.getConn();
		st = conn.prepareStatement("delete from Product where pid=?");
		st.setInt(1, h);
		s = st.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		Juts.guan(conn, st, rs);
	}
	return s;
}
public static  Product pr(int id){
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	Product p = new Product();
	try {
		conn = Juts.getConn();
		st = conn.prepareStatement("select pid,pname,price,flag from Product where pid=?");
		st.setObject(1, id);
		rs = st.executeQuery();
		rs.next();
		p.setPid(rs.getInt("pid"));
		p.setPname(rs.getString("pname"));
		p.setPrice(rs.getInt("price"));
		p.setFlag(rs.getString("flag"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		Juts.guan(conn, st, rs);
	}
	return p;
}
private static void shan() {
	try {
		QueryRunner qr = new QueryRunner();
		String sql = "delete from product where pid=?";
		Object[] obj = {"11"};
		qr.update(sql,obj);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private static void gai() {
	try {
		QueryRunner qr = new QueryRunner();
		String sql = "update product set pname=? where pid=?";
		Object[] obj = {"标码","11"};
		qr.update(sql,obj);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private static void zeng() {
	try {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into  product(pname,price,flag) values(?,?,?)";
		Object[] obj = {"senma","500","1"};
		qr.update(sql,obj);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
