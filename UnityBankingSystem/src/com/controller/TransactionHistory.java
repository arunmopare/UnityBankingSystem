package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BankDao;
import com.model.Transaction;

@WebServlet("/TransactionHistory")
public class TransactionHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1=request.getParameter("curr_account");
		HttpSession session= request.getSession();
		BankDao bd= new BankDao();
		List<Transaction>lst= bd.getTansactionTable(s1);
		System.out.println(lst);
		request.setAttribute("Listhistory",lst);
		response.sendRedirect("tranHistory.jsp");
	}

}
