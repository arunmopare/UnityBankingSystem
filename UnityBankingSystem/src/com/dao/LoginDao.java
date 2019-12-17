package com.dao;
import java.sql.*;
public class LoginDao 
{
	Connection con;
	PreparedStatement ps;
	public Connection getConnection() 
	{
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
	public boolean check(String user, String pass) 
	{
		boolean b=false;
		Connection con =getConnection();
		System.out.println("hiii");
		try
		{
			//select * from adminpass where username='arunmopare' and password='iamadmin';
			ps=con.prepareStatement("select* from adminpass where username=? and password=?");
			ps.setString(1,user);
			ps.setString(2,pass);
			
			System.out.println(user+" "+pass);
			
			ResultSet rst=ps.executeQuery();
			System.out.println("hiii");
			if(rst.next()) {
				System.out.println("result set");
				b=true;
			}
			else {
				System.out.println("result not set");
			}
			System.out.println("hiii2");
		}
		catch (SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
		return b;

	}
}
