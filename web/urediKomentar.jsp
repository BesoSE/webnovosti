<%-- 
    Document   : urediKomentar
    Created on : Nov 26, 2020, 8:30:58 PM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:include page="header.jsp" flush="ture"  />
    
    
    
       
        <div class="container">
            <div class="alert-success" id="Message">${message}</div>
     <div class="alert-danger" id="Message">${error}</div>
            
        <div class = "row">
			<div class = "col-md-6 col-md-offset-3">
				
				
				<form action=" KomentarController?action=urediKomentar&id=${param["id"]}&idn=${param["idn"]}" id="comment" method="post">
					
				<div class = "form-group">
						
                                    <textarea type="text" class = "form-control"  name = "komentar" 
					
						placeholder="Komentar..." required autofocus="autofocus" />${param["kom"]}</textarea>
					</div>
    
				
					
					
                   
					
					<div class="form-group">
						<div class="row">
							<div class="col-sm-6 col-sm-offset-3">
								<input type="submit" name="commentsubmit" id="submitComment"
									class="form-control btn btn-primary" value="Uredi Komentar" />
							</div>
						</div>
					</div>
				</form>
				
			</div>
		</div>

   
 </div> 
    </body>
</html>
