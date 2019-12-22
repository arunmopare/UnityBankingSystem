package com.controller;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.model.Transaction;

import oracle.sql.DATE;
//import com.sun.org.apache.bcel.internal.generic.LSTORE;

//	import jdk.vm.ci.meta.Local;

@WebServlet("/TransferMoney")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String curr_account= request.getParameter("curr_account");
		String bnf_number_transfer= request.getParameter("bnf_number_transfer");
		String transaction_type= request.getParameter("transaction_type");
		String tr_amount= request.getParameter("tr_amount");
		
		curr_account= curr_account.trim();
		bnf_number_transfer =bnf_number_transfer.trim();
		transaction_type =transaction_type.trim();
		tr_amount =tr_amount.trim();
		int transAmount=Integer.parseInt(tr_amount);
		
		//validation of nft rtgs 
		BankDao bd = new BankDao();
		
		String bnf_accountno=bd.bnf_accountno(bnf_number_transfer);
		String bnf_currbal=bd.getAccBal(bnf_accountno);
		String curr_bal=bd.getAccBal(curr_account);
		
		int bennAccountInt=Integer.parseInt(bnf_currbal);
		int curr_accountbal=Integer.parseInt(curr_bal);
		HttpSession session =request.getSession(true); 
		if(curr_accountbal<transAmount) {
			session.setAttribute("Insufficient_Balance","****Insufficient_Balance*****");
			response.sendRedirect("transfer_money.jsp");
			return;
		}else {
			session.setAttribute("Insufficient_Balance","");
		}
		
		////
		if(transaction_type.contentEquals("QUICKTRANSFER")&&transAmount>=50000) {
			session.setAttribute("Transaction_limit_Exceeded","****QUICKTRANSFER Transaction limit Exceeded *****");
			response.sendRedirect("transfer_money.jsp");
			return;
		}else {
			session.setAttribute("Transaction_limit_Exceeded","");
		}
		////////
		
		if(transaction_type.contentEquals("NEFT")&&transAmount>=100000) {
			session.setAttribute("Transaction_limit_Exceeded","****NEFT Transaction limit Exceeded*****");
			response.sendRedirect("transfer_money.jsp");
			return;
		}else {
			session.setAttribute("Transaction_limit_Exceeded","");
		}
		
		////
		if(transaction_type.contentEquals("IMPS")&&transAmount>=200000) {
			session.setAttribute("Transaction_limit_Exceeded","****IMPS Transaction limit Exceeded*****");
			response.sendRedirect("transfer_money.jsp");
			return;
		}else {
			session.setAttribute("Transaction_limit_Exceeded","");
		}
		
		
		
		
		//update the balance in account table
		
		curr_accountbal=curr_accountbal-transAmount;
		bennAccountInt=bennAccountInt+transAmount;
		
		int i11=bd.updatebaltransaction(curr_accountbal,curr_account);
		int i22=bd.updatebaltransaction(bennAccountInt,bnf_accountno);
		
		List<Transaction>ls11=new ArrayList<Transaction>();
		Transaction transaction= new Transaction();
		
		
		
		
		
		transaction.setFrom_account(curr_account);
		transaction.setTo_account(bnf_accountno);
		transaction.setTransactionType(transaction_type);
		
		transaction.setTranactionStatus("SUCCESSFULL");
		
		ls11.add(transaction);
		
		
		
		if(i11>0&&i22>0) {
			System.out.println("both bal Updated");
			int z=bd.insertIntoTransaction(ls11);
			if(z>0) {
				System.out.println("Tranaction Saved");
				response.sendRedirect("NetBankingDashboard.jsp");
				return;
			}
		}
		
		System.out.println(bnf_accountno);
		System.out.println(bnf_currbal);
		System.out.println(curr_bal);
		//String currentBalCurrent=
		//String currentBalBenef=
	
		//somehow update balance
		//somhow reduce curr acnt amount
		//somehow incr amount bnf account
		//somehow create transation
	
	}

}
