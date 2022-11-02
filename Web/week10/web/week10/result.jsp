<%@ page import="week10.JavaBean.user.User" %><%--
  Created by IntelliJ IDEA.
  User: 18452
  Date: 2022/11/2
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册结果</title>
</head>
<body>
<jsp:useBean id="user" class="week10.JavaBean.user.User" />
<div align="center">
    <jsp:setProperty name="user" property="*" />
    <%
        if (!user.getUsername().equals("") && !user.getPassword().equals(""))
            out.print("注册成功!<br /><br />");
        else
            out.print("请输入合法的用户名和密码!!");
    %>
    用户名:<jsp:getProperty name="user" property="username" /><br />
    密&nbsp;&nbsp;&nbsp;码:<jsp:getProperty name="user" property="password" />
    <br /><br /><br />
    <a href="index.jsp">点击返回</a>
</div>
</body>
</html>
