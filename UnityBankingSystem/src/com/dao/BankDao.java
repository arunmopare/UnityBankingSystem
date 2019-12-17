package com.dao;
import java.sql.*;
import java.util.List;

//import org.graalvm.compiler.lir.amd64.AMD64Unary.RMOp;

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
public int savedData(List<Application> lst1){
	Application r=lst1.get(0);
	Connection con =getConnection();
	System.out.println("test1"+con);
	int i=0;
	
	try {
		ps=con.prepareStatement("insert into application values(seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		//ps=con.prepareStatement("insert into arun1 values(?,?)");
		//insert into application values(seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);

		int j=1;
		
//		ps.setString(2, "12");
//		ps.setString(3, "12");
//		ps.setString(4, "12");
//		ps.setString(5, "12");
//		ps.setString(6, "12");
//		ps.setString(7,"12");
//		
//		ps.setString(8, "12");
//		ps.setString(9, "12");		
//		ps.setString(10, "12");
//		ps.setString(11, "12");
//		ps.setString(12, "12");
//		ps.setString(13, "12");
//		ps.setString(14, "12");
//		ps.setString(15, "12");
//		ps.setString(16, "12");
//		ps.setString(17, "12");
		
		//first is autoincreamental value
		//ps.setInt(1,1);
		ps.setString(1, r.getBranch_number());
		ps.setString(2, r.getAccount_type());
		ps.setString(3, r.getLast_name());
		ps.setString(4, r.getFirst_name());
		ps.setString(5, r.getMiddle_name());
		ps.setString(6, r.getBirth_date());
		
		ps.setString(7, r.getEmail_address());
		ps.setString(8, r.getMobile_number());		
		ps.setString(9, r.getNationality());
		ps.setString(10, r.getOccupation());
		ps.setString(11, r.getCity());
		ps.setString(12, r.getState());
		ps.setString(13, r.getDistrict());
		ps.setString(14, r.getPin_code());
		ps.setString(15, r.getAadhar_number());
		ps.setString(16, r.getPan_number());
		
		i=ps.executeUpdate();
		System.out.println(i);
		con.close();
		
		
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
		
		System.err.print(e.getMessage());;
		e.printStackTrace();
	}
	return i;
}
}
