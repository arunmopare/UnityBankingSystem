package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BankDao;
import com.model.AdminLogin;
import com.model.Otp;

@WebServlet("/VerifyOtpStep2Controler")
public class VerifyOtpStep2Controler extends HttpServlet {
    public static String otp1;
	//String email="";
//	public String verifyOTP(List<Otp>lst) {
//	Otp otplst=lst.get(0);
//	//String email=otplst.getEmail();
//	String otp1=otplst.getotp();
//	System.out.println(otp1+"list");
//	return otp1;
//	
//	}
    
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String s1= request.getParameter("email");
		String s2 =request.getParameter("otpstep2");
		String s3=request.getParameter("otpforward");
		System.out.println(s3+ "inside" );
		System.out.println(s2+"input");
		s2=s2.trim();
		s3=s3.trim();
		s1=s1.trim();
		System.out.println(s2);
		
		if(s2.equals(s3)) {
			System.out.println("match");
			BankDao bd = new BankDao();
			//response.sendRedirect("Success.jsp");
			PrintWriter pw = response.getWriter();
			int k=bd.updateEmailApproval(s1);
			if(k>0) {
				response.sendRedirect("Success.jsp");
			}
		}
		else {
				
				System.out.println("no otp match");
				//response.sendRedirect("Success.jsp");
		}
		
	}

}
