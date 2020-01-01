<%@page import="com.model.Transaction"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page errorPage="error.jsp" %>
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
<h1><center>Under Development</center></h1>
<h4><center> Welcome  @${net_banking_username} </center></h4>
<br>
<br>
<hr>

</main>
<div class="container">

<%!List<Transaction>lst; %>
<%  if((!session.isNew())&& !(session.getAttribute("Listhistory")==null)) {
    	 lst=(List<Transaction>)session.getAttribute("Listhistory");
    	 System.out.println(lst);
   
 %>
    <table border="1" align="center">
  <tr>
    <th>Transaction History ID</th>
    <th>From Account Number</th>
    <th>to Account Number</th>
    <th>Transaction Type</th>
    <th>Transaction Date</th>
    <th>Transaction Status</th>
  </tr>
 <% for(Transaction tra:lst)
 {
 %>
<tr>
<td><%=tra.getTransation_id()%></td>
<td><%=tra.getFrom_account() %></td>
<td><%=tra.getTo_account()%></td>
<td><%=tra.getTransactionType()%></td>
<td><%=tra.getTransactionDate() %></td>
<td><%=tra.getTranactionStatus() %></td>
</tr>

<%}%>
</table>
<%}%> 

<form action="TransactionHistory" method="post">
<INPUT TYPE="HIDDEN" NAME="curr_account" value="${currrent_accno}" >
<input type="submit" value="Show all History" class="submitbt">
</form>
<br><br><hr>
</div>

</body>
</html>