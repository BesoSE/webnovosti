<%-- 
    Document   : header
    Created on : Nov 21, 2020, 1:45:26 PM
    Author     : korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        
    </head>
    <body>
        <nav class="navbar navbar-light bg-dark">
  <form class="form-inline">
    <a class="btn btn-outline-success" type="button" href="NovostiController?action=prikazinovosti">Home</a>
   
  </form>
           
            <form  class="form-inline" method="post">
                 <c:if test="${User.getRole()=='ROLE_EDITOR'}">
                 <a class="btn btn-sm btn-outline-primary" type="button" href="dodajnovost.jsp?id=${User.getId()}">Dodaj novost</a>
                    </c:if>
                
                
                <c:if test="${User.getRole()=='ROLE_ADMIN'}">
                 <a class="btn btn-sm btn-outline-primary" type="button" href="UsersController">Korisnici</a>
                    </c:if>
                 <br>
                <c:if test="${User==null}">
                 <a class="btn btn-sm btn-outline-secondary" type="button" href="login.jsp">Login</a>
                </c:if>
                 <c:if test="${User!=null}">
     <a class="btn btn-sm btn-outline-secondary" type="button" href="LogoutController">Logout</a>
   </c:if>
  </form>
            
</nav>