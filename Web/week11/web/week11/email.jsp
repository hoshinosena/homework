<%--
  Created by IntelliJ IDEA.
  User: 18452
  Date: 2022/11/13
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>邮件发送</title>
</head>
<body>
<form action="release.jsp" method="post">
    <table align="center" width="450" border="1">
        <tr><td align="center" colspan="2" height="40"><b>邮件发送</b></td></tr>
        <tr><td align="left" width="450">标题：<input type="text" name="title"></td></tr>
        <tr><td align="left" width="450">内容：<textarea rows="8" clos="40" name="content"></textarea></td></tr>
        <tr><td align="center"><input type="submit" value="提交"></td></tr>
    </table>
</form>
</body>
</html>
