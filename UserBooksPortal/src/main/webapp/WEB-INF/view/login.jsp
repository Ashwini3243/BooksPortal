<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
    <title>Custom login</title>
    <style type="text/css">
        body {
            height: 100vh;
            background: #efefef;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .error,
        .msg {
            margin-top: 1rem !important;
        }

        .wrapper {
            width: 350px;
        }
        .main_wrapper{
            display: flex !important;
            justify-content: center;
        }
    </style>
</head>

<body>

<div class="ui container main_wrapper">


    <div class="wrapper">
        <div class="ui piled segment">
            <!-- custom login form -->
            <form name="loginform" action="<c:url value='j_spring_security_check'/>" method="POST" id="login_form" class="ui form">
                <h1 class="ui center aligned header">Login</h1>
                <div class="field required">
                    <label>UserName/Email</label>
                    <input type='text' name='j_username' placeholder="UserName" />
                </div>
                <div class="field required">
                    <label>Password</label>
                    <input type='password' name='j_password' placeholder="password" />
                </div>
                <div class="ui fluid center aligned header" >

                    <button class="ui button linkedin "  type="submit">Login<i style="margin-left: 0.5rem;margin-right: 0;" class="ui icon sign-in">
                        <!--  -->
                    </i></button>
                </div>
            </form>
            <!-- invalid credentials error msg -->
            <c:if test="${not empty error}">
                <div class="error ui message red">${error}</div>
            </c:if>

            <!-- logged out msg -->
            <c:if test="${not empty msg}">
                <div class="msg ui message yellow">${msg}</div>
            </c:if>
        </div>
    </div>
</div>


</html>