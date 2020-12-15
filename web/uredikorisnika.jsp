<%-- 
    Document   : uredikorisnika
    Created on : Nov 22, 2020, 9:08:22 PM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" flush="ture"  />
    
    
    <div class="container">

    <div>
					<div class="alert-success" id="Message">${message}</div>
     <div class="alert-danger" id="Message">${error}</div>
					</div>

		<div class="row">
			<div class="col-md-6 col-md-offset-3">

			
				<h1>Uredi korisnika</h1>

				<form action="AdminController?action=edit&id=${param["id"]}" method="post" id="registerForm">
					<div class="form-group">
						<label class="control-label" for="firstName"> First Name </label>
                                                <input id="firstName" class="form-control"  name="firstName" value="${param["fn"]}"
							required autofocus="autofocus" />
					</div>
                                    
                                    <div class="form-group">
						<label class="control-label" for="lastName"> Last Name </label>
						<input id="lastName" class="form-control"  name="lastName" value="${param["ln"]}"
							required autofocus="autofocus" />
					</div>


					<div class="form-group">
						<label class="control-label" for="email"> Email </label>
                                                <input type="email"	id="email" class="form-control" name="email" value="${param["email"]}"  required
							autofocus="autofocus" />
					</div>

					
                               

					<div class="form-group">
						<button type="submit" id="submitRegister" name="register" class="btn btn-success">Uredi korisnika</button>
						
					</div>
				</form>
			</div>
		</div>
	</div>
  
    
    </body>
</html>
