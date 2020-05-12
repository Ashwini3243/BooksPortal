<%--
  Created by IntelliJ IDEA.
  User: Interview
  Date: 3/3/2020
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/addBookFormAction" var="formUrl"/>
<form:form modelAttribute="user" action="${formUrl}" method="POST"  >
    <style>
        .error{
            color: darkblue;
        }
    </style>
    <table>
        <tr>
            <td>bookId  : </td>
            <td><form:input path="bookId"  readonly="true"/></td>
            <td> <form:errors path="bookId"  cssClass="error"  ></form:errors></td>
        </tr>
        <tr>
            <td>bookName  :</td>
            <td><form:input path="bookName"   /></td>
           <td> <form:errors path="bookName" cssClass="error"  ></form:errors></td>
        </tr>
        <tr>
            <td>bookAuthor  :</td>
            <td><form:input path="bookAuthor"/></td>
            <td><form:errors path="bookAuthor"   ></form:errors></td>
        </tr>
        <tr>
            <td>boookDesc  :</td>
            <td><form:input path="bookDesc" /></td>
            <td> <form:errors path="bookDesc"    cssClass="error"></form:errors></td>
        </tr>
        <tr>
            <td>price  :</td>
            <td><form:input path="price" /></td>
            <td> <form:errors path="price"  cssClass="error"></form:errors></td>
        </tr>
        <tr>
            <td>language :</td>
            <td><form:select path="language" >
                <form:options items="${languages}"/>
            </form:select></td>
            <td> <form:errors path="language" cssClass="error"  ></form:errors></td>
        </tr>
        <tr>

            <td><input type="submit" value="submit"  style="color: darkblue"></td>

        </tr>

    </table>
    <a href="index.jsp"><input type="button" value="Back" align="centre" style="color: red"></a>
    </form:form>
