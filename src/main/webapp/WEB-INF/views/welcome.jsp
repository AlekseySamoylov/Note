<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<spring:url value="/resources/assets/css/style.css"/>"/>
    <link type="text/css" rel="stylesheet" href="<spring:url value="/resources/assets/css/textStyle.css"/>"/>
    <link type="text/css" rel="stylesheet" href="<spring:url value="/resources/assets/css/bootstrap.min.css"/>"/>
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Welcome</title>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">

        <ul class="nav navbar-nav">

            <li><a class="btn btn-default" href="<spring:url value="/login"/>">Войти</a></li>

        </ul>
    </div>
</nav>
<div class="col-lg-9 pull-right">

    <div class="container">
        <jsp:include page="../views/fragments/welcome.jsp"/>
    </div>
</div>
</body>
</html>
