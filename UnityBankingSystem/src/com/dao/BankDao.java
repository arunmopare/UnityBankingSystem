package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.AdminLogin;

//import org.graalvm.compiler.lir.amd64.AMD64Unary.RMOp;

import com.model.Application;

import oracle.jdbc.util.Login;
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

public boolean validate(List<AdminLogin> lst){
	getConnection();
	boolean b=false;
	AdminLogin ad=(AdminLogin)lst.get(0);
	try
	{
		ps=con.prepareStatement("select * from pass where uname=? AND pass=?");
		ps.setString(1,ad.getUname());
		ps.setString(2,ad.getPass());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			System.out.println("result set");
			b=true;
		}
		else
		{
			System.out.println("no result..");
		}
	}
	catch(Exception e){
		System.out.println(e);
	}
	return b;
}

public int savedData(List<Application> lst1){
	Application r=lst1.get(0);
	Connection con =getConnection();
	System.out.println("test1"+con);
	int i=0;
	
	try {
		ps=con.prepareStatement("insert into application values(seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		int j=1;
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
		
		

	} catch (SQLException e) {
		
		System.err.print(e.getMessage());;
		e.printStackTrace();
	}
	return i;
}
public List<Application> searchData(){
	Connection con =getConnection();
	List<Application> l1 = new ArrayList<Application>();
	try {
		System.out.println("errr1");
		ps=con.prepareStatement("select * from application" );
		System.out.println("errr2");
		//ps.setString(1, sno);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			System.out.println("errr3");
			Application apl=new Application();
			apl.setCust_id(rs.getString(1));
			apl.setBranch_number(rs.getString(2));
			apl.setAccount_type(rs.getString(3));
			apl.setLast_name(rs.getString(4));
			apl.setFirst_name(rs.getString(5));
			apl.setMiddle_name(rs.getString(6));
			apl.setBirth_date(rs.getString(7));
			apl.setEmail_address(rs.getString(8));
			apl.setMobile_number(rs.getString(9));
			apl.setNationality(rs.getString(10));
			apl.setOccupation(rs.getString(11));
			apl.setCity(rs.getString(12));
			apl.setState(rs.getString(13));
			apl.setDistrict(rs.getString(14));
			apl.setPin_code(rs.getString(15));
			apl.setAadhar_number(rs.getString(16));
			apl.setPan_number(rs.getString(17));
			l1.add(apl);
		
			
		}
		}
		catch(SQLException e)
		{
			System.out.println("Not found");
			System.err.print(e.getMessage());;
			e.printStackTrace();
			
		}
		return l1;

}
}
