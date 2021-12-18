<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="home.jsp" />    <br/><br/>  
</head>
<body>

 <center>
 
    <form action="searchEmp" method="post">  
    
   Select Option <select id="country" name="option">
   <option value="All">All</option>
   <option value="name">BY NAME</option>
   <option value="email">BY EMAIL</option>
   <option value="phone"> BY TELIPHONE</option>
   <option value="address"> BY ADDRESS</option>
   <option value="course"> BY COURSE</option>
</select> 
    UserName:<input type="text" name="name"/>
    
    <br/><br/>  
    <input type="submit" value="submit"/>  
    </form>  

      
      
     <br>
     <h3>List of Employees</h3>
    	<table border="1">

			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Course</th>
         
         <c:forEach var="employee" items="${listEmployee}">
         		
				<tr>

					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td>${employee.address}</td>
					<td>${employee.telephone}</td>
					<td>${employee.course}</td>
				</tr>
			</c:forEach>
         
        
    </table>
    
    </center>

	
  </body>
</html>