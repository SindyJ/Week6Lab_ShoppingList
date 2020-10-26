<%-- 
    Document   : shoppingList
    Created on : Oct 25, 2020, 4:35:47 PM
    Author     : 726772
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <h3>Hello ${username}</h3>
        <a href="ShoppingList?action=logout">Logout</a>
        <br>
        
        <h2>List</h2>
        <form action="ShoppingList" method="post">
            <label for="list">Add item: </label>
            <input type="text" name="item">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>

        <form action="ShoppingList" method="post">
             <ul>
                <c:forEach var="item" items="${list}">
                    <li><input type="radio" name="item" value="${item}">${item}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
        
    </body>
</html>
