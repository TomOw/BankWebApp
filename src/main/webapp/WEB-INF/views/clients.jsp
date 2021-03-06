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
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <title>All Clients</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Bank</h1>
                <p>You're logged as: ${pageContext.request.userPrincipal.name}</p>
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
            <c:forEach items="${clients}" var="client" varStatus="theCount">
                <li class="list-group-item">
                    <h2>${theCount.count}</h2>
                    <h3>${client.name}</h3>
                    <p>ID: ${client.id}</p>
                    <h4>Account deatils:</h4>
                    <p>Account number: ${client.account.number}</p>
                    <p>Balance: ${client.account.balance} ${client.account.currency}</p>
                    <p>Currency: ${client.account.currency}</p>
                    <p><a href="/user/${client.name}"><button type="button" class="btn btn-md btn-primary">
                        <span class="glyphicon glyphicon-user"></span>User Profile
                    </button></a></p>
                </li>
            </c:forEach>
        </ul>
    </section>
</body>
</html>
