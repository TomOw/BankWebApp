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
    <title>Home</title>
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <h1>Bank</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-2">
            <p><a href="/clients/all"><button type="button" class="btn btn-md btn-primary">
                <span class="glyphicon glyphicon-eye-open"></span>All Clients
            </button></a></p>
            <p><a href="/transfer/make"><button type="button" class="btn btn-md btn-primary">
                <span class="glyphicon glyphicon-sound-stereo"></span>Make transfer
            </button></a></p>
            <p><a href="/clients/add"><button type="button" class="btn btn-md btn-primary">
                <span class="glyphicons glyphicon-fees-payment"></span>Add client
            </button></a></p>
        </div>
    </div>
    <div class="row">
        <c:forEach begin="0" end="10">
            <div class="col-sm-4">
                Hello
            </div>
        </c:forEach>
    </div>
    </div>
</body>
</html>
