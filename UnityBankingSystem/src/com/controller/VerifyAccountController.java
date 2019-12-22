package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BankDao;
import com.mail.EmailUtility;
import com.model.AccountModel;
import com.model.Application;
import com.model.Branch;
import com.model.Otp;


@WebServlet("/VerifyAccountController")
public class VerifyAccountController extends HttpServlet {
	private String host;
    private String port;
    private String user;
    private String pass;
    

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_id = request.getParameter("customer_id");
		String initial_amount=request.getParameter("initial_balance");
		BankDao bd = new BankDao();
		PrintWriter pw = response.getWriter();
		int k=bd.updateApproval(cust_id);
		if(k>0) {
			System.out.println("approved");
		}
		//get account number
		
		
		
		String gotEmail=bd.searchEmailType(cust_id);
		System.out.println(gotEmail);
		//somehow get account type
		String account_type=bd.searchAccountType(cust_id);
		System.out.println(account_type);
		//will return account type
		String br_name1= bd.searchBranch(cust_id);
		System.out.println(br_name1);
		//will return the branch name details of the customers
		
		
		List<Branch> list_branches= bd.searchBranchDetails(br_name1);
		System.out.println(list_branches);
		
		
		
		Branch branch=list_branches.get(0);
		String branch_name=branch.getBranch_name();
		String branch_code=branch.getBranch_code();
		String ifsc_code=branch.getIfsc_code();
		String micr_code=branch.getMicr_code();
		
		
//		for(Branch branch:list_branches) {
//		 	 branch_name=branch.getBranch_name();
//			branch_code=branch.getBranch_code();
//			ifsc_code=branch.getIfsc_code();
//			micr_code=branch.getMicr_code();
//		}
		
		System.out.println("got ifsc "+branch_name);
		System.out.println("got ifsc "+branch_code);
		System.out.println("got ifsc "+ifsc_code);
		System.out.println("got ifsc "+micr_code);
		
//		
//		Branch branch=(Branch)list_branches;
//		System.out.println("got it using brnch object"+branch.getBranch_code());
		//it will give all details regarding to perticular branch
		
		 AccountModel account=new AccountModel();
		 //account.setAccount_no(account_no);
		 account.setAccount_balance(initial_amount);
		 account.setCust_id(cust_id);
		 account.setBranch_name(branch_name);
		 account.setBranch_code(branch_code);
		 account.setIfsc_code(ifsc_code);
		 account.setMicr_code(micr_code);
		 account.setAccount_type(account_type);
		 
		 List<AccountModel> accountList=new ArrayList<AccountModel>();
		 accountList.add(account);
		 
		 int i=bd.addVerifiedAccount(accountList);
		 if(i>0)
			{
			 	
			 try {
				 String accountnot= bd.accessAccount(cust_id);
				    EmailUtility.sendEmail(host, port, user, pass, gotEmail, "FROM BANK OF UNITY ",
				    		"Dear Customer of UNITY BANK YOUR Account no is:-"+accountnot
				    		+"\n"+ "Branch name is: "+branch_name
				    		+"\n"+ "branch code is: "+branch_code
				    		+"\n"+ "ifsc is :"+ifsc_code
				    		+"\n"+ "account type is :"+account_type
				    		+"\n"+ "mivsr code is :"+micr_code);
				    
				} catch (Exception ex) {
				    ex.printStackTrace();
//				    resultMessage = "There were an error: " + ex.getMessage();
				} finally {
//					List<Otp> lst = new ArrayList<Otp>();
//					Otp o=new Otp();
//					o.setEmail(recipient); 	 	 	
//					o.setotp(otpstr);
					
//					lst.add(o);
					//VerifyOtpStep2Controler verstep2=new VerifyOtpStep2Controler();
					//String c= verstep2.verifyOTP(lst);
					
//				    session.setAttribute("mail", recipient);
//				    session.setAttribute("otp", otpstr);
					System.out.println("Mail sent");
				    response.sendRedirect("AccountCreatedAndmailsent.jsp");
					}
			 
				System.out.println("account inserted");
			}
		 
		//crateAccount()
		//int 
		//get branch details by username,
		//sendmail()
		//createaacount(branh)
		//
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
