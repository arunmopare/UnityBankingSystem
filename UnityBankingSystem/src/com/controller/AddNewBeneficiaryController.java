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
import com.model.Beneficiary;


@WebServlet("/AddNewBeneficiaryController")
public class AddNewBeneficiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String benif_name=request.getParameter("benfi_name");
	     String account_no=request.getParameter("account_number");
	     String account_no2=request.getParameter("account_number2");
	     String amount_limit=request.getParameter("amount_limit");
	     String curr_account=request.getParameter("curr_account");
	     String ifsc_benf=request.getParameter("ifsc_benf");
	     
	     ifsc_benf=ifsc_benf.trim();
	     curr_account=curr_account.trim();
	     benif_name=benif_name.trim();
	     account_no=account_no.trim();
	     account_no2=account_no2.trim();
	     HttpSession session=request.getSession();
	     //check if account exists
	     BankDao bd =new BankDao();
	     if(!account_no.equals(account_no2)) {
	    	 response.sendRedirect("AddNewBeneficiary.jsp");
	    	 session.setAttribute("invalid_details_of_account", "INVALID DETAILS OF ACCOUNT");
	    	 return;
	     }
	     boolean b=bd.checkAccountExists(ifsc_benf,account_no);
	     if(b) {
	    	 System.out.println("Account Exists");
	    	 List<Beneficiary> lst= new ArrayList<Beneficiary>();
	    	 Beneficiary beneficiary = new Beneficiary();
	    	 beneficiary.setB_name(benif_name);
	    	 beneficiary.setFrom_account(curr_account);
	    	 beneficiary.setTo_account(account_no2);
	    	 beneficiary.setTo_ifsc(ifsc_benf);
	    	 beneficiary.setB_limit(amount_limit);
	    	 lst.add(beneficiary);
	    	
	    	 int i = bd.CreateBeneficiary(lst);
	    	 if(i>0)
	 		{
	 			response.sendRedirect("bnfcreated.jsp");
	 			System.out.println("Application Submitted");
	 		}
	    	 //HttpSession session=request.getSession();
				//session.setAttribute("username", username);
				//response.sendRedirect("AdminDashboard.jsp");
	     }
	     else {
				response.sendRedirect("AddNewBeneficiary.jsp");
				session.setAttribute("invalid_details_of_account", "invalid_details_of_account");
			}
	    
	}

}
