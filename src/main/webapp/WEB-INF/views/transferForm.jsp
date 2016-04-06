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
    <title>Transfer</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Bank</h1>
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
        <form:form modelAttribute="transfer" cssClass="form-horizontal">
            <fieldset>
                <legend>Transfer details</legend>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="accountFrom">From account</label>
                    <div class="col-lg-10">
                        <form:input path="accountFrom" type="number" cssClass="input-lg"></form:input>
                    </div>
                    <label class="control-label col-lg-2 col-lg-2" for="accountTo">To account</label>
                    <div class="col-lg-10">
                        <form:input path="accountTo" type="number" cssClass="input-lg"></form:input>
                    </div>
                    <label class="control-label col-lg-2 col-lg-2" for="value">Value</label>
                    <div class="col-lg-10">
                        <form:input path="value" type="number" cssClass="input-lg"></form:input>
                    </div>
                    <label class="control-label col-lg-2 col-lg-2" for="sender">Sender</label>
                    <div class="col-lg-10">
                        <form:input path="sender" type="text" cssClass="input-lg"></form:input>
                    </div>
                    <label class="control-label col-lg-2 col-lg-2" for="receiver">Receiver</label>
                    <div class="col-lg-10">
                        <form:input path="receiver" type="text" cssClass="input-lg"></form:input>
                    </div>
                    <label class="control-label col-lg-2 col-lg-2" for="title">Title</label>
                    <div class="col-lg-10">
                        <form:input path="title" type="text" cssClass="input-lg"></form:input>
                    </div>
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
