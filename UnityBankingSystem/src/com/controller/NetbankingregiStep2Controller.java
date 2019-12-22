package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BankDao;
import com.model.NetBankingprofile;

@WebServlet("/NetbankingregiStep2Controller")
public class NetbankingregiStep2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s0=request.getParameter("account_number");
		String s1= request.getParameter("email");
		String s2 =request.getParameter("otpstep2");
		String s3=request.getParameter("otpforward11");
		String s4=request.getParameter("netbankingpassword");
		String s5=request.getParameter("netbankingpassword2");
		String s6=request.getParameter("user_id");
		
		HttpSession session=request.getSession();
		
		s2=s2.trim();
		s3=s3.trim();
		s1=s1.trim();
		s4=s4.trim();
		s5=s5.trim();
		s6=s6.trim();
		if(!s4.equals(s5)) {
			session.setAttribute("repeated_password","Password Missmathched Please Enter the password again");
			response.sendRedirect("NetbankingregiStep2.jsp");
			return;
		}
		else {
			session.setAttribute("repeated_password","");
			
		}
		
		
		if(!s2.equals(s3)) {
			session.setAttribute("wrong_otp11","Please Check your OTP");
			response.sendRedirect("NetbankingregiStep2.jsp");
			return;
		}else {
			session.setAttribute("wrong_otp11","");
		}
		
		NetBankingprofile bankingprofile =new NetBankingprofile();
		bankingprofile.setAccount_number(s0);
		bankingprofile.setUser_id(s6);
		bankingprofile.setPassword(s5);
		
		 List<NetBankingprofile> lst=new ArrayList<NetBankingprofile>();
		 lst.add(bankingprofile);
		//bankingprofile.setPassword();
		//List<NetBankingprofile>
		
			System.out.println("matched password and otp");
			
			BankDao bd = new BankDao();
			//response.sendRedirect("Success.jsp");
			PrintWriter pw = response.getWriter();
			int k=bd.CreateNetBanking(lst);
			if(k>0) {
				response.sendRedirect("Success2.jsp");
			}		
			else {
				response.sendRedirect("error.jsp");
			}
			
		}

	
}
