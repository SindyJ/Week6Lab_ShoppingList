<%-- 
    Document   : shoppingList
    Created on : Oct 25, 2020, 4:35:47 PM
    Author     : 726772
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <form action="" method="post">
            <label for="list">Add item: </label>
            <input type="text" name="item">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form action="" method="post">
            <ul>
                <li><input type="radio" name="item" value=""></li>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
        
    </body>
</html>
