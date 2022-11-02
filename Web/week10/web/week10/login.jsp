<%--
  Created by IntelliJ IDEA.
  User: 18452
  Date: 2022/11/2
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="week10.session.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies == null || cookies.length == 0);
    else
        for(Cookie cookie:cookies)
            if (cookie.getName().equals("id")) {
                User user = new User(cookie.getValue());
                session.setAttribute("user", user);
                response.sendRedirect("loginServlet");
                return;
            }
%>
<form action="loginServlet" method="post">
    用户名：<input type="text" name="username" /><br />
    密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" /><br />
    <input type="submit" value="提交" />
</form>
</body>
</html>
