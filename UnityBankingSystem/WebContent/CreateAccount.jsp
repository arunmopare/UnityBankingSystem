<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page errorPage="error.jsp" %>
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

<form action="AccountRegistrationController" method="post">
	<div class="container">
	<h1>Create Account</h1>
    <p>Please Fill in The Required Fields to create an Unity Bank Account.</p>
    <hr>
	<b>Select Account Type:-</b>	
	<select name="account_type" class="forsel">
    <option value="Saving">Saving</option>
    <option value="Current">Current</option>
    <option value="Salary">Salary</option>
    
  </select>
	<br>
	<br>
	<b>Select Branch:-</b>	
	<select name="branch_name" class="forsel">
    <option value="PUNE01">PUNE01</option>
    <option value="PUNE02">PUNE02</option>
    <option value="PUNE03">PUNE03</option>
    <option value="PUNE04">PUNE04</option>
  </select>
	<br>
	<br>
	<br>
	<label for="last_name"><b>Last Name</b></label>
    <input type="text" name="last_name" placeholder="Enter Your Last Name*" maxlength="10" required>
    
	<label for="first_name"><b>First Name</b></label>
	<input type="text" name="first_name" placeholder="Enter Your First Name*" maxlength="10" required><br>
	
	<label for="middle_name"><b>Middle Name</b></label>
	<input type="text" name="middle_name" placeholder="Enter Your Middle Name*" maxlength="10" required><br>
	
	<b>DOB</b>: <input type="date" name="birth_date"> <br>
	<br>
	<b>E-mail:</b> <input type="email" name="email_address" placeholder="Enter Your Email*" maxlength="50" required><br>
	<br>
	<label for="mobile_number"><b>Mobile Number</b></label>
    <input type="text" name="mobile_number" placeholder="Enter Your Mobile Number*" onkeypress="isInputNumber(event)" maxlength="10" required><br>
    <script >
    	function isInputNumber(evt) {
			var ch = String.fromCharCode(evt.which);
			if(!(/[0-9]/.test(ch))){
				evt.preventDefault();
			}
		}
    </script>
    <label for="nationality"><b>Nationality</b></label>
    <input type="text" name="nationality" placeholder="Enter Your nationality*"  required><br>
    
    <label for="occupation"><b>Occupation</b></label>
    <input type="text" name="occupation" placeholder="Enter Your Occupation*" required><br>
    
    <b>Enter Your Address</b> 
    <br>
    
    <label for="city"><b>City</b></label>
    <input type="text" name="city" placeholder="Enter Your City*" required><br>
    
    <label for="state"><b>State</b></label>
    <input type="text" name="state" placeholder="Enter Your State*" maxlength="15" required><br>
    
    <label for="district"><b>District</b></label>
    <input type="text" name="district" placeholder="Enter Your District*" required><br>
    
    <label for="pincode"><b>PIN CODE</b></label>
    <input type="text" name="pin_code" placeholder="Enter Your PIN CODE*" onkeypress="isInputNumber(event)" maxlength="6" required><br>
    
    <label for="aadhar"><b>AADHAR</b></label>
    <input type="text" name="aadhar_number" placeholder="Enter Your AADHAR NUMBER*" onkeypress="isInputNumber(event)" maxlength="12" required><br>
    
    <label for=0"pan"><b>PAN</b></label>
    <input type="text" name="pan_number" placeholder="Enter Your PAN NUMBER*" maxlength="10" required><br>

    <hr>
        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
     <hr>
    <input type="submit" value="submit" class="submitbt" > 

    </div>
	
	</form>
</body> 
</html>