<%-- 
    Document   : shoppingList
    Created on : 20-Oct-2021, 3:10:05 AM
    Author     : AponTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <h3>Hello, ${userName}</h3>
        <p><a href="ShoppingList?action=logout">Log Out</a></p>
        
        <h2>List</h2>
        
        <form action="" method="POST">
            <label>Add Item: </label>
            <input type="text" name="itemadded">
            <input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">           
        </form>
        
        <form action="" method="POST">
            <ul>
                <c:forEach items="${itemAdded}" var="item">
                    <li><input type="radio" name="items" value="${item}">${item}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
