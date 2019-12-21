package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BankDao;
import com.mail.EmailUtility;
import com.mail.OtpGenerator;
import com.model.Otp;

@WebServlet("/NetBankingRegistrationController")
public class NetBankingRegistrationController extends HttpServlet {
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
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String s0=request.getParameter("account_number");
	
	HttpSession session=request.getSession();
	String recipient = request.getParameter("email_netbanking_registration");		
	
	
	
	//get cust id 
	BankDao bd =new BankDao();
	String cust_id=bd.getCustIDFromAccount(s0);
	System.out.println(cust_id);
	
	//get email from cust_id
	//check account is associated with the eamil or nor
	
	String verifyEmail=bd.searchEmailType(cust_id);
	verifyEmail=verifyEmail.trim();
	recipient=recipient.trim();
	
	if(!verifyEmail.equals(recipient)) {
		session.setAttribute("invalid_email", "Email is not associated with any account");
		response.sendRedirect(" NetbankingRegistration.jsp");
		return;
	}else
	{
		session.setAttribute("invalid_email", "");
	}
	if(cust_id.equals("account does not exist") )
	{
		session.setAttribute("account_not_exist", cust_id);
		response.sendRedirect(" NetbankingRegistration.jsp");
		return;
	}
	
	
	//check account is associated with the eamil or nor
	//dispay account is not associated with email
	OtpGenerator otp=new OtpGenerator();
	char[] otp1=otp.generate_otp(5);
	String otpstr=String.copyValueOf(otp1);
	
	try {
	    EmailUtility.sendEmail(host, port, user, pass, recipient, "FROM BANK OF UNITY ",
	    		"Dear Customrt of UNITY BANK YOUR VERIFICATION OTP IS For Creating NetBanking Account:-"+otpstr);
	   
	} catch (Exception ex) {
	    ex.printStackTrace();
	    
	} finally {
		
		
		
		//VerifyOtpStep2Controler verstep2=new VerifyOtpStep2Controler();
		//String c= verstep2.verifyOTP(lst);
		
	    session.setAttribute("mail_netbanking", recipient);
	    session.setAttribute("otp_netbanking", otpstr);
	    session.setAttribute("accfornetbanking", s0);
	    //session.setAttribute("account_number", );
	    response.sendRedirect("NetbankingregiStep2.jsp");
		}
	
	}

}
