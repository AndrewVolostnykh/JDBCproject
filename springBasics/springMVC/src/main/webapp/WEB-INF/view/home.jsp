<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>


<html>
    <head>
        <title>Home page</title>
    </head>
    <body>
        <p>${reuslt}</p><br><br>

        Profile :
        <p>Name: ${user.name}, Email: ${user.email}, Age: ${user.age}, Surname: ${user.surname}</p>
        <button onclick="location.href='/login'">Login</button>
    </body>
</html>