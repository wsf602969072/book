<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/21 0021
  Time: 下午 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#button").click(function () {
                /*$.ajax({
                    url:"${pageContext.request.contextPath}/user/selectUserByCondition.do",
                    data:"userId=1",
                    dataType:"json",
                    success:function (data) {
                        alert(data)
                    }
                })*/
                $.post("${pageContext.request.contextPath}/user/selectUserByCondition.do",{"userId":1},function (data) {
                    alert(data)
                },"text")
            })

        })
    </script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/user/selectUserByCondition.do?userId=1">test</a>
    <a id="button">111</a>
</body>
</html>
