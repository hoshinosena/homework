<%--
  Created by IntelliJ IDEA.
  User: 18452
  Date: 2022/11/13
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
</head>
<body>
<jsp:useBean id="student" class="week11.JavaBean.Student" />
<div>
    <ul>
        <li>姓名：<jsp:getProperty name="student" property="name" /></li>
        <li>年龄：<jsp:getProperty name="student" property="age" /></li>
        <li>性别：<jsp:getProperty name="student" property="sex" /></li>
    </ul>
</div>
</body>
</html>
