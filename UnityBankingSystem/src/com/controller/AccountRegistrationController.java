package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BankDao;
import com.model.Application;

/**
 * Servlet implementation class AccountRegistrationController
 */
@WebServlet("/AccountRegistrationController")
public class AccountRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("hiiii");
		
	

		String s0=request.getParameter("branch_name");
		String s1=request.getParameter("account_type");
		String s2=request.getParameter("last_name");
		String s3=request.getParameter("first_name");
		String s4=request.getParameter("middle_name");
		String s5=request.getParameter("birth_date");
		String s6=request.getParameter("email_address");
		String s7=request.getParameter("mobile_number");
		String s8=request.getParameter("nationality");
		String s9=request.getParameter("occupation");
		String s10=request.getParameter("city");
		String s11=request.getParameter("state");
		String s12=request.getParameter("district");
		String s13=request.getParameter("pin_code");
		String s14=request.getParameter("aadhar_number");
		String s15=request.getParameter("pan_number");

		//request.getIntHeader(name)
		
		Application rm=new Application();
		
		rm.setBranch_number(s0);
		rm.setAccount_type(s1);
		rm.setLast_name(s2);
		rm.setFirst_name(s3);
		rm.setMiddle_name(s4);
		rm.setBirth_date(s5);
		rm.setEmail_address(s6); 
		rm.setMobile_number(s7);
		rm.setNationality(s8);
		rm.setOccupation(s9);
		rm.setCity(s10);
		rm.setState(s11);
		rm.setDistrict(s12);
		rm.setPin_code(s13);
		rm.setAadhar_number(s14);
		rm.setPan_number(s15);
		
		List<Application> lst =new ArrayList<Application>();
		lst.add(rm);
		
		BankDao rd = new BankDao();
		PrintWriter pw = response.getWriter();
		int i=rd.savedData(lst);
		//int j=rd.saveAccount(lst2);
		if(i>0)
		{
			response.sendRedirect("VerifyOtp.jsp");
			System.out.println("Application Submitted");
		}
		
	}

}
