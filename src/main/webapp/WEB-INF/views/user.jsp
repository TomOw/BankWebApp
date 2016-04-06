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
    <title>User Profile</title>
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
            <li class="list-group-item col-lg-10">
                <h2>${user.name}</h2>
                <p>ID: ${user.id}</p>
                <h3>Account deatils:</h3>
                <p>Account number: ${user.account.number}</p>
                <p>Balance: ${user.account.balance} ${client.account.currency}</p>
                <p>Currency: ${user.account.currency}</p>
                <h4>Transaction history:</h4>
                <section class="container">
                    <ul class="list-group">
                        <c:forEach items="${user.account.transferHistory}" var="transfer" varStatus="theCount">
                        <li class="list-group-item">
                            <h4>${theCount.count}</h4>
                            <p>Date of transfer: ${transfer.date}</p>
                            <p>Title: ${transfer.title}</p>
                            <p>Value: ${transfer.value}</p>
                            <p>From account: ${transfer.accountFrom}</p>
                            <p>To account: ${transfer.accountTo}</p>
                            <p>Sender: ${transfer.sender}</p>
                            <p>Receiver: ${transfer.receiver}</p>
                            </c:forEach>
                        </li>
                    </ul>
                </section>
                <p><a href="/clients/all"><button type="button" class="btn btn-md btn-primary">
                    <span class="glyphicons glyphicons-chevron-left"></span>Back
                </button></a></p>
                <p><a href="/user/${user.name}/addAccount"><button type="button" class="btn btn-md btn-primary">
                    <span class="glyphicons glyphicons-chevron-left"></span>Add Account
                </button></a></p>
            </li>
        </ul>
    </section>
</body>
</html>
