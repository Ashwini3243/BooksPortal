<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Secure page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">

    <style>
        body {
            height: 100vh;
            background: #efefef;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }
    </style>
</head>
<body>


<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2> hey , You have logged In successfully </h2>
    <h2 style="margin-bottom: 3rem;">Welcome: ${pageContext.request.userPrincipal.name}</h2>
</c:if>
<div class="button">

    <a href="getObjByList" class="ui button linkedin">Book List</a>
    <a  href="logout" class="ui button linkedin">Logout   </a>
</div>
</body>
</html>