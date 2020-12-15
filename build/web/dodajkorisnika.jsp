<%-- 
    Document   : dodajkorisnika
    Created on : Nov 22, 2020, 8:49:38 PM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" flush="ture"  />
    
    
    <div class="container">

  <div class="alert-success" id="Message">${message}</div>
     <div class="alert-danger" id="Message">${error}</div>

		<div class="row">
			<div class="col-md-6 col-md-offset-3">

			
				<h1>Dodaj korisnika</h1>

				<form action="RegistrationController?action=admin" method="post" id="registerForm">
					<div class="form-group">
						<label class="control-label" for="firstName"> First Name </label>
						<input id="firstName" class="form-control"  name="firstName"
							required autofocus="autofocus" />
					</div>
                                    
                                    <div class="form-group">
						<label class="control-label" for="lastName"> Last Name </label>
						<input id="lastName" class="form-control"  name="lastName"
							required autofocus="autofocus" />
					</div>


					<div class="form-group">
						<label class="control-label" for="email"> Email </label>
                                                <input type="email"	id="email" class="form-control" name="email"  required
							autofocus="autofocus" />
					</div>

					<div class="form-group">
						<label class="control-label" for="password"> Password </label> <input
							id="password" class="form-control" type="password" name="password"
						 required autofocus="autofocus" />
					</div>
                    <div class="form-group">
						<label class="control-label" for="repeatpassword">Repeat Password </label> <input
							id="repeatpassword" class="form-control" type="password" name="repeat"
						 required autofocus="autofocus" />
					</div>

					<div class="form-group">
						<button type="submit" id="submitRegister" name="register" class="btn btn-success">Dodaj korisnika</button>
						
					</div>
				</form>
			</div>
		</div>
	</div>
  
    
    </body>
</html>
