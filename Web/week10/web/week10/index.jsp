<%--
  Created by IntelliJ IDEA.
  User: 18452
  Date: 2022/11/2
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="result.jsp" method="post">
    <table align="center" width="300" border="1" height="150">
        <tr>
            <td colspan="2" align="center">
                <b>登录</b>
            </td>
        </tr>
        <tr>
            <td align="left">
                用户名：<input type="text" name="username" />
            </td>
        </tr>
        <tr>
            <td align="left">
                密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
