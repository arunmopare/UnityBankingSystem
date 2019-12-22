<%@page import="java.util.List"%>
<%@page import="com.model.Application"%>
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

<title>Admin Dashboard</title>
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-12 col-12">
                <div class ="btn-group">
                    <button class="btn border dropdown-toggle my-md-4 my-2 text-white"  data-toggle="dropdown-toggle" aria-haspopup="true"
                    aria-expanded="false" 
                    >INR</button>
                    <div class="dropdown-menu text-white">
                        <a href="#" class="dropdown-item">IND-INR</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-12 text-center">
                <h2 class="my-md-3 site-title text-white ">Unity Bank</h2>
            </div>
            <div class="col-md4 col-12 text-right">
                <p class="my-md-4 header-links">
                    <a href="Login.jsp"class="px-2"></a>

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
                  <a class="nav-link" href="DispAll.jsp">Display All Applications</a>
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
<main>


	<%
	
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//http 1.1

	response.setHeader("Pragma","no-cache");//http 1.1
	
	response.setHeader("Expires","0");//proxies

if(session.getAttribute("username")==null)  	
{	response.sendRedirect("LogInAdmin.jsp");
}
%>
<h1><center> Welcome Admin @${username} </center></h1>
</main>

<%! List<Application>lst; %>
<%
    
    if((!session.isNew())&& !(session.getAttribute("data")==null)) {
    lst=(List<Application>)session.getAttribute("data");
    session.invalidate();
 %>
    <table border="1" align="center">
  <tr>
    <th>CustID</th>
    <th>BRANCH_NAME</th>
    <th>ACCOUNT_TYPE</th>
    <th>SURNAME</th>
    <th>FIRSTNAME</th>
    <th>MIDDLENAME</th>
    <th>DateOfBirth</th>
    <th>EMAIL</th>
    <th>MOBILE_NO</th>
    <th>NATIONALITY</th>
    <th>OCCUPATION</th>
    <th>CITY</th>
    <th>STATE</th>
    <th>DISTRICT</th>
    <th>PINCODE</th>
    <th>AADHAR_NO</th>
    <th>PAN_NO</th>
  </tr>
 <% for(Application a:lst)
 {
 %>
<tr>
<td><%=a.getCust_id()%></td>
<td><%=a.getBranch_number() %></td>
<td><%=a.getAccount_type() %></td>
<td><%=a.getLast_name() %></td>
<td><%=a.getFirst_name() %></td>
<td><%=a.getMiddle_name() %></td>
<td><%=a.getBirth_date() %></td>
<td><%=a.getEmail_address() %></td>
<td><%=a.getMobile_number() %></td>
<td><%=a.getNationality() %></td>
<td><%=a.getOccupation() %></td>
<td><%=a.getCity() %></td>
<td><%=a.getState() %></td>
<td><%=a.getDistrict() %></td>
<td><%=a.getPin_code() %></td>
<td><%=a.getAadhar_number() %></td>
<td><%=a.getPan_number() %></td>
</tr>

<%}%>
</table>
<%}%> 
<form action="DispAllApplications" >
<div class="container">
<input type="submit" value="Show All " class="submitbt" >
</div>
</form>



<form action="VerifyAccountController" >
<script >
    	function isInputNumber(evt) {
			var ch = String.fromCharCode(evt.which);
			if(!(/[0-9]/.test(ch))){
				evt.preventDefault();
			}
		}
</script>
<div class="container">
<label for="CustId"><b>Enter Customer ID To be Verified</b></label>
    <input type="text" name="customer_id" placeholder="Enter Customer ID To be Verified*" onkeypress="isInputNumber(event)" maxlength="10" required><br>
    <input type="text" name="initial_balance" placeholder="Enter Initial Requested Balance in Rupees*" onkeypress="isInputNumber(event)" maxlength="10" required><br>
    
<input type="submit" value="Approve" class="submitbt" >
</div>
</form>
</body>
</html>