<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <form:form action="saveSignUpForm" method="post" modelAttribute="signUpForm">
        <label for="firstName" > First name </label><br>
        <form:input path="firstName" />

        <form:button>Submit</form:button>
    </form:form>


</body>
</html>
