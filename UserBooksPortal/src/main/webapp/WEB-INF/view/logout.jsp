<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
    <script src="/resources/jquery.js" defer></script>
    <style>
        .wrapped{
            width: 100%;
            height: 300%;
            display: flex;
            justify-content: center;

        }
        .wrapped_container{
            display: flex;
            justify-content: center;
            align-content: center;
            flex-direction: column;
            height: 300px;
        }
    </style>
</head>
<body>
<div class="wrapped">
    <div class="ui segment piled wrapped_container">
        <h2 class="ui header" style="color: red">You Have Successfully Logged Out...!</h2>
        <div>
            <a href="login"><input class="ui button primary" type="button" value="login here" align="centre" ></a>
            <a href="register"><input class="ui button primary" type="button" value="Register" align="centre"  ></a>
            <a href="getObjByList"><input class="ui button primary" type="button" value="List Of Books" align="centre"  ></a>
        </div>
    </div>
</div>

</body>
</html>
