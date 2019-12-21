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
                  <a class="nav-link" href="AllApplications.jsp">Display All Applications</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="Bill1.jsp"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp"></a>
                  </li>
              </ul>
            </div>

            <!-- div class="navbar-nav">
                <li class="nav-item border rounded-circle mx-2 search-icon">
                    <i class="fas fa-search"></i>
                </li>

                <li class="nav-item border rounded-circle mx-2 basket-icon">
                    <i class="fas fa-cart-plus"></i>
                </li>
            </div> -->

          </nav>
    </div>
</header>
<main>


<%
	
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//http 1.1

	response.setHeader("Pragma","no-cache");//http 1.1
	
	response.setHeader("Expires","0");//proxies

//if(session.getAttribute("username")==null) 
//{
//	response.sendRedirect("LogInAdmin.jsp");
//}
%>
<h1><center> Welcome Admin11 @${username} </center></h1>
</main>
<form action="DispAllApplications" >
<input type="submit" value="Show All" class="submitbt" >
</form>
<%!List<Application> lst; %>
<%
    
    if(!session.isNew()){
    lst=(List<Application>)session.getAttribute("data");
    session.invalidate();
 %>
    <table border="1" align="center">
  <tr>
    <th><h1>Customer ID</h1></th>
    <th><h1>BRANCH_NAME</h1></th>
    <th><h1>ACCOUNT_TYPE</h1></th>
    <th><h1>SURNAME</h1></th>
    <th><h1>FIRSTNAME</h1></th>
    <th><h1>MIDDLENAME</h1></th>
    <th><h1>DATEOFBIRTH</h1></th>
    <th><h1>EMAIL</h1></th>
    <th><h1>MOBILE_NO</h1></th>
    <th><h1>NATIONALITY</h1></th>
    <th><h1>OCCUPATION</h1></th>
    <th><h1>CITY</h1></th>
    <th><h1>STATE</h1></th>
    <th><h1>DISTRICT</h1></th>
    <th><h1>PINCODE</h1></th>
    <th><h1>AADHAR_NO</h1></th>
    <th><h1>PAN_NO</h1></th>
  </tr>
 <% for(Application a:lst ){ %>
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
</body>
</html>