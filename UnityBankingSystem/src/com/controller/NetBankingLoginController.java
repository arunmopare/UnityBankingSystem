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
import com.model.AccountModel;
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
			//somehow get account number
			String account_no=bd.account_noFromUsername(net_username);
			//somehow send Account Details to nxt page
			List<AccountModel>list_account=bd.getAllAccountdetails(account_no);
			
			AccountModel accountModel=(AccountModel)list_account.get(0);
			
			String currrent_accno=accountModel.getAccount_no();
			String currrent_balance=accountModel.getAccount_balance();
			String currrent_cust_id=accountModel.getCust_id();
			String currrent_branchna=accountModel.getBranch_name();
			String currrent_brcode=accountModel.getBranch_code();
			String currrent_ifsc=accountModel.getIfsc_code();
			String currrent_micr=accountModel.getMicr_code();
			String currrent_accounttype=accountModel.getAccount_type();
					
			System.out.println(currrent_accounttype+"  :acctype");
			session.setAttribute("currrent_accno",currrent_accno);
			session.setAttribute("currrent_branchname",currrent_branchna);
			session.setAttribute("currrent_accounttype",currrent_accounttype);
			session.setAttribute("currrent_ifsc",currrent_ifsc);
			session.setAttribute("currrent_brcode",currrent_brcode);
			session.setAttribute("currrent_micr",currrent_micr);
			
			System.out.println(list_account);
			session.setAttribute("list_of_accounts",list_account);
			response.sendRedirect("NetBankingDashboard.jsp");			
		}
		else {
			response.sendRedirect("NetBankingLogin.jsp");
			
		}
	} 
     
     
	}


