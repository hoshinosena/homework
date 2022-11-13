<%--
  Created by IntelliJ IDEA.
  User: 18452
  Date: 2022/11/13
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
</head>
<body>
<jsp:useBean id="student" class="week11.JavaBean.Student1" />
<jsp:setProperty name="student" property="name" value="小明" />
<jsp:setProperty name="student" property="age" value="18" />
<jsp:setProperty name="student" property="sex" value="男" />
<div>
    <ul>
        <li>姓名：<jsp:getProperty name="student" property="name"/></li>
        <li>年龄：<jsp:getProperty name="student" property="age"/></li>
        <li>性别：<jsp:getProperty name="student" property="sex"/></li>
    </ul>
</div>
</body>
</html>
