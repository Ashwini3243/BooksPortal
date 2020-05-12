<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: darkmagenta" > Students list</h1>
<table border="2" cellspacing="0" cellpadding="8" style="border-color: darkblue" >
    <tr >
        <th>bookId</th>
        <th>bookName</th>
        <th>bookAuthor</th>
        <th>bookDesc</th>
        <th>price</th>
        <th>language</th>
    </tr>
    <c:forEach items="${BooksList}" var="bl">
        <tr>
            <td><a href="getBooksById/${bl.bookId}">${bl.bookId}</a></td>

            <td>${bl.bookName}</td>
            <td>${bl.bookAuthor}</td>
            <td>${bl.bookDesc}</td>
            <td>${bl.price}</td>
            <td>${bl.language}</td>

        </tr>
    </c:forEach>

</table><br><br>
<a href="index.jsp"><input type="button" value="home" style="color: springgreen" ></a>
