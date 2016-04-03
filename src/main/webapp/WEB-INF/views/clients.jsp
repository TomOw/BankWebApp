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
    <title>Title</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Bank</h1>
                <p>All Clients</p>
            </div>
        </div>
    </section>
    <div class="row">
        <div class="col-sm-2">
            <a href="/"><input type="button" value="Home" class="btn btn-lg btn-primary"/></a>
            <a href="/clients/add"><input type="button" value="Add Client" class="btn btn-lg btn-primary"/></a>
        </div>
    </div>
    <section class="container">
        <ul class="list-group">
            <c:forEach items="${clients}" var="client">
                <li class="list-group-item">
                    <h3>${client.name}</h3>
                    <p>ID: ${client.id}</p>
                    <h4>Account deatils:</h4>
                    <p>Account number: ${client.account.number}</p>
                    <p>Balance: ${client.account.balance} ${client.account.currency}</p>
                    <p>Currency: ${client.account.currency}</p>
                </li>
            </c:forEach>
        </ul>
    </section>
</body>
</html>
