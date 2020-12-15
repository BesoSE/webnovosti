<%-- 
    Document   : prikaziNovost
    Created on : Nov 23, 2020, 10:00:52 PM
    Author     : korisnik
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" flush="ture"  />
    
    

    <div class="container">
    <div class="alert-success" id="Message">${message}</div>
     <div class="alert-danger" id="Message">${error}</div>
        
       
        <h5>${News.getTitle()}</h5><br>
          <p>${News.getText()}</p><br>
          <h6>Datum: ${News.getDate()}</h6>
          <h6>Autor: ${U.getFirstName()} ${U.getLastName()}</h6>
          <c:if test="${User.getRole()=='ROLE_EDITOR'}">
           <a class="btn btn-sm btn-danger" type="button" href="NovostiController?action=uredinovostP&id=${News.getId()}">Uredi novost</a>
               <a class="btn btn-sm btn-danger" type="button" href="NovostiController?action=obrisi&id=${News.getId()}">Obrisi novost</a>
        </c:if>
               <br><br>
               <h5>Komentari</h5>
              <c:forEach  var="c" items="${Comments}">
                 <c:forEach  var="k" items="${Korisnici}"> 
                    <c:if test="${k.getId()==c.getIduser()}">

                        <h6>  ${k.getFirstName()} ${k.getLastName()}</h6>
                    </c:if>
                         </c:forEach>
                        <p>  ${c.getComment()}   
                            <c:if test="${User!=null}">
                                <c:if test="${User.getId()==c.getIduser()}">
                                   
                        <a class="btn btn-sm btn-primary float-right" type="button" href="urediKomentar.jsp?id=${c.getId()}&idn=${News.getId()}&kom=${c.getComment()}">Uredi komentar</a>
                        <a class="btn btn-sm btn-danger float-right" type="button" href="KomentarController?action=obrisiKomentar&id=${c.getId()}&idn=${News.getId()}">Obrisi komentar</a>
                   </c:if>  </c:if>
                        
                        
                         <c:if test="${User.getRole()=='ROLE_EDITOR'}">
                              <c:if test="${User.getId()!=c.getIduser()}">
                          <a class="btn btn-sm btn-danger float-right" type="button" href="KomentarController?action=obrisiKomentar&id=${c.getId()}&idn=${News.getId()}">Obrisi komentar</a>
                        </c:if>
                           </c:if>
                            </p>
                        <hr>
                   
               </c:forEach>
               
          
                        <c:if test="${User!=null}">
                       
		<div class = "row">
			<div class = "col-md-6 col-md-offset-3">
				
				
				<form action="KomentarController?action=dodaj&idu=${User.getId()}&idn=${News.getId()}" id="comment" method="post">
					
				<div class = "form-group">
						
                                    <textarea type="text" class = "form-control"  name = "komentar" 
					
						placeholder="Komentar..." required autofocus="autofocus" /></textarea>
					</div>
    
				
					
					
                   
					
					<div class="form-group">
						<div class="row">
							<div class="col-sm-6 col-sm-offset-3">
								<input type="submit" name="commentsubmit" id="submitComment"
									class="form-control btn btn-primary" value="Comment" />
							</div>
						</div>
					</div>
				</form>
				
			</div>
		</div>

                        </c:if>
 </div> 
    </body>
</html>
