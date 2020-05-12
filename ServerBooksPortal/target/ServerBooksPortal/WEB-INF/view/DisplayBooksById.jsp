<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1" cellspacing="0">
    <tr>
        <th>bookId</th>
        <th>bookName</th>
        <th>bookAuthor</th>
        <th>bookDesc</th>
        <th>price</th>
        <th>language</th>
    </tr>
    <tr>
        <td>${bookById.bookId}</td>
        <td>${bookById.bookName}</td>
        <td>${bookById.bookAuthor}</td>
        <td>${bookById.bookDesc}</td>
        <td>${bookById.price}</td>
        <td>${bookById.language}</td>
    </tr>

</table>
<a href="getBooksList"><input type="button" value="back" align="centre" style="color: brown"></a>
<a href="../index.jsp"><input type="button" value="home" style="color: springgreen" ></a>