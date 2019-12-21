<%@page import="java.util.List"%>
<%@page import="com.model.Otp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Unity Bank</title>
<link rel="stylesheet" type="text/css" href="StyleForHeadFoot.css">


<!--bootstrap cdn-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!--Font Awesome-->
<script src="https://kit.fontawesome.com/e12d480ba5.js" crossorigin="anonymous"></script>

<!--slider-->
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

<title>Verify OTP</title>
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-12 col-12">
               
            </div>
            <div class="col-md-4 col-12 text-center">
                <h2 class="my-md-3 site-title text-white ">Unity Bank</h2>
            </div>
            <div class="col-md4 col-12 text-right">
                <p class="my-md-4 header-links">
                    <a href="Login.jsp"class="px-2"></a>
                    <a href="Registration.jsp"class="px-1"></a>

                </p>
            </div>
            
        </div>
    </div>
    <div class="container-fluid P-0">
        <nav class="navbar navbar-expand-lg navbar-light bg-white ">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link" href="Index.jsp">HOME <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href=""></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href=""></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href=""></a>
                  </li>
              </ul>
            </div>

            

          </nav>
          <hr>
    </div>
</header>
	
 
 <%
    
    //if(!session.getAttribute("mail")==null) {
    session.getAttribute("mail");
    session.getAttribute("otp");
 %>
<form action="VerifyOtpStep2Controler" method="post">
<div class="container">
	<h1>Verify Your E-Mail Address To Continue</h1>
    <p>Please Enter a valid Mail-id</p>
    <hr>
   	<label for="email"><b>Email</b></label>
		<input type="email" name="email" placeholder="Please Enter Valid Email" value=" ${mail}" required><br>
	
	<label for="otp"><b>OTP</b></label>
	<input type="text" name="otpstep2" placeholder="Please Enter Five Digit OTP*" maxlength="5"required><br>
	 <INPUT TYPE="HIDDEN" NAME="otpforward" value=" ${otp}" >
    <hr>
    <div><center><input type="submit" value="VERIFY OTP" class="submitbt" ></center></div>
   	 
</div>

</form>

</body>
</html>