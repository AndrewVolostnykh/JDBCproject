<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <form action="login-page">
            <input type="text" name="login"><br>
            <input type="text" name="password"><br>
            <input type="submit">
        </form>
    </body>
</html>
