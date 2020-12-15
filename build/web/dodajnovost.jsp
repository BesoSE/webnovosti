<%-- 
    Document   : dodajnovost
    Created on : Nov 23, 2020, 2:26:30 PM
    Author     : korisnik
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" flush="ture"  />
    
    
   <div class = "container">
		<div class = "row">
			<div class = "col-md-6 col-md-offset-3">
				
				<h1>  Dodaj novost  </h1>
				<form action="NovostiController?action=dodajnovost&id=${param["id"]}" id="dodajNovost" method="post">
					
				
    
    	<!--  message  -->
        <div >
					<div class="alert-success" id="Message">${message}</div>
     <div class="alert-danger" id="Message">${error}</div>
				</div>

				
					
					<div class = "form-group">
						<label for ="naslov"> Naslov </label> 
						<input type="text" class = "form-control" id ="naslov" name = "naslov" 
					
						placeholder="Naslov" required autofocus="autofocus" />
					</div>
					
					<div class="form-group">
						<label for="tekst">Tekst</label> 
                                                <textarea name="tekst" class="form-control" id="tekst" required autofocus="autofocus" /></textarea>
                                                
					</div>
                   
					
					<div class="form-group">
						<div class="row">
							<div class="col-sm-6 col-sm-offset-3">
								<input type="submit" name="submit" id="submit"
									class="form-control btn btn-primary" value="Dodaj novost" />
							</div>
						</div>
					</div>
				</form>
				
			</div>
		</div>
	</div>
    </body>
</html>

