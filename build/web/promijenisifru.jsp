<%-- 
    Document   : promjenisifru
    Created on : Nov 22, 2020, 10:12:58 PM
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

			
				<h1>Promijeni sifru</h1>
                                <h2>${param["email"]}</h2>
				<form action="AdminController?action=promijenisifru&id=${param["id"]}" method="post" id="registerForm">
			
					<div class="form-group">
						<label class="control-label" for="password">New Password </label> <input
							id="password" class="form-control" type="password" name="password"
						 required autofocus="autofocus" />
					</div>
                    <div class="form-group">
						<label class="control-label" for="repeatpassword">Repeat Password </label> <input
							id="repeatpassword" class="form-control" type="password" name="repeat"
						 required autofocus="autofocus" />
					</div>

					<div class="form-group">
						<button type="submit" id="submitRegister" name="register" class="btn btn-success">Promjeni sifru</button>
						
					</div>
				</form>
			</div>
		</div>
	</div>
  
    
    </body>
</html>
