<%-- 
    Document   : register
    Created on : 20-Oct-2021, 2:43:42 AM
    Author     : AponTran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">
            <label>Username: </label>
            <input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <br>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
