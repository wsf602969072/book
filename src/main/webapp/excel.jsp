<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22 0022
  Time: 上午 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<!-- 正常数据导出肯定要传入参数，我这里没有用ajax传参，简单用链接传参 -->

</head>
<body>

    <input type="button" value="报表导出" onclick="download()"/>

</body>
<script type="text/javascript">
    function download(){
        var url=${pageContext.request.contextPath}+"/download_excel.do?id=10&name=张三";
        location.href = url;
    }
</script>
</html>
