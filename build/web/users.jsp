<%-- 
    Document   : users
    Created on : Nov 22, 2020, 1:39:32 PM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% int i=1;
  
%>

<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" flush="ture"  />
    <div class="container">
    <div class="alert-success" id="Message">${message}</div>
     <div class="alert-danger" id="Message">${error}</div>
    <a class="btn btn-sm btn-primary" type="button" href="dodajkorisnika.jsp">Dodaj korisnika</a><br>
    </div>
      <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Ime</th>
      <th scope="col">Prezime</th>
      <th scope="col">Email</th>
      <th scope="col">Uloga</th>
      <th scope="col">Status</th>
      <th scope="col">Promjena podataka</th>
    </tr>
  </thead>
    <c:forEach var="v" items="${Users}">
        
  <tbody>
    <tr>
      <th scope="row"><%=i %> </th>
      <td>${v.getFirstName()}</td>
      <td>${v.getLastName()}</td>
      <td>${v.getEmail()}</td>
      
      <td>
          <c:if test="${v.getRole()=='ROLE_EDITOR'}">
                        
          <h6>Editor</h6>
          <a class="btn btn-sm btn-danger" type="button" href="AdminController?action=uklonieditora&id=${v.getId()}">Ukloni editora</a>
          </c:if>
           <c:if test="${v.getRole()=='ROLE_USER'}">
          <h6>Korisnik</h6>
          <a class="btn btn-sm btn-danger" type="button" href="AdminController?action=dodajeditora&id=${v.getId()}">Dodaj editora</a>
          </c:if>
          
           <c:if test="${v.getRole()=='ROLE_ADMIN'}">
          <h6>ADMIN</h6>
         
          </c:if>
  
      </td>
     
      
      
      <td><c:if test="${v.isStatus()==true}">
          <h6>Aktivan</h6>
          <a class="btn btn-sm btn-danger" type="button" href="AdminController?action=status&status=${v.isStatus()}&id=${v.getId()}">Neaktivan</a>
          </c:if>
          <c:if test="${v.isStatus()==false}">
              
          <h6>Neaktivan</h6>
          <a class="btn btn-sm btn-success" type="button" href="AdminController?action=status&status=${v.isStatus()}&id=${v.getId()}">Aktivan</a>
          </c:if>
    </td>
      <td><a class="btn btn-sm btn-danger" type="button" href="uredikorisnika.jsp?fn=${v.getFirstName()}&ln=${v.getLastName()}&email=${v.getEmail()}&id=${v.getId()}">Uredi</a>
          <a class="btn btn-sm btn-danger" type="button" href="promijenisifru.jsp?email=${v.getEmail()}&id=${v.getId()}">Promijeni Sifru</a></td>
    </tr>
 
  <%  i=i+1; %>
</c:forEach>

      </tbody>
</table>
    </body>
</html>
