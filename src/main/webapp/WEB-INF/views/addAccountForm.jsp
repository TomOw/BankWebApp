<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Add Account</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Bank</h1>
                <p>You're logged as: ${pageContext.request.userPrincipal.name}</p>
                <p>Transfer</p>
            </div>
        </div>
    </section>
    <div class="row">
        <div class="col-sm-2">
            <a href="/"><input type="button" value="Home" class="btn btn-lg btn-primary"/></a>
        </div>
    </div>
    <section class="container">
        <form:form modelAttribute="newAccount" cssClass="form-horizontal">
            <fieldset>
                <legend>Transfer details</legend>
                <div class="form-group">
                    <h4>Your account number wiil be: ${newAccount.number}</h4>
                    <h5>Choose the currency</h5>
                    <form:radiobutton path="currency" value="PLN"></form:radiobutton>PLN
                    <form:radiobutton path="currency" value="USD"></form:radiobutton>USD
                    <form:radiobutton path="currency" value="EUR"></form:radiobutton>EUR
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button type="submit" class="btn btn-md btn-primary">
                                <span class="glyphicons glyphicons-ok"></span>Submit
                            </button>
                        </div>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </section>
</body>
</html>
