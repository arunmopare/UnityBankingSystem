package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mail.EmailUtility;
import com.mail.OtpGenerator;

import com.model.Otp;

/**
 * Servlet implementation class VerifyOtp
 */
@WebServlet("/VerifyOtp")
public class VerifyOtp extends HttpServlet {
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
	HttpSession session=request.getSession();
	String recipient = request.getParameter("email");
	OtpGenerator otp=new OtpGenerator();
	char[] otp1=otp.generate_otp(5);
	String otpstr=String.copyValueOf(otp1);
	
String resultMessage = "";
	
	

try {
    EmailUtility.sendEmail(host, port, user, pass, recipient, "FROM BANK OF UNITY ",
    		"Dear Customrt of UNITY BANK YOUR VERIFICATION OTP IS:-"+otpstr);
    resultMessage = "The OTP was sent successfully";
} catch (Exception ex) {
    ex.printStackTrace();
    resultMessage = "There were an error: " + ex.getMessage();
} finally {
	List<Otp> lst = new ArrayList<Otp>();
	Otp o=new Otp();
	o.setEmail(recipient); 	 	 	
	o.setotp(otpstr);
	
	lst.add(o);
	//VerifyOtpStep2Controler verstep2=new VerifyOtpStep2Controler();
	//String c= verstep2.verifyOTP(lst);
	
    session.setAttribute("mail", recipient);
    session.setAttribute("otp", otpstr);
    
    response.sendRedirect("VerifyOtpStep2.jsp");
	}
}
}

