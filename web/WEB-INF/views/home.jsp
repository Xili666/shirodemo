<%--
  Created by IntelliJ IDEA.
  User: 15229
  Date: 2018/8/7
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="javascript:void(0)" data-href="${pageContext.request.contextPath}/emp/save">emp-save</a></p>
<p><a href="javascript:void(0)" data-href="${pageContext.request.contextPath}/emp/del">emp-del</a></p>
<p><a href="javascript:void(0)" data-href="${pageContext.request.contextPath}/admin/save">adimn-save</a></p>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    $('a').click(function () {
        var url = $(this).attr("data-href");
        $.get(url, function (data) {
            alert(JSON.stringify(data));
        })
    });
</script>
</body>
</html>
