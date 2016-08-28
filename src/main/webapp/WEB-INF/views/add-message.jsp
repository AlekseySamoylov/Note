<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 8/20/16
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <meta charset="utf-8">
    <title>Новое сообщение</title>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">

        <ul class="nav navbar-nav">

            <li><a class="btn btn-default" href="<spring:url value="/user-messages"/>">Вернуться</a></li>

        </ul>
    </div>
</nav>
<div class="container">
    <p>Оборачивайте код в теги &ltpre&gt и &ltxmp&gt Your code &lt/xmp&gt и &lt/pre&gt</p>
    <spring:url value="/save-message" var="saveUrl"/>
    <form:form action="${saveUrl}" method="post" modelAttribute="messageBody">
        <form:hidden path="userId"/>
        <form:hidden path="id"/>
        <div class="form-group">
            <label for="title">Заголовок</label>
            <input type="text" name="title" class="form-control" rows="8" id="title" value="${messageBody.title}" />
        </div>

        <div class="form-group">
            <label for="message">Текст</label>
            <textarea name="textBody" class="form-control" rows="8" id="message" >${messageBody.textBody}</textarea>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-default">
                <spring:message code="button.save" text="Save"/>
            </button>
        </div>
    </form:form>
</div>

</body>
</html>
