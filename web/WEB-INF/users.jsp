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
        
        <form method="post" action="">
            <input type="hidden" name="action" value="add">
            <input type="text" name="new_email" value="" placeholder="Email Address" required />
            <br />
            <input type="text" name="new_fname" value="" placeholder="First Name" required />
            <br />
            <input type="text" name ="new_lname" value="" placeholder="Last Name" required />
            <br />
            <input type="text" name="new_password" value="" placeholder="Password" required />
            <br />
            <select name="new_roles">
                <c:forEach var="role" items="${roles}">
                    <option value="${role.id}">${role.name}</option>
                </c:forEach>
            </select>
            <br />
            <input type="submit" value="Add User">
            <br />
        </form>
        
        <c:forEach var="user" items="${users}">
            <p>${user.email}, ${user.firstName}, ${user.lastName}, ${user.active}, ${user.role}</p>
        </c:forEach>
            
        <c:if test="${message != null}">
            <p>${message}</p>
        </c:if>
            
        <p>${user.firstName} ${user.lastName} was found in search and their email is ${user.email}</p>
    </body>
</html>
