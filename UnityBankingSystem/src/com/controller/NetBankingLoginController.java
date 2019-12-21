package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BankDao;
import com.model.Net_login;


@WebServlet("/NetBankingLoginController")
public class NetBankingLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
     String net_username=request.getParameter("net_username");
     String net_password=request.getParameter("net_password");
     
     HttpSession sesion=request.getSession();
     
     
     net_username=net_username.trim();
     net_password=net_password.trim();
     
     Net_login login = new Net_login();
     List<Net_login> lst = new ArrayList<Net_login>();
     
     
     login.setNet_username(net_username);
     login.setNet_password(net_password);
    
     lst.add(login);
     
     BankDao bd=new BankDao();
     boolean b= bd.validatenetBankingLogin(lst);
     
     System.out.println(net_username+" "+net_password);
		if(b) 
		{
			HttpSession session=request.getSession();
			session.setAttribute("net_banking_username",net_username);
			response.sendRedirect("NetBankingDashboard.jsp");			
		}
		else {
			response.sendRedirect("NetBankingLogin.jsp");
			
		}
	} 
     
     
	}


