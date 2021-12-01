<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 30/11/2564
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row bg-primary"><h2>Classic Model Offices ::</h2></div>
    <div class="row">
        <c:forEach items="${offices}" var="office">
            <div class="col-2 border border-secondary p-2 m-2
                    ${office.id == selectedOffice.id ? 'bg-warning' : ''}">
                <div>
                    <a href="office-list?officeCode=${office.id}">${office.city}</a>, ${office.country}
                </div>
                <div> ${office.phone}</div>
            </div>
        </c:forEach>
    </div>
    <br>
    <hr>
    <div class="row bg-light"><b>Employees ::</b></div>
    <div class="row">
        <c:forEach items="${selectedOffice.employeeList}" var="employee">
            <div class="col-2 pl-2 m-2 border border-secondary rounded-pill">
                <div> ${employee.firstName} ${employee.lastName} - ${employee.jobTitle}</div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
