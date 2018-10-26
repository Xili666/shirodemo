<%--
  Created by IntelliJ IDEA.
  User: 15229
  Date: 2018/8/7
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="left col-sm-8">
        <h1 class="text-left">用户登陆</h1>
    </div>
    <div class="well col-sm-3 right">
        <form method="post" role="form" action="${pageContext.request.contextPath}/login">
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" class="form-control" name="username" id="username"/>
            </div>
            <div class="form-group">
                <label for="password">用户名</label>
                <input type="password" class="form-control" name="password" id="password"/>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-default" value="登录"/>
                <input type="reset" class="btn btn-default" value="重置"/>
            </div>
        </form>
    </div>
    <div>${errorMsg}</div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    <%--$('input[type=submit]').click(function () {--%>
        <%--var data = $('form').serialize();--%>
        <%--$.post("${pageContext.request.contextPath}/login", data, function (res) {--%>
            <%--alert(JSON.stringify(res));--%>
        <%--})--%>
    <%--});--%>
</script>
</body>
</html>
