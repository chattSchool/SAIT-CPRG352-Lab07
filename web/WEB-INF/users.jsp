<%-- 
    Document   : users
    Created on : 25-Jun-2022, 4:41:23 PM
    Author     : Dakota Chatt
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        
        <c:forEach var="user" items="${users}">
            <p>${user.email}, ${user.first_name}, ${user.last_name}, ${user.active}</p>
        </c:forEach>
            
        <c:if test="${message != null}">
            <p>${message}</p>
        </c:if>
    </body>
</html>
