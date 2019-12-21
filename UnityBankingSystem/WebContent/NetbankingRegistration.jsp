<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply For New Account</title>

<!--bootstrap cdn-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!--Font Awesome-->
<script src="https://kit.fontawesome.com/e12d480ba5.js" crossorigin="anonymous"></script>

<!--slider-->
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>



<link rel="stylesheet" type="text/css" href="StyleForHeadFoot.css">
<title>Create Account</title>
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
                    <a href="Login.jsp"class="px-2">Sign In</a>
                    <a href="Registration.jsp"class="px-1">Sign Up</a>

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
                  <a class="nav-link" href="Cart1.jsp"></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="Bill1.jsp"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp"></a>
                  </li>
              </ul>
            </div>

            
          </nav>
          <hr>
    </div>
</header>

<form action="NetBankingRegistrationController" method="post">
	<div class="container">
	<h1>Apply For NetBanking Account</h1>
    <p>Please Fill in The Required Fields to create an Unity Net-banking Online Account.</p>
    <hr>
	
	<label for="account_number"><b>Account Number</b></label>
    <input type="text" name="account_number" placeholder="Enter Account Number Received by Mail*" onkeypress="isInputNumber(event)" maxlength="12" required><br>
    
	
	<b>E-mail:</b> <input type="email" name="email_netbanking_registration" placeholder="Enter Your Email*" required><br>
	<br>   
    <script >
    	function isInputNumber(evt) {
			var ch = String.fromCharCode(evt.which);
			if(!(/[0-9]/.test(ch))){
				evt.preventDefault();
			}
		}
    </script>
    
    <%if(!session.isNew()){
    	session.getAttribute("account_not_exist");
        session.getAttribute("invalid_email");
     %>
     <h6>${account_not_exist}</h6>
     <h6>${invalid_email}</h6>
        <%}%>
     <hr>
    <input type="submit" value="Send OTP" class="submitbt" > 
	<hr>
    </div>
	
	</form>
	
</body> 
</html>