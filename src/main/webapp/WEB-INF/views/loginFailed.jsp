<%--
  Created by IntelliJ IDEA.
  User: tomaszowczarczyk
  Date: 31.01.2016
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body onload='document.f.username.focus();'>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Bank</h1>
                <p>Login</p>
            </div>
        </div>
    </section>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-heading">
                    <h4>Login with username and password</h4>
                    <div class="alert alert-danger">
                        <h4>${message}</h4>
                    </div>
                </div>
                <div class="panel-body">
                    <form name ="f" action="/login" method="POST">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Username" name='username' type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name='password' type="password" value="">
                            </div>
                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
