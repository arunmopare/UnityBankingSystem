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
import com.model.Beneficiary;

@WebServlet("/ShowAllBnfTransferCon")
public class ShowAllBnfTransferCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BankDao bd = new BankDao();
		String curr_ac_bnf=request.getParameter("curr_account");
		curr_ac_bnf=curr_ac_bnf.trim();	
		
		List<Beneficiary> lst= bd.searchdataBnf(curr_ac_bnf);
		HttpSession session = request.getSession(true);
		session.setAttribute("bnfdata", lst);
		response.sendRedirect("transfer_money.jsp");
		
	}

}
