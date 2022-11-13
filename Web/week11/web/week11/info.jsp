<%--
  Created by IntelliJ IDEA.
  User: 18452
  Date: 2022/11/13
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加成功</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="book" class="week11.JavaBean.Book" scope="session"/>
<jsp:setProperty name="book" property="*" />
<table align="center" width="400">
    <tr><td align="center">名称：<jsp:getProperty name="book" property="name" /></td></tr>
    <tr><td align="center">价格：<jsp:getProperty name="book" property="price" /></td></tr>
    <tr><td align="center">作者：<jsp:getProperty name="book" property="author" /></td></tr>
</table>
</body>
</html>
