

<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<script>
function validateForm(){
	var name = document.forms["myForm"]["userName"].value;
	var email = document.forms["myForm"]["userPassword"].value;
	

	if (name.length<1) {
        document.getElementById('error-name').innerHTML = " Please Enter Your  User Name *"
    }
    if (email.length<1) {
        document.getElementById('error-email').innerHTML = " Please Enter Your Password *";
    }
    
    if(name.length<1 || email.length<1){
       	return false;
    }            
}
</script>

 <center style="top: 50%; left: 50%; margin-top:200px; margin-left: -200px;font-size:30px; ">
<form name="myForm" method="post" action="login" onsubmit="return validateForm()">
	<div class="form-group">
	
		<input type="text"  style="height:30px;font-size:14pt;" name="userName" class="form-control" placeholder="Enter User Name"><span id="error-name"></span>
	</div>
	<br>
	<div class="form-group"> 
		
		<input type="password" name="userPassword" style="height:30px;font-size:14pt;" class="form-control" placeholder="Enter your Password"> <span id="error-email"></span>
	</div>
<br>
	<div class="form-group">
		<input type="submit" style="height:30px;font-size:14pt;" value="Login">
	</div>
</form>

<c:if test="${not empty error}">
    ${error}
</c:if>


</center>
</html>