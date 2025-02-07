<%-- 
    Document   : login
    Created on : Aug 11, 2022, 2:35:57 PM
    Author     : doixu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <a href="MainController"><button>Home page</button></a> 

        <form action="MainController" method="post">
            Username <br/>
            <input type="text" name="txtUsername" value="${USERNAME}"/><br/>
            Password <br/>
            <input type="password" name="txtPassword" value=""/><br/>
            ${MESSAGE} ${MESSAGE != null? "<br/>" : ""}
            <input type="submit" value="Login" name="btnAction"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
