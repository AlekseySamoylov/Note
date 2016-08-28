<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 8/28/16
  Time: 7:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<spring:url value="/resources/assets/css/bootstrap.min.css"/>"/>
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>User-messages</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container-fluid">

            <ul class="nav navbar-nav">

                <li><a class="btn btn-default" href="<spring:url value="/add-message"/>">Добавить сообщение</a></li>

                <li><a class="btn btn-default" href="<spring:url value="/refresh"/>">Обновить</a></li>
                <li><a class="btn btn-default" href="<spring:url value="/logout"/>">Выйти</a></li>


            </ul>
        </div>
    </nav>
    <c:forEach items="${messages}" var="message">
        <div class="container">
            <h1>${message.title}</h1>
            <a href="<spring:url value="/update-message/"/>${message.id}">Edit message</a>
            <p>${message.textBody}</p>
            <a href="<spring:url value="/delete-message/"/>${message.id}">Delete message</a>
        </div>
        <hr/>
    </c:forEach>
</div>
</body>
</html>
