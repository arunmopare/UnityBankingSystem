package com.dao;
import java.sql.*;
import java.util.List;

import com.model.Application;
public class BankDao {
Connection con;
PreparedStatement ps;
public Connection getConnection() {
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456789");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}
public int savedData(List<Application> lst){
	Application r=lst.get(0);
	Connection con =getConnection();
	int i=0;
	try {
		ps=con.prepareStatement("insert into application values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		
//		ps.setInt(1, r.getApp_no());
//		ps.setString(2,r.getBranch_name());
//		ps.setString(3,r.getAccount_type());
//		ps.setString(4,r.getSurname());
//		ps.setString(5,r.getFirtsname());
//		ps.setString(6,r.getMiddlename());
//		ps.setString(7,r.getDate());
//		ps.setString(8,r.getMother_name());
//		ps.setString(9,r.getEmail());
//		ps.setString(10,r.getMobile_no());
//		ps.setString(11,r.getNationality());
//		ps.setString(12,r.getOccupation());
//		ps.setString(13,r.getCity());
//		ps.setString(14,r.getState());
//		ps.setString(15,r.getDistrict());
//		ps.setInt(16,r.getPincode());
//		ps.setString(17,r.getAadhar_no());
//		ps.setInt(18,r.getPan_no());
//		i=ps.executeUpdate();
//		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return i;
}
}
