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
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <title>Title</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Bank</h1>
                <p>Add Client ${clientId}</p>
            </div>
        </div>
    </section>
    <div class="row">
        <div class="col-sm-2">
            <a href="/"><input type="button" value="Home" class="btn btn-lg btn-primary"/></a>
        </div>
    </div>
    <section class="container">
        <form:form modelAttribute="newClient" cssClass="form-horizontal">
            <fieldset>
                <legend>Client's details</legend>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="name">Client's name</label>
                    <div class="col-lg-10">
                        <form:input path="name" type="text" cssClass="input-lg"></form:input>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" class="btn btn-primary" value="Add">
                        </div>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </section>
</body>
</html>
