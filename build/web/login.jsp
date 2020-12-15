<%-- 
    Document   : login
    Created on : Nov 21, 2020, 1:49:08 PM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" flush="ture"  />
    
   <div class = "container">
		<div class = "row">
			<div class = "col-md-6 col-md-offset-3">
				
				<h1>  Login  </h1>
				<form action="LoginController" id="loginForm" method="post">
					
				
    
    	<!--  message  -->
        <div >
				<div class="alert-success" id="Message">${message}</div>
     <div class="alert-danger" id="Message">${error}</div>
				</div>

				
					
					<div class = "form-group">
						<label for ="email"> Email </label> 
						<input type="email" class = "form-control" id ="email" name = "email" 
					
						placeholder="Email" required autofocus="autofocus" />
					</div>
					
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							id="password" name="password" class="form-control"
							
							placeholder="Password" required autofocus="autofocus" />
					</div>
                   
					
					<div class="form-group">
						<div class="row">
							<div class="col-sm-6 col-sm-offset-3">
								<input type="submit" name="loginsubmit" id="submitLogin"
									class="form-control btn btn-primary" value="Login" />
							</div>
						</div>
					</div>
				</form>
				<div class="form-group">
						<span>New user? <a href="register.jsp" >Register
								here</a></span>
				</div>
			</div>
		</div>
	</div>
    </body>
</html>
