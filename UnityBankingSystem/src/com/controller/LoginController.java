package com.controller;

import java.io.Console;
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
import com.dao.LoginDao;
import com.model.AdminLogin;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username= request.getParameter("username");

		String password= request.getParameter("password");
		AdminLogin a =new AdminLogin();
		
		a.setUname(username);
		a.setPass(password);
		
		List<AdminLogin> lst=new ArrayList<AdminLogin>();
		System.out.println("log 1");
		lst.add(a);
		System.out.println("log2");
		
		
		
		BankDao dao =new BankDao();
		
		boolean b = dao.validate(lst);
		
		
		System.out.println(username+" "+password);
		if(b) 
		{
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("AdminDashboard.jsp");			
		}
		else {
			response.sendRedirect("LogInAdmin.jsp");
			
		}
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
