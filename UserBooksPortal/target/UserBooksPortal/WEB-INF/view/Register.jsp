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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
<title>Registration</title>
<style type="text/css">

     .error{
         color: red;
     }


      body {
          height: 100vh;
          background: #efefef;
          display: flex;
          justify-content: center;
          align-items: center;
          flex-direction: column;
      }


</style>

<c:url value="/saveRegData" var="formUrl"/>
<form:form modelAttribute="reg" action="${formUrl}" method="post">
    <table>
        <tr>
            <td>
               <h3> Register</h3>
            </td>
        </tr>
        <tr>
            <td>ID  : </td>
            <td><form:input path="id" /></td>
            <td> <form:errors path="id"  cssClass="error"  ></form:errors></td>
        </tr>
        <tr>
            <td>NAME  :</td>
            <td><form:input path="name"/></td>
            <td> <form:errors path="name"  cssClass="error"  ></form:errors></td>
        </tr>
        <tr>
            <td>AGE  :</td>
            <td><form:input path="age"/></td>
            <td> <form:errors path="age"  cssClass="error"  ></form:errors></td>
        </tr>
        <tr>
            <td>Email  :</td>
            <td><form:input path="email"/></td>
            <td> <form:errors path="email"  cssClass="error"  ></form:errors></td>
        </tr>
        <tr>
            <td>ADDRESS  :</td>
            <td><form:input path="address"/></td>
            <td> <form:errors path="address"  cssClass="error"  ></form:errors></td>
        </tr>
        <tr>
            <td>country :</td>
            <td><form:select path="country">
                <form:options items="${countriesList}"/>
            </form:select></td>
            <td> <form:errors path="country"  cssClass="error"  ></form:errors></td>
        </tr>
        <tr>
            <td>USERNAME  :</td>
            <td><form:input path="username"/></td>
            <td> <form:errors path="username"  cssClass="error"  ></form:errors></td>
        </tr>
        <tr>
            <td>PASSWORD  :</td>
            <td><form:input path="password"/></td>
            <td> <form:errors path="password"  cssClass="error"  ></form:errors></td>
        </tr>
        <tr>
            <td>ROLE_NAME :</td>
            <td><form:select path="role">
                <form:options items="${rolesList}"/>
            </form:select></td>
            <td> <form:errors path="role"  cssClass="error"  ></form:errors></td>
        </tr>
        <tr>
            <td>ENABLED  :</td>
            <td><form:input path="enabled"/></td>
            <td> <form:errors path="enabled"  cssClass="error"  ></form:errors></td>
        </tr>
        <tr>

            <td><input type="submit" value="Register" style="color: darkblue"></td>
           <td> <a href="index.jsp"><input type="button" value="home" align="centre" style="color: blue"></a>
              <a href="index.jsp"><input type="button" value=" back " style="color: blue" ></a></td>
        </tr>

    </table>
</form:form>
