<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>bookList</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">

    <%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
        table tr th{
            font-weight: 900;
            font-size: 15px;
            text-align: center;
        }
        .wrapper{
            padding-top: 2rem;
        }
    </style>
</head>
<body>
<div class="ui container wrapper">
    <h1 class="ui header divided" > Books list</h1>
    <table cellspacing="0" cellpadding="8" class="ui table striped celled" >

        <tr >
            <th>Book Id</th>
            <th>Book Name</th>
            <th>Book Author</th>
            <th>Book Desc</th>
            <!-- <%-- <th>price</th>--%> -->
            <th>Language</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${data.userBooksInfos}" var="data">

            <tr>
                <td>${data.bookId}</td>
                <td>${data.bookName}</td>
                <td>${data.bookAuthor}</td>
                <td>${data.bookDesc}</td>
                <!-- <%--<td>${std.price}</td>--%> -->
                <td>${data.language}</td>
                <td><a href="getObj/${data.bookId}" >view</a></td>

            </tr>
        </c:forEach>
    </table>
    <a href="welcome" class="ui button linkedin">Back</a>
    <a href="logout" class="ui button linkedin">Logout</a>
</div>
</body>
</html>


