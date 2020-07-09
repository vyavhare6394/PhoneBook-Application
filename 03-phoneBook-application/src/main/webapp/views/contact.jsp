<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style >

	.error{color:red}

</style>
</head>
<body>
<h2>PhoneBook Application</h2>


<hr/>
<h3 ><font color="red">Contact Info</font></h3>
<font color="green" >${msg}</font>
<form:form action="contactSubmit" modelAttribute="contact" method="post">
 
<table>
		<tr>
			<tr>
					<form:hidden path="id"/>
					<td>Name :</td>
					<td><form:input  path="contactName"/></td>
					
			<tr>
			
					<td>Email ID :</td>
					<td><form:input  path="contactEmail"/>
					<form:errors path="contactEmail" cssClass="error" /></td>		
					
					<tr>
			
					<td>Phone Number :</td>
					<td><form:input  path="contactPhone"  /></td>
					
		
			
			</tr>
			
			</table>	
	<input type="reset" value=Reset>			
	<input type="submit" value=Submit>
	
	</form:form>
	
	<a href="viewContactDetails">View All Contact</a>


</body>
</html>