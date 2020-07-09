<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
.center {
 text-align: center
}
</style>


<style>

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

<style >

	.error{color:red}

</style>

<style >

@import url("https://fonts.googleapis.com/css?family=Open+Sans");

/* Styles */
* {
  margin: 0;
  padding: 0;
}

body {
  font-family: "Open Sans";
  font-size: 14px;
}

.container {
  width: 500px;
  margin: 25px auto;
}

form {
  padding: 20px;
  background: #2c3e50;
  color: #fff;
  -moz-border-radius: 4px;
  -webkit-border-radius: 4px;
  border-radius: 4px;
}
form label,
form input,
form button {
  border: 0;
  margin-bottom: 3px;
  display: block;
  width: 100%;
}
form input {
  height: 25px;
  line-height: 25px;
  background: #fff;
  color: #000;
  padding: 0 6px;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
form button {
  height: 30px;
  line-height: 30px;
  background: #e67e22;
  color: #fff;
  margin-top: 10px;
  cursor: pointer;
}
form .error {
  color: #ff0000;
}


</style>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>


<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
<body>
<h2>PhoneBook Application</h2>


<hr/>
<h2 class="center">All Contact</h2>
<a href="contactForm">+Add Contact</a>
<form action="viewContactDetails" method="get" >

<input id="myInput" type="text" placeholder="Search..">
<br><br>
<table  >
		<thead>
				<tr>
					<th> S. no</th>
					
					<th>Name</th>
				
					<th>Email</th>
				<th>Contact Number</th>
				<th>Action</th>
				
		</thead>
	
	<tbody  id="myTable">
			<c:forEach items="${co}" var ="b"  varStatus="index">
			
			<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/editContact">
						<c:param name="customerId" value="${b.id}" />
					</c:url>
			
			<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/delete">
						<c:param name="customerId" value="${b.id}" />
					</c:url>
			
			<tr>
				<td>${index.count}</td>
				<td>${b.contactName}</td>
				<td>${b.contactEmail}</td>
				<td>${b.contactPhone}</td>	
				<td>
				
				<a href="${updateLink}">Edit</a>|<a href="${deleteLink}"
				onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"
				 >delete</a>
				
				</td>
			
			</tr>
			
			
			</c:forEach>
	
	
	</tbody>
	
	
	
	</table>
		
	</form>
	



</body>
</html>