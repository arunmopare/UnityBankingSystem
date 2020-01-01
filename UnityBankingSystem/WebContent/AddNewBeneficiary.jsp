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

<title>Customer Dashboard</title>
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
                  <a class="nav-link" href="bnfcreated.jsp">ADD  BENEFICIARY</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="AccountDetails.jsp">SHOW ACCOUNT DETAILS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="transfer_money.jsp">PAYMENT TRANSFER</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="tranHistory.jsp">Transaction History</a>
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
<main>


<%
	
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//http 1.1

	response.setHeader("Pragma","no-cache");//http 1.1
	
	response.setHeader("Expires","0");//proxies

if(session.getAttribute("net_banking_username")==null) 
{
	response.sendRedirect("NetBankingLogin.jsp");
}
%>
<h1><center> Add New Intra Bank Beneficiary </center></h1>
<br>
<br>
<hr>
<div class="container">
	
		<form action="AddNewBeneficiaryController" method="post">
		
		 <%if(!session.isNew()){
    	session.getAttribute("invalid_details_of_account");
        
     %>
     <h4>****${invalid_details_of_account}****</h4>
     
        <%}%>
		
		<label for="Name"><b>Name</b></label>
    <input type="text" name="benfi_name" placeholder="Enter Name*" required><br>
   	
   	<label for="account_number"><b>Account Number</b></label>
    <input type="text" name="account_number" placeholder="Enter Account Number *" onkeypress="isInputNumber(event)" maxlength="12"   required><br>
    
    <INPUT TYPE="HIDDEN" NAME="curr_account" value="${currrent_accno}" >
    <label for="account_number"><b>Account Number</b></label>
    <input type="text" name="account_number2" placeholder="Retype Account Number*" onkeypress="isInputNumber(event)" maxlength="12"   required><br>
    
    <label for="ifsc_benf"><b>Enter IFSC code of Beneficiary</b></label>
    <input type="text" name="ifsc_benf" placeholder="Enter IFSC code of Beneficiary*"  maxlength="11"   required><br>
    
    <script >
    	function isInputNumber(evt) {
			var ch = String.fromCharCode(evt.which);
			if(!(/[0-9]/.test(ch))){
				evt.preventDefault();
			}
		}
    </script>
     <label for="amount_limit"><b>Transfer Limit*(INR)(Max-1000000)</b></label>
    <input type="text" name="amount_limit" placeholder="Type Transfer Limit*" onkeypress="isInputNumber(event)" maxlength="7"   required><br>
     	
    <input type="submit" value="submit" class="submitbt" > 
		</form>
		
	
	
	
</div>


</main>

<form></form>


</body>
</html>