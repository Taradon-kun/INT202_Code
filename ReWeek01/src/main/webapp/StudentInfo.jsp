<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 25/9/2564
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Info</title>
</head>
<body>
    <h2>New student has been save</h2><br>
    Student id: ${student.id} <br>
    Student name: ${student.name} <br>
    Gpax: ${student.gpax} <br>
    <hr>
    <a href="index.jsp"><button value=" OK "> OK </button> </a><br>
    request.param.id : ${param.id}<br>
    request.param.name : ${param.name}<br>
    request.param.gpax : ${param.gpax}<br>
    Browser: ${header["User-Agent"]}<br>
    Accept-Language: ${headerValues["Accept-Language"][0]},${headerValues["Accept-Language"][1]}<br>
</body>
</html>
