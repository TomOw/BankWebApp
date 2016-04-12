<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 28.03.2016
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <title>Logout Succesful</title>
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <h1>Bank</h1>
            <p>You have successfully logged out</p>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-2">
            <p><a href="/">
                <button type="button" class="btn btn-md btn-primary">
                    <span class="glyphicon glyphicon-eye-open"></span>Home
                </button>
            </a></p>
            <p><a href="/login">
                <button type="button" class="btn btn-md btn-primary">
                    <span class="glyphicons glyphicon-fees-payment"></span>Login
                </button>
            </a></p>
        </div>
    </div>
    </div>
</body>
</html>
