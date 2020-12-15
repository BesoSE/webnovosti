<%-- 
    Document   : index
    Created on : Nov 21, 2020, 1:29:37 PM
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
      <c:forEach var="v" items="${News}">
          <a href="NovostiController?action=pregled&id=${v.getId()}">   
          <h5>${v.getTitle()}</h5>
          <p>${v.getText()}</p>
          
         </a>
         <hr>
      </c:forEach>
         </div>
    </body>
</html>
