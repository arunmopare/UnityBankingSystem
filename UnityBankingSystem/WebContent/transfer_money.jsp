<%@page import="com.model.Beneficiary"%>
<%@page import="java.util.List"%>
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
                  <a class="nav-link" href="bnfcreated.jsp">ADD BENEFICIARY</a>
                </li>
                <li class="nav-item">
                   <a class="nav-link" href="AccountDetails.jsp">SHOW ACCOUNT DETAILS</a>
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
<br>
<br>
<hr>
<div class="container">
<!-- bnfdata -->
<h3><center>List Of Beneficiary's</center></h3>
<hr>
<br>
<br>
<%! List<Beneficiary>lst; %>
<%
    
    if((!session.isNew())&& !(session.getAttribute("bnfdata")==null)) {
    lst=(List<Beneficiary>)session.getAttribute("bnfdata");
   // session.invalidate();
 %>
    <table border="1" align="center">
  <tr>
    <th>Beneficiary ID</th>
    <th>Beneficiary Name</th>
    <th>From Account Number</th>
    <th>Beneficiary Account Number</th>
    <th>Beneficiary IFSC code</th>
    <th>Beneficiary Amount Limit</th>
  </tr>
 <% for(Beneficiary b:lst)
 {
 %>
<tr>
<td><%=b.getB_id() %></td>
<td><%=b.getB_name() %></td>
<td><%=b.getFrom_account()%></td>
<td><%=b.getTo_account()%></td>
<td><%=b.getTo_ifsc() %></td>
<td><%=b.getB_limit() %></td>
</tr>

<%}%>
</table>
<%}%> 
<br><br><hr>

	<center>
		<form action="ShowAllBnfTransferCon" method="post">
	
	<INPUT TYPE="HIDDEN" NAME="curr_account" value="${currrent_accno}" >
	<input type="submit" value="Show all Beneficieries" class="submitbt">
		</form>
		</center>
	<h4>${Insufficient_Balance}</h4>
	<h4>${Transaction_limit_Exceeded}</h4>
	<form action="TransferMoney" method="post">
	<INPUT TYPE="HIDDEN" NAME="curr_account" value="${currrent_accno}" >
	<label for="BeneficiaryNumber"><b>Beneficiary No.</b></label>
    <input type="text" name="bnf_number_transfer" placeholder="Enter Beneficiary Number*" onkeypress="isInputNumber(event)" maxlength="10" required><br>
    <script >
    	function isInputNumber(evt) {
			var ch = String.fromCharCode(evt.which);
			if(!(/[0-9]/.test(ch))){
				evt.preventDefault();
			}
		}
    </script>
    <br>
    <hr>
    
    <b>Select Type Of Transaction:-</b>	
	<select name="transaction_type" class="forsel">
    <option value="QUICKTRANSFER">QUICKTRANSFER</option>
    <option value="NEFT">NEFT</option>
    <option value="IMPS">IMPS</option>
    
  </select>
  <br>
  <br>
  <hr>
  <label for="tr_amount"><b>Amount to be Transferred *(INR)</b></label>
    <input type="text" name="tr_amount" placeholder="Amount to be Transferred *(INR)" onkeypress="isInputNumber(event)" maxlength="7"   required><br>
     

	<input type="submit" value="Transfer Money" class="submitbt">
		</form>	
	
	
	
</div>


</main>




</body>
</html>